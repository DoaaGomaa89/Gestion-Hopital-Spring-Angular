import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrl: './doctor.component.css'
})
export class DoctorComponent implements OnInit {

  public doctors : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','nom','dateNaissane','specialite'];

  ngOnInit(){

  }

}
