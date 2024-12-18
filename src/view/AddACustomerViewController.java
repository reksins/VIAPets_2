package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.ModeManager;
import model.Pet;
import model.PetList;
import model.Customer;
import model.CustomerList;
import java.util.ArrayList;

public class AddACustomerViewController
{
  private Scene scene;
  private ModeManager modeManager;
  private ViewHandler viewHandler;

  @FXML private TextField nameField;
  @FXML private TextField emailField;
  @FXML private TextField phoneField;
  @FXML private ComboBox<Pet> petComboBox;
  @FXML private Button updateButton;
  @FXML private Button backButton;
  @FXML private MenuItem exitMenuItem;
  @FXML private CheckMenuItem editFieldsMenuItem;
  @FXML private MenuItem aboutMenuItem;

  public void init(ViewHandler viewHandler, Scene scene, ModeManager modeManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.modeManager = modeManager;
  }

  public void reset()
  {
    updatePetBox();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == updateButton)
    {
      String name = nameField.getText();
      String email = emailField.getText();
      String phonenumber = phoneField.getText();
      Pet pet = petComboBox.getSelectionModel().getSelectedItem();

      Customer temp = new Customer(name, email, phonenumber, pet);
      CustomerList temp1 = new CustomerList();
      temp1.getAllCustomers();
      temp1.addCustomer(temp);
      modeManager.saveCustomers(temp1);
      updatePetBox();
    }
    else if (e.getSource() == backButton)
    {
      viewHandler.openView("MainView");
    }
    else if (e.getSource() == exitMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          "Do you really want to exit the program?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);

      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES)
      {
        System.exit(0);
      }
    }
    else if (e.getSource() == editFieldsMenuItem)
    {
      if (editFieldsMenuItem.isSelected())
      {
        nameField.setEditable(true);
        emailField.setEditable(true);
        phoneField.setEditable(true);
      }
      else
      {
        nameField.setEditable(false);
        emailField.setEditable(false);
        phoneField.setEditable(false);
      }
    }
    else if (e.getSource() == aboutMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setTitle("About");
      alert.setContentText("This is the store information management system for VIAPets store made by Markus, Marta, Matteo and Matteo");
      alert.showAndWait();
    }
  }

  private void updatePetBox()
  {
    int currentIndex = petComboBox.getSelectionModel().getSelectedIndex();

    petComboBox.getItems().clear();

    ModeManager pets = new ModeManager("pets.bin");
    PetList temp = pets.getAllPetsFile();

    for (int i = 0; i < temp.size(); i++)
    {
      petComboBox.getItems().add(temp.get(i));
    }

    if (currentIndex == -1 && petComboBox.getItems().size() > 0)
    {
      petComboBox.getSelectionModel().select(0);
    }
    else
    {
      petComboBox.getSelectionModel().select(currentIndex);
    }
  }
}
