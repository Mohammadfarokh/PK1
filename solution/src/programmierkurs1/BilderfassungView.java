package programmierkurs1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BilderfassungView extends Stage {

	private Bild bild;
	
	public BilderfassungView(Bild bild, Stage primaryStage) {
		this.initOwner(primaryStage);
		this.initModality(Modality.WINDOW_MODAL);
		this.bild = bild;
	}
	
	public void showView() {
		setTitle("Bilderfassung");
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		Label titel = new Label("Titel:");
		TextField tf_titel = new TextField();
		GridPane.setHgrow(tf_titel, Priority.ALWAYS);
		gp.addRow(0, titel, tf_titel);
		
		Label ort = new Label("Ort:");
		TextField tf_ort = new TextField();
		GridPane.setHgrow(tf_ort, Priority.ALWAYS);
		gp.addRow(1, ort, tf_ort);
		
		Label aufnahmejahr = new Label("Aufnahmejahr:");
		TextField tf_aufnahmejahr = new TextField();
		GridPane.setHgrow(tf_aufnahmejahr, Priority.ALWAYS);
		gp.addRow(2, aufnahmejahr, tf_aufnahmejahr);
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10); // Abschaende zwsichen den Elementen
		Button neu = new Button("Neu");
		Button abbrechen = new Button("Abbrechen");
		hb.getChildren().addAll(neu, abbrechen);

		root.setTop(gp);
		root.setBottom(hb);
		
		// immer
		Scene sc = new Scene(root, 400, 200);
		setScene(sc);
		showAndWait(); // Hauptfenster sperren, solange dieses Fenster offen ist.
	}
	
}
