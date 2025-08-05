import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelarReservas } from './cancelar-reservas';

describe('CancelarReservas', () => {
  let component: CancelarReservas;
  let fixture: ComponentFixture<CancelarReservas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CancelarReservas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CancelarReservas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
