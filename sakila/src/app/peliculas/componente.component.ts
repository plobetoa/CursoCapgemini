import { Component, OnInit, OnDestroy, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DatePipe, } from '@angular/common';
import { PaginatorModule } from 'primeng/paginator';
import { ErrorMessagePipe, TypeValidator } from '@my/core';
import { PeliculasViewModelService } from './servicios.service';

@Component({
    selector: 'app-peliculas-list',
    templateUrl: './tmpl-list.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [RouterLink, PaginatorModule]
})
export class PeliculasListComponent implements OnChanges, OnDestroy {
  @Input() page = 0

  constructor(protected vm: PeliculasViewModelService) { }
  public get VM(): PeliculasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    this.vm.load(this.page)
  }
  ngOnDestroy(): void { this.vm.clear(); }
}
@Component({
    selector: 'app-peliculas-add',
    templateUrl: './tmpl-form.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [FormsModule, TypeValidator, ErrorMessagePipe]
})
export class PeliculasAddComponent implements OnInit {
  constructor(protected vm: PeliculasViewModelService) { }
  public get VM(): PeliculasViewModelService { return this.vm; }
  ngOnInit(): void {
    this.vm.add();
  }
}
@Component({
    selector: 'app-peliculas-edit',
    templateUrl: './tmpl-form.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [FormsModule, TypeValidator, ErrorMessagePipe]
})
export class PeliculasEditComponent implements OnChanges {
  @Input() id?: string;
  constructor(protected vm: PeliculasViewModelService, protected router: Router) { }
  public get VM(): PeliculasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    if (this.id) {
      this.vm.view(+this.id);
    } else {
      this.router.navigate(['/404.html']);
    }
  }
}
@Component({
    selector: 'app-peliculas-view',
    templateUrl: './tmpl-view.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [DatePipe]
})
export class PeliculasViewComponent implements OnChanges {
  @Input() id?: string;
  constructor(protected vm: PeliculasViewModelService, protected router: Router) { }
  public get VM(): PeliculasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    if (this.id) {
      this.vm.view(+this.id);
    } else {
      this.router.navigate(['/404.html']);
    }
  }
}

export const PELICULAS_COMPONENTES = [
  PeliculasListComponent, PeliculasAddComponent, PeliculasEditComponent, PeliculasViewComponent,
];
