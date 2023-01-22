package com.example.mvc.repository;

import com.example.mvc.MvcApplicationTests;
import com.example.mvc.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    public void read() {
        // userRepository.findAll(); 리스트 전체를 가져옴
        Optional<User> user = userRepository.findById(3L); // Optional은 있을 수도 있고, 없을 수도 있다는 뜻
        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method");

            userRepository.save(selectUser);
            // 해당 user를 repository에 save 해주어야 한다.
            // ※ selectUser라는 새로운 객체에 값을 담아서 수정을 하게 되는데, findById를 기반으로 Spring 이 먼저 탐색을 수행 후,
            // 값이 존재할 경우 해당 컬럼을 update 해주게 된다.
        });
    }

    public void delete() {

    }
}
