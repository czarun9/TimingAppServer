package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShowsOnWatchedListService {

    @Autowired
    UserShowsOnWatchedListRepository userShowsOnWatchedListRepository;

    public void addUserShowsOnWatchedList(UserShowsOnWatchedList userShowsOnWatchedList){
        userShowsOnWatchedListRepository.save(userShowsOnWatchedList);
    }
}
