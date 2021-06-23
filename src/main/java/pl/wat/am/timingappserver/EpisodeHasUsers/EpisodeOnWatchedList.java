package pl.wat.am.timingappserver.EpisodeHasUsers;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.Users.User;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "EpisodeHasUser")
@Entity
@NoArgsConstructor
public class EpisodeOnWatchedList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    Episode episode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    Boolean isOnWatchedList;

    public EpisodeOnWatchedList(Boolean isOnWatchedList) {
        this.isOnWatchedList = isOnWatchedList;
        this.episode = new Episode();
        this.user = new User();
    }
}
