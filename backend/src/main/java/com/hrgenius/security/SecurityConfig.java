package com.hrgenius.security;
import org.springframework.context.annotation.*; import org.springframework.http.HttpMethod; import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain; import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration @EnableMethodSecurity
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean SecurityFilterChain filterChain(HttpSecurity http,JwtAuthFilter jwt)throws Exception{
  return http.csrf(c->c.disable()).cors(c->{}).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authorizeHttpRequests(a->a.requestMatchers("/api/health","/actuator/health","/h2-console/**").permitAll()
    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasAnyRole("HR_ADMIN","HR_EXECUTIVE","MANAGER")
    .requestMatchers("/api/**").authenticated().anyRequest().permitAll())
   .headers(h->h.frameOptions(f->f.sameOrigin())).addFilterBefore(jwt,UsernamePasswordAuthenticationFilter.class).build();
 }
}
