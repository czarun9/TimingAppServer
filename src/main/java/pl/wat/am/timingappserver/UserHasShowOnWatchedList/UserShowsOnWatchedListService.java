package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Shows.ShowDAO;
import pl.wat.am.timingappserver.Shows.ShowService;
import pl.wat.am.timingappserver.Users.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserShowsOnWatchedListService {

    @Autowired
    UserShowsOnWatchedListRepository userShowsOnWatchedListRepository;
    @Autowired
    ShowService showService;

    public void addUserShowsOnWatchedList(UserShowsOnWatchedList userShowsOnWatchedList) {
        List <UserShowsOnWatchedList> userShowsOnWatchedListWithShow =userShowsOnWatchedListRepository.findByShow(userShowsOnWatchedList.getShow());
        if(userShowsOnWatchedListWithShow.isEmpty()){
            userShowsOnWatchedListRepository.save(userShowsOnWatchedList);
        }
    }

    public List<UserShowsOnWatchedListDAO> getAllUserShowsOnWatchedList(String userId) {
        List<UserShowsOnWatchedListDAO> watchedList = new ArrayList<>();
        Iterator<UserShowsOnWatchedList> it = userShowsOnWatchedListRepository.findAll().iterator();
        while (it.hasNext()) {
            UserShowsOnWatchedList userShowsOnWatchedList = it.next();
            if (userShowsOnWatchedList.getUser().getId().equals(userId)) {
                Show show = showService.getShow(userShowsOnWatchedList.getShow().getId());
                ShowDAO showDAO = new ShowDAO(show.getId(), show.getName());
                UserShowsOnWatchedListDAO userShowsOnWatchedListDAO = new UserShowsOnWatchedListDAO(userId, showDAO, userShowsOnWatchedList.getIsOnWatchedList());
                watchedList.add(userShowsOnWatchedListDAO);
            }
        }
        return watchedList;
    }


    public void deleteUserShowsOnWatchedList(String userId, String showOnWatchedListId) {
        List<UserShowsOnWatchedList> userShowsOnWatchedLists = showService.getShow(showOnWatchedListId).getShowHasUsers();

        for (UserShowsOnWatchedList userShowsOnWatchedList : userShowsOnWatchedLists) {
            if (userShowsOnWatchedList.getUser().getId().equals(userId)) {
                userShowsOnWatchedListRepository.delete(userShowsOnWatchedList);
            }
        }
    }
}
