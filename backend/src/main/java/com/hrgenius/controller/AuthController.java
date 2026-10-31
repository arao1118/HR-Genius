package com.hrgenius.controller;
import com.hrgenius.repository.UserAccountRepository; import com.hrgenius.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth")
public class AuthController {
 private final UserAccountRepository users; private final PasswordEncoder encoder; private final JwtService jwt;
 public AuthController(UserAccountRepository u,PasswordEncoder e,JwtService j){users=u;encoder=e;jwt=j;}
 public record LoginRequest(String username,String password){}
 @PostMapping("/login") public Map<String,String> login(@RequestBody LoginRequest r){
  var u=users.findByUsername(r.username()).orElseThrow(()->new IllegalArgumentException("Invalid credentials"));
  if(!Boolean.TRUE.equals(u.getActive())||!encoder.matches(r.password(),u.getPasswordHash()))throw new IllegalArgumentException("Invalid credentials");
  return Map.of("accessToken",jwt.generate(u.getUsername(),u.getRole().getRoleName()),"tokenType","Bearer");
 }
}
