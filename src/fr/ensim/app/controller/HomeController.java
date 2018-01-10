package fr.ensim.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.ensim.app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController implements Initializable {

	//Declaration des objets de ta scene
	//La liste est d�clar�e sous scene builder gr�ce aux fx_id
	//Voir Document/Controller sous scene builder

	@FXML
	private ImageView img_concurrence1;
	@FXML
	private ImageView img_concurrence2;
	@FXML
	private ImageView img_concurrence3;
	@FXML
	private ImageView img_concurrence4;
	@FXML
	private ImageView img_haut_gauche;
	@FXML
	private ComboBox<String> combo_box_etat;
	@FXML
	private TextField text_prix_achat;
	@FXML
	private TextField text_prix_concurrence1;
	@FXML
	private TextField text_prix_concurrence2;
	@FXML
	private TextField text_prix_concurrence3;
	@FXML
	private TextField text_prix_concurrence4;
	@FXML
	private TextField text_prix_vente;
	@FXML
	private TextField text_prix_mini;
	@FXML
	private TextField text_quantite;
	@FXML
	private TextField text_titre;
	
	@FXML
	private Button btn_home;
	@FXML
	private ToggleButton button_en_vente;
	@FXML
	private TextArea text_description;

	private Image img_h_g,img_c1,img_c2,img_c3,img_c4;


	//Fonction initialize : Est ex�cut�e d�s l'ouverture de la sc�ne
	//Permet d'initaliser les divers �l�ments

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	

		//Ajout des �l�ments de la combo box
		combo_box_etat.getItems().addAll("Neuf","Comme Neuf","Tr�s Bon","Bon","Moyen");

		//Ajout image dans image view (FORMAT JPG fonctionne, pas test� pour png)
		img_h_g = new Image("/img/pcmsi.jpg");
		img_c1 = new Image("/img/meilleurpc.jpg");
		img_c2 = new Image("/img/amazon.jpg");
		img_c3 = new Image("/img/boostmyshop.png");
		img_c4 = new Image("/img/priceminister.jpg");

		img_concurrence1.setImage(img_c1);
		img_concurrence2.setImage(img_c2);
		img_concurrence3.setImage(img_c3);
		img_concurrence4.setImage(img_c4);
		img_haut_gauche.setImage(img_h_g);



	}

	//Fonction �v�nement sur un objet de la sc�ne, en l'occurence "en_vente_on_action", soit une action sur le bouton "en_vente"
	//La fonction se d�clare sous scene builder
	//Clique sur le bouton "en_vente" sous scene builder
	//Va dans le volet "Code"
	//Tu d�clares tes fonctions sur objet en mettant un nom de ton choix
	@FXML
	public void en_vente_on_action(ActionEvent event) {
		if (button_en_vente.isSelected()==true){
			//System.out.println("Boutton En Vente S�lectionn�");
			Main.setEtat("En vente");
		}
		else {
			//System.out.println("Boutton En Vente Non S�lectionn�");
			Main.setEtat("En attente");
		}
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

	@FXML
	public void button_validate_on_action(ActionEvent event) throws IOException {

		if(combo_box_etat.getValue()==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Etat de l'objet non choisi !");
			alert.setHeaderText(null);
			alert.setContentText("Vous devez choisir l'�tat de l'objet � vendre.");
			alert.showAndWait();
		}
		else {
			//Code Exemple, A toi de jouer :)
			System.out.println("Objet Ajout� !");
			System.out.println("Nom : " + text_titre.getText());
			Main.setTitre(text_titre.getText());
			
			System.out.println("Prix d'achat : " + text_prix_achat.getText());
			Main.setPrixAchat(text_prix_achat.getText());
			
			System.out.println("Prix de vente : " + text_prix_vente.getText());
			Main.setPrix(text_prix_vente.getText());
			
			System.out.println("Prix minimal : " + text_prix_mini.getText());
			Main.setPrixVenteMin(text_prix_mini.getText());
			
			System.out.println("�tat : " + combo_box_etat.getValue());
			Main.setUsure(combo_box_etat.getValue());
			
			System.out.println("Quantit� : "+ text_quantite.getText());
			System.out.println("Description : "+ text_description.getText());
			
			Stage stage;
			Button btn_valid = (Button) event.getSource();
			stage = (Stage) btn_valid.getScene().getWindow();
			Parent newView;
			double h = stage.getHeight();
			double w = stage.getWidth();
			newView = FXMLLoader.load(getClass().getResource("/fxml/Recap.fxml"));
			Scene scene = new Scene(newView);
			stage.setScene(scene);
			stage.setHeight(h);
			stage.setWidth(w);
		}


	}



}
