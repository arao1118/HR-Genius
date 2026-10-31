import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService, Employee } from './api.service';
@Component({
 selector:'app-root', standalone:true, imports:[CommonModule],
 template:`
 <div class="shell">
  <aside class="sidebar"><div class="brand">HR<span>Genius</span></div><p class="muted">PEOPLE OPERATIONS</p>
   <nav><a class="active">▦ Overview</a><a>♙ Employees</a><a>⌕ Recruitment</a><a>◷ Attendance & Leave</a><a>₹ Payroll</a><a>☆ Performance</a><a>▤ Analytics</a><a>⚙ Administration</a></nav>
   <div class="profile"><div class="avatar">HR</div><div><b>HR Workspace</b><small>Demo interface</small></div></div>
  </aside>
  <main><header><div><small>WORKSPACE / DASHBOARD</small><h1>People overview</h1></div><button>Export report</button></header>
   <section class="cards"><article><small>Total employees</small><strong>{{employees.length || '—'}}</strong><em>Active workforce</em></article><article><small>Open requisitions</small><strong>—</strong><em>Recruitment pipeline</em></article><article><small>Pending leave</small><strong>—</strong><em>Manager approvals</em></article><article><small>Payroll status</small><strong>Ready</strong><em>Period-based processing</em></article></section>
   <section class="panel"><div class="panel-head"><div><h2>Employee directory</h2><p>Employee master records from the HR Genius API</p></div><span class="status">{{apiStatus}}</span></div>
    <div *ngIf="error" class="error">{{error}}</div>
    <table><thead><tr><th>Employee code</th><th>Name</th><th>Email</th><th>Status</th></tr></thead><tbody>
    <tr *ngFor="let e of employees"><td>{{e.employeeCode}}</td><td>{{e.firstName}} {{e.lastName}}</td><td>{{e.email}}</td><td><span class="pill">{{e.status}}</span></td></tr>
    <tr *ngIf="!employees.length"><td colspan="4" class="empty">No employees returned. Start the API and add records to populate this directory.</td></tr>
    </tbody></table>
   </section>
   <p class="foot">HR Genius · Workforce management platform · Synthetic/demo workspace</p>
  </main>
 </div>`
})
export class AppComponent implements OnInit {
 private api=inject(ApiService); employees:Employee[]=[]; apiStatus='Connecting'; error='';
 ngOnInit(){this.api.employees().subscribe({next:data=>{this.employees=data;this.apiStatus='Connected';},error:()=>{this.apiStatus='API unavailable';this.error='Could not connect to the backend. Start Spring Boot at localhost:8080.';}});}
}
