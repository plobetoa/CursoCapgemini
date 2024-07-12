import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SecurityModule } from './security';
import { NotificationComponent } from './main/notification/notification.component';
import { DemosComponent } from './demos/demos.component';
import { HomeComponent, NotificationModalComponent } from './main';
import { DashboardComponent } from "./ejemplos/dashboard/dashboard.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SecurityModule, NotificationComponent, NotificationModalComponent, DemosComponent, HomeComponent, DashboardComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
}
