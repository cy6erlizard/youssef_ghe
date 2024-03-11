package tn.esprit.coexist.service.ColocationService.CollocationBooking;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.coexist.entity.ColocationEntity.CollocationBooking;
import tn.esprit.coexist.repository.ColocationRepository.CollocationBookingRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingCollocationServiceImp implements ICRUDService<CollocationBooking,Integer>, tn.esprit.coexist.service.CollocationBooking.BookingCollocationService {
    @Autowired
    CollocationBookingRepository collocationBookingRepository;



    @Override
    public List<CollocationBooking> findAll()  {
        return collocationBookingRepository.findAll();
    }

    @Override
    public CollocationBooking retrieveItem(Integer idItem) {
        return collocationBookingRepository.findById(idItem).get();
    }

    @Override
    public CollocationBooking add(CollocationBooking class1) {
        return collocationBookingRepository.save(class1);
    }

    @Override
    public void delete(Integer idBooking) {
        collocationBookingRepository.deleteById(idBooking);

    }

    @Override
    public CollocationBooking update(Integer integer, CollocationBooking Classe1) {
        return null;
    }


}
