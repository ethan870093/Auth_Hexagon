package validator;

import domain.Account;
import domain.LoginInfo;
import service.AuthRepository;

public class LoginValidator extends AuthValidator {

  public LoginValidator(AuthRepository repository) {
    super(repository);
  }

  @Override
  public boolean isValid(Account account) {
    LoginInfo info = (LoginInfo) account;
    if (info.getUsername() == "") {
      messages.put("username", "Username is required");
      return false;
    }
    if (info.getPassword() == "") {
      messages.put("password", "Password is required");
      return false;
    }

    return true;
  }

}
