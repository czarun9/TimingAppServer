package pl.wat.am.timingappserver.EpisodeHasUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeOnWatchedListDAO {
    String episodeId;
    String userId;
}
