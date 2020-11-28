package application;

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

public class NewStudentController {
	
	
	ObservableList<String> categoryList = FXCollections.observableArrayList();
	@FXML
    private ChoiceBox<String> category;

    @FXML
    private TextField lName;

    @FXML
    private Button submit;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField phone;

    @FXML
    private TextField dob;

    @FXML
    private TextField caste;

    @FXML
    private TextField fName;

    @FXML
    private TextField mName;

    @FXML
    private TextField mother_tounge;

    @FXML
    private TextField email;

    @FXML
    private TextField religion;
    
    @FXML
    private Label result;
    
    @FXML
    private TextField aadhar;
    
    @FXML
    private CheckBox ews;
    
    @FXML
    private CheckBox disabled;
    
    private void loadData()
    {
    	categoryList.removeAll(categoryList);
    	String A = "Open";
    	String B = "OBC";
    	String C = "ST";
    	String D = "J&K";
    	categoryList.addAll(A, B , C, D);
    	category.getItems().addAll(categoryList);
    	System.out.println("Reached here.");
    }
    
    @FXML
    public void initialize() {
    	loadData();
    }
    
    

    @FXML
    void onSubmit() {
    	try {
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    		Random rand = new Random();
    		RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
    		String toogleGroupValue = selectedRadioButton.getText();
    		int id = rand.nextInt(10000000);
    		String ewsVal = ews.isSelected() ? "True" : "False";
    		String disabledVal = disabled.isSelected() ? "True" : "False";
    		String sql = "insert into student values("+id + ",'" + fName.getText() + "','" + mName.getText() + "','" + lName.getText() + "','" + dob.getText() + "','" + email.getText() + "','" + category.getValue() + "','" + toogleGroupValue + "','" + ewsVal + "','" + disabledVal + "','" + mother_tounge.getText() + "','" + caste.getText() + "','" + religion.getText() + "','" + phone.getText() + "','" + aadhar.getText()+"')";
    		System.out.println(sql);
    		ResultSet rs = con.createStatement().executeQuery(sql);
    		if(rs.next()) {
    			result.setText("Saved");
    			FXMLLoader loader  = new FXMLLoader(getClass().getResource("NewParent.fxml"));
    			AnchorPane root = (AnchorPane)loader.load();
    			Scene scene = new Scene(root,400,400);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			Stage  stage = new Stage();
    			NewParentController controller = (NewParentController)loader.getController();
    			controller.setStudentId(id);
    			stage.setScene(scene);
    			stage.show();
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
