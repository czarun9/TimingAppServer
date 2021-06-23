package pl.wat.am.timingappserver.EpisodeHasUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Episodes.EpisodeRepository;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.Seasons.SeasonRepository;
import pl.wat.am.timingappserver.UserHasShowOnWatchedList.UserShowsOnWatchedList;
import pl.wat.am.timingappserver.UserHasShowOnWatchedList.UserShowsOnWatchedListDAO;
import pl.wat.am.timingappserver.Users.User;
import pl.wat.am.timingappserver.Users.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeOnWatchedListService {

    @Autowired
    EpisodeOnWatchedListRepository episodeOnWatchedListRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SeasonRepository seasonRepository;

    public List<EpisodeOnWatchedListDAO> getAllEpisodesOnWatchedListBySeason(String userId, String seasonId) {
        User user = userRepository.getById(userId);
        Season season = seasonRepository.getById(seasonId);

        List<EpisodeOnWatchedListDAO> episodeOnWatchedListDAOS = new ArrayList<>();
        for (Episode episode : season.getEpisodes()) {
            List<EpisodeOnWatchedList> episodeOnWatchedList = episodeOnWatchedListRepository.findByUserIdAndEpisodeId(userId, episode.getId());
            episodeOnWatchedListDAOS.add(new EpisodeOnWatchedListDAO(episodeOnWatchedList.get(0).getEpisode().getId(),
                    episodeOnWatchedList.get(0).getUser().getId()));
        }
        return episodeOnWatchedListDAOS;
    }

    public void addEpisodeOnWatchedList(EpisodeOnWatchedList episodeOnWatchedList) {

        List<EpisodeOnWatchedList> episodeOnWatchedListTest = episodeOnWatchedListRepository.findByUserIdAndEpisodeId(episodeOnWatchedList.getUser().getId(),episodeOnWatchedList.getEpisode().getId());

        if (episodeOnWatchedListTest.isEmpty()){
            episodeOnWatchedListRepository.save(episodeOnWatchedList);
        }
    }

    public EpisodeOnWatchedList getEpisodeOnWatchedList(String userId, String episodeId) {
        return episodeOnWatchedListRepository.findByUserIdAndEpisodeId(userId, episodeId).get(0);
    }

    public void deleteEpisodeOnWatchedList(String userId, String episodeId){
        List<EpisodeOnWatchedList> episodeOnWatchedListTest = episodeOnWatchedListRepository.findByUserIdAndEpisodeId(userId,episodeId);

        for(EpisodeOnWatchedList episodeOnWatchedList:episodeOnWatchedListTest){
            episodeOnWatchedListRepository.delete(episodeOnWatchedList);
        }
    }
}
