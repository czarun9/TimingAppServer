package pl.wat.am.timingappserver.Shows;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wat.am.timingappserver.Seasons.SeasonDAO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShowDAODetails {
    private String id;
    private String name;
    private List<SeasonDAO> seasonList;
    private Boolean isWatched;

    public ShowDAODetails(String id, String name, List<SeasonDAO> seasonList) {
        this.id = id;
        this.name = name;
        this.seasonList = seasonList;
        this.isWatched = false;
    }

}
