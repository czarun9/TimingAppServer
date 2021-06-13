package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Users.User;
import pl.wat.am.timingappserver.Users.UserService;

import java.util.List;

@RestController
public class UserShowsOnWatchedListController {

    @Autowired
    UserShowsOnWatchedListService userShowsOnWatchedListService;

    @RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/shows/{showOnWatchedListId}")
    public void addUserShowsOnWatchedList(@RequestBody UserShowsOnWatchedList userShowsOnWatchedList, @PathVariable String userId, @PathVariable String showOnWatchedListId) {
        userShowsOnWatchedList.setUser(new User(userId));
        userShowsOnWatchedList.setShow(new Show(showOnWatchedListId,""));
        userShowsOnWatchedListService.addUserShowsOnWatchedList(userShowsOnWatchedList);
    }

    @RequestMapping(method = RequestMethod.GET, value ="users/{userId}/shows")
    public List<UserShowsOnWatchedListDAO> getAllUserShowsOnWatchedList(@PathVariable String userId){
        return userShowsOnWatchedListService.getAllUserShowsOnWatchedList(userId);
    }
}
