package tn.esprit.coexist.service.ColocationService.FavorisCollocation;

import tn.esprit.coexist.entity.ColocationEntity.Favoris;

public interface FavorisService {
    Favoris addAnnoceCollToFAVORIS(Integer userId, Integer annId) ;
    void updateFavorisStatus(Integer userId, Integer annId, boolean favoris);
    void removeAnnoceCollFromFAVORIS(Integer userId, Integer annId);
    void removeFavoris(Integer announcementId);
}
