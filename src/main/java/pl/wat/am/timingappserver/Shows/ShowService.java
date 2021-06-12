package pl.wat.am.timingappserver.Shows;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    public void addShow(Show show){
        showRepository.save(show);
    }

    public Show getShow(String id){
        return (Show) showRepository.findById(id).orElse(null);
    }

    public List<Show> getAllShows() {
        List<Show> shows = new ArrayList<>();
        Iterable<Show> it = showRepository.findAll();
        it.forEach(shows::add);
        return shows;
    }
}
