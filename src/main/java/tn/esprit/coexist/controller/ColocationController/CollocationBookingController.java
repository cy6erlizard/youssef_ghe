package tn.esprit.coexist.controller.ColocationController;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.ColocationEntity.CollocationBooking;
import tn.esprit.coexist.service.ColocationService.CollocationBooking.BookingCollocationServiceImp;

import java.util.List;

@RestController
@RequestMapping("AnnonceBooking")
@CrossOrigin("*")
@AllArgsConstructor
public class CollocationBookingController {
    @Autowired
    BookingCollocationServiceImp bookingCollocationServiceImp;
    @PostMapping("/add-CollocationBooking")
    @ResponseBody
    public CollocationBooking addCollocationBooking(@RequestBody CollocationBooking b) {

        return bookingCollocationServiceImp.add(b);
    }
    @GetMapping("/get_all_CollocationBookings")
    public List<CollocationBooking> findAll() {
        return bookingCollocationServiceImp.findAll();
    }


    @DeleteMapping("/deleteCollocationBooking/{id}")
    public void delete(@PathVariable("id") Integer CollocationBookingId) {
        bookingCollocationServiceImp.delete(CollocationBookingId);
    }
}
