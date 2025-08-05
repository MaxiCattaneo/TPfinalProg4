import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarReservasId } from './consultar-reservas-id';

describe('ConsultarReservasId', () => {
  let component: ConsultarReservasId;
  let fixture: ComponentFixture<ConsultarReservasId>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarReservasId]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarReservasId);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
