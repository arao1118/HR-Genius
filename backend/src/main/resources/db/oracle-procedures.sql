-- Reference PL/SQL procedures aligned with the functional specification.
CREATE OR REPLACE PROCEDURE HR_REGISTER_EMPLOYEE(
 p_code IN VARCHAR2, p_first IN VARCHAR2, p_last IN VARCHAR2, p_email IN VARCHAR2,
 p_hire_date IN DATE, p_department_id IN NUMBER, p_designation_id IN NUMBER,
 p_employee_id OUT NUMBER
) AS
BEGIN
 INSERT INTO EMPLOYEES(EMPLOYEE_CODE,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,DEPARTMENT_ID,DESIGNATION_ID,STATUS)
 VALUES(p_code,p_first,p_last,p_email,p_hire_date,p_department_id,p_designation_id,'ACTIVE')
 RETURNING ID INTO p_employee_id;
END;
/
CREATE OR REPLACE PROCEDURE HR_CREATE_JOB_REQUISITION(
 p_department_id IN NUMBER,p_designation_id IN NUMBER,p_requested_by IN NUMBER,
 p_openings IN NUMBER,p_description IN VARCHAR2,p_requisition_id OUT NUMBER
) AS
BEGIN
 IF p_openings < 1 THEN RAISE_APPLICATION_ERROR(-20001,'Openings must be positive'); END IF;
 INSERT INTO JOB_REQUISITIONS(DEPARTMENT_ID,DESIGNATION_ID,REQUESTED_BY,OPENINGS,STATUS,OPEN_DATE,JOB_DESCRIPTION)
 VALUES(p_department_id,p_designation_id,p_requested_by,p_openings,'PENDING_APPROVAL',TRUNC(SYSDATE),p_description)
 RETURNING ID INTO p_requisition_id;
END;
/
CREATE OR REPLACE PROCEDURE HR_APPLY_LEAVE(
 p_employee_id IN NUMBER,p_leave_type_id IN NUMBER,p_from IN DATE,p_to IN DATE,p_reason IN VARCHAR2,p_request_id OUT NUMBER
) AS
 v_overlap NUMBER;
BEGIN
 IF p_to < p_from THEN RAISE_APPLICATION_ERROR(-20002,'Invalid leave date range'); END IF;
 SELECT COUNT(*) INTO v_overlap FROM LEAVE_REQUESTS
 WHERE EMPLOYEE_ID=p_employee_id AND STATUS='APPROVED'
 AND p_from <= TO_DATE AND p_to >= FROM_DATE;
 IF v_overlap > 0 THEN RAISE_APPLICATION_ERROR(-20003,'Approved leave overlap'); END IF;
 INSERT INTO LEAVE_REQUESTS(EMPLOYEE_ID,LEAVE_TYPE_ID,FROM_DATE,TO_DATE,REASON,STATUS)
 VALUES(p_employee_id,p_leave_type_id,p_from,p_to,p_reason,'PENDING')
 RETURNING ID INTO p_request_id;
END;
/
-- Additional production procedures: HR_SCHEDULE_INTERVIEW (lock/check interviewer calendar),
-- HR_CONVERT_CANDIDATE_TO_EMPLOYEE, HR_APPROVE_LEAVE, HR_RUN_PAYROLL,
-- HR_CREATE_PERFORMANCE_REVIEW, HR_CLOSE_REVIEW_CYCLE and HR_USER_MANAGEMENT.
-- Implement organisation-specific tax/PF policy and audit writes before production rollout.
