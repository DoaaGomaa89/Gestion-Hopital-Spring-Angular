import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

interface Patient{
  id: number;
  nom: string;
  dateNaissane: Date;
  malade:Boolean;
  score:number;
}

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrl: './doctor.component.css'
})
export class DoctorComponent implements OnInit {

  public doctors : any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','nom','dateNaissane','specialite','actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  public selectedDoctorPatients: Patient[] = [];
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

  viewPatients(doctorId:number) {
    this.http.get<Patient[]>(`http://localhost:8080/doctors/${doctorId}/patients`).subscribe(
      {
        next: doctors => {
          this.selectedDoctorPatients = doctors;
        },
        error: err => {
          console.error('Failed to fetch doctors:', err);
        }
      }
    );
  }
}
