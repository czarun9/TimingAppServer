package pl.wat.am.timingappserver.EpisodeHasUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Users.User;

import java.util.List;


public interface EpisodeOnWatchedListRepository extends JpaRepository<EpisodeOnWatchedList,String> {
    List<EpisodeOnWatchedList> findByUserIdAndEpisodeId(String userId, String episodeId);
}
