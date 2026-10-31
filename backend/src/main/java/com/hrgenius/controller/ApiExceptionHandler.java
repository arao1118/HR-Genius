package com.hrgenius.controller;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.time.Instant; import java.util.Map;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class) ResponseEntity<?> badRequest(RuntimeException e){return ResponseEntity.badRequest().body(Map.of("timestamp",Instant.now().toString(),"error",e.getMessage()));}
 @ExceptionHandler(IllegalStateException.class) ResponseEntity<?> conflict(RuntimeException e){return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("timestamp",Instant.now().toString(),"error",e.getMessage()));}
}
