package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class NewAcademicController {
	
	
	@FXML
    private Label result;

    @FXML
    private TextField cet;

    @FXML
    private Button submit;

    @FXML
    private TextField sscYear;

    @FXML
    private TextField hscYear;

    @FXML
    private TextField jee;

    @FXML
    private TextField sscMarks;

    @FXML
    private TextField hscMarks;

    @FXML
    void onSubmit() {
    	
    	try
    	{
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    				
    		String sql1 = "insert into academic_detail values (" + Integer.parseInt(result.getText()) + "," + Double.parseDouble(cet.getText()) + "," + Double.parseDouble(jee.getText()) + "," + Double.parseDouble(hscMarks.getText()) + "," + Double.parseDouble(sscMarks.getText()) + "," + Integer.parseInt(sscYear.getText()) + "," + Integer.parseInt(hscYear.getText()) + ")";
            System.out.println(sql1);
    		ResultSet rs1 = con.createStatement().executeQuery(sql1);
    		
    		if (rs1.next())
    		{
    			result.setText("Saved");
                FXMLLoader loader  = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                AnchorPane root = (AnchorPane)loader.load();
                Scene scene = new Scene(root,400,400);
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                Stage  stage = new Stage();   
                stage.setScene(scene);
                stage.show();
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }
	
	
	
	
	public void setStudentId(int id)
    {
    	result.setText(String.valueOf(id));
    }

}
