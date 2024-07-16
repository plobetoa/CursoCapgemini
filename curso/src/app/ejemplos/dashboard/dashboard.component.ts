import { Component } from '@angular/core';
import { DemosComponent } from 'src/app/demos/demos.component';
import { HomeComponent } from 'src/app/main';
import GraficoSvgComponent from 'src/lib/my-core/components/grafico-svg/grafico-svg.component';
import { NotificationComponent } from "../../main/notification/notification.component";
import { CommonModule } from '@angular/common';
import { CalculadoraComponent } from '@my/core';
import { FormularioComponent } from '../formulario/formulario.component';
import { ContactosComponent } from 'src/app/contactos';
import { HeaderComponent } from "../../main/header/header.component";
import { FooterComponent } from "../../main/footer/footer.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NotificationComponent, CommonModule, HeaderComponent, FooterComponent, HeaderComponent, FooterComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  menu = [
    {texto: 'formulario', icono: 'fa-solid fa-person-chalkboard', componente: FormularioComponent},
    {texto: 'inicio', icono: 'fa-solid fa-house', componente: HomeComponent},
    {texto: 'demos', icono: 'fa-solid fa-person-chalkboard', componente: DemosComponent},
    {texto: 'grafico', icono: 'fa-solid fa-image', componente: GraficoSvgComponent},
    {texto: 'calculadora', icono: 'fa-solid fa-calculator', componente: CalculadoraComponent},
    {texto: 'contactos', icono: 'fa-solid fa-address-book', componente: ContactosComponent},
  ]
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  actual: any = this.menu[0].componente

  seleccionar(indice: number){
    this.actual = this.menu[indice].componente
  }
}
