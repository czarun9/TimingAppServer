package pl.wat.am.timingappserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Episodes.EpisodeService;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.Seasons.SeasonService;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Shows.ShowService;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InsertData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InsertData.class);

    @Autowired
    ShowService showService;
    @Autowired
    SeasonService seasonService;
    @Autowired
    EpisodeService episodeService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("Initializing data");
        try {
            List<List<String>> records = initializeDataFromFile("src/main/resources/static/Big Bang Theory_IMDB.csv");
            insertShows(records);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<List<String>> initializeDataFromFile(String resourcePath) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\n");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * records - row 0 - column names<br>
     * records - column: <br>
     * <ul>0 - id</ul>
     * <ul>1 - season number</ul>
     * <ul>2 - episode number</ul>
     * <ul>3 - air day</ul>
     * <ul>4 - air month</ul>
     * <ul>5 - air year</ul>
     * <ul>6 - title</ul>
     * <ul>7 - rating</ul>
     * <ul>8 - number of votes</ul>
     * <ul>9 - episode description</ul>
     */

    private void insertShows(List<List<String>> records) {
        showService.addShow(new Show("1", "The Big Bang Theory"));
        String showId = showService.getShow("1").getId();

        List<Show> showsToInsert = new ArrayList<>();
        records.remove(0);
        Integer seasonNumber = 0;
        for (List<String> record : records) {
            String[] details = record.get(0).split(";");

            if (Integer.parseInt(details[1]) != seasonNumber) {
                Season season = new Season(showId, "", Integer.parseInt(details[1]));
                season.setShow(new Show("1", "The Big Bang Theory"));
                seasonService.addSeason(season);
                seasonNumber++;
            }

            Season season = seasonService.getSeason(showId + "_" + seasonNumber);

            Episode episode = new Episode(season.getId(),Integer.parseInt(details[2]), details[9], details[6]);
            episode.setSeason(season);
            episodeService.addEpisode(episode);

        }

    }
}
