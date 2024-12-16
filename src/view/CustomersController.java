package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.*;

import java.util.ArrayList;

public class CustomersController
{
  private Scene scene;
  private ModeManager modeManager;
  private ViewHandler viewHandler;

  @FXML private Button getButton;
  @FXML private Button backButton;
  @FXML private TextArea allCustomersArea;
  @FXML private MenuItem exitMenuItem;
  @FXML private CheckMenuItem editAreaMenuItem;
  @FXML private MenuItem aboutMenuItem;

  public void init(ViewHandler viewHandler, Scene scene, ModeManager modeManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.modeManager = modeManager;
  }

  public void reset()
  {
    updateCustomersArea();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == getButton)
    {
      updateCustomersArea();
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
    else if (e.getSource() == editAreaMenuItem)
    {
      if (editAreaMenuItem.isSelected())
      {
        allCustomersArea.setEditable(true);
      }
      else
      {
        allCustomersArea.setEditable(false);
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

  private void updateCustomersArea()
  {
    CustomerList customers = modeManager.getAllCustomers();
    allCustomersArea.setText(customers.toString());
  }
}
