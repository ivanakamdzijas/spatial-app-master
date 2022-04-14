import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule,  ReactiveFormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import { CitiesMarkersService } from './cities-markers.service';
import { NgxUiLoaderModule } from 'ngx-ui-loader';
import { MatDialogModule } from '@angular/material/dialog';
import { NewCityComponent } from './new-city/new-city.component';

import {MatDividerModule} from '@angular/material/divider';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    NewCityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatRadioModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDialogModule,
    MatDividerModule,
    NgxUiLoaderModule,
  ],
  providers: [CitiesMarkersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
