package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewDetailsController {

    @FXML
    private Button parent;

    @FXML
    private Button academic;

    @FXML
    private Button personal;

    @FXML
    private TextField id;

    @FXML
    void showPersonal() {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("PersonalDetails2.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			PersonalDetailsController controller = (PersonalDetailsController)loader.getController();
			System.out.println(controller);
			controller.setStudentId(id.getText());
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void showAcademic() {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("AcademicDetails.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			AcademicDetailsController controller = (AcademicDetailsController)loader.getController();
			System.out.println(controller);
			controller.setStudentId(id.getText());
			System.out.println(id.getText());
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void showParent() {
    	try
    	{
	    	FXMLLoader loader  = new FXMLLoader(getClass().getResource("ParentDetails.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage  stage = new Stage();
			ParentDetailsController controller = (ParentDetailsController)loader.getController();
			System.out.println(controller);
			controller.setStudentId(id.getText());
			stage.setScene(scene);
			stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

}
