package hellofx;

//Anthony Marquez

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.effect.ColorAdjust; 

public class BlueMarbleController {

	BlueMarble bigBlue = new BlueMarble();

    @FXML
    private ImageView earth;

    @FXML
    private DatePicker date;

    @FXML
    private Button showButton;

    @FXML
    private Text caption;
 
    @FXML
    private Text error;

    @FXML
    private CheckBox enhanceToggle;

    @FXML
    private CheckBox monoToggle;

    @FXML
    void clickMono(ActionEvent event) {
    	if (monoToggle.isSelected()) {
    		ColorAdjust colorAdjust = new ColorAdjust();
    		colorAdjust.setSaturation(-1);
    		earth.setEffect(colorAdjust);
    		
    	} 
    	else {
    		ColorAdjust colorAdjust = new ColorAdjust();
    		colorAdjust.setSaturation(0);
    		earth.setEffect(colorAdjust);
    	}
    }
    
    @FXML
    void enterDate(ActionEvent event) {
    }
  
    @FXML
    void clickEnhance(ActionEvent event) {
    	if (enhanceToggle.isSelected()) {
    		bigBlue.setEnhanced(true);
    	} 
    	else {
    		bigBlue.setEnhanced(false);    		
    	}
    }

    @FXML
    void clickShow(ActionEvent event) {
    	LocalDate today = LocalDate.now();
    	
		boolean isDateNull = false;
    	try {
    		if (date.getValue().isAfter(today)) {
            	throw new Exception("No future date allowed.");
			}
    		
    	} catch (Exception e) {   
    		if (e.getMessage() == "No future date allowed.") {
	    		System.out.println("No future date allowed.");
	           	error.setText("The date you selected is in the future.  Try again.");
    		}
	    	isDateNull = true;
    	}

	    if (!isDateNull) {
           	error.setText(null);
	    	String dateString = date.getValue().toString();
    		bigBlue.setDate(dateString);
    		Image image = new Image(bigBlue.getImage());
    		String captionWeb = bigBlue.getCaption();
    		earth.setImage(image);
    		caption.setText(captionWeb);  		
    	}
    }
}