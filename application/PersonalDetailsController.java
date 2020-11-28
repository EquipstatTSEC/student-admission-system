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


public class PersonalDetailsController {

	@FXML
    private Label ews;

    @FXML
    private Label lName;

    @FXML
    private Label gender;

    @FXML
    private Label caste;

    @FXML
    private Label religion;

    @FXML
    private Label result;

    @FXML
    private Label fName;

    @FXML
    private Label phone;

    @FXML
    private Label dob;

    @FXML
    private Label aadhar;

    @FXML
    private Label disabled;

    @FXML
    private Label mName;

    @FXML
    private Label category;

    @FXML
    private Label email;

    @FXML
    private Label mother_tongue;
	
	public void setStudentId(String id)
    {
    	result.setText(id);
    	show();
    }
    
    
    public void show() {
    	try
    	{
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    		int id = Integer.parseInt(result.getText());
    		String sql = "select * from student where id="+ id;
    		ResultSet rs = con.createStatement().executeQuery(sql);
    		if(rs.next())
    		{
    			fName.setText(rs.getString(2));
    			mName.setText(rs.getString(3));
    			lName.setText(rs.getString(4));
    			dob.setText(rs.getString(5));
    			email.setText(rs.getString(6));
    			category.setText(rs.getString(7));
    			gender.setText(rs.getString(8));
    			ews.setText(rs.getString(9));
    			disabled.setText(rs.getString(10));
    			mother_tongue.setText(rs.getString(11));
    			caste.setText(rs.getString(12));
    			religion.setText(rs.getString(13));
    			phone.setText(rs.getString(14));
    			aadhar.setText(rs.getString(15));
    		}
    		else
    		{
    			result.setText("Invalid Student ID");
    		}
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	
    }

}
