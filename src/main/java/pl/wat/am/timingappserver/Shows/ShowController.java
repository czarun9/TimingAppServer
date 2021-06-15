package pl.wat.am.timingappserver.Shows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wat.am.timingappserver.Users.User;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    ShowService showService;

    @RequestMapping(method = RequestMethod.GET, value = "/shows/{id}")
    public Show getShow(@PathVariable String id) {
        return showService.getShow(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/shows/details/{id}")
    public ShowDAODetails getShowDetails(@PathVariable String id) {
        return showService.getShowDetails(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/shows")
    public List<ShowDAO> getAllShows() {
        return showService.getAllShows();
    }



}
