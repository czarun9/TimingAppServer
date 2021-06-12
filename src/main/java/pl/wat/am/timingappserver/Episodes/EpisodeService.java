package pl.wat.am.timingappserver.Episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {

    @Autowired
    EpisodeRepository episodeRepository;

    public void addEpisode(Episode episode) {
        episodeRepository.save(episode);
    }
}
