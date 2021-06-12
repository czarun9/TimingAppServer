package pl.wat.am.timingappserver.Episodes;

import lombok.Getter;
import lombok.Setter;
import pl.wat.am.timingappserver.Seasons.Season;

import javax.persistence.*;


@Getter
@Setter
@Table(name = "EPISODES")
@Entity
public class Episode {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String description;
    String title;

    @ManyToOne
    @JoinColumn(name = "season_id",nullable = false)
    Season season;


}
