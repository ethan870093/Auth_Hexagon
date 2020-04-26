package service;

import command.AuthCommand;
import domain.AccountFactory;
import domain.AppUser;
import domain.LoginInfo;
import domain.RegisterInfo;
import validator.AuthValidator;
import validator.LoginValidator;
import validator.RegisterValidator;

public class AuthService {
  private AuthResponse response;
  private AuthValidator validator;
  private AuthRepository repository;

  public void run(AuthCommand command) {
    this.repository = command.getRepository();
    this.response = command.getResponse();
    switch (command.getType()) {
      case REGISTER:
        register(command);
        break;

      case LOGIN:
        login(command);
        break;

      default:
        throw new IllegalArgumentException("This command is not supported");
    }

  }

  private void login(AuthCommand command) {
    validator = new LoginValidator(command.getRepository());
    LoginInfo info = (LoginInfo) command.getAccount();
    if (validator.isValid(info)) {
      String salt = "generator salt by encrypt util";
      String encryptedPass = info.getPassword() + salt;
      // Hard code for demo
      encryptedPass = info.getPassword();
      AppUser appUser = repository.findByUsernameAndPassword(info.getUsername(),
          encryptedPass);
      if (appUser == null) {
        response.fail(false, "Đăng nhập thất bại");
      } else {
        response.reply(info);
      }
    } else {
      response.fail(validator.getMessage());
    }
  }

  private void register(AuthCommand command) {
    validator = new RegisterValidator(command.getRepository());
    RegisterInfo info = (RegisterInfo) command.getAccount();
    if (validator.isValid(info)) {
      AppUser appUser = AccountFactory.getInstance().parse(info);
      repository.save(appUser);
      response.reply(info);
    } else {
      response.fail(validator.getMessage());
    }
  }

}
