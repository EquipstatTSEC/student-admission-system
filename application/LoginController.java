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
public class LoginController {

    @FXML
    private Label result;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtName;

    @FXML
    void onClick() {
    	try {
    		//Class.forName("oracle.jdbc.driver.OracleDriver"); // for server IP address instead of localhost 
    		//Database connection
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    		String name = txtName.getText();
    		
    		//result.setText(Integer.toString(id));
    		if(name.equals("admin@gmail.com"))
    		{
    			
    			String pass = txtPass.getText();
    			if(pass.equals("admin123"))
    			{
    				result.setText("Login Successful");
    				FXMLLoader loader  = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
    				AnchorPane root = (AnchorPane)loader.load();
    				Scene scene = new Scene(root,400,400);
    				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    				Stage  stage = new Stage();
    				stage.setScene(scene);
    				stage.show();
    			}
    			else {
    				result.setText("Invalid Password");
    			}
    		}
    		else {
    			result.setText("Invalid ID");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }

}
