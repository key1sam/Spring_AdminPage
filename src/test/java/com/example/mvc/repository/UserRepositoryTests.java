package com.example.mvc.repository;

import com.example.mvc.MvcApplicationTests;
import com.example.mvc.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

@WebAppConfiguration
public class UserRepositoryTests extends MvcApplicationTests {

    @Autowired // Spring Dependency Injection (DI)
    private UserRepository userRepository;
    // 보통 private UserRepository userRepository = new UserRepository(); 와 같이 구성하는데,
    // Autowired를 통해 Spring이 객체를 직접 관리하게 되며, 의존성을 주입받게 된다.
    @Test
    public void create() {
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        // user.setId(); Auto Increment 여서 써주지 않아도 된다.
        user.setAccount("TestUser03");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-1111-4444");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user); // user를 넘기고 데이터베이스에 저장된 새로운 User라는 객체를 호출
        System.out.println("newUser : " + newUser);

    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
