package tn.esprit.coexist.service.ColocationService.CollocationFeedback;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.ColocationEntity.CollocationBooking;
import tn.esprit.coexist.entity.ColocationEntity.CollocationFeedback;
import tn.esprit.coexist.repository.ColocationRepository.CollocationBookingRepository;
import tn.esprit.coexist.repository.ColocationRepository.CollocationFeedbackRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CollocationFeedbackServiceImp implements ICRUDService<CollocationFeedback,Integer>, CollocationFeedbackService {

  @Autowired
  CollocationFeedbackRepository collocationFeedbackRepository ;
  CollocationBookingRepository collocationBookingRepository ;

    @Override
    public List<CollocationFeedback> findAll() {
        return collocationFeedbackRepository.findAll();
    }

    @Override
    public CollocationFeedback retrieveItem(Integer idItem) {
        return collocationFeedbackRepository.findById(idItem).get();
    }

    @Override
    public CollocationFeedback add(CollocationFeedback class1) {
        return collocationFeedbackRepository.save(class1);
    }

    @Override
    public void delete(Integer idAnn) {
        collocationFeedbackRepository.deleteById(idAnn);

    }

    @Override
    public CollocationFeedback update(Integer id, CollocationFeedback Classe1) {
        Optional<CollocationFeedback> existingCollocationFeedbackOptional = collocationFeedbackRepository.findById(id);

        if (existingCollocationFeedbackOptional.isPresent()) {
            CollocationFeedback existingCollocationFeedback = existingCollocationFeedbackOptional.get();
            existingCollocationFeedback.setNote(Classe1.getNote());

            return collocationFeedbackRepository.save(existingCollocationFeedback);
        } else {
            return null;
        }

}

    @Override
    public void addFeedbackToCollocation(Integer collocationId, String feedbackNote) {

        Optional<CollocationBooking> collocationBookingOptional = collocationBookingRepository.findById(collocationId);

        if (collocationBookingOptional.isPresent()) {

            CollocationFeedback collocationFeedback = new CollocationFeedback();
            collocationFeedback.setNote(feedbackNote);


            CollocationBooking collocationBooking = collocationBookingOptional.get();
            collocationFeedback.setCollocationBooking(collocationBooking);


            collocationBooking.getCollocationFeedbacks().add(collocationFeedback);


            collocationBookingRepository.save(collocationBooking);
        } else {

            throw new RuntimeException("Collocation with ID " + collocationId + " not found.");
        }
    }

}



