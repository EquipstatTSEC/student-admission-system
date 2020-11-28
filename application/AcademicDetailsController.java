package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.util.Random; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;





public class AcademicDetailsController {

    @FXML
    private Label result;

    @FXML
    private Label cet;

    @FXML
    private Label hscYear;

    @FXML
    private Label sscYear;

    @FXML
    private Label jee;

    @FXML
    private Label sscMarks;

    @FXML
    private Label hscMarks;
    
    
    
    public void setStudentId(String id)
    {
    	result.setText(id);
    	System.out.println(id);
    	show();
    }
    
    
    
    public void show()
    {
    	try
    	{
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    		System.out.println("Connected");

    		int id = Integer.parseInt(result.getText());
    		String sql = "select * from academic_detail where student_id ="+ id;
    		System.out.println(sql);
    		ResultSet rs = con.createStatement().executeQuery(sql);
    		System.out.println(rs);
    		if(rs.next())
    		{
    			System.out.println("Inside IF");
    			cet.setText(rs.getString(2));
    			System.out.println("cet");
    			hscYear.setText(rs.getString(7));
    			System.out.println("hscyr");
    			sscYear.setText(rs.getString(6));
    			System.out.println("sscyr");
    			jee.setText(rs.getString(3));
    			System.out.println("jee");
    			sscMarks.setText(rs.getString(5));
    			System.out.println("sscmks");
    			hscMarks.setText(rs.getString(4));
    			System.out.println("hscmks");
    		}
    		else
    		{
    			result.setText("Invalid Student ID");
    		}
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }

}
