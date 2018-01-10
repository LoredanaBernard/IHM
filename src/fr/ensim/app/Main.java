package fr.ensim.app;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//PENSER A SAUVEGARDER la scène sous scene builder ET/OU ACTUALISER la scène sous eclipse (F5)

public class Main extends Application {
	// Variables globales
	private static String titre_produit;
	private static String etat_produit;
	private static String prix_produit;
	private static String usure_produit;
	private static String prix_achat_produit;
	private static String prix_vente_min_produit;
	
	// Assesseurs
	public static void setTitre(String titre) {
		titre_produit=titre;
	}
	public static String getTitre() {
		return titre_produit;
	}
	public static void setPrix(String prix) {
		prix_produit=prix;
	}
	public static String getPrix() {
		return prix_produit;
	}
	public static void setEtat(String etat) {
		etat_produit=etat;
	}
	public static String getEtat() {
		return etat_produit;
	}
	public static void setUsure(String usure) {
		usure_produit=usure;
	}
	public static String getUsure() {
		return usure_produit;
	}
	public static void setPrixAchat(String prixAchat) {
		prix_achat_produit=prixAchat;
	}
	public static String getPrixAchat() {
		return prix_achat_produit;
	}
	public static void setPrixVenteMin(String prixMin) {
		prix_vente_min_produit=prixMin;
	}
	public static String getPrixVenteMin() {
		return prix_vente_min_produit;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scan.fxml"));

			Scene scene = new Scene(root);

			primaryStage.setTitle("Application de Dana");
//			primaryStage.setMinHeight(450);
//			primaryStage.setMinWidth(700);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
