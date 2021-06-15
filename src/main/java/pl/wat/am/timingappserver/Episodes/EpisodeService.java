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

    public EpisodeDAODetails getEpisodeDetails(String id) {
        Episode episode = (Episode) episodeRepository.findById(id).orElse(null);
        EpisodeDAODetails episodeDAODetails = new EpisodeDAODetails();
        episodeDAODetails.setId(episode.getId());
        episodeDAODetails.setNoOfEpisode(episode.getNoOfEpisode());
        episodeDAODetails.setDescription(episode.getDescription());
        episodeDAODetails.setTitle(episode.getTitle());
        return episodeDAODetails;
    }
}
