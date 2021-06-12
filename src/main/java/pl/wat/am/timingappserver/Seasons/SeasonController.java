package pl.wat.am.timingappserver.Seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasonController {

    @Autowired
    SeasonService seasonService;
}
