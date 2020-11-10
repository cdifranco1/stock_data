package com.cdifranco.investingapp.services;

import com.cdifranco.investingapp.models.User;

public interface UserService {
  public void saveUser(User user);

  public User findById(long userId);

  public User findByUsername(String username);
}
