package pl.wat.am.timingappserver.Seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Episodes.EpisodeDAO;
import pl.wat.am.timingappserver.Episodes.EpisodeRepository;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Shows.ShowDAODetails;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    EpisodeRepository episodeRepository;

    public void addSeason(Season season) {
        seasonRepository.save(season);
    }

    public Season getSeason(String id) {
        return (Season) seasonRepository.findById(id).orElse(null);
    }

    public SeasonDAODetails getSeasonDetails(String id) {
        Season season = (Season) seasonRepository.findById(id).orElse(null);
        SeasonDAODetails seasonDAODetails = new SeasonDAODetails();
        seasonDAODetails.setNoOfSeason(season.getNoOfSeason());
        seasonDAODetails.setId(id);

        List<Episode> episodes = episodeRepository.findAll();
        List<Episode> seasonEpisodes = new ArrayList<>();

        for (Episode episode : episodes) {
            if (episode.getSeason().getId() == id) {
                seasonEpisodes.add(episode);
            }
        }
        List<EpisodeDAO> episodeDAOS = new ArrayList<>();
        for (Episode episode : seasonEpisodes) {
            episodeDAOS.add(new EpisodeDAO(episode.getId(), episode.getTitle(), episode.getNoOfEpisode()));
        }
        seasonDAODetails.setEpisodes(episodeDAOS);
        return seasonDAODetails;
    }
}
