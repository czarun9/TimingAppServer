package pl.wat.am.timingappserver.Episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.am.timingappserver.Seasons.SeasonDAODetails;

@RestController
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;

    @RequestMapping(method = RequestMethod.GET, value = "/shows/details/{showId}/seasons/{seasonId}/episodes/{id}")
    public EpisodeDAODetails getEpisodeDetails(@PathVariable String id) {
        return episodeService.getEpisodeDetails(id);
    }
}
