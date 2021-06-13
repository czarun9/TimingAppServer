package pl.wat.am.timingappserver.Shows;


import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.UserHasShowOnWatchedList.UserShowsOnWatchedList;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name = "SHOWS")
@Entity
public class Show {

    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "show")
    List<Season> seasons;
    @OneToMany(mappedBy = "show")
    List<UserShowsOnWatchedList> showHasUsers;

    public Show() {
    }

    public Show(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
