import command.AuthCommand;
import command.CommandType;
import domain.Account;
import domain.RegisterInfo;
import service.AuthRepository;
import service.AuthResponse;
import service.AuthService;

public class RegisterMain {
  public static void main(String[] args) {
    // input
    Account account = new RegisterInfo("buivanA", "password2", "password");

    // create connection with DB
    AuthRepository repository = new HardcodeRepository();

    // define how to show output
    AuthResponse console = new ConsoleResponse();

    // setting command to ready to run
    AuthCommand command = new AuthCommand(account, console, repository,
        CommandType.REGISTER);

    // create service
    AuthService service = new AuthService();

    // run service with resource above
    service.run(command);

    // display result with console
    ((ConsoleResponse) console).display();
  }
}
