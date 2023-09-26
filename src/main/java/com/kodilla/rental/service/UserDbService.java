package com.kodilla.rental.service;

import com.kodilla.rental.domain.User;
import com.kodilla.rental.exception.UserNotFoundException;
import com.kodilla.rental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDbService {
    @Autowired
    private final UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User saveUser(User user){
        return repository.save(user);
    }

    public User getUser(Long userId)throws UserNotFoundException {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public void deleteUser(Long userId){
        
        repository.deleteById(userId);
    }


}
