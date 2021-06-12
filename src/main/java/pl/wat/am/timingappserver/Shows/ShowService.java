package pl.wat.am.timingappserver.Shows;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    public List<ShowDAO> getAllShows() {
        List<ShowDAO> shows = new ArrayList<>();
        Iterator<Show> it = showRepository.findAll().iterator();
        while(it.hasNext()){
            Show show=it.next();
            shows.add(new ShowDAO(show.id,show.name));
        }
        return shows;
    }


}
