import { Component } from '@angular/core';
import { HomeComponent } from '../main';
import { NotificationComponent } from "../main/notification/notification.component";
import { CommonModule } from '@angular/common';
import { HeaderComponent } from "../main/header/header.component";
import { FooterComponent } from "../main/footer/footer.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NotificationComponent, CommonModule, HeaderComponent, FooterComponent,],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  menu = [
    {texto: 'inicio', icono: 'fa-solid fa-house', componente: HomeComponent},
  ]
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  actual: any = this.menu[0].componente

  seleccionar(indice: number){
    this.actual = this.menu[indice].componente
  }
}
