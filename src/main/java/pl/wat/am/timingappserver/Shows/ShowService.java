package pl.wat.am.timingappserver.Shows;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.Seasons.SeasonDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    public void addShow(Show show) {
        showRepository.save(show);
    }

    public Show getShow(String id) {
        return (Show) showRepository.findById(id).orElse(null);
    }

    public ShowDAODetails getShowDetails(String id) {
        Show show = (Show) showRepository.findById(id).orElse(null);
        ShowDAODetails showDAODetails = new ShowDAODetails();
        showDAODetails.setId(id);
        showDAODetails.setName(show.getName());
        List<Season> seasons = show.getSeasons();
        List<SeasonDAO> seasonDAOS = new ArrayList<>();
        for(Season season: seasons){
            seasonDAOS.add(new SeasonDAO(season.getId(),season.getNoOfSeason()));
        }
        showDAODetails.setSeasonList(seasonDAOS);
        return showDAODetails;
    }

    public List<ShowDAO> getAllShows() {
        List<ShowDAO> shows = new ArrayList<>();
        Iterator<Show> it = showRepository.findAll().iterator();
        while (it.hasNext()) {
            Show show = it.next();
            shows.add(new ShowDAO(show.id, show.name));
        }
        return shows;
    }


}
