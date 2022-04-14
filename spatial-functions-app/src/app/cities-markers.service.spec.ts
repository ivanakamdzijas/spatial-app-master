import { TestBed } from '@angular/core/testing';

import { CitiesMarkersService } from './cities-markers.service';

describe('CitiesMarkersService', () => {
  let service: CitiesMarkersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CitiesMarkersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
