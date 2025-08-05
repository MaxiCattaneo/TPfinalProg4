import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarReservas } from './consultar-reservas';

describe('ConsultarReservas', () => {
  let component: ConsultarReservas;
  let fixture: ComponentFixture<ConsultarReservas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarReservas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarReservas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
