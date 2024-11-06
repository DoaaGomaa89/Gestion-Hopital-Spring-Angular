import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {HospitalComponent} from './hospital/hospital.component';
import {DoctorComponent} from './doctor/doctor.component';
import {PatientComponent} from './patient/patient.component';
import {AppointmentComponent} from './appointment/appointment.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {AdminTemplateComponent} from './admin-template/admin-template.component';
import {AuthGuard} from './guard/auth.guard';
import {AuthorisationGuard} from './guard/authorisation.guard';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminTemplateComponent,
    canActivate: [AuthGuard],
    children : [
      {path: 'home', component: HomeComponent},
      {
        path: 'hospital', component: HospitalComponent,
        canActivate :[AuthorisationGuard], data:{roles:['ADMIN']}
      },
      {
        path: 'doctor', component: DoctorComponent,
        canActivate :[AuthorisationGuard], data:{roles:['ADMIN']}
      },
      {
        path: 'patient', component: PatientComponent,
        canActivate :[AuthorisationGuard], data:{roles:['DOCTOR']}
      },
      {
        path: 'appointment', component: AppointmentComponent,
        canActivate :[AuthorisationGuard], data:{roles:['PATIENT']}
      },
      {path: 'dashboard', component: DashboardComponent},
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
