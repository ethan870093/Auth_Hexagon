package service;

import java.util.HashMap;
import java.util.Map;

import domain.Account;

public class AuthResponse {
  protected boolean status;
  protected String message;
  protected Map<String, Object> errors;
  protected Account account;

  public void fail(Map<String, Object> errors) {
    this.status = false;
    this.account = null;
    this.errors = errors;
  }

  public void reply(Account account) {
    this.status = true;
    this.account = account;
    this.errors = new HashMap<String, Object>();
  }

  public void fail(boolean status, String message) {
    this.errors = new HashMap<String, Object>();
    this.status = status;
    this.message = message;
  }

}
