package com.example.PayementService.Services;


import com.example.PayementService.Models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Simple authentication (in real apps, you'd use a database)
    public boolean authenticate(User user) {
        // In a real-world application, replace with proper authentication logic
        return "admin".equals(user.getUsername()) && "password".equals(user.getPassword());
    }
}
