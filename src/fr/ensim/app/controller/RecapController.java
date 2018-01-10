package fr.ensim.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.ensim.app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RecapController implements Initializable{
	
	@FXML
	private ImageView img_produit;
	@FXML
	private TextField text_titre;
	@FXML 
	private Text text_en_vente;
	@FXML 
	private Text text_prix;
	@FXML 
	private Text text_usure;
	@FXML 
	private Text text_marge;
	@FXML 
	private Button btn_home;
	
	private Image img_p;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		img_p = new Image("/img/pcmsi.jpg");
		img_produit.setImage(img_p);
		
		text_titre.setText(Main.getTitre());
		text_prix.setText(Main.getPrix()+" €");
		text_usure.setText(Main.getUsure());
		text_en_vente.setText(Main.getEtat());
		int a=0;
		try {
		      a = Integer.parseInt(Main.getPrixAchat());
		} catch (NumberFormatException e) {
			
		}
		
		int v=0;
		try {
		      v = Integer.parseInt(Main.getPrixVenteMin());
		} catch (NumberFormatException e2) {
		}

		text_marge.setText("Marge minimale : " +(v-a) + " €");
		
	}
	
	@FXML
	public void button_home_on_action(ActionEvent event) throws IOException {
		// Retour page d'accueil

		Stage stage;
		Button btn_home = (Button) event.getSource();
		stage = (Stage) btn_home.getScene().getWindow();
		Parent newView;
		double h = stage.getHeight();
		double w = stage.getWidth();
		newView = FXMLLoader.load(getClass().getResource("/fxml/Scan.fxml"));
		Scene scene = new Scene(newView);
		stage.setScene(scene);
		stage.setHeight(h);
		stage.setWidth(w);
	}

}
