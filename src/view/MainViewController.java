package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import model.ModeManager;

public class MainViewController
{
  private Scene scene;
  private ModeManager modeManager;
  private ViewHandler viewHandler;

  @FXML Button KennelBookingsButton;
  @FXML Button PetsForSaleButton;
  @FXML Button CustomersButton;
  @FXML MenuItem exitMenuItem;
  @FXML MenuItem aboutMenuItem;

  public void init(ViewHandler viewHandler, Scene scene, ModeManager modeManager)
  {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.modeManager = modeManager;
  }

  public void reset(){

  }

  public Scene getScene(){
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == KennelBookingsButton)
    {
      viewHandler.openView("KennelBookingsView");
    }
    else if(e.getSource() == PetsForSaleButton)
    {
      viewHandler.openView("PetsView");
    }
    else if(e.getSource() == CustomersButton)
    {
      viewHandler.openView("CustomersView");
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
    else if (e.getSource() == aboutMenuItem)
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setTitle("About the program");
      alert.setContentText("This is the store information management system for VIAPets store made by Markus, Marta, Matteo and Matteo");
      alert.showAndWait();
    }
  }
}
