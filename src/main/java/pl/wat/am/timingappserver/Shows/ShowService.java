package pl.wat.am.timingappserver.Shows;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Users.User;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    public void addShow(Show show){
        showRepository.save(show);
    }
}
