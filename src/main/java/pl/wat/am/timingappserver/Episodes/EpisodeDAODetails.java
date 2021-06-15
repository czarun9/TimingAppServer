package pl.wat.am.timingappserver.Episodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDAODetails {
    String id;
    String title;
    String description;
    Integer noOfEpisode;
}
