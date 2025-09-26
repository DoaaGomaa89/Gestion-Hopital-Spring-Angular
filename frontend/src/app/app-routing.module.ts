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
  { path: '', redirectTo: 'login', pathMatch: 'full' },   // <- add this
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminTemplateComponent,
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'hospital', component: HospitalComponent },
      { path: 'doctor', component: DoctorComponent },
      { path: 'patient', component: PatientComponent },
      { path: 'appointment', component: AppointmentComponent },
      { path: 'dashboard', component: DashboardComponent },
    ]
  },
  { path: '**', redirectTo: 'login' }                     // <- and this (optional)
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
