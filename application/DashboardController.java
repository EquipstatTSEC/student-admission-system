package application;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class DashboardController {

	@FXML
    private Button addStudent;

    @FXML
    private Button studentDetails;


    @FXML
    void showDetails()
    {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("ViewDetails.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    @FXML
    void addStudent()
    {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("NewStudent.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	

    }
    @FXML
    void AddTerrorist() 
    {
    	try
    	{
    		FXMLLoader loader  = new FXMLLoader(getClass().getResource("NewTerrorist.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			stage.setScene(scene);
			stage.show();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	

    }
    @FXML
    void showDetailst()
    {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("TerroristDetails.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }

}
