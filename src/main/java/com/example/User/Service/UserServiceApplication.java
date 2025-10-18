package com.example.User.Service;

import com.example.User.Service.entities.Address;
import com.example.User.Service.entities.Profile;
import com.example.User.Service.entities.User;
import com.example.User.Service.repositories.userRepository;
import com.example.User.Service.services.userService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserServiceApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
//        var repository = context.getBean(userRepository.class);
//        var user = User.builder()
//                .name("john")
//                .password("password")
//                .email("john@gmail.com")
//                .build();
//        repository.save(user);
//        repository.findAll().forEach(u -> System.out.println(u.getEmail()));
//           var user1 = repository.findById(1L).orElseThrow();
//        System.out.println(user1.getEmail());
//        repository.deleteById(1L);
//
//
//       user.addTag("tag1");
//        user.addAddress(address);
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user);

        var service = context.getBean(userService.class);
        service.findProducts();
    }

}
