import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CollocationBookingService} from "../../Services/collocation-booking.service";
import {Router} from "@angular/router";
import {CollocationBooking} from "../../entity/CollocationBooking";

@Component({
  selector: 'app-add-bookingcoll',
  templateUrl: './add-bookingcoll.component.html',
  styleUrls: ['./add-bookingcoll.component.css']
})
export class AddBookingcollComponent {
  newCollocationBookingFormGroup!: FormGroup;

  constructor(private formBuilder: FormBuilder, private collocationBookingService: CollocationBookingService, private router: Router) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.newCollocationBookingFormGroup = this.formBuilder.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      statusType: ['']
      // Ajoutez d'autres champs au besoin en fonction des propriétés de la réservation de colocation
    });
  }

  handleSaveCollocationBooking(): void {
    if (this.newCollocationBookingFormGroup.valid) {
      const collocationBooking: CollocationBooking = this.newCollocationBookingFormGroup.value as CollocationBooking;

      // Appelez votre service pour enregistrer la réservation de colocation
      this.collocationBookingService.addCollocationBooking(collocationBooking).subscribe({
        next: data => {
          // Affichez un message de succès
          alert("La réservation de colocation a été enregistrée avec succès!");
          // Naviguez vers "/all-collocation-bookings"
          this.router.navigateByUrl("/home/booColl");
        },
        error: err => {

          console.error(err);
        }
      });
    } else {
      // Si le formulaire n'est pas valide, journalisez une erreur ou gérez-la selon vos besoins
      console.error('Le formulaire n\'est pas valide');
      // Vous voudrez peut-être afficher un message d'erreur à l'utilisateur
    }
  }
}
