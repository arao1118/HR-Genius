# HR Genius — Human Resource Management System

An enterprise-style HRMS reference implementation using **Java 21, Spring Boot 3, Spring Data JPA/Hibernate, Angular, and Oracle Database**.

## Modules
1. Employee registration, demographics, employment history and education
2. Recruitment: requisitions, candidates and interview scheduling
3. Attendance and leave requests/approval
4. Payroll: salary components, employee salary structures and payroll runs
5. Performance reviews
6. HR analytics/reporting endpoints and CSV exports
7. User management and role-based access

## Architecture
- `backend/`: REST API, domain model, repositories, services, validation, security, exception handling and Oracle SQL.
- `frontend/`: Angular standalone application shell and typed API service.
- `docs/`: architecture and API notes.
- `../HR-Genius-Datasets/`: synthetic CSV seed data, separate from source code.

## Requirements
- JDK 21
- Maven 3.9+
- Oracle Database 19c/21c/23ai (or Oracle Free)
- Node.js 20+ and Angular CLI 18+
- Optional: Docker for local Oracle XE/Free setup

## Run backend
1. Create an Oracle schema/user and grant required privileges.
2. Set environment variables:
   - `HR_DB_URL=jdbc:oracle:thin:@//localhost:1521/FREEPDB1`
   - `HR_DB_USERNAME=HR_GENIUS`
   - `HR_DB_PASSWORD=change-me`
   - `HR_JWT_SECRET=replace-with-a-long-random-secret-at-least-32-bytes`
3. From `backend/`: `mvn spring-boot:run`
4. API base URL: `http://localhost:8080/api`
5. Health check: `GET /api/health`

The default profile is `dev` and uses H2 for a quick smoke test. Set `SPRING_PROFILES_ACTIVE=oracle` to use Oracle. The Oracle schema DDL is in `src/main/resources/db/oracle-schema.sql`.

## Run frontend
From `frontend/`:
```bash
npm install
npm start
```
The Angular shell runs at `http://localhost:4200`. Configure the API base URL in `src/app/api.service.ts`.

## Security and demo credentials
The backend uses Spring Security, BCrypt password hashing, JWT bearer tokens and role checks. Register the first admin through the seed SQL or create a user via an administrator workflow. Do not use demo secrets or synthetic employee data in production.

## Important implementation notes
- Payroll calculation in this project is a transparent demonstration rule set, not legal/tax advice. Configure statutory deductions for the jurisdiction and organisation before production use.
- Bank, tax and identity information should be encrypted and masked; the sample schema deliberately avoids storing real bank or government identifiers.
- File uploads, email/SMS, bank integrations, statutory filings, SSO, MFA, approval delegation and production observability are integration points, not claimed as completed integrations.
- Use migrations (Flyway/Liquibase), secrets management, HTTPS, backups, retention policies and security testing before deployment.
