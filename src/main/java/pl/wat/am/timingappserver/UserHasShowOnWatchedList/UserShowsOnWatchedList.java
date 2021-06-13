package pl.wat.am.timingappserver.UserHasShowOnWatchedList;


import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Users.User;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ShowHasUser")
@Entity
public class UserShowsOnWatchedList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    Show show;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    Boolean isOnWatchedList;

    public UserShowsOnWatchedList() {
    }

    public UserShowsOnWatchedList(Boolean isOnWatchedList) {
        this.isOnWatchedList = isOnWatchedList;
    }
}
