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

    @Id
    String id;
    @Column(length = 400)
    String description;
    String title;
    Integer noOfEpisode;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    Season season;

    public Episode() {
    }

    public Episode(String seasonId, Integer noOfEpisode, String description, String title) {
        this.id = seasonId + '_' + noOfEpisode;
        this.noOfEpisode = noOfEpisode;
        this.description = description;
        this.title = title;
        this.season = new Season();
    }
}
