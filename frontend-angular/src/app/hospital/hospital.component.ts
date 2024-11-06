import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrl: './hospital.component.css'
})
export class HospitalComponent implements OnInit {

  public hospitals : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','name','location','capacity'];
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('http://localhost:8080/hospitals').subscribe(
      {
        next:data => {
          this.hospitals = data;
          this.dataSource = new MatTableDataSource(this.hospitals);
        },
        error : err => {
          console.log(err);
        }
      }
    )
  }

}
