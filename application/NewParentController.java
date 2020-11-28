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

public class NewParentController {
	
	ObservableList<String> occupationList = FXCollections.observableArrayList();

    @FXML
    private TextField fmName;

    @FXML
    private TextField fphone;

    @FXML
    private Button submit;

    @FXML
    private TextField mfName;

    @FXML
    private TextField femail;

    @FXML
    private TextField mincome;

    @FXML
    private TextField fincome;

    @FXML
    private TextField memail;

    @FXML
    private TextField mmName;

    @FXML
    private Label result;

    @FXML
    private TextField moccupation;

    @FXML
    private ChoiceBox<String> mtype;

    @FXML
    private ChoiceBox<String> ftype;

    @FXML
    private TextField flName;

    @FXML
    private TextField foccupation;

    @FXML
    private TextField mphone;

    @FXML
    private TextField ffName;

    @FXML
    private TextField mlName;
    
    @FXML
    private Label error;

    
    public void setStudentId(int id)
    {
    	result.setText(String.valueOf(id));
    }
    
    
    private void loadData()
    {
    	result.setText("4198782");
    	occupationList.removeAll(occupationList);
    	String A = "Business";
    	String B = "Job";
    	String C = "Home Maker";
    	String D = "Freelancer";
    	String E = "Others";
    	
    	occupationList.addAll(A, B , C, D, E);
    	mtype.getItems().addAll(occupationList);
    	ftype.getItems().addAll(occupationList);
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
            int mid = rand.nextInt(10000000);
            int fid = rand.nextInt(10000000);
    		
            if(mfName.getText()== null ||mfName.getText().length()==0) {
            	error.setText("First Name should not be empty");
            	return;
            }
            if(!memail.getText().contains("@") ||!memail.getText().contains(".") ) {
            	error.setText("Invalid email");
            	return;
            }
            
    		String sql1 = "insert into parent values("+mid + ",'mother','" + mfName.getText() + "','" + mmName.getText() + "','" + mlName.getText() + "','"+ memail.getText() + "','" + mtype.getValue() + "','" + moccupation.getText() + "','"  +mincome.getText() + "','"   + mphone.getText()+"')";
    		ResultSet rs1 = con.createStatement().executeQuery(sql1);
    		if(rs1.next()) {


                String sql2 = "insert into parent values("+fid + ",'father','" + ffName.getText() + "','" + fmName.getText() + "','" + flName.getText() + "','"+ femail.getText() + "','" + ftype.getValue() + "','" + foccupation.getText() + "','"  +fincome.getText() + "','"   + fphone.getText()+"')";
                ResultSet rs2 = con.createStatement().executeQuery(sql2);
                if(rs2.next()) {
                   String sql3 = "insert into student_parents values(" + Integer.parseInt(result.getText()) + ", " + mid + ")";
                   ResultSet rs3 = con.createStatement().executeQuery(sql3);
                   if(rs3.next())
                   {
                        String sql4 = "insert into student_parents values(" + Integer.parseInt(result.getText()) + ", " + fid + ")";
                        ResultSet rs4 = con.createStatement().executeQuery(sql4);
                        if(rs4.next())
                        {
                            error.setText("Saved");
                            FXMLLoader loader  = new FXMLLoader(getClass().getResource("NewAcademic.fxml"));
                            AnchorPane root = (AnchorPane)loader.load();
                            Scene scene = new Scene(root,400,400);
                            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                            Stage  stage = new Stage();
                            NewAcademicController controller = (NewAcademicController)loader.getController();
                            controller.setStudentId(Integer.parseInt(result.getText()));   
                            stage.setScene(scene);
                            stage.show();
                        }   
                   }
                }
            }
            

    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

    }

}
