package fr.ensim.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScanController implements Initializable {

	private double width;
	private double height;
	private int fontSize = 10;
	
	@FXML
	private ImageView img_scan;
	@FXML
	private TextField text_code_barre;
	@FXML
	private Button btn_valider;
	@FXML
	private Pane pane_scan;
	
	private Image img_s;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		img_s = new Image("/img/barre.png");
		img_scan.setImage(img_s);
		fontSizeModification(btn_valider);
	}
	
	@FXML
	public void valider_code_on_action(ActionEvent event) throws IOException {
		
			Stage stage;
			Button b = (Button) event.getSource();
			stage = (Stage) b.getScene().getWindow();
			Parent newView;
			double h = stage.getHeight();
			double w = stage.getWidth();
			newView = FXMLLoader.load(getClass().getResource("/fxml/Ajout.fxml"));
			Scene scene = new Scene(newView);
			stage.setScene(scene);
			stage.setHeight(h);
			stage.setWidth(w);
		
	}
	

public void fontSizeModification(final Button button) {
		
		pane_scan.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				
				button.setPrefWidth( (double)(newSceneWidth)/10);
				System.out.println("Width: " + button.getWidth());
				
				
				
				setFontSize((int) ((getWidth() * getHeight()) / 1000));
				// System.out.println("Font Size : " + getFontSize());
				button.styleProperty().bind(Bindings.concat("-fx-font-size: ", getFontSizeString(), ";"));
			}
		});

		pane_scan.heightProperty().addListener(new ChangeListener<Number>() {
		@Override
		public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight,
				Number newSceneHeight) {
			
			button.setPrefHeight( (double)(newSceneHeight)/10);
			
			setFontSize((int) ((getWidth() * getHeight()) / 1000));
			// System.out.println("Font Size : " + getFontSize());
			button.styleProperty().bind(Bindings.concat("-fx-font-size: ", getFontSizeString(), ";"));
		}
	});
	}

	public int getFontSize() {
		return fontSize;
	}

	public String getFontSizeString() {
		return fontSize + "px";
	}

	public void setFontSize(int fontSize) {
		if (fontSize > 10) {
			this.fontSize = fontSize;
		} else {
			this.fontSize = 10;
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double size) {
		this.width = size;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double size) {
		this.height = size;
	}
	
	
	
}


