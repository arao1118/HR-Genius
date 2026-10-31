package com.hrgenius.controller;
import com.hrgenius.domain.LeaveRequest; import com.hrgenius.service.LeaveService;
import org.springframework.web.bind.annotation.*; import java.time.LocalDate; import java.util.List;
@RestController @RequestMapping("/api/leaves")
public class LeaveController {
 private final LeaveService service; public LeaveController(LeaveService s){service=s;}
 @GetMapping public List<LeaveRequest> all(){return service.all();}
 public record ApplyRequest(Long employeeId,Long leaveTypeId,LocalDate fromDate,LocalDate toDate,String reason){}
 public record DecisionRequest(Long approverId,boolean approve,String comment){}
 @PostMapping public LeaveRequest apply(@RequestBody ApplyRequest r){return service.apply(r.employeeId(),r.leaveTypeId(),r.fromDate(),r.toDate(),r.reason());}
 @PatchMapping("/{id}/decision") public LeaveRequest decide(@PathVariable Long id,@RequestBody DecisionRequest r){return service.decide(id,r.approverId(),r.approve(),r.comment());}
}
