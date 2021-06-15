package pl.wat.am.timingappserver.Seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasonController {

    @Autowired
    SeasonService seasonService;

    @RequestMapping(method = RequestMethod.GET, value = "/shows/details/{showId}/seasons/{id}")
    public SeasonDAODetails getShowDetails(@PathVariable String id) {
        return seasonService.getSeasonDetails(id);
    }
}
