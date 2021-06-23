package pl.wat.am.timingappserver.EpisodeHasUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wat.am.timingappserver.Episodes.Episode;
import pl.wat.am.timingappserver.Episodes.EpisodeService;
import pl.wat.am.timingappserver.Seasons.Season;
import pl.wat.am.timingappserver.Shows.Show;
import pl.wat.am.timingappserver.UserHasShowOnWatchedList.UserShowsOnWatchedList;
import pl.wat.am.timingappserver.Users.User;
import pl.wat.am.timingappserver.Users.UserService;

import java.util.List;

@RestController
public class EpisodeOnWatchedListController {
    @Autowired
    EpisodeOnWatchedListService episodeOnWatchedListService;
    @Autowired
    EpisodeService episodeService;
    @Autowired
    UserService userService;

   /* @RequestMapping(method = RequestMethod.GET, value = "users/{userId}/seasons/{seasonId}")
    public List<EpisodeOnWatchedListDAO> getAllEpisodesOnWatchedListBySeason(@PathVariable String userId, @PathVariable String seasonId) {
        return episodeOnWatchedListService.getAllEpisodesOnWatchedListBySeason(userId, seasonId);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "users/{userId}/shows/{showId}/seasons/{seasonId}/episodes/{episodeId}")
    public void addEpisodeOnWatchedList(@RequestBody EpisodeOnWatchedList episodeOnWatchedList, @PathVariable String userId, @PathVariable String showId, @PathVariable String seasonId, @PathVariable String episodeId) {

        Episode episode = episodeService.getEpisode(episodeId);
        User user = userService.getUser(userId);

        episodeOnWatchedList.setUser(user);
        episodeOnWatchedList.setIsOnWatchedList(true);
        episodeOnWatchedList.setEpisode(episode);

        episodeOnWatchedListService.addEpisodeOnWatchedList(episodeOnWatchedList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "users/{userId}/shows/{showId}/seasons/{seasonId}/episodes/{episodeId}")
    public EpisodeOnWatchedListDAO getEpisodeOnWatchedList(@PathVariable String userId, @PathVariable String showId, @PathVariable String seasonId, @PathVariable String episodeId) {
        EpisodeOnWatchedList episodeOnWatchedList = episodeOnWatchedListService.getEpisodeOnWatchedList(userId, episodeId);
        return new EpisodeOnWatchedListDAO(episodeOnWatchedList.getEpisode().getId(),episodeOnWatchedList.getUser().getId());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "users/{userId}/shows/{showId}/seasons/{seasonId}/episodes/{episodeId}")
    public void deleteEpisodeOnWatchedList(@PathVariable String userId, @PathVariable String showId, @PathVariable String seasonId, @PathVariable String episodeId) {
        episodeOnWatchedListService.deleteEpisodeOnWatchedList(userId, episodeId);
    }


}
