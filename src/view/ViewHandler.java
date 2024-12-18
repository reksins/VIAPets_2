package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ModeManager;


import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private MainViewController mainViewController;
  private KennelBookingsController kennelBookingsController;
  private PetsController petsController;
  private CustomersController customersController;
  private AddACustomerViewController addCustomersViewController;
  private AddAPetViewController addAPetViewController;
  // private AddABookingViewController addABookingViewController;

  private ModeManager modeManager;

  public ViewHandler(Stage stage, ModeManager modeManager)
  {
    this.stage = stage;
    this.modeManager = modeManager;
  }

  public void start()
  {
    loadViewMain();
    loadViewPets();
    loadViewKennelBookings();
    loadViewCustomers();
    loadAddACustomer();
    openView("MainView");
  }

  public void openView(String id)
  {
    switch (id)
    {
      case "MainView":
        stage.setScene(mainViewController.getScene());
        mainViewController.reset();
        break;
      case "KennelBookingsView":
        stage.setScene(kennelBookingsController.getScene());
        kennelBookingsController.reset();
        break;
      case "PetsView":
        stage.setScene(petsController.getScene());
        petsController.reset();
        break;
      case "CostumersView":
        stage.setScene(customersController.getScene());
        customersController.reset();
        break;
      case "AddACostumersView":
        stage.setScene(addCustomersViewController.getScene());
        customersController.reset();
        break;
      /*case "AddAPetView":
        stage.setScene(AddAPetViewController.getScene());
        customersController.reset();
        break; */
    }

    String title = "";

    if(stage.getScene().getRoot().getUserData() !=null)
    {
      title = stage.getScene().getRoot().getUserData().toString();
    }

    stage.setTitle(title);
    stage.show();
  }

  private void loadViewMain()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainView.fxml"));
      Region root = loader.load();
      mainViewController = loader.getController();
      mainViewController.init(this, new Scene(root), modeManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadViewKennelBookings()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("KennelBookingsView.fxml"));
      Region root = loader.load();
      kennelBookingsController = loader.getController();
      kennelBookingsController.init(this, new Scene(root), modeManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadViewCustomers()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CustomersView.fxml"));
      Region root = loader.load();
      customersController = loader.getController();
      customersController.init(this, new Scene(root), modeManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadViewPets()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("PetsView.fxml"));
      Region root = loader.load();
      petsController = loader.getController();
      petsController.init(this, new Scene(root), modeManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadAddACustomer()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("AddACustomerView.fxml"));
      Region root = loader.load();
      addCustomersViewController = loader.getController();
      addCustomersViewController.init(this, new Scene(root), modeManager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /*
    It's not necessary in this example, but sometimes it might be needed
    for one controller to access/modify data in another controller's view.
    That can be done by creating a get-method in this ViewHandler class for
    the controller of the view that must be accessed. E.g.:

     public kennelBookingsController getKennelBookingsController()
     {
       return kennelBookingsController;
     }

    It's then possible in e.g. the MainViewController to call this
    get-method on its ViewHandler object, to get access to any methods
    made in the kennelBookingsController. E.g.:

     viewHandler.getKennelBookingsController().aSetMethod("New data to set");
  */
}
