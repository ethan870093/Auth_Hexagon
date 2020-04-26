package validator;

import domain.Account;
import domain.RegisterInfo;
import service.AuthRepository;

public class RegisterValidator extends AuthValidator {

  public RegisterValidator(AuthRepository repository) {
    super(repository);
  }

  @Override
  public boolean isValid(Account account) {
    RegisterInfo info = (RegisterInfo) account;

    if (info.getUsername() == "") {
      messages.put("username", "Username is required");
      return false;
    }
    if (info.getPassword() == "") {
      messages.put("password", "Password is required");
      return false;
    }
    if (info.getPassword() != info.getConfirmPassword()) {
      messages.put("confirmPassword",
          "Password and Comfirm password is not match");
      return false;
    }

    if (repository.findByUsername(info.getUsername()) != null) {
      messages.put("username",
          "This username (" + info.getUsername() + ") has been exists!");
      return false;
    }

    return true;
  }

}
