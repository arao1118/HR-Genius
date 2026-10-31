package com.hrgenius.controller;
import com.hrgenius.domain.Employee; import com.hrgenius.service.EmployeeService;
import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/employees")
public class EmployeeController {
 private final EmployeeService service; public EmployeeController(EmployeeService s){service=s;}
 @GetMapping public List<Employee> all(){return service.all();}
 @GetMapping("/{id}") public Employee get(@PathVariable Long id){return service.get(id);}
 @PostMapping public ResponseEntity<Employee> create(@Valid @RequestBody Employee e){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(e));}
 @PutMapping("/{id}") public Employee update(@PathVariable Long id,@RequestBody Employee e){return service.update(id,e);}
}
