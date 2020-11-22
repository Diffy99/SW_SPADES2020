package server.serverdata;

import java.io.Serializable;

public class CreateAccountData implements Serializable 
{
  // Private data fields for the username and password.
  private String username;
  private String password;
  private String verifyPassword;
  
  // Getters for the username and password.
  public String getUsername()
  {
    return username;
  }
  public String getPassword()
  {
    return password;
  }
  public String getPassword2()
  {
    return verifyPassword;
  }
  
  // Setters for the username and password.
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public void setPassword2(String password)
  {
    this.verifyPassword = password;
  }
  
  // Constructor that initializes the username and password.
  public CreateAccountData(String username, String password, String password2)
  {
    setUsername(username);
    setPassword(password);
    setPassword2(password2);
  }
}
