package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.am.timingappserver.Shows.Show;
import java.util.List;

public interface UserShowsOnWatchedListRepository  extends JpaRepository<UserShowsOnWatchedList,String> {
    List<UserShowsOnWatchedList> findByShow(Show show);
}
