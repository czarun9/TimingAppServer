package pl.wat.am.timingappserver.Seasons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.am.timingappserver.Shows.Show;

@Repository
public interface SeasonRepository extends JpaRepository<Season,String> {

}