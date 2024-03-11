import { Component } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {CollocationBooking} from "../../entity/CollocationBooking";
import {CollocationBookingService} from "../../Services/collocation-booking.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-bookingcoll',
  templateUrl: './all-bookingcoll.component.html',
  styleUrls: ['./all-bookingcoll.component.css']
})
export class AllBookingcollComponent {
  newCollocationBookingFormGroup!: FormGroup;
  allCollocationBookings: CollocationBooking[] = [];

  constructor(private collocationBookingService: CollocationBookingService, private router: Router) { }

  ngOnInit(): void {
    this.collocationBookingService.getAllCollocationBookings().subscribe((data) => {
      // @ts-ignore
      this.allCollocationBookings = data;
    });
  }

  redirectToCreateCollocationBooking() {
    this.router.navigate(['/home/addBooColl']);
  }

  handleDeleteCollocationBooking(collocationBooking: CollocationBooking) {
    let confirmation = confirm("Are you sure?");
    if (!confirmation) return;

    this.collocationBookingService.deleteCollocationBooking(collocationBooking.idCollocationBooking).subscribe({
      next: (resp) => {
        // Supprimer l'élément du tableau
        const index = this.allCollocationBookings.indexOf(collocationBooking);
        if (index !== -1) {
          this.allCollocationBookings.splice(index, 1);
        }
      },
      error: err => {
        console.log(err);
      }
    });
  }

}
