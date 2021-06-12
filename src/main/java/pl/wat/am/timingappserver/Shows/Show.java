package pl.wat.am.timingappserver.Shows;


import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.ShowHasUsers.ShowHasUser;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name = "SHOWS")
@Entity
public class Show {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String country;
    @OneToMany (mappedBy = "show")
    List<Season> seasons;
    @OneToMany(mappedBy = "show")
    List<ShowHasUser> showHasUsers;

    public Show() {
    }

    public Show(String name, String country) {
        super();
        this.name = name;
        this.country = country;
    }
}
