import { Component, OnDestroy, OnInit } from '@angular/core';
import { NotificationService, NotificationType } from '../common-services';
import { Unsubscribable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MyCoreModule } from '@my/core';

@Component({
  selector: 'app-demos',
  standalone: true,
  imports: [CommonModule, FormsModule, MyCoreModule,],
  templateUrl: './demos.component.html',
  styleUrl: './demos.component.css'
})
export class DemosComponent implements OnInit, OnDestroy {
  // eslint-disable-next-line @typescript-eslint/no-inferrable-types
  private nombre: string = 'mundo'
  fecha = '2024-07-11'
  fontSize = 24
  listado = [
    {id: 1, nombre: 'Madrid'},
    {id: 2, nombre: 'BARCELONA'},
    {id: 3, nombre: 'oviedo'},
    {id: 4, nombre: 'ciudad Real'},
  ]
  idProvincia = 2
  
  resultado?: string
  visible = true
  estetica = { importante: true, error: false, urgente: true}
  
  private suscriptor: Unsubscribable | undefined;

  constructor(public vm: NotificationService) { }

  public get Nombre(): string { return this.nombre }

  public set Nombre(value: string){ 
    if(this.nombre === value) return
    this.nombre = value
   }

   public saluda(): void{
    this.resultado  = `Hola ${this.Nombre}`
   }

   public despide(): void{
    this.resultado  = `Adios ${this.Nombre}`
   }

   public di(algo: string): void{
    this.resultado  = `Hola ${algo}`
   }

   cambia(){
    this.visible = !this.visible
    this.estetica.error = !this.estetica.error
    this.estetica.importante = !this.estetica.importante
   }

   public calcula(a:number, b:number):number {return a+b}

   public add (provincia:string){
    const id = this.listado[this.listado.length - 1].id + 1
    this.listado.push({id, nombre: provincia})
    this.idProvincia = id
   }

  ngOnInit(): void {
    this.suscriptor = this.vm.Notificacion.subscribe(n => {
      if (n.Type !== NotificationType.error) { return; }
      window.alert(`Suscripcion: ${n.Message}`);
      this.vm.remove(this.vm.Listado.length - 1);
    });
  }
  ngOnDestroy(): void {
    if (this.suscriptor) {
      this.suscriptor.unsubscribe();
    }
  }
  
}
