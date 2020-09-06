package accountInfoManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class presents methods that read and write (encrypted) account data.
 */
public class FileInputOutput {
  String filename;

  /**
   * Class constructor.
   */
  public FileInputOutput() {
    this.filename = "Account Data.txt";
  }

  /**
   * Read data from specified local file and return it.
   * Return an empty string if the data file is empty or the file cannot be found.
   * @return the data read as a string
   */
  protected String readFile() {
    String s = "";
    try {
      FileReader fr = new FileReader(this.filename);
      int i;
      while ((i = fr.read()) != -1) {
        s += (char)(i);
      }
      fr.close();
    } catch (FileNotFoundException e) {
      return s;
    } catch (IOException e) {
      return s;
    }
    return s;
  }

  /**
   * Write data to a local text file.
   * @param data data to be written.
   */
  protected void writeToFile(String data) {
    try {
      FileWriter fw = new FileWriter(this.filename);
      fw.write(data);
      fw.close();
    } catch (IOException ioe) {
      System.out.println("Account data cannot be written.");
    }
  }
}
