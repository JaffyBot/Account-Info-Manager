package accountInfoManager;

/**
 * The driver of the Account Info Manager program.
 */
public class Main {
  public static void main(String[] args) {
    AccountBook accountBook = new AccountBook();
    FileInputOutput fileIO = new FileInputOutput();
    Encryption encryptor = new Encryption();

    // read the encrypted data
    String encodedData = fileIO.readFile();
    // if the data isn't empty
    if (encodedData.length() != 0) {
      // decode the data and populate the account book with the data
      String decodedData = encryptor.encrypt(encodedData, true);
      accountBook = AccountBook.populateAccountBook(decodedData);
    }
    // run the program graphical interface
    new GUI(accountBook);
  }
}
