package service;

import domain.AppUser;

public interface AuthRepository {

  void save(AppUser appUser);

  AppUser findByUsername(String username);

  AppUser findByUsernameAndPassword(String username, String encryptedPass);

}
