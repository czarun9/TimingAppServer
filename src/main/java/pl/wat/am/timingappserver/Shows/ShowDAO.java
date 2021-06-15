package pl.wat.am.timingappserver.Shows;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ShowDAO implements Serializable {
    private String id;
    private String name;

    public ShowDAO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}