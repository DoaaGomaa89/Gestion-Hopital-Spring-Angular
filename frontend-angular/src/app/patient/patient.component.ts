import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

interface Appointment{
  id: number;
  title : string;
  description : string;
  date : Date;
}

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrl: './patient.component.css'
})
export class PatientComponent implements OnInit {

  constructor(private http: HttpClient) {
  }
  public patients:any;
  public dataSource: any;
  public displayedColumns:string[] = ['id','nom','dateNaissane','malade','score','actions'];
  public selectedPatientAppointments : Appointment[] = [];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit() {
    this.http.get('http://localhost:8080/patients').subscribe(
      {
        next:data => {
          this.patients = data;
          this.dataSource = new MatTableDataSource(this.patients);
          this.dataSource.paginator = this.paginator;
        },
        error : err => {
          console.log(err);
        }
      }
    )
  }

  viewAppointments(patientId:number) {
    this.http.get<Appointment[]>(`http://localhost:8080/patients/${patientId}/appointments`).subscribe(
      {
        next: appointments => {
          this.selectedPatientAppointments = appointments;
        },
        error: err => {
          console.error('Failed to fetch doctors:', err);
        }
      }
    );

  }
}
