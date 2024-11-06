import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrl: './hospital.component.css'
})
export class HospitalComponent implements OnInit {

  public hospitals : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','name','location','capacity'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('http://localhost:8080/hospitals').subscribe(
      {
        next:data => {
          this.hospitals = data;
          this.dataSource = new MatTableDataSource(this.hospitals);
          this.dataSource.paginator = this.paginator;
        },
        error : err => {
          console.log(err);
        }
      }
    )
  }

}
