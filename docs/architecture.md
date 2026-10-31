# HR Genius — Architecture Notes

## Layering
`REST Controller -> Application Service -> Spring Data Repository -> Hibernate/JPA -> Oracle`

Controllers expose resource-oriented APIs. Services own transaction boundaries and business validation. Repositories isolate persistence. Domain entities represent the HR record model. Spring Security validates JWT bearer tokens and applies role gates.

## Core relationship map
- Department 1:N Employee; Designation 1:N Employee; Employee 1:N EmploymentHistory and EducationQualification.
- Employee 1:N AttendanceRecord, LeaveRequest, EmployeeSalary, Payroll and PerformanceReview.
- JobRequisition 1:N Candidate; Candidate 1:N Interview; Interview references an Employee interviewer.
- Role 1:N UserAccount; UserAccount optionally maps to one Employee.
- AuditLog records actor, entity, action and timestamp.

## Main API routes
| Method | Route | Purpose |
|---|---|---|
| GET/POST | `/api/employees` | Employee directory / registration |
| GET/PUT | `/api/employees/{id}` | Employee details / update |
| GET/POST | `/api/leaves` | Leave requests |
| PATCH | `/api/leaves/{id}/decision` | Approve/reject leave |
| GET | `/api/payroll` | Payslip/payroll history |
| POST | `/api/payroll/run` | Process period payroll |
| POST | `/api/auth/login` | Issue JWT |
| GET | `/api/health` | Health check |

The domain model includes the other functional areas and repositories; extend controllers/services following the same pattern for requisitions, candidates, interviews, attendance, salary setup, performance reviews, role administration and analytics.

## Production hardening checklist
- Replace demo payroll rules with approved tax, PF and statutory policies.
- Enforce manager/team and employee-self data scopes at service/query level.
- Add audit writes for employee, payroll, leave and user mutations.
- Add Flyway/Liquibase migrations and Oracle integration tests.
- Add pagination, filtering, sorting, optimistic locking and idempotency.
- Add secure document storage, malware scanning and signed download URLs.
- Add secrets vault, HTTPS, CORS allow-list, MFA/SSO, rate limits and security monitoring.
