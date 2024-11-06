import {Component, OnInit, ViewChild, viewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrl: './appointment.component.css'
})
export class AppointmentComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  public appointments:any;
  public dataSource:any;
  public displayedColumns:string[] = ['id','title','description','date'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit() {
    this.http.get('http://localhost:8080/appointments').subscribe(
      {
        next:data => {
          this.appointments = data;
          this.dataSource = new MatTableDataSource(this.appointments);
          this.dataSource.paginator = this.paginator;
        },
        error : err => {
          console.log(err);
        }
      }
    )

  }

}
