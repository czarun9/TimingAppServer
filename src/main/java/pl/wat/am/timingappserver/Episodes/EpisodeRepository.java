package pl.wat.am.timingappserver.Episodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.am.timingappserver.Seasons.Season;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,String> {

}
