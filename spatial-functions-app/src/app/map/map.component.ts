import { AfterViewInit, Component, OnInit } from '@angular/core';

import { MatRadioChange } from '@angular/material/radio';
import * as L from 'leaflet';
import { CitiesMarkersService } from '../cities-markers.service';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { NewCityComponent } from '../new-city/new-city.component';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit {
  
  private map;
  public europeCitiesChecked:boolean;
  public belgradeCitiesChecked:boolean;
  public europeRussiaCitiesChecked:boolean;

  public newCitiesChecked:boolean;

  numberOfDots: string = '5000'
  numberOfDotsRussia: string = '5000'
  numberOfDotsBelgrade: string = '5000'
  nDots: string[] = ['5000', '10000', '20000',  '40000'];

  databases:string[] = ['postgreSQL', 'mongo', 'neo4j'];
  selectedDatabase=this.databases[0];

  distances: string[] = ['100', '200', '500'];
  selectedDistance = '200';

  newCities:boolean = false;


  private initMap(): void {
    this.map = L.map('map', {
      //center: [ 55.751244, 37.618423 ],
      center: [ 	44.787197, 20.457273 ],
      zoom: 3
    });
    

    

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
  
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  constructor(private citiesMarkersService: CitiesMarkersService, public dialog: MatDialog) {   }

  public onChanged(value:boolean){
    this.europeCitiesChecked = value;
    if(value){
      this.citiesMarkersService.makeEuropeCitiesMarkers(this.map,this.numberOfDots, this.selectedDatabase);
      console.log('number of dots '+ this.numberOfDots)
    }else{
      this.citiesMarkersService.removeEuropeCitiesMarkers(this.map);
    }
  }

  onChangedRadio(e:MatRadioChange){
    this.citiesMarkersService.removeEuropeCitiesMarkers(this.map);
    this.citiesMarkersService.makeEuropeCitiesMarkers(this.map,e.value, this.selectedDatabase);
    console.log('changed ' +e.value);
  }

  onChangedEuropeRussia(value:boolean){
    this.europeRussiaCitiesChecked = value;
    if(value){
      this.citiesMarkersService.makeEuropeRussiaCitiesMarkers(this.map,this.numberOfDotsRussia, this.selectedDatabase);
      console.log('number of dots '+ this.numberOfDotsRussia)
    }else{
      this.citiesMarkersService.removeEuropeRussiaCitiesMarkers(this.map);
    }

  }

  onChangedNewCities(value:boolean){
    this.newCitiesChecked = value;
    if(value){
      /*this.citiesMarkersService.makeEuropeRussiaCitiesMarkers(this.map,this.numberOfDotsRussia, this.selectedDatabase);
      console.log('number of dots '+ this.numberOfDotsRussia)*/
    }else{
      this.citiesMarkersService.removeNewCitiesCitiesMarkers(this.map);
      this.newCities = false;
     // this.citiesMarkersService.removeEuropeRussiaCitiesMarkers(this.map);
    }

  }


  onChangedRadioRussia(e:MatRadioChange){
    this.citiesMarkersService.removeEuropeRussiaCitiesMarkers(this.map);
    this.citiesMarkersService.makeEuropeRussiaCitiesMarkers(this.map,e.value, this.selectedDatabase);
    console.log('changed ' +e.value);
  }


  public onChangedBelgrade(value:boolean){
    this.belgradeCitiesChecked = value;
    if(value){
      this.citiesMarkersService.makeBelgradeCitiesMarkers(this.map,this.numberOfDotsBelgrade, this.selectedDistance, this.selectedDatabase);
      
    }else{
      this.citiesMarkersService.removeBelgradeCitiesMarkers(this.map);
    }
  }

  onSelectedDBChanged(){
    this.onChanged(false);
    this.onChangedBelgrade(false);
    this.onChangedEuropeRussia(false);
    this.onChangedNewCities(false);
  }
  
 
  onChangedRadioBelgrade(e){
    this.citiesMarkersService.removeBelgradeCitiesMarkers(this.map);
    if(e.value == undefined){
      this.citiesMarkersService.makeBelgradeCitiesMarkers(this.map,this.numberOfDotsBelgrade, this.selectedDistance, this.selectedDatabase)
    console.log('changed ' +e.value);
    }else{
      this.citiesMarkersService.makeBelgradeCitiesMarkers(this.map,e.value, this.selectedDistance, this.selectedDatabase)
    console.log('changed ' +e.value);
    }
    
  }

  ngAfterViewInit(): void {
    this.initMap();
  }

  openDialog() {
    this.citiesMarkersService.makeNewCitiesMarkers(this.map);
    const dialogRef = this.dialog.open(NewCityComponent);
  
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);  
      //this.onSelectedDBChanged();
      this.onChanged(false);
    this.onChangedBelgrade(false);
    this.onChangedEuropeRussia(false);
    
      this.newCities = true;
      this.newCitiesChecked = true;
      
    });
  }
}
