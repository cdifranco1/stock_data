package com.cdifranco.investingapp.services;

import com.cdifranco.investingapp.exceptions.ResourceNotFoundException;
import com.cdifranco.investingapp.models.User;
import com.cdifranco.investingapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service
public class UserServiceImplementation implements UserService {
  @Autowired
  private UserRepo userRepo;

  @Override
  public User saveUser(User user) {
    User newUser = userRepo.save(user);

    return newUser;
  }

  @Override
  public User findById(long userId) {

    return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User " + userId + " not found."));
  }

  @Override
  public User findByUsername(String username) {
    User user = userRepo.findUserByUsername(username);

    if (user == null){
      throw new ResourceNotFoundException("User " + username + " not found.");
    }

    return user;
  }
}
