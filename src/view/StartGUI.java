package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ModeManager;

public class StartGUI extends Application
{
  public void start(Stage window)
  {
    ModeManager ModeManager = new ModeManager("VIAPets.bin");
    ViewHandler viewHandler = new ViewHandler(window, ModeManager);
    viewHandler.start();

  }
}
