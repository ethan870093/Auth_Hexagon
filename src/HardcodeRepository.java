
import java.util.ArrayList;
import java.util.List;

import domain.AppUser;
import service.AuthRepository;

public class HardcodeRepository implements AuthRepository {

  private List<AppUser> users = null;

  public HardcodeRepository() {
    super();
    this.users = new ArrayList<AppUser>();
    this.users.add(new AppUser("username", "password", "salt"));
  }

  @Override
  public void save(AppUser appUser) {
    users.add(appUser);
  }

  @Override
  public AppUser findByUsername(String username) {
    for (AppUser user : users) {
      if (user.getUsername() == username) {
        return user;
      }
    }

    return null;
  }

  @Override
  public AppUser findByUsernameAndPassword(String username,
      String encryptedPass) {
    for (AppUser user : users) {
      if (user.getUsername() == username
          && user.getPassword() == encryptedPass) {
        return user;
      }
    }

    return null;
  }

}
