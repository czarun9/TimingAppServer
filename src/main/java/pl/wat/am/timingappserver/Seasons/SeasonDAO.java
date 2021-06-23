package pl.wat.am.timingappserver.Seasons;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SeasonDAO {
    String id;
    Integer noOfSeason;
    Boolean isWatched;

    public SeasonDAO(String id, Integer noOfSeason) {
        this.id = id;
        this.noOfSeason = noOfSeason;
        this.isWatched = false;
    }
}
