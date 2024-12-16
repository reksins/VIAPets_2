package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.ModeManager;
import model.PetList;

import java.util.ArrayList;

public class PetsController
{
  private Scene scene;
  private ModeManager modeManager;
  private ViewHandler viewHandler;

  @FXML private Button getButton;
  @FXML private Button backButton;
  @FXML private TextArea allPetsArea;
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
    updatePetArea();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == getButton)
    {
      updatePetArea();
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
        allPetsArea.setEditable(true);
      }
      else
      {
        allPetsArea.setEditable(false);
      }
    }
    else if (e.getSource() == aboutMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setTitle("About");
      alert.setContentText("This is just a little program that demonstrates some of the GUI features in Java");
      alert.showAndWait();
    }
  }

  private void updatePetArea()
  {
    PetList pets = modeManager.getAllPets();
    allPetsArea.setText(pets.toString());
  }
}