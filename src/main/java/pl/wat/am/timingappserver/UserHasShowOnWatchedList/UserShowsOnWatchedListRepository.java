package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.am.timingappserver.Users.User;

public interface UserShowsOnWatchedListRepository  extends JpaRepository<UserShowsOnWatchedList,String> {
}
