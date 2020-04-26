package validator;

import java.util.HashMap;
import java.util.Map;

import domain.Account;
import service.AuthRepository;

public abstract class AuthValidator {

  protected AuthRepository repository;

  protected Map<String, Object> messages;

  public AuthValidator(AuthRepository repository) {
    super();
    this.repository = repository;
    this.messages = new HashMap<String, Object>();
  }

  public abstract boolean isValid(Account info);

  public Map<String, Object> getMessage() {
    return messages;
  }

}
