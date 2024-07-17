import { Component, OnInit, OnDestroy, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DatePipe, } from '@angular/common';
import { PaginatorModule } from 'primeng/paginator';
import { ErrorMessagePipe, TypeValidator } from '@my/core';
import { CategoriasViewModelService } from './servicios.service';

@Component({
    selector: 'app-categorias-list',
    templateUrl: './tmpl-list.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [RouterLink, PaginatorModule]
})
export class CategoriasListComponent implements OnChanges, OnDestroy {
  @Input() page = 0

  constructor(protected vm: CategoriasViewModelService) { }
  public get VM(): CategoriasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    this.vm.load(this.page)
  }
  ngOnDestroy(): void { this.vm.clear(); }
}
@Component({
    selector: 'app-categorias-add',
    templateUrl: './tmpl-form.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [FormsModule, TypeValidator, ErrorMessagePipe]
})
export class CategoriasAddComponent implements OnInit {
  constructor(protected vm: CategoriasViewModelService) { }
  public get VM(): CategoriasViewModelService { return this.vm; }
  ngOnInit(): void {
    this.vm.add();
  }
}
@Component({
    selector: 'app-categorias-edit',
    templateUrl: './tmpl-form.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [FormsModule, TypeValidator, ErrorMessagePipe]
})
export class CategoriasEditComponent implements OnChanges {
  @Input() id?: string;
  constructor(protected vm: CategoriasViewModelService, protected router: Router) { }
  public get VM(): CategoriasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    if (this.id) {
      this.vm.view(+this.id);
    } else {
      this.router.navigate(['/404.html']);
    }
  }
}
@Component({
    selector: 'app-categorias-view',
    templateUrl: './tmpl-view.component.html',
    styleUrls: ['./componente.component.css'],
    standalone: true,
    imports: [DatePipe]
})
export class CategoriasViewComponent implements OnChanges {
  @Input() id?: string;
  constructor(protected vm: CategoriasViewModelService, protected router: Router) { }
  public get VM(): CategoriasViewModelService { return this.vm; }
  ngOnChanges(_changes: SimpleChanges): void {
    if (this.id) {
      this.vm.view(+this.id);
    } else {
      this.router.navigate(['/404.html']);
    }
  }
}

export const CATEGORIAS_COMPONENTES = [
  CategoriasListComponent, CategoriasAddComponent, CategoriasEditComponent, CategoriasViewComponent,
];
