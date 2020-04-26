import command.AuthCommand;
import command.CommandType;
import domain.Account;
import domain.LoginInfo;
import service.AuthRepository;
import service.AuthResponse;
import service.AuthService;

public class LoginMain {
  public static void main(String[] args) {
    // input
    Account account = new LoginInfo("username", "password");

    // create connection with DB
    AuthRepository repository = new HardcodeRepository();

    // define how to show output
    AuthResponse console = new ConsoleResponse();

    // setting command to ready to run
    AuthCommand command = new AuthCommand(account, console, repository,
        CommandType.LOGIN);
    // create service
    AuthService service = new AuthService();

    // run service with resource above
    service.run(command);

    // display result with console
    ((ConsoleResponse) console).loginResult();
  }
}
