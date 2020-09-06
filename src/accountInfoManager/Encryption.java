package accountInfoManager;

/**
 * This class represent the methods that encode and decode account data.
 */
public class Encryption {
  private int[] keys;
  private int k;

  /**
   * Class constructor. Set the keys that are used for data encryption.
   */
  public Encryption() {
    this.keys = new int[] {1, 9, 85, 7, 66, 28, 2, 10, 99, 30};
    this.k = this.keys.length;
  }

  /**
   * Method that encrypt the data. Works for both encoding and decoding purpose.
   * @param accountData account data (either raw data or encoded)
   * @param dataIsEncoded true for decoding and false for encoding
   * @return the data that are encoded (or decoded, based on the mode that is in)
   */
  protected String encrypt(String accountData, boolean dataIsEncoded) {
    char[] chars = accountData.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      int key = keys[i % k];
      char c = chars[i];
      if (dataIsEncoded) {
        chars[i] = this.decode(c, key);
      }
      else{
        chars[i] = this.encode(c,key);
      }
    }

    return new String(chars);
  }

  /**
   * Helper method that encodes data.
   * @param c char value of the data
   * @param key key used to encode the char value
   * @return the encoded char
   */
  protected char encode(char c, int key) {
    return (char) (c + key);
  }

  /**
   * Helper method that decodes data.
   * @param c char value of the data
   * @param key key used to decode the char value
   * @return the decoded char
   */
  protected char decode(char c, int key) {
    return (char)(c - key);
  }
}
