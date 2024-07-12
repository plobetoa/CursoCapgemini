import { Component } from '@angular/core';
import { DemosComponent } from 'src/app/demos/demos.component';
import { HomeComponent } from 'src/app/main';
import GraficoSvgComponent from 'src/lib/my-core/components/grafico-svg/grafico-svg.component';
import { NotificationComponent } from "../../main/notification/notification.component";
import { CommonModule } from '@angular/common';
import { CalculadoraComponent } from '@my/core';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NotificationComponent, CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  menu = [
    {texto: 'inicio', icono: '', componente: HomeComponent},
    {texto: 'demos', icono: '', componente: DemosComponent},
    {texto: 'grafico', icono: '', componente: GraficoSvgComponent},
    {texto: 'calculadora', icono: '\uF1E0', componente: CalculadoraComponent},
  ]
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  actual: any = this.menu[3].componente

  seleccionar(indice: number){
    this.actual = this.menu[indice].componente
  }
}
