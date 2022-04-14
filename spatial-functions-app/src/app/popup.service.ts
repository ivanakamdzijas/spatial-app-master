import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PopupService {

  constructor() { }

  makePlacePopup(data: any): string { 
    return `` +
      `<div> Naziv mesta: ${ data.city }</div>` 
     
  }

}

