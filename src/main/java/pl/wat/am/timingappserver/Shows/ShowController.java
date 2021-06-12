package pl.wat.am.timingappserver.Shows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    ShowService showService;


}
