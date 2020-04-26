package command;

import domain.Account;
import service.AuthRepository;
import service.AuthResponse;

public class AuthCommand {
  private final AuthResponse response;
  private final AuthRepository repository;
  private final Account account;
  private final CommandType type;

  public AuthCommand(Account account, AuthResponse response,
      AuthRepository repository, CommandType type) {
    super();
    this.response = response;
    this.repository = repository;
    this.account = account;
    this.type = type;
  }

  public AuthResponse getResponse() {
    return response;
  }

  public AuthRepository getRepository() {
    return repository;
  }

  public Account getAccount() {
    return account;
  }

  public CommandType getType() {
    return type;
  }

}
