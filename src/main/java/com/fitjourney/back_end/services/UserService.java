package com.fitjourney.back_end.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitjourney.back_end.model.User;
import com.fitjourney.back_end.repository.UserRepository;

@Service    
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public void update(User user, Long userId){
        userRepository.save(user);
    
    }

    public boolean delete(UUID userId){

        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }



    public List<User> findAll(){
        List<User> todosUsuarios = this.userRepository.findAll();
        return todosUsuarios;
    }

    public User findByUserId(UUID userId){
        User user = this.userRepository.findById(userId).get();
        return user;
    }
    

}
