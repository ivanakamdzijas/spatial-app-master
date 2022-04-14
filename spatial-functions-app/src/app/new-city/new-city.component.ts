import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CitiesMarkersService } from '../cities-markers.service';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent implements OnInit {

  numberOfDots:string = '5000'
  nDots: string[] = ['5000', '10000', '20000',  '40000'];

  databases:string[] = ['postgis', 'mongo', 'neo4j'];
  selectedDatabase=this.databases[0];

  form: FormGroup;

  constructor(public fb: FormBuilder, private citiesCircleMarkerService: CitiesMarkersService) { 
    this.form = this.fb.group({
      city: [''],
      country: [''],
      lat: '',
      lon: ''
    })
  }


  ngOnInit(): void {
  }

  submitForm() {
    console.log(this.form.value);
    
    console.log(this.form.get('city')?.value);
    console.log(this.form.get('country')?.value);
    console.log(this.form.get('lon')?.value);
    console.log(this.form.get('lat')?.value);
    const city = this.form.get('city')?.value;
    const country = this.form.get('country')?.value;
    const lon =this.form.get('lon')?.value;
    const lat = this.form.get('lat')?.value
    this.citiesCircleMarkerService.saveCity(city, country, lat, lon, this.numberOfDots, this.selectedDatabase);
    this.form.reset();
    

  }

 
}
