
import java.util.Map.Entry;

import domain.LoginInfo;
import domain.RegisterInfo;
import service.AuthResponse;

public class ConsoleResponse extends AuthResponse {

  public void display() {
    if (this.status) {
      System.out.println("Register successful with account: "
          + ((RegisterInfo) this.account).getUsername());
    } else {
      System.out.println("Has error: ");
      for (Entry<String, Object> msg : this.errors.entrySet()) {
        System.out.println(msg.getKey() + " : " + msg.getValue());
      }
    }
  }

  public void loginResult() {
    if (this.status) {
      System.out.println("Login successful with account: "
          + ((LoginInfo) this.account).getUsername());
    } else {

      if (errors.size() > 0) {
        System.out.println("Has error: ");
        for (Entry<String, Object> msg : this.errors.entrySet()) {
          System.out.println(msg.getKey() + " : " + msg.getValue());
        }
      } else {
        System.out.println(this.message);
      }
    }
  }

}
