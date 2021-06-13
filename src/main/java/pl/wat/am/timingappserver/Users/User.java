package pl.wat.am.timingappserver.Users;

import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.UserHasShowOnWatchedList.UserShowsOnWatchedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Table(name = "USERS")
@Entity
public class User {

    @Id
    String id;

    @OneToMany(mappedBy = "user")
    List<UserShowsOnWatchedList> userHasShow;

    public User() {

    }

    public User(String id) {
        super();
        this.id = id;
    }
}
