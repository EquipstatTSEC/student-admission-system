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



public class ParentDetailsController {
	   
	@FXML
    private Label fphone;

    @FXML
    private Label flName;

    @FXML
    private Label mfName;

    @FXML
    private Label mincome;

    @FXML
    private Label femail;

    @FXML
    private Label fincome;

    @FXML
    private Label memail;

    @FXML
    private Label mlName;

    @FXML
    private Label moccupation;

    @FXML
    private Label result;

    @FXML
    private Label mtype;

    @FXML
    private Label ftype;

    @FXML
    private Label fmName;

    @FXML
    private Label foccupation;

    @FXML
    private Label mmName;

    @FXML
    private Label mphone;

    @FXML
    private Label ffName;
	
	
	
	
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
//			setStudentId("4198782");
    		int id = Integer.parseInt(result.getText());
//			int id = 4198782;
    		
    		String sql1 = "select * from student_parents where student_id ="+ id;
    		System.out.println(sql1);
    		
    		ResultSet rs1 = con.createStatement().executeQuery(sql1);
    		int current = 0;
    		while (rs1.next())
    		{
    			if(current==0)
    			{
    				
    				String sql2 = "select * from parent where id=" + rs1.getString(2);
    				ResultSet rs2 = con.createStatement().executeQuery(sql2);
    				if(rs2.next()) {
    				mfName.setText(rs2.getString(3));
    				mmName.setText(rs2.getString(4));
    				mlName.setText(rs2.getString(5));
    				memail.setText(rs2.getString(6));
    				mtype.setText(rs2.getString(7));
    				moccupation.setText(rs2.getString(8));
    				mincome.setText(rs2.getString(9));
    				mphone.setText(rs2.getString(10));
    				
    				current=1;
    				}
    			}
    			else
    			{
    				String sql2 = "select * from parent where id=" + rs1.getString(2);
    				ResultSet rs2 = con.createStatement().executeQuery(sql2);
    				if(rs2.next()) {
    				ffName.setText(rs2.getString(3));
    				fmName.setText(rs2.getString(4));
    				flName.setText(rs2.getString(5));
    				femail.setText(rs2.getString(6));
    				ftype.setText(rs2.getString(7));
    				foccupation.setText(rs2.getString(8));
    				fincome.setText(rs2.getString(9));
    				fphone.setText(rs2.getString(10));
    			}}
    		}
		}
		
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}









