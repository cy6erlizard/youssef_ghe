package tn.esprit.coexist.service.ColocationService.AnnoncementCollocation;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.repository.ColocationRepository.AnnoncementCollocationRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AnnoncementCollocationServiceImp implements ICRUDService<AnnoncementCollocation,Integer>, AnnoncementCollocationService {
    private static final Logger logger = LoggerFactory.getLogger(AnnoncementCollocationServiceImp.class);


    @Autowired
    AnnoncementCollocationRepository annoncementCollocationRepository ;

    @Override
    public List<AnnoncementCollocation> findAll() {
        return annoncementCollocationRepository.findAll();
    }

    @Override
    public AnnoncementCollocation retrieveItem(Integer idItem) {
        return annoncementCollocationRepository.findById(idItem).get();
    }

    @Override
    public AnnoncementCollocation add(AnnoncementCollocation class1) {
        return annoncementCollocationRepository.save(class1);
    }

    @Override
    public void delete(Integer idAnn) {
        annoncementCollocationRepository.deleteById(idAnn);

    }

    @Override
    public AnnoncementCollocation update(Integer id, AnnoncementCollocation Classe1) {
        logger.info("Updating AnnoncementCollocation with ID: {}", id);

        Optional<AnnoncementCollocation> existingSubjectOptional = annoncementCollocationRepository.findById(id);

        if (existingSubjectOptional.isPresent()) {
            AnnoncementCollocation existingSubject = existingSubjectOptional.get();
            logger.debug("Found existing AnnoncementCollocation: {}", existingSubject);

            String newAddress = Classe1.getAddress();
            logger.debug("New address received: {}", newAddress);

            existingSubject.setAddress(newAddress);
            logger.info("Address updated to: {}", newAddress);

            AnnoncementCollocation updatedAnnoncement = annoncementCollocationRepository.save(existingSubject);
            logger.info("AnnoncementCollocation updated successfully: {}", updatedAnnoncement);

            return updatedAnnoncement;
        } else {
            logger.warn("AnnoncementCollocation with ID {} not found", id);
            return null;
        }
    }
    @Override
    public AnnoncementCollocation getAnnouncementById(Integer id) {
        Optional<AnnoncementCollocation> announcementOptional = annoncementCollocationRepository.findById(id);
        return announcementOptional.orElse(null);
    }


}



