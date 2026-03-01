package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 768, 768);
			Image icon = new Image("/icon.png");
			Pane layout1 = new Pane();
			Controller controller = loader.getController();
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
				@Override
				public void handle(KeyEvent event) {
					System.out.println(event.getCode());
					switch (event.getCode()) {
					case W:
						//controller.increaseDetail();
						System.out.println("W");
						
						break;
					case D:
						controller.increaseScale();
						System.out.println("D");
						
						break;
					case A:
						controller.decreaseScale();
						System.out.println("A");
						break;
					case S:
						//controller.decreaseDetail();
						System.out.println("S");
						break;
					case NUMPAD8:
						controller.moveUp();
						break;
						
					default:
						break;
					}
					
				}
				
			});
			
			//scene.getStylesheets().add(getClass().getResource("application.css"))
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icon);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	

		
	public static void main(String[] args) {
		launch(args);
	}
}
