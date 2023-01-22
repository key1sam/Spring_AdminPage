package com.example.mvc.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// JPA의 Entity 및 column 은 자동으로 camel case -> DB의 snake_case에 매칭시켜줍니다.
@Data // Lombok 활용
@AllArgsConstructor

@Entity // DB 테이블 == JPA ENTITY
//@Table(name = "table 이름")을 해주어야하는데, class 이름과 DB테이블 이름 동일하면 괜찮다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // DB 테이블에서는 BIGINT 형이다.

    //@Column(name = "account") 와 같이 지정할 수 있지만 DB 컬럼과 동일할 경우 필요없다.
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createAt;
    private String createDBy;
    private LocalDateTime updatedAt;
    private String updatedBy;



}
