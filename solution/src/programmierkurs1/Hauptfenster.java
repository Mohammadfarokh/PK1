package programmierkurs1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hauptfenster");
		BorderPane root = new BorderPane();
		
		root.setTop(createMenuBar());
		
		BilderfassungView bev = new BilderfassungView(null, primaryStage);
		bev.showView();
		
		Scene sc = new Scene(root, 500, 500);
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
	public MenuBar createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem laden = new MenuItem("Laden");
		MenuItem speichern = new MenuItem("Speichern");
		MenuItem medienliste = new MenuItem("Medienliste in Datei");
		MenuItem beenden = new MenuItem("Beenden");
		datei.getItems().addAll(laden, speichern, new SeparatorMenuItem(), medienliste, new SeparatorMenuItem(), beenden);
		
		
		Menu medium = new Menu("Medium");
		MenuItem audioNeu = new MenuItem("Audio neu");
		MenuItem bildNeu = new MenuItem("Bild neu");
		medium.getItems().addAll(audioNeu, bildNeu);
		
		Menu anzeige = new Menu("Anzeige");
		MenuItem erscheinungsjahr = new MenuItem("Erscheinungsjahr");
		MenuItem neuesMedium = new MenuItem("Neuestes Medium");
		anzeige.getItems().addAll(erscheinungsjahr, neuesMedium);
		
		mb.getMenus().addAll(datei, medium, anzeige);
		return mb;
	}
	
	public static void main(String[] args) {
		launch();
	}

}
