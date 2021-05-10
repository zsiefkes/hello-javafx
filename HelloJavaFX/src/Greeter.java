// what i'm doing:
/*
 * create a bunch of different greetings
 * log the number of times each is pressed
 * present a pie chart or some other chart with live updates.
 * 
 * Success! Now to have the pie chart not take over the whole scene lol...
 * 
 * hmm ... shall we do it using a borderpane?
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// for pie chart code
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class Greeter extends Application {
	// set greeting text
	String greetingAText = "Hello"; 
	String greetingBText = "Wassup"; 
	String greetingCText = "Hey girl";
	// counters to log greeting usage
	private int greetingACount = 0;
	private int greetingBCount = 0;
	private int greetingCCount = 0;
	
	private BorderPane generateBorderPane(Stage stage) {
		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox(stage)); // combining the two above steps in one
//		addStackPane(hbox);         // Add stack to HBox in top region

		return border;
		
//		border.setCenter(addGridPane());
//		border.setRight(addFlowPane());
	}
	
	// from https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm#JFXLY102	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonGreetings = new Button("Greetings");
	    buttonGreetings.setPrefSize(100, 20);

	    Button buttonResults = new Button("Results");
	    buttonResults.setPrefSize(100, 20);
	    hbox.getChildren().addAll(buttonGreetings, buttonResults);

	    return hbox;
	}
	
	private VBox addVBox(Stage stage) {
		// text needs to be set as final. no new object will be instantiated in the variable text, will always refer to this object. the object can however change the value of its attributes. is that the same as immutable? 
		// this is necessary for the btn.setOnAction() block of code. eg. it would throw an error if text was now null.
		final Text text = new Text();
		text.setText("No one has been greeted");
		
		// set a few buttons with greetings
		Button btnA = new Button(); // import button from javafx, not java.awt (that's the older gui library)
		btnA.setText(greetingAText);
		Button btnB = new Button();		
		btnB.setText(greetingBText);
		Button btnC = new Button();		
		btnC.setText(greetingCText);
		
		btnA.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				greetingACount++;
				text.setText(greetingAText);
				displayGraph(stage);
			}
		});
		btnB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				greetingBCount++;
				text.setText(greetingBText);
				displayGraph(stage);
			}
		});
		btnC.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				greetingCCount++;
				text.setText(greetingCText);
				displayGraph(stage);
			}
		});
		
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//			// counter for number of times button has been pressed
//			int n=0;
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				n++; // increment counter
//				
//				text.setText("Hello! You have been greeted " + n + " times.");
//			}
//		});
//		
		VBox pane = new VBox();
		pane.getChildren().add(text);
		pane.getChildren().add(btnA);
		pane.getChildren().add(btnB);
		pane.getChildren().add(btnC);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		return pane;
	}
	
	// dispay/update graph based on count
	// note how I send a Stage as an argument! How cool am I 8)
	private void displayGraph(Stage stage) {
        Scene scene = new Scene(new Group());
//        stage.setTitle("Imported Fruits");
//        stage.setWidth(500);
//        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                new PieChart.Data(greetingAText, greetingACount),
                new PieChart.Data(greetingBText, greetingBCount),
                new PieChart.Data(greetingCText, greetingCCount)
            );
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Greeting usage");

        // not sure what the use of Group is here... 
//        ((Group) scene.getRoot()).getChildren().add(chart);
//        stage.setScene(scene);
        // maybe try just add um. a bloody uh. child to the stage? lol
        stage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Greeter");
		
		BorderPane border = generateBorderPane(primaryStage);
//		generateBorderPane(primaryStage);
//		showWindow(primaryStage);
		primaryStage.setScene(new Scene(border, 300, 250));
		primaryStage.show();
	}
	
//	private void showWindow(Stage primaryStage) {
//		primaryStage.setScene(new Scene(pane, 300, 250));
//		primaryStage.show();
//	}

	public static void main(String[] args) {
		launch(args); // don't need Application. to precede call to launch(args) since we're a subclass of the Application class so it's automatically there yuss
	}
}


