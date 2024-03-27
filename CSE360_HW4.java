/* Creator: Nick Arredondo
 * Publish Date: March 27, 2024 */

package application;
	
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label; 
import javafx.scene.control.RadioButton; 
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CSE360_HW4 extends Application {
	public static void main(String[] args) {
        launch(args);
    }
    
	int newPatientNumber = 0;
    HBox mainPane = new HBox();
	VBox subVPane = new VBox(8), mainVPane = new VBox(20);
	GridPane mainGridPane = new GridPane(), subGridPane = new GridPane(); 
    
    public void start(Stage primaryStage) {
    	Button patientIntake = new Button(), ctScan = new Button(), patientView = new Button();
    	Label header = new Label("Welcome to Heart Health Imagine and Recording System");

    	header.setFont(new Font("Arial", 20));
    	
    	patientIntake.setText("Patient Intake");
    	patientIntake.setPrefSize(210, 60);
    	patientIntake.setFont(new Font("Arial", 16));
    	ctScan.setText("CT Scan Tech View");
    	ctScan.setPrefSize(210, 60);
    	ctScan.setFont(new Font("Arial", 16));
    	patientView.setText("Patient View");
    	patientView.setPrefSize(210, 60);
    	patientView.setFont(new Font("Arial", 16));
    	
    	subVPane.setAlignment(Pos.CENTER);
    	subVPane.getChildren().add(patientIntake);
    	subVPane.getChildren().add(ctScan);
    	subVPane.getChildren().add(patientView);
    	
    	mainVPane.setAlignment(Pos.CENTER);
    	mainVPane.getChildren().add(header);
    	mainVPane.getChildren().add(subVPane);
    	
    	mainPane.setAlignment(Pos.CENTER);
    	mainPane.getChildren().add(mainVPane);
    	
    	patientIntake.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			mainPane.getChildren().clear();
    			mainVPane.getChildren().clear();
    			subVPane.getChildren().clear();
    			
    			receptionistView();
    		}
    	});
    	
    	ctScan.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			mainPane.getChildren().clear();
    			mainVPane.getChildren().clear();
    			subVPane.getChildren().clear();
    			
    			ctTechView();
    		}
    	});
    	
    	patientView.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			mainPane.getChildren().clear();
    			mainVPane.getChildren().clear();
    			subVPane.getChildren().clear();
    			
    			patientView();
    		}
    	});
    	
    	primaryStage.setTitle("Heart Health Imaging and Recording System");
    	primaryStage.setScene(new Scene(mainPane, 880, 495));
    	primaryStage.show();    	
    }
    
    private void receptionistView() {
    	Button save = new Button(); 
    	Label header = new Label("Patient Intake Form"),
    		  firstName = new Label("First name:"),
    		  lastName = new Label("Last Name:"),
    		  email = new Label("Email:"),
    		  phoneNumber = new Label("Phone Number:"),
    		  healthHistory = new Label("Health History:"),
    		  insuranceID = new Label("Insurance ID:");
    	TextArea firstNameText = new TextArea(),
      		  	 lastNameText = new TextArea(),
      		  	 emailText = new TextArea(),
      		  	 phoneNumberText = new TextArea(),
      		  	 healthHistoryText = new TextArea(),
      		  	 insuranceIDText = new TextArea();
    	
    	save.setText("Save");
    	save.setPrefSize(160, 50);
    	save.setFont(new Font("Arial", 14));
    	
    	header.setFont(new Font("Arial", 20));
    	
    	firstNameText.setPrefSize(400, 15);
    	lastNameText.setPrefSize(400, 15);
    	emailText.setPrefSize(400, 15);
    	phoneNumberText.setPrefSize(400, 15);
    	healthHistoryText.setPrefSize(400, 15);
    	insuranceIDText.setPrefSize(400, 15);
    	
    	mainGridPane.setHgap(40); 
    	mainGridPane.setVgap(20);
    	mainGridPane.setPadding(new Insets(10, 10, 10, 10));
    	
    	mainGridPane.add(header, 1, 0);
    	mainGridPane.add(firstName, 0, 1);
    	mainGridPane.add(lastName, 0, 2);
    	mainGridPane.add(email, 0, 3);
    	mainGridPane.add(phoneNumber, 0, 4);
    	mainGridPane.add(healthHistory, 0, 5);
    	mainGridPane.add(insuranceID, 0, 6);
    	
    	mainGridPane.add(firstNameText, 1, 1);
    	mainGridPane.add(lastNameText, 1, 2);
    	mainGridPane.add(emailText, 1, 3);
    	mainGridPane.add(phoneNumberText, 1, 4);
    	mainGridPane.add(healthHistoryText, 1, 5);
    	mainGridPane.add(insuranceIDText, 1, 6);
    	
    	mainGridPane.add(save, 2, 7);
    	
    	mainPane.getChildren().add(mainGridPane);
    	mainPane.setAlignment(Pos.CENTER_LEFT);
    	
    	save.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			
    		}
    	});
    }
    
    private void ctTechView() {
    	Button save = new Button(); 
    	Label patientID = new Label("Patient ID:"),
      		  totalAgt = new Label("The total Agaston CAC score"),
      		  vesselAgt = new Label("Vessel level Agatston CAC score"),
      		  lm = new Label("LM:"),
      		  lad = new Label("LAD:"),
      		  lcx = new Label("LCX:"),
      		  rca = new Label("RCA:"),
      		  pda = new Label("PDA:");
    	TextArea patientIDText = new TextArea(),
     		  	 totalAgtText = new TextArea(),
     		  	 lmText = new TextArea(),
     		  	 ladText = new TextArea(),
     		  	 lcxText = new TextArea(),
     		  	 rcaText = new TextArea(),
     		  	 pdaText = new TextArea();

    	save.setText("Save");
    	save.setPrefSize(160, 50);
    	save.setFont(new Font("Arial", 14));
    	
    	lmText.setPrefSize(100, 10);
    	ladText.setPrefSize(100, 10);
    	lcxText.setPrefSize(100, 10);
    	rcaText.setPrefSize(100, 10);
    	pdaText.setPrefSize(100, 10);
    	
    	patientIDText.setPrefSize(200, 10);
    	totalAgtText.setPrefSize(200, 10);
    	
    	subGridPane.setHgap(40);
    	subGridPane.setVgap(10);
    	subGridPane.setPadding(new Insets(10, 10, 20, 20));
    	
    	subGridPane.add(lm, 0, 0);
    	subGridPane.add(lad, 0, 1);
    	subGridPane.add(lcx, 0, 2);
    	subGridPane.add(rca, 0, 3);
    	subGridPane.add(pda, 0, 4);

    	subGridPane.add(lmText, 1, 0);
    	subGridPane.add(ladText, 1, 1);
    	subGridPane.add(lcxText, 1, 2);
    	subGridPane.add(rcaText, 1, 3);
    	subGridPane.add(pdaText, 1, 4);
    	
    	mainGridPane.setHgap(40); 
    	mainGridPane.setVgap(20);
    	mainGridPane.setPadding(new Insets(10, 10, 10, 10));
    	
    	mainGridPane.add(patientID, 0, 0);
    	mainGridPane.add(totalAgt, 0, 1);
    	mainGridPane.add(vesselAgt, 0, 2);
    	mainGridPane.add(subGridPane, 0, 3);

    	mainGridPane.add(patientIDText, 1, 0);
    	mainGridPane.add(totalAgtText, 1, 1);
    	mainGridPane.add(save, 2, 4);
    	
    	mainPane.getChildren().add(mainGridPane);
    	mainPane.setAlignment(Pos.CENTER_LEFT);
    	
    	save.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			
    		}
    	});
    }
    
    private void patientLogin() {
    	Button login = new Button(); 
    	
    	login.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			patientView();
    		}
    	});
    }
    
    private void patientView() {
    	String patientName = ""; 
    	Button done = new Button();
    	Label welcome = new Label("Welcome" + patientName),
    		  totalAgt = new Label("The total Agaston CAC score"),
    		  lm = new Label("LM:"),
    		  lad = new Label("LAD:"),
    		  lcx = new Label("LCX:"),
    		  rca = new Label("RCA:"),
    		  pda = new Label("PDA:");
      	TextArea totalAgtText = new TextArea(),
       		  	 lmText = new TextArea(),
       		  	 ladText = new TextArea(),
       		  	 lcxText = new TextArea(),
       		  	 rcaText = new TextArea(),
       		  	 pdaText = new TextArea();

      	done.setText("Done");
      	done.setPrefSize(160, 50);
      	done.setFont(new Font("Arial", 14));
      	
      	lmText.setPrefSize(100, 10);
      	ladText.setPrefSize(100, 10);
      	lcxText.setPrefSize(100, 10);
      	rcaText.setPrefSize(100, 10);
      	pdaText.setPrefSize(100, 10);
      	
      	totalAgtText.setPrefSize(200, 10);
      	
      	subGridPane.setHgap(40);
      	subGridPane.setVgap(10);
      	subGridPane.setPadding(new Insets(10, 10, 20, 20));
      	
      	subGridPane.add(lm, 0, 0);
      	subGridPane.add(lad, 0, 1);
      	subGridPane.add(lcx, 0, 2);
      	subGridPane.add(rca, 0, 3);
      	subGridPane.add(pda, 0, 4);

      	subGridPane.add(lmText, 1, 0);
      	subGridPane.add(ladText, 1, 1);
      	subGridPane.add(lcxText, 1, 2);
      	subGridPane.add(rcaText, 1, 3);
      	subGridPane.add(pdaText, 1, 4);
      	
      	mainGridPane.setHgap(40); 
      	mainGridPane.setVgap(20);
      	mainGridPane.setPadding(new Insets(10, 10, 10, 10));
      	
      	mainGridPane.add(totalAgt, 0, 1);
      	mainGridPane.add(subGridPane, 0, 2);

      	mainGridPane.add(welcome, 1, 0);
      	mainGridPane.add(totalAgtText, 1, 1);
      	mainGridPane.add(done, 2, 3);
      	
      	mainPane.getChildren().add(mainGridPane);
      	mainPane.setAlignment(Pos.CENTER_LEFT);
      	
      	done.setOnAction(new EventHandler<>() {
    		public void handle(ActionEvent event) {
    			
    		}
    	});
    }
}
