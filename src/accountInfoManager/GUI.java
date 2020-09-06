package accountInfoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * This class represents the GUI of the Account Info Manager Program.
 * The GUI contains four pages: 1) main menu page, 2) add new account page,
 * 3) select existing account page, and 4) update existing account page.
 */
public class GUI {
  private AccountBook accountBook;
  boolean wasModified;

  private JFrame frame;
  private JFrame popWindowFrame;
  private JPanel rootPanel;
  private JPanel menuPanel;
  private JPanel newAccountPanel, newAccountPanelSub1, newAccountPanelSub2;
  private JPanel selectExistingAccountPanel, selectExistingAccountPanelSub1, selectExistingAccountPanelSub2,
          selectExistingAccountPanelSub3;
  private JPanel updateExistingAccountPanel, updateExistingAccountPanelSub1, updateExistingAccountPanelSub2;

  private JScrollPane scrollPane;

  private JButton newAccountButton, existingAccountButton;
  private JButton addButton, backButton1;
  private JButton confirmButton, backButton2;
  private JButton updateButton, backButton3, deleteButton;

  private ImageIcon image1, image2, image3;
  private JLabel background1,background2, background3, background4;
  private JLabel newAccountLabelLabel, newAccountUsernameLabel, newAccountPasswordLabel;
  private JLabel selectExistingAccountLabel;
  private JLabel updateAccountLabelLabel, updateAccountUsernameLabel, updateAccountPasswordLabel;

  private JTextField newAccountLabelTextField, newAccountUsernameTextField;
  private JTextField selectExistingAccountTextField;
  private JTextField updateAccountLabelTextField, updateAccountUsernameTextField, updateAccountPasswordTextField;
  private JPasswordField newAccountPasswordTextField;
  private JTextArea textArea;

  private CardLayout cardLayout;
  private GridBagConstraints gbc;

  /**
   * Class Constructor that sets up the program graphical user interface.
   * @param accountBook An account book that stores account information
   */
  public GUI(AccountBook accountBook){
    this.accountBook = accountBook;
    this.wasModified = false;

    // set the two main frames in the program
    this.popWindowFrame = new JFrame();
    this.frame = new JFrame("Account Info Manager ");
    this.frame.setSize(500,290);
    this.frame.setLocationRelativeTo(null);
    this.frame.addWindowListener(new WindowHandler());
    this.frame.setResizable(false);

    // initialize layout objects
    this.gbc = new GridBagConstraints();
    this.cardLayout = new CardLayout();

    this.rootPanel = new JPanel();
    this.rootPanel.setLayout(this.cardLayout);

    // set up the pages/panels
    setUpMenu();
    setUpNewAccountPage();
    setUpSelectExistingAccountPage();
    setUpUpdateExistingAccountPage();

    //show the menu page as the first pane
    this.cardLayout.show(this.rootPanel, "Menu Panel");
    this.frame.add(this.rootPanel);
    this.frame.setVisible(true);
  }

  private void setUpMenu(){
    this.menuPanel = new JPanel(new BorderLayout());

    // set background photo
    this.image1 = new ImageIcon("Background Photo 1.jpg");
    this.background1 = new JLabel(image1);
    this.background1.setLayout(new GridBagLayout());

    this.newAccountButton = new JButton("Add New Account");
    this.newAccountButton.setPreferredSize(new Dimension(160, 25));
    this.existingAccountButton = new JButton("Update Account");
    this.existingAccountButton.setPreferredSize(new Dimension(160, 25));

    // set action listener to the buttons
    this.newAccountButton.addActionListener(new EventHandler());
    this.existingAccountButton.addActionListener(new EventHandler());

    this.gbc.insets = new Insets(10,10,10,10);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.background1.add(this.newAccountButton, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.background1.add(this.existingAccountButton, gbc);

    this.menuPanel.add(this.background1);
    this.rootPanel.add(this.menuPanel,"Menu Panel");
  }

  private void setUpNewAccountPage(){
    this.newAccountPanel = new JPanel();
    this.newAccountPanel.setLayout(new BorderLayout());
    this.newAccountPanelSub1 = new JPanel(new BorderLayout());
    this.newAccountPanelSub2 = new JPanel(new FlowLayout());

    // set background photo
    this.image2 = new ImageIcon("Background Photo 2.jpg");
    this.background2 = new JLabel(this.image2);
    this.background2.setLayout(new GridBagLayout());

    this.addButton = new JButton("Add");
    this.addButton.setPreferredSize(new Dimension(100, 25));
    this.backButton1 = new JButton("Back");
    this.backButton1.setPreferredSize(new Dimension(100, 25));

    // set action listener to the buttons
    this.addButton.addActionListener(new EventHandler());
    this.backButton1.addActionListener(new EventHandler());

    this.newAccountLabelTextField = new JTextField(20);
    this.newAccountUsernameTextField = new JTextField(20);
    this.newAccountPasswordTextField = new JPasswordField(20);
    this.newAccountLabelLabel = new JLabel("Create a new label:");
    this.newAccountUsernameLabel = new JLabel("Account username:");
    this.newAccountPasswordLabel = new JLabel("Account password:");

    this.gbc.insets = new Insets(1,1,1,1);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.background2.add(this.newAccountLabelLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.background2.add(this.newAccountLabelTextField, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 3;
    this.background2.add(this.newAccountUsernameLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 4;
    this.background2.add(this.newAccountUsernameTextField, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 5;
    this.background2.add(this.newAccountPasswordLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 6;
    this.background2.add(this.newAccountPasswordTextField, gbc);

    this.newAccountPanelSub1.add(this.background2);
    this.newAccountPanelSub2.add(this.addButton);
    this.newAccountPanelSub2.add(this.backButton1);

    this.newAccountPanel.add(this.newAccountPanelSub1);
    this.newAccountPanel.add(this.newAccountPanelSub2, BorderLayout.SOUTH);
    this.rootPanel.add(this.newAccountPanel, "New Account Panel");
  }

  private void setUpSelectExistingAccountPage(){
    this.selectExistingAccountPanel = new JPanel(new BorderLayout());
    this.selectExistingAccountPanelSub1 = new JPanel();
    this.selectExistingAccountPanelSub1.setLayout(new BoxLayout(this.selectExistingAccountPanelSub1, BoxLayout.PAGE_AXIS));
    this.selectExistingAccountPanelSub2 = new JPanel(new BorderLayout());
    this.selectExistingAccountPanelSub3 = new JPanel(new FlowLayout());

    // set the text area and add a scroll bar to it
    this.textArea = new JTextArea(this.accountBook.getLabelList(),10,7);
    this.textArea.setEditable(false);
    this.scrollPane = new JScrollPane(this.textArea);
    this.scrollPane.createVerticalScrollBar();

    // set background photo
    this.image3 = new ImageIcon("Background Photo 3.jpg");
    this.background3 = new JLabel(image3);
    this.background3.setLayout(new GridBagLayout());

    this.selectExistingAccountLabel = new JLabel("Select an Existing Account Label:");
    this.selectExistingAccountTextField = new JTextField(20);

    this.confirmButton = new JButton("Confirm");
    this.confirmButton.setPreferredSize(new Dimension(100,25));
    this.backButton2 = new JButton("Back");
    this.backButton2.setPreferredSize(new Dimension(100,25));

    // set action listener to the buttons
    this.confirmButton.addActionListener(new EventHandler());
    this.backButton2.addActionListener(new EventHandler());

    this.gbc.insets = new Insets(10,10,10,10);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.background3.add(this.selectExistingAccountLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.background3.add(this.selectExistingAccountTextField, gbc);

    this.selectExistingAccountPanelSub1.add(this.scrollPane);
    this.selectExistingAccountPanelSub2.add(this.background3);
    this.selectExistingAccountPanelSub3.add(this.confirmButton);
    this.selectExistingAccountPanelSub3.add(this.backButton2);

    this.selectExistingAccountPanel.add(this.selectExistingAccountPanelSub1, BorderLayout.WEST);
    this.selectExistingAccountPanel.add(this.selectExistingAccountPanelSub2);
    this.selectExistingAccountPanel.add(this.selectExistingAccountPanelSub3, BorderLayout.SOUTH);

    this.rootPanel.add(this.selectExistingAccountPanel, "Select Existing Account Panel");
  }

  private void setUpUpdateExistingAccountPage() {
    this.updateExistingAccountPanel = new JPanel(new BorderLayout());
    this.updateExistingAccountPanelSub1 = new JPanel(new BorderLayout());
    this.updateExistingAccountPanelSub2 = new JPanel(new FlowLayout());

    // set background photo
    this.background4 = new JLabel(this.image3);
    this.background4.setLayout(new GridBagLayout());

    this.updateAccountLabelTextField = new JTextField(20);
    this.updateAccountUsernameTextField = new JTextField(20);
    this.updateAccountPasswordTextField = new JTextField(20);
    this.updateAccountLabelLabel = new JLabel("Account Label:");
    this.updateAccountUsernameLabel = new JLabel("Account Username:");
    this.updateAccountPasswordLabel = new JLabel("Account Password:");

    this.updateButton = new JButton("Update");
    this.updateButton.setPreferredSize(new Dimension(130, 25));
    this.backButton3 = new JButton ("Back");
    this.backButton3.setPreferredSize(new Dimension(130, 25));
    this.deleteButton = new JButton("Delete Account");
    this.deleteButton.setPreferredSize(new Dimension(130, 25));

    // add action listener to the buttons
    this.updateButton.addActionListener(new EventHandler());
    this.backButton3.addActionListener(new EventHandler());
    this.deleteButton.addActionListener(new EventHandler());

    this.gbc.insets = new Insets(1,1,1,1);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    this.background4.add(this.updateAccountLabelLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    this.background4.add(this.updateAccountLabelTextField, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 3;
    this.background4.add(this.updateAccountUsernameLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 4;
    this.background4.add(this.updateAccountUsernameTextField, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 5;
    this.background4.add(this.updateAccountPasswordLabel, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 6;
    this.background4.add(this.updateAccountPasswordTextField, gbc);

    this.updateExistingAccountPanelSub2.add(this.updateButton);
    this.updateExistingAccountPanelSub2.add(this.backButton3);
    this.updateExistingAccountPanelSub2.add(this.deleteButton);
    this.updateExistingAccountPanelSub1.add(this.background4);

    this.updateExistingAccountPanel.add(updateExistingAccountPanelSub1);
    this.updateExistingAccountPanel.add(updateExistingAccountPanelSub2, BorderLayout.SOUTH);

    this.rootPanel.add(this.updateExistingAccountPanel, "Update Existing Account Panel");
  }

  // empty the text fields
  private void resetNewAccountTextField() {
    this.newAccountLabelTextField.setText("");
    this.newAccountUsernameTextField.setText("");
    this.newAccountPasswordTextField.setText("");
  }

  // update to label list shown to the text area
  // the function does not update it if the data was not modified
  private void updateTextArea() {
    if (this.wasModified) {
      this.textArea.setText(accountBook.getLabelList());
      this.wasModified = false;
    }
  }

  // refill the text fields with the the info of the account of interest
  private void resetUpdateExistingAccountTextField(String label) {
    this.updateAccountLabelTextField.setText(label);
    this.updateAccountUsernameTextField.setText(accountBook.getUsername(label));
    this.updateAccountPasswordTextField.setText(accountBook.getPassword(label));
  }

  // determine if any of the text fields is empty
  private boolean textFieldsAreEmpty(String label, String username, String password) {
    return label.strip().length() == 0 || username.strip().length() == 0 ||
            password.strip().length() == 0;
  }

  // encrypt the account data and write them to a file
  private void saveData() {
    String data;
    if (this.accountBook.isEmpty()) {
      data = "";
    }
    else {
      data = new Encryption().encrypt(this.accountBook.toString(), false);
    }
    new FileInputOutput().writeToFile(data);
  }

  // the class that handles button-clicking events
  private class EventHandler implements ActionListener {
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == newAccountButton) {
        cardLayout.show(rootPanel, "New Account Panel");
      }
      else if (e.getSource() == existingAccountButton) {
        updateTextArea();
        cardLayout.show(rootPanel, "Select Existing Account Panel");
      }
      else if (e.getSource() == backButton1) {
        resetNewAccountTextField();
        cardLayout.show(rootPanel, "Menu Panel");
      }
      else if (e.getSource() == backButton2) {
        selectExistingAccountTextField.setText("");
        cardLayout.show(rootPanel, "Menu Panel");
      }
      else if (e.getSource() == backButton3) {
        selectExistingAccountTextField.setText("");
        updateTextArea();
        cardLayout.show(rootPanel, "Select Existing Account Panel");
      }
      else if (e.getSource() == addButton) {
        String label = newAccountLabelTextField.getText();
        String username = newAccountUsernameTextField.getText();
        String password = newAccountPasswordTextField.getText();
        if (textFieldsAreEmpty(label, username, password)) {
          // warning pop window
          JOptionPane.showMessageDialog(popWindowFrame, "Fields cannot be empty.",
                  "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
          if (accountBook.labelExist(label)){
            // warning pop window
            JOptionPane.showMessageDialog(popWindowFrame, "Label already exists.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
          }
          else {
            accountBook.addAccount(label, username, password);
            wasModified = true;
            // pop window saying account added
            JOptionPane.showMessageDialog(popWindowFrame, "Account successfully added!");
            resetNewAccountTextField();
          }
        }
      }
      else if (e.getSource() == confirmButton) {
        String label = selectExistingAccountTextField.getText();
        if (! accountBook.labelExist(label)){
          // pop window saying account label does not exist
          JOptionPane.showMessageDialog(popWindowFrame,"Label does not exist.",
                  "Warning",  JOptionPane.WARNING_MESSAGE);
        }
        else {
          resetUpdateExistingAccountTextField(label);
          cardLayout.show(rootPanel, "Update Existing Account Panel");
        }
      }
      else if (e.getSource() == updateButton) {
        String originalLabel = selectExistingAccountTextField.getText();
        String currentLabel = updateAccountLabelTextField.getText();
        String currentUsername = updateAccountUsernameTextField.getText();
        String currentPassword = updateAccountPasswordTextField.getText();

        if (textFieldsAreEmpty(currentLabel, currentUsername, currentPassword)) {
          // pop window saying fields cannot be empty
          JOptionPane.showMessageDialog(popWindowFrame, "Fields cannot be empty.",
                  "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
          if (originalLabel != currentLabel) {
            accountBook.deleteAccount(originalLabel);
            selectExistingAccountTextField.setText(currentLabel);
          }
          accountBook.addAccount(currentLabel, currentUsername, currentPassword);
          wasModified = true;
          JOptionPane.showMessageDialog(popWindowFrame, "Account updated!");
        }
      }
      else if (e.getSource() == deleteButton) {
        accountBook.deleteAccount(selectExistingAccountTextField.getText());
        wasModified = true;
        // pop window that saying account deleted
        JOptionPane.showMessageDialog(popWindowFrame, "Account removed!");
        backButton3.doClick();
      }
    }
  }

  // class that handles when the window is closed
  private class WindowHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      // automatically save the account data when the window is closed
      saveData();
      System.exit(0);
    }
  }
}
