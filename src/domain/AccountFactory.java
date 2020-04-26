package domain;

public class AccountFactory {
  private static AccountFactory INSTANCE = null;

  private AccountFactory() {
  }

  public static AccountFactory getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AccountFactory();
    }
    return INSTANCE;
  }

  public AppUser parse(Account account) {
    if (account instanceof RegisterInfo) {
      return getRegister(account);
    }
    throw new IllegalArgumentException("This account is not supported");
  }

  private AppUser getRegister(Account account) {
    RegisterInfo info = (RegisterInfo) account;
    AppUser appUser = new AppUser();
    String salt = "generator salt by encrypt util";
    appUser.setUsername(info.getUsername());
    appUser.setSalt(salt);
    appUser.setPassword(info.getPassword() + salt);

    return appUser;
  }

}
