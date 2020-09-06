package accountInfoManager;

/**
 * This class represent an account. An account contains three pieces of information:
 * 1) the label of the account, 2) account username, and 3) account password.
 */
public class Account {
  private String label;
  private String username;
  private String password;

  /**
   * The constructor of the account class.
   * @param label account label
   * @param username account username
   * @param password account password
   */
  public Account(String label, String username, String password) {
    this.label = label;
    this.username = username;
    this.password = password;
  }

  /**
   * Get the account label.
   * @return the account label
   */
  public String getLabel(){
    return this.label;
  }

  /**
   * Get the username.
   * @return the username
   */
  public String getUsername(){
    return this.username;
  }

  /**
   * Get the password.
   * @return the password
   */
  public String getPassword(){
    return this.password;
  }

  /**
   * Set the value of the account label.
   * @param label account label
   */
  public void setLabel(String label){
    this.label = label;
  }

  /**
   * Set the username of the account.
   * @param username account username
   */
  public void setUsername(String username){
    this.username = username;
  }

  /**
   * Set the password of the account.
   * @param password account password
   */
  public void setPassword(String password){
    this.password = password;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Label: " + this.label + "\n");
    sb.append("Username: " + this.username + "\n");
    sb.append("Password: " + this.password + "\n");
    return sb.toString();
  }
}
