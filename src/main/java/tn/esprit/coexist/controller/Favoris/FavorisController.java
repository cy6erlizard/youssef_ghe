package tn.esprit.coexist.controller.Favoris;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.entity.ColocationEntity.Favoris;
import tn.esprit.coexist.service.ColocationService.FavorisCollocation.FavorisService;
import tn.esprit.coexist.service.ColocationService.FavorisCollocation.FavorisServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Announce")
@AllArgsConstructor
@CrossOrigin("*")

public class FavorisController {
    @Autowired
    FavorisServiceImp favorisService ;



    @GetMapping("/all")
    public List<Favoris> findAll() {
        return favorisService.findAll();
    }

    @PostMapping("/addAnnoceCollToFAVORIS/{userId}/{annId}")
    public ResponseEntity<?> addAnnoceCollToFAVORIS(@PathVariable Integer userId, @PathVariable Integer annId) {
        Favoris favoris = favorisService.addAnnoceCollToFAVORIS(userId, annId);
        return ResponseEntity.ok().body(favoris);
    }
    @PutMapping("/updateFavorisStatus/{userId}/{annId}")
    public ResponseEntity<String> updateFavorisStatus(
            @PathVariable Integer userId,
            @PathVariable Integer annId,
            @RequestParam boolean favoris) {
        favorisService.updateFavorisStatus(userId, annId, favoris);
        return ResponseEntity.ok("Favoris status updated successfully.");
    }
    @DeleteMapping("/removeAnnoceCollFromFAVORIS/{userId}/{annId}")
    public ResponseEntity<String> removeAnnoceCollFromFAVORIS(
            @PathVariable Integer userId,
            @PathVariable Integer annId) {
        favorisService.removeAnnoceCollFromFAVORIS(userId, annId);
        return ResponseEntity.ok("Announcement removed from favoris successfully.");
    }

    @DeleteMapping("/api/favoris/{announcementId}")
    public ResponseEntity<String> removeFavoris(@PathVariable Integer announcementId) {
        favorisService.removeFavoris(announcementId);
        return ResponseEntity.ok("Announcement removed from favoris successfully.");
    }
}
