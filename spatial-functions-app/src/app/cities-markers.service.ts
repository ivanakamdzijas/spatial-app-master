import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as L from 'leaflet';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { PopupService } from './popup.service';

@Injectable({
  providedIn: 'root'
})
export class CitiesMarkersService {

  //mongo
  mongoeuropeCitiesUrl5000:string ='http://localhost:8081/cities5/mongo/europe';
  mongoeuropeCitiesUrl10000:string ='http://localhost:8081/cities10/mongo/europe';
  mongoeuropeCitiesUrl20000:string ='http://localhost:8081/cities20/mongo/europe'
  mongoeuropeCitiesUrl40000:string ='http://localhost:8081/cities40/mongo/europe';

  mongoeuropeRussiaCitiesUrl5000:string = 'http://localhost:8081/cities5/mongo/russia'
  mongoeuropeRussiaCitiesUrl10000:string ='http://localhost:8081/cities10/mongo/russia';
  mongoeuropeRussiaCitiesUrl20000:string = 'http://localhost:8081/cities20/mongo/russia';
  mongoeuropeRussiaCitiesUrl40000:string ='http://localhost:8081/cities40/mongo/russia'
  mongobelgradeUrl5000100:string ='http://localhost:8081/cities5/mongo/bg100'
  mongobelgradeUrl5000200:string = 'http://localhost:8081/cities5/mongo/bg200'
  mongobelgradeUrl5000500:string = 'http://localhost:8081/cities5/mongo/bg500'
  mongobelgradeUrl10000100:string = 'http://localhost:8081/cities10/mongo/bg100'
  mongobelgradeUrl10000200:string = 'http://localhost:8081/cities10/mongo/bg200'
  mongobelgradeUrl10000500:string = 'http://localhost:8081/cities10/mongo/bg500'
  mongobelgradeUrl20000100:string = 'http://localhost:8081/cities20/mongo/bg100'
  mongobelgradeUrl20000200:string = 'http://localhost:8081/cities20/mongo/bg200'
  mongobelgradeUrl20000500:string = 'http://localhost:8081/cities20/mongo/bg500'
  
  mongobelgradeUrl40000100:string = 'http://localhost:8081/cities40/mongo/bg100'
  mongobelgradeUrl40000200:string = 'http://localhost:8081/cities40/mongo/bg200'
  mongobelgradeUrl40000500:string = 'http://localhost:8081/cities10/mongo/bg500'
  

  //postgreSQL
  postgreSQLeuropeCitiesUrl5000:string = 'http://localhost:8081/cities5/postgis/europe';
  postgreSQLeuropeCitiesUrl10000:string ='http://localhost:8081/cities10/postgis/europe';
  postgreSQLeuropeCitiesUrl20000:string ='http://localhost:8081/cities20/postgis/europe';
  postgreSQLeuropeCitiesUrl40000:string ='http://localhost:8081/cities40/postgis/europe';

  postgreSQLeuropeRussiaCitiesUrl5000:string = 'http://localhost:8081/cities5/postgis/russia';
  postgreSQLeuropeRussiaCitiesUrl10000:string ='http://localhost:8081/cities10/postgis/russia';
  postgreSQLeuropeRussiaCitiesUrl20000:string ='http://localhost:8081/cities20/postgis/russia';
  postgreSQLeuropeRussiaCitiesUrl40000:string ='http://localhost:8081/cities40/postgis/russia';
  postgreSQLbelgradeUrl5000100:string ='http://localhost:8081/cities5/postgis/bg100';
  postgreSQLbelgradeUrl5000200:string = 'http://localhost:8081/cities5/postgis/bg200';
  postgreSQLbelgradeUrl5000500:string = 'http://localhost:8081/cities5/postgis/bg500';
  postgreSQLbelgradeUrl10000100:string = 'http://localhost:8081/cities10/postgis/bg100';
  postgreSQLbelgradeUrl10000200:string = 'http://localhost:8081/cities10/postgis/bg200';
  postgreSQLbelgradeUrl10000500:string = 'http://localhost:8081/cities10/postgis/bg500';
  postgreSQLbelgradeUrl20000100:string = 'http://localhost:8081/cities20/postgis/bg100';
  postgreSQLbelgradeUrl20000200:string = 'http://localhost:8081/cities20/postgis/bg200';
  postgreSQLbelgradeUrl20000500:string = 'http://localhost:8081/cities20/postgis/bg500';
  
  postgreSQLbelgradeUrl40000100:string = 'http://localhost:8081/cities40/postgis/bg100';
  postgreSQLbelgradeUrl40000200:string = 'http://localhost:8081/cities40/postgis/bg200';
  postgreSQLbelgradeUrl40000500:string = 'http://localhost:8081/cities40/postgis/bg500';
  
  //geoserver
  /**mongoeuropeCitiesUrl5000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-cities-5&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeCitiesUrl10000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-cities-10&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeCitiesUrl20000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-cities-20&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeCitiesUrl40000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-cities-40&maxFeatures=50&outputFormat=application%2Fjson';

  mongoeuropeRussiaCitiesUrl5000:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-russia-5&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeRussiaCitiesUrl10000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-russia-10&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeRussiaCitiesUrl20000:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-russia-20&maxFeatures=50&outputFormat=application%2Fjson';
  mongoeuropeRussiaCitiesUrl40000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-russia-40&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl5000100:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-5-100&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl5000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-5-200&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl5000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-5-500&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl10000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-10-100&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl10000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-10-200&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl10000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-10-500&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl20000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-20-100&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl20000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-20-200&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl20000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-20-500&maxFeatures=50&outputFormat=application%2Fjson';
  
  mongobelgradeUrl40000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-40-100&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl40000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-40-200&maxFeatures=50&outputFormat=application%2Fjson';
  mongobelgradeUrl40000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Amongo-belgrade-40-500&maxFeatures=50&outputFormat=application%2Fjson';
  

  //postgreSQL
  postgreSQLeuropeCitiesUrl5000:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe&maxFeatures=50&outputFormat=application%2Fjson'
  postgreSQLeuropeCitiesUrl10000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-10&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLeuropeCitiesUrl20000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-20&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLeuropeCitiesUrl40000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-40&maxFeatures=50&outputFormat=application%2Fjson';

  postgreSQLeuropeRussiaCitiesUrl5000:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-russia-5&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLeuropeRussiaCitiesUrl10000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-russia-10&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLeuropeRussiaCitiesUrl20000:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-russia-20&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLeuropeRussiaCitiesUrl40000:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Acities-europe-russia-40&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl5000100:string ='http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-5-100km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl5000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-5-200km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl5000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-5-500km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl10000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-10-100km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl10000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-10-200km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl10000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-10-500km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl20000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-20-100km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl20000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-20-200km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl20000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-20-500km&maxFeatures=50&outputFormat=application%2Fjson';
  
  postgreSQLbelgradeUrl40000100:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-40-100km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl40000200:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-40-200km&maxFeatures=50&outputFormat=application%2Fjson';
  postgreSQLbelgradeUrl40000500:string = 'http://localhost:8080/geoserver/master/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=master%3Abelgrade-40-500km&maxFeatures=50&outputFormat=application%2Fjson';
  
   */
   //neo
  neo4jeuropeCitiesUrl5000:string ='http://localhost:8081/cities5/neo4j/europe';
   neo4jeuropeCitiesUrl10000:string ='http://localhost:8081/cities10/neo4j/europe';
   neo4jeuropeCitiesUrl20000:string ='http://localhost:8081/cities20/neo4j/europe';
   neo4jeuropeCitiesUrl40000:string ='http://localhost:8081/cities40/neo4j/europe';
 
   neo4jeuropeRussiaCitiesUrl5000:string = 'http://localhost:8081/cities5/neo4j/russia';
   neo4jeuropeRussiaCitiesUrl10000:string ='http://localhost:8081/cities10/neo4j/russia';
   neo4jeuropeRussiaCitiesUrl20000:string = 'http://localhost:8081/cities20/neo4j/russia';
   neo4jeuropeRussiaCitiesUrl40000:string ='http://localhost:8081/cities40/neo4j/russia';
   neo4jbelgradeUrl5000100:string ='http://localhost:8081/cities5/neo4j/bg100';
   neo4jbelgradeUrl5000200:string = 'http://localhost:8081/cities5/neo4j/bg200';
   neo4jbelgradeUrl5000500:string = 'http://localhost:8081/cities5/neo4j/bg500';
   neo4jbelgradeUrl10000100:string = 'http://localhost:8081/cities10/neo4j/bg100';
   neo4jbelgradeUrl10000200:string = 'http://localhost:8081/cities10/neo4j/bg200';
   neo4jbelgradeUrl10000500:string = 'http://localhost:8081/cities10/neo4j/bg500';
   neo4jbelgradeUrl20000100:string = 'http://localhost:8081/cities20/neo4j/bg100';
   neo4jbelgradeUrl20000200:string = 'http://localhost:8081/cities20/neo4j/bg200';
   neo4jbelgradeUrl20000500:string = 'http://localhost:8081/cities20/neo4j/bg500';
   
   neo4jbelgradeUrl40000100:string = 'http://localhost:8081/cities40/bg100';
   neo4jbelgradeUrl40000200:string = 'http://localhost:8081/cities40/bg200';
   neo4jbelgradeUrl40000500:string = 'http://localhost:8081/cities40/bg500';
   
 
  url:string;


  europeCitiesLayerGroup:any; 
  europeRussiaCitiesLayerGroup:any; 
  belgradeLayerGroup:any; 
  newCitiesLayerGroup:any;

  

  

  constructor(private http: HttpClient,  private popupService: PopupService, private ngxService: NgxUiLoaderService) { }


  findURL(citiesUrl:string){
    console.log(citiesUrl);
    switch(citiesUrl){

      //postgreSQL
      case 'postgreSQLeuropeCitiesUrl5000': { 
        this.url = this.postgreSQLeuropeCitiesUrl5000;
         break; 
      } 
      case 'postgreSQLeuropeCitiesUrl10000': { 
        this.url = this.postgreSQLeuropeCitiesUrl10000;
         break; 
      } 
      case 'postgreSQLeuropeCitiesUrl20000': { 
        this.url = this.postgreSQLeuropeCitiesUrl20000;
         break; 
      } 
      case 'postgreSQLeuropeCitiesUrl40000': { 
        this.url = this.postgreSQLeuropeCitiesUrl40000;
         break; 
      } 
      case 'postgreSQLeuropeRussiaCitiesUrl5000': { 
        this.url = this.postgreSQLeuropeRussiaCitiesUrl5000;
         break; 
      } 
      case 'postgreSQLeuropeRussiaCitiesUrl10000': { 
        this.url = this.postgreSQLeuropeRussiaCitiesUrl10000;
         break; 
      } 
      case 'postgreSQLeuropeRussiaCitiesUrl20000': { 
        this.url = this.postgreSQLeuropeRussiaCitiesUrl20000;
         break; 
      } 
      case 'postgreSQLeuropeRussiaCitiesUrl40000': { 
        this.url = this.postgreSQLeuropeRussiaCitiesUrl40000;
         break; 
      } 
      case 'postgreSQLbelgradeUrl5000100': { 
        this.url = this.postgreSQLbelgradeUrl5000100;
         break; 
      } 
      case 'postgreSQLbelgradeUrl5000200': { 
        this.url = this.postgreSQLbelgradeUrl5000200;
         break; 
      } 
      case 'postgreSQLbelgradeUrl5000500': { 
        this.url = this.postgreSQLbelgradeUrl5000500;
         break; 
      } 
      case 'postgreSQLbelgradeUrl10000100': { 
        this.url = this.postgreSQLbelgradeUrl10000100;
         break; 
      } 
      case 'postgreSQLbelgradeUrl10000200': { 
        this.url = this.postgreSQLbelgradeUrl10000200;
         break; 
      }
      case 'postgreSQLbelgradeUrl10000500': { 
        this.url = this.postgreSQLbelgradeUrl10000500;
         break; 
      } 
      case 'postgreSQLbelgradeUrl20000100': { 
        this.url = this.postgreSQLbelgradeUrl20000100;
         break; 
      } 
      case 'postgreSQLbelgradeUrl20000200': { 
        this.url = this.postgreSQLbelgradeUrl20000200;
         break; 
      } 
      case 'postgreSQLbelgradeUrl20000500': { 
        this.url = this.postgreSQLbelgradeUrl20000500;
         break; 
      }  
      case 'postgreSQLbelgradeUrl40000100': { 
        this.url = this.postgreSQLbelgradeUrl40000100;
         break; 
      } 
      case 'postgreSQLbelgradeUrl40000200': { 
        this.url = this.postgreSQLbelgradeUrl40000200;
         break; 
      } 
      case 'postgreSQLbelgradeUrl40000500': { 
        this.url = this.postgreSQLbelgradeUrl40000500;
         break; 
      } 

      //mongo
      case 'mongoeuropeCitiesUrl5000': { 
        this.url = this.mongoeuropeCitiesUrl5000;
         break; 
      } 
      case 'mongoeuropeCitiesUrl10000': { 
        this.url = this.mongoeuropeCitiesUrl10000;
         break; 
      } 
      case 'mongoeuropeCitiesUrl20000': { 
        this.url = this.mongoeuropeCitiesUrl20000;
         break; 
      } 
      case 'mongoeuropeCitiesUrl40000': { 
        this.url = this.mongoeuropeCitiesUrl40000;
         break; 
      } 
      case 'mongoeuropeRussiaCitiesUrl5000': { 
        this.url = this.mongoeuropeRussiaCitiesUrl5000;
         break; 
      } 
      case 'mongoeuropeRussiaCitiesUrl10000': { 
        this.url = this.mongoeuropeRussiaCitiesUrl10000;
         break; 
      } 
      case 'mongoeuropeRussiaCitiesUrl20000': { 
        this.url = this.mongoeuropeRussiaCitiesUrl20000;
         break; 
      } 
      case 'mongoeuropeRussiaCitiesUrl40000': { 
        this.url = this.mongoeuropeRussiaCitiesUrl40000;
         break; 
      } 
      case 'mongobelgradeUrl5000100': { 
        this.url = this.mongobelgradeUrl5000100;
         break; 
      } 
      case 'mongobelgradeUrl5000200': { 
        this.url = this.mongobelgradeUrl5000200;
         break; 
      } 
      case 'mongobelgradeUrl5000500': { 
        this.url = this.mongobelgradeUrl5000500;
         break; 
      } 
      case 'mongobelgradeUrl10000100': { 
        this.url = this.mongobelgradeUrl10000100;
         break; 
      } 
      case 'mongobelgradeUrl10000200': { 
        this.url = this.mongobelgradeUrl10000200;
         break; 
      }
      case 'mongobelgradeUrl10000500': { 
        this.url = this.mongobelgradeUrl10000500;
         break; 
      } 
      case 'mongobelgradeUrl20000100': { 
        this.url = this.mongobelgradeUrl20000100;
         break; 
      } 
      case 'mongobelgradeUrl20000200': { 
        this.url = this.mongobelgradeUrl20000200;
         break; 
      } 
      case 'mongobelgradeUrl20000500': { 
        this.url = this.mongobelgradeUrl20000500;
         break; 
      }  
      case 'mongobelgradeUrl40000100': { 
        this.url = this.mongobelgradeUrl40000100;
         break; 
      } 
      case 'mongobelgradeUrl40000200': { 
        this.url = this.mongobelgradeUrl40000200;
         break; 
      } 
      case 'mongobelgradeUrl40000500': { 
        this.url = this.mongobelgradeUrl40000500;
         break; 
      } 

      //neo
      case 'neo4jeuropeCitiesUrl5000': { 
        this.url = this.neo4jeuropeCitiesUrl5000;
         break; 
      } 
      case 'neo4jeuropeCitiesUrl10000': { 
        this.url = this.neo4jeuropeCitiesUrl10000;
         break; 
      } 
      case 'neo4jeuropeCitiesUrl20000': { 
        this.url = this.neo4jeuropeCitiesUrl20000;
         break; 
      } 
      case 'neo4jeuropeCitiesUrl40000': { 
        this.url = this.neo4jeuropeCitiesUrl40000;
         break; 
      } 
      case 'neo4jeuropeRussiaCitiesUrl5000': { 
        this.url = this.neo4jeuropeRussiaCitiesUrl5000;
         break; 
      } 
      case 'neo4jeuropeRussiaCitiesUrl10000': { 
        this.url = this.neo4jeuropeRussiaCitiesUrl10000;
         break; 
      } 
      case 'neo4jeuropeRussiaCitiesUrl20000': { 
        this.url = this.neo4jeuropeRussiaCitiesUrl20000;
         break; 
      } 
      case 'neo4jeuropeRussiaCitiesUrl40000': { 
        this.url = this.neo4jeuropeRussiaCitiesUrl40000;
         break; 
      } 
      case 'neo4jbelgradeUrl5000100': { 
        this.url = this.neo4jbelgradeUrl5000100;
         break; 
      } 
      case 'neo4jbelgradeUrl5000200': { 
        this.url = this.neo4jbelgradeUrl5000200;
         break; 
      } 
      case 'neo4jbelgradeUrl5000500': { 
        this.url = this.neo4jbelgradeUrl5000500;
         break; 
      } 
      case 'neo4jbelgradeUrl10000100': { 
        this.url = this.neo4jbelgradeUrl10000100;
         break; 
      } 
      case 'neo4jbelgradeUrl10000200': { 
        this.url = this.neo4jbelgradeUrl10000200;
         break; 
      }
      case 'neo4jbelgradeUrl10000500': { 
        this.url = this.neo4jbelgradeUrl10000500;
         break; 
      } 
      case 'neo4jbelgradeUrl20000100': { 
        this.url = this.neo4jbelgradeUrl20000100;
         break; 
      } 
      case 'neo4jbelgradeUrl20000200': { 
        this.url = this.neo4jbelgradeUrl20000200;
         break; 
      } 
      case 'neo4jbelgradeUrl20000500': { 
        this.url = this.neo4jbelgradeUrl20000500;
         break; 
      }  
      case 'neo4jbelgradeUrl40000100': { 
        this.url = this.neo4jbelgradeUrl40000100;
         break; 
      } 
      case 'neo4jbelgradeUrl40000200': { 
        this.url = this.neo4jbelgradeUrl40000200;
         break; 
      } 
      case 'neo4jbelgradeUrl40000500': { 
        this.url = this.neo4jbelgradeUrl40000500;
         break; 
      } 


      default: { 
        this.url = '';
         break; 
      } 
    }
  }

   

  makeEuropeCitiesMarkers(map: L.Map, n:string, selectedDb: string): void {
    this.ngxService.start();
    this.findURL(selectedDb+'europeCitiesUrl'+n);
    this.http.get(this.url).subscribe((res: any) => {
      console.log(this.url)
      console.log('response '+ JSON.stringify(res));
      this.ngxService.stop();
      this.europeCitiesLayerGroup = L.layerGroup().addTo(map); 
      
   

   if(selectedDb=='neo4j'){
    for (const c of res) {
      console.log(c);
      console.log("x "+c.coordinates.y + " y "+c.coordinates.x);
    const lon =c.coordinates.x;
      const lat =c.coordinates.y;
      const marker = L.marker([lon, lat]);
      marker.bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeCitiesLayerGroup);
      map.addLayer( marker);
    }
  }
    else if(selectedDb=='mongo'){
     
      for (const c of res) {
        if(c.city=='Petrovaradin'){
          console.log(c.city);
        }else{
          console.log("NOOO");
        }
        var lat = c.geom.coordinates[1];
        var lon = c.geom.coordinates[0];
          /*var lat = c.geom.x;
          var lon = c.geom.y;*/
    
          // create a new marker using the icon style
          L.marker([lat,lon]).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeCitiesLayerGroup);
        //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).addTo(this.europeCitiesLayerGroup);
        this.ngxService.stop();
      }
    }
    else {
     
      for (const c of res) {
        /*var lat = c.geometry.coordinates[1];
          var lon = c.geometry.coordinates[0];*/
          var lat = c.geom.coordinates[1];
          var lon = c.geom.coordinates[0];
    
          // create a new marker using the icon style
          L.marker([lat,lon]).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeCitiesLayerGroup);
        //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).addTo(this.europeCitiesLayerGroup);
        this.ngxService.stop();
      }
    }
 });
  }

  
  
  

  makeBelgradeCitiesMarkers(map: L.Map, n:string, distance:string, selectedDb: string): void {
    const greyIcon = new L.Icon({
      iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-grey.png',
      shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
      iconSize: [25, 41],
      iconAnchor: [12, 41],
      popupAnchor: [1, -34],
      shadowSize: [41, 41]
    });
    this.ngxService.start();
    this.findURL(selectedDb+'belgradeUrl'+n+distance);
    this.http.get(this.url).subscribe((res: any) => {
      console.log(this.url)
      console.log(res);
      this.ngxService.stop();
      this.belgradeLayerGroup = L.layerGroup().addTo(map); 
      
      if(selectedDb=='neo4j'){
      for (const c of res) {
        
        
      const lon =c.coordinates.x;
        const lat =c.coordinates.y;

        const marker = L.marker([lon, lat], {icon: greyIcon});
       
        
       marker.addTo(this.belgradeLayerGroup);
        
        marker.bindPopup(this.popupService.makePlacePopup(c));
        map.addLayer( marker);
        
      }
    }
    else if(selectedDb=='mongo'){
        for (const c of res) {
          //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).setStyle({fillColor: '#7B7B7B'}).addTo(this.belgradeLayerGroup);
         
          var lat = c.geom.coordinates[1];
        var lon = c.geom.coordinates[0];
          /*var lat = c.geom.x;
          var lon = c.geom.y;*/
    
          // create a new marker using the icon style
          L.marker([lat,lon],{icon:  greyIcon}).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.belgradeLayerGroup);
          this.ngxService.stop();
        }
      }
      else {
     
        for (const c of res) {
          /*var lat = c.geometry.coordinates[1];
            var lon = c.geometry.coordinates[0];*/
            var lat = c.geom.coordinates[1];
            var lon = c.geom.coordinates[0];
      
            // create a new marker using the icon style
            L.marker([lat,lon]).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.belgradeLayerGroup);
          //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).addTo(this.europeCitiesLayerGroup);
          this.ngxService.stop();
        }
      }
   });
  }

  removeBelgradeCitiesMarkers(map: L.Map): void {
    if(this.belgradeLayerGroup != null){
      this.belgradeLayerGroup.clearLayers();
     }
  }


   removeEuropeCitiesMarkers(map: L.Map): void {
     if(this.europeCitiesLayerGroup != null){
      this.europeCitiesLayerGroup.clearLayers();
     }


     
}

makeEuropeRussiaCitiesMarkers(map: L.Map, n:string, selectedDb: string): void {
  this.ngxService.start();
  var goldIcon = new L.Icon({
    iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-gold.png',
    shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    shadowSize: [41, 41]
  });
  this.findURL(selectedDb+'europeRussiaCitiesUrl'+n);
  this.http.get(this.url).subscribe((res: any) => {
    console.log(res);
    console.log('europeRussiaCitiesUrl'+n)
    console.log(this.url)
    this.ngxService.stop();
    this.europeRussiaCitiesLayerGroup = L.layerGroup().addTo(map); 

    if(selectedDb=='neo4j'){
      for (const c of res) {
      const lon =c.coordinates.x;
        const lat =c.coordinates.y;
        const marker = L.marker([lon, lat], {icon: goldIcon});
        marker.bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeRussiaCitiesLayerGroup);
        map.addLayer( marker);
      }
    }
    else if(selectedDb=='mongo'){
       
    for (const c of res) {
      
      
      var lat = c.geom.coordinates[1];
      var lon = c.geom.coordinates[0];
      

      // create a new marker using the icon style
      L.marker([lat,lon],{icon:  goldIcon}).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeRussiaCitiesLayerGroup);
      //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).setStyle({fillColor :'#FFD326'}).addTo(this.europeRussiaCitiesLayerGroup);
      this.ngxService.stop();
    }
      }
      else {
     
        for (const c of res) {
          /*var lat = c.geometry.coordinates[1];
            var lon = c.geometry.coordinates[0];*/
            var lat = c.geom.coordinates[1];
            var lon = c.geom.coordinates[0];
          
      
            // create a new marker using the icon style
            L.marker([lat,lon]).bindPopup(this.popupService.makePlacePopup(c)).addTo(this.europeRussiaCitiesLayerGroup);
          //L.geoJSON(c).bindPopup(this.popupService.makePlacePopup(c.properties)).addTo(this.europeCitiesLayerGroup);
          this.ngxService.stop();
        }
      }
   });

}

removeNewCitiesCitiesMarkers(map: L.Map): void {
  if(this.newCitiesLayerGroup != null){
    this.newCitiesLayerGroup.clearLayers();
   }
}


removeEuropeRussiaCitiesMarkers(map: L.Map): void {
  if(this.europeRussiaCitiesLayerGroup != null){

   this.europeRussiaCitiesLayerGroup.clearLayers();
   
   console.log('cllll')
  }
}
  
makeNewCitiesMarkers(map: L.Map){
  if(this.newCitiesLayerGroup==null){
    this.newCitiesLayerGroup = L.layerGroup().addTo(map); 
  }
}

addToNewCitiesMarker(data, selectedDb:string){
  console.log(data)
  const greyIcon = new L.Icon({
    iconUrl: 'https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-violet.png',
    shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    shadowSize: [41, 41]
  });
  //
  if(selectedDb=='neo4j'){
   
    const lon =data.coordinates.x;
      const lat =data.coordinates.y;
      const marker = L.marker([lon, lat], {icon: greyIcon});
      marker.bindPopup(this.popupService.makePlacePopup(data)).addTo(this.newCitiesLayerGroup);
  }
  else if(selectedDb=='mongo'){
    var lat = data.geom.coordinates[1];
    var lon = data.geom.coordinates[0];
    L.marker([lat,lon],{icon:  greyIcon}).bindPopup(this.popupService.makePlacePopup(data)).addTo(this.newCitiesLayerGroup);
    }
    else {
      var lat = data.geom.coordinates[1];
      var lon = data.geom.coordinates[0];
      L.marker([lat,lon],{icon: greyIcon}).bindPopup(this.popupService.makePlacePopup(data)).addTo(this.newCitiesLayerGroup);
    }
  //
 


      }

saveCity(city, country, lat, lon, n:string, selectedDb: string): void{
  switch(n){
    case '5000': { 
      this.save5(city, country, lat, lon, selectedDb);
       break; 
    } 
    case '10000': { 
      this.save10(city, country, lat, lon, selectedDb);
       break; 
    }
    case '20000': { 
      this.save20(city, country, lat, lon, selectedDb);
       break; 
    } 
    default: { 
      this.save40(city, country, lat, lon, selectedDb);
       break; 
    } 
  }

  /*let headers: HttpHeaders = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  this.http.post(this.saveCityUrl +'city='+ city + '&country='+country + '&lat='+lat+'&lon='+lon,{ headers: headers }).subscribe(data => {  
       console.log(data) 
      })*/
}
save5(city, country, lat, lon, selectedDb:string){
  let headers: HttpHeaders = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  this.http.post(this.save5Url+selectedDb +'/save?city='+ city + '&country='+country + '&lat='+lat+'&lng='+lon,{ headers: headers }).subscribe(data => {  
    console.log(data) 
    this.addToNewCitiesMarker(data,selectedDb);
  })
 
}



save10(city, country, lat, lon, selectedDb:string): void{
  let headers: HttpHeaders = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  this.http.post(this.save10Url+selectedDb +'/save?city='+ city + '&country='+country + '&lat='+lat+'&lng='+lon,{ headers: headers }).subscribe(data => {  
    console.log(data) 
  
  })
}

save20(city, country, lat, lon, selectedDb:string): void{
  let headers: HttpHeaders = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  this.http.post(this.save20Url+selectedDb +'/save?city='+ city + '&country='+country + '&lat='+lat+'&lng='+lon,{ headers: headers }).subscribe(data => {  
    console.log(data) 
  
  })
}

save40(city, country, lat, lon, selectedDb:string): void{
  let headers: HttpHeaders = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  this.http.post(this.save40Url+selectedDb +'/save?city='+ city + '&country='+country + '&lat='+lat+'&lng='+lon,{ headers: headers }).subscribe(data => {  
    console.log(data) 
  
  })
}





//u
save5Url :string = 'http://localhost:8081/cities5/';
save10Url :string = 'http://localhost:8081/cities10/';
save20Url :string = 'http://localhost:8081/cities20/';
save40Url :string = 'http://localhost:8081/cities40/';



      
  
      
       
}
