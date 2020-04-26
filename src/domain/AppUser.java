package domain;

public class AppUser implements Account {

  private String username;
  private String salt;
  private String password;

  public AppUser() {
    super();
  }

  public AppUser(String username, String password, String salt) {
    super();
    this.username = username;
    this.salt = salt;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
