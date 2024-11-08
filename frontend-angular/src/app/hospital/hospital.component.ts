import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

interface Doctor {
  id: number;
  nom: string;
  dateNaissane: Date;
  specialite: string;
}

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrl: './hospital.component.css'
})
export class HospitalComponent implements OnInit {

  public hospitals : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','name','location','capacity','actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  public selectedHospitalDoctors: Doctor[] = [];
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

  viewDoctors(hospitalId: number) {
    this.http.get<Doctor[]>(`http://localhost:8080/hospitals/${hospitalId}/doctors`).subscribe(
      {
        next: doctors => {
          this.selectedHospitalDoctors = doctors;
        },
        error: err => {
          console.error('Failed to fetch doctors:', err);
        }
      }
    );
  }
}
