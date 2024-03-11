package tn.esprit.coexist.controller.ColocationController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.service.ColocationService.AnnoncementCollocation.AnnoncementCollocationServiceImp;

import java.util.List;

@RestController
@RequestMapping("Announce")
@AllArgsConstructor
@CrossOrigin("*")
public class AnnoncementCollocationController {
    @Autowired
    AnnoncementCollocationServiceImp annoncementCollocationServiceImp ;
    @PostMapping("/add-AnnoncementCollocation")
    @ResponseBody
    public AnnoncementCollocation addAnnoncementCollocation(@RequestBody AnnoncementCollocation b) {

        return annoncementCollocationServiceImp.add(b);
    }
    @GetMapping("/get_all_AnnoncementCollocations")
    public List<AnnoncementCollocation> findAll() {
        return annoncementCollocationServiceImp.findAll();
    }

    @PutMapping("/updateAnnoncementCollocation/{id}")
    public AnnoncementCollocation update(@RequestBody AnnoncementCollocation AnnoncementCollocation ,@PathVariable("id") Integer id) {
        return annoncementCollocationServiceImp.update(id,AnnoncementCollocation);
    }

    @DeleteMapping("/deleteAnnoncementCollocation/{id}")
    public void delete(@PathVariable("id") Integer AnnoncementCollocationId) {
        annoncementCollocationServiceImp.delete(AnnoncementCollocationId);
    }
    @GetMapping("/get_AnnoncementById/{id}")
    public ResponseEntity<AnnoncementCollocation> getAnnouncementById(@PathVariable("id") Integer id) {
        AnnoncementCollocation announcement = annoncementCollocationServiceImp.getAnnouncementById(id);

        if (announcement != null) {
            return ResponseEntity.ok(announcement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

