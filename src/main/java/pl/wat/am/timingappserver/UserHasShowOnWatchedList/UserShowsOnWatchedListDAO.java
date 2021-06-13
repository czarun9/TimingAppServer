package pl.wat.am.timingappserver.UserHasShowOnWatchedList;

import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Shows.ShowDAO;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class UserShowsOnWatchedListDAO implements Serializable {
    String userId;
    ShowDAO showDAO;
    Boolean isOnWatchedList;

    public UserShowsOnWatchedListDAO(String userId, ShowDAO showDAO, Boolean isOnWatchedList) {
        this.userId = userId;
        this.showDAO = showDAO;
        this.isOnWatchedList = isOnWatchedList;
    }
}
