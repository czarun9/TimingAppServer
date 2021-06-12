package pl.wat.am.timingappserver.ShowHasUsers;


import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.events.Event;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Users.User;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ShowHasUser")
@Entity
public class ShowHasUser {
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

    public ShowHasUser() {
    }

    public ShowHasUser(long showId, long userId, Boolean isOnWatchedList) {
        //this.show = show;
        //this.user = user;
        this.isOnWatchedList = isOnWatchedList;
    }
}
