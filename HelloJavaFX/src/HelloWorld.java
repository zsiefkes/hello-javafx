import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a scene for the window with the text inside it
    	Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")));
        
    	//Set title of the window
        primaryStage.setTitle("Wassup mofo");
         
        //Add scene to the window (underneath the window bar)
        primaryStage.setScene(scene);
         
        //Change size of window to fit text
//        primaryStage.sizeToScene();
        
        // Set default size
        primaryStage.setWidth(200);
        primaryStage.setHeight(150);
        
        //Show the window
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}