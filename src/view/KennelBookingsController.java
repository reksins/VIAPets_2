package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.Booking;
import model.BookingList;
import model.ModeManager;
import model.PetList;

import java.util.ArrayList;

public class KennelBookingsController
{
  private Scene scene;
  private ModeManager modeManager;
  private ViewHandler viewHandler;

  @FXML private Button getButton;
  @FXML private Button backButton;
  @FXML private TextArea allBookingsArea;
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
    updateBookingsArea();
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == getButton)
    {
      updateBookingsArea();
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
        allBookingsArea.setEditable(true);
      }
      else
      {
        allBookingsArea.setEditable(false);
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

  private void updateBookingsArea()
  {
    BookingList bookings = modeManager.getAllBookings();
    allBookingsArea.setText(bookings.toString());
  }
}
