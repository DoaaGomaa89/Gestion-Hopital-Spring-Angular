import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrl: './doctor.component.css'
})
export class DoctorComponent implements OnInit {

  public doctors : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','nom','dateNaissane','specialite'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private http: HttpClient) {
  }
  ngOnInit(){
    this.http.get('http://localhost:8080/doctors').subscribe(
      {
        next:data => {
          this.doctors = data;
          this.dataSource = new MatTableDataSource(this.doctors);
          this.dataSource.paginator = this.paginator;
        },
        error : err => {
          console.log(err);
        }
      }
    )

  }

}
