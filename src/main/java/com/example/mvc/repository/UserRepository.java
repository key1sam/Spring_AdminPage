package com.example.mvc.repository;

import com.example.mvc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository : 따로 쿼리문을 작성하지 않아도 기본적인 CRUD 를 활용할 수 있게 해줍니다.
@Repository
public interface UserRepository extends JpaRepository<User, Long> { //Entity, 기본키 타입 설정
}
