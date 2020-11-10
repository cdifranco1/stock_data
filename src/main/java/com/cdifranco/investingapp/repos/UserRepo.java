package com.cdifranco.investingapp.repos;

import com.cdifranco.investingapp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
  public User findUserByUsername(String username);
}
