import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Hello extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Greeter");
		
		// text needs to be set as final. no new object will be instantiated in the variable text, will always refer to this object. the object can however change the value of its attributes. is that the same as immutable? 
		// this is necessary for the btn.setOnAction() block of code. eg. it would throw an error if text was now null.
		final Text text = new Text();
		text.setText("No one has been greeted");
		
		Button btn = new Button(); // import button from javafx, not java.awt (that's the older gui library)
		btn.setText("Greet yourself");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			// counter for number of times button has been pressed
			int n=0;
			
			@Override
			public void handle(ActionEvent arg0) {
				n++; // increment counter
				
				text.setText("Hello! You have been greeted " + n + " times.");
			}
		});
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.getChildren().add(text);
		pane.getChildren().add(btn);
		
		primaryStage.setScene(new Scene(pane, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
//		Application.launch(args);
		launch(args); 
	}
}

