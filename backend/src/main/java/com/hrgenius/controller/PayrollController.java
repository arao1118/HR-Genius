package com.hrgenius.controller;
import com.hrgenius.domain.Payroll; import com.hrgenius.service.PayrollService;
import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/payroll")
public class PayrollController {
 private final PayrollService service; public PayrollController(PayrollService s){service=s;}
 @GetMapping public List<Payroll> all(){return service.all();}
 public record RunRequest(String payPeriod){}
 @PostMapping("/run") public List<Payroll> run(@RequestBody RunRequest r){return service.run(r.payPeriod());}
}
