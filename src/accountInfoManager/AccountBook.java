package accountInfoManager;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class represents an account book that stores accounts.
 */
public class AccountBook {
  private HashMap<String, Account> accountBook;

  /**
   * Default constructor.
   */
  public AccountBook() {
    accountBook = new HashMap<>();
  }

  /**
   * Determines if the account book contains the account by looking up its label.
   * @param label the account label.
   * @return a boolean value that describes where the account is in the account book
   */
  public boolean labelExist(String label) {
    return accountBook.containsKey(label);
  }

  /**
   * Add an account to the account book.
   * @param label account label
   * @param username account username
   * @param password account password
   */
  public void addAccount(String label, String username, String password) {
      this.accountBook.put(label, new Account(label, username, password));
  }

  /**
   * Delete an account from the account book.
   * @param label the label of the account
   */
  public void deleteAccount(String label){
    this.accountBook.remove(label);
  }

  /**
   * Get a list of the labels in the account book. Return "(empty)" if the account book is empty.
   * @return the list of the labels in the account book
   */
  public String getLabelList(){
    if (isEmpty()) {
      return "(Empty)";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (String label : this.accountBook.keySet()){
      stringBuilder.append(label);
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  /**
   * Get the username that is associated with the account label provided.
   * @param label account label
   * @return the username of the account
   */
  public String getUsername(String label) {
    return this.accountBook.get(label).getUsername();
  }

  /**
   * Get the password that is associated with the account label provided.
   * @param label account label
   * @return the password of the account
   */
  public String getPassword(String label) {
    return this.accountBook.get(label).getPassword();
  }

  /**
   * Determine if the account book is empty.
   * @return a boolean value that represents whether the account book is empty
   */
  public boolean isEmpty(){
    return this.accountBook.size() == 0;
  }

  /**
   * Populate an account book with provided data. The data format is equivalent to toString() of
   * an account book.
   * @param s account info that is used to populate an account book
   * @return a populated account book
   */
  public static AccountBook populateAccountBook(String s) {
    AccountBook accountBook = new AccountBook();
    Scanner scanner = new Scanner(s);
    while (scanner.hasNext()) {
      String label = scanner.nextLine();
      String username = scanner.nextLine();
      String password = scanner.nextLine();
      label = label.substring(label.indexOf(":")+2);
      username = username.substring(username.indexOf(":")+2);
      password = password.substring(password.indexOf(":")+2);
      if (scanner.hasNext()) {
        String garbage = scanner.nextLine();
      }
      accountBook.addAccount(label, username, password);
    }
    return accountBook;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (String label: this.accountBook.keySet()){
      sb.append(this.accountBook.get(label).toString());
      sb.append("\n");
    }
    return sb.toString();
  }
}
