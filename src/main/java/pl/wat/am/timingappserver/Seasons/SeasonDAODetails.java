package pl.wat.am.timingappserver.Seasons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wat.am.timingappserver.Episodes.EpisodeDAO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDAODetails {
    String id;
    Integer noOfSeason;
    List<EpisodeDAO> episodes;
}


