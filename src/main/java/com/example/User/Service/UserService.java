package com.example.User.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepo;
    private NotificationService notification;


    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepo= userRepository;
        this.notification = notificationService;
    }

    public void registerUser(User user){
        if(userRepo.findUserByEmail(user.getEmail()) != null){
            throw new  IllegalArgumentException("User exists already");
        }
        userRepo.Save(user);
        notification.send("Account created successfully", user.getEmail());
    }


}
