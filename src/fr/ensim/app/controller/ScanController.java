package fr.ensim.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ScanController implements Initializable {

	@FXML
	private ImageView img_scan;
	@FXML
	private TextField text_code_barre;
	@FXML
	private Button btn_valider;
	
	private Image img_s;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		img_s = new Image("/img/barre.png");
		img_scan.setImage(img_s);
	}
	
	@FXML
	public void valider_code_on_action(ActionEvent event) throws IOException {
		
			Stage stage;
			Button b = (Button) event.getSource();
			stage = (Stage) b.getScene().getWindow();
			Parent newView;
			double h = stage.getHeight();
			double w = stage.getWidth();
			newView = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
			Scene scene = new Scene(newView);
			stage.setScene(scene);
			stage.setHeight(h);
			stage.setWidth(w);
		
	}

	

}
