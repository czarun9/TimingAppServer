package pl.wat.am.timingappserver.Seasons;


import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Shows.Show;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "SEASONS")
public class Season {
    @Id
    String id;
    String description;
    Integer noOfSeason;
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    Show show;

    @OneToMany
    List<Episode> episodes;


    public Season() {
    }

    public Season(String showId, String description, Integer noOfSeason) {
        this.id = showId + "_" + noOfSeason;
        this.description = description;
        this.noOfSeason = noOfSeason;
        this.show = new Show();
    }
}
