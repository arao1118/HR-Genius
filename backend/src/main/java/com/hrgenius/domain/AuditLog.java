package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="AUDIT_LOGS", indexes=@Index(name="IDX_AUDIT_ENTITY",columnList="entity_name,entity_id"))
public class AuditLog {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100) private String entityName;
 @Column(nullable=false,length=80) private String entityId;
 @Column(nullable=false,length=20) private String action;
 @Column(length=100) private String actor;
 @Column(nullable=false) private Instant occurredAt=Instant.now();
 @Column(length=2000) private String details;
 public Long getId(){return id;} public String getEntityName(){return entityName;} public void setEntityName(String v){entityName=v;}
 public String getEntityId(){return entityId;} public void setEntityId(String v){entityId=v;}
 public String getAction(){return action;} public void setAction(String v){action=v;}
 public String getActor(){return actor;} public void setActor(String v){actor=v;}
 public Instant getOccurredAt(){return occurredAt;} public void setOccurredAt(Instant v){occurredAt=v;}
 public String getDetails(){return details;} public void setDetails(String v){details=v;}
}
