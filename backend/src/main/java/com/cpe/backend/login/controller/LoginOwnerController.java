package com.cpe.backend.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.backend.login.entity.*;
import com.cpe.backend.login.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LoginOwnerController {

  @Autowired
  private final AccountRepository accountRepository;
  @Autowired
  private final UserPriorityRepository userPriorityRepository;

  public LoginOwnerController(AccountRepository accountRepository,UserPriorityRepository userPriorityRepository){
    this.accountRepository = accountRepository;
    this.userPriorityRepository = userPriorityRepository;
  }


  @PostMapping("/loginOwner/{username}/{password}")
  public Boolean login(@PathVariable String username,@PathVariable String password) {
    Account account = accountRepository.findByUsername(username);
    UserPriority userPriority = userPriorityRepository.findById(1);
    if(account != null){
      if(!account.getUserPriority().equals(userPriority)){
        return false;
      }else if(account.getUsername().equalsIgnoreCase(username) & account.getPassword().equals(password)){
        return true;  
      }
    }
    return false;
  }
}