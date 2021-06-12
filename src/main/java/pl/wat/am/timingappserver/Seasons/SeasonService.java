package pl.wat.am.timingappserver.Seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Shows.Show;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;

    public void addSeason(Season season){
        seasonRepository.save(season);
    }

    public Season getSeason(String id){
        return (Season) seasonRepository.findById(id).orElse(null);
    }
}
