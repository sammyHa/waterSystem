package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;


public class Controller {
    public Controller(){

    }


    @FXML
    TextField precipitation;

    @FXML
    TextField soilMoisture;

    @FXML
    TextField waterVolume;

    @FXML
    TextField areaOfGarden;

    @FXML
    TextArea resultBox;

    public TextField getPrecipitation() {
        return precipitation;
    }

    public TextField getSoilMoisture() {
        return soilMoisture;
    }

    public TextField getWaterVolume() {
        return waterVolume;
    }

    public TextField getAreaOfGarden() {
        return areaOfGarden;
    }

    public TextArea getResultBox() {
        return resultBox;
    }

    private Garden garden = new Garden();
    private Constants mTwilioMessage = new Constants();



    public void waterNow(){

        // this data is coming from a hardware
        garden.setForecast(Double.parseDouble(precipitation.getText()));
        garden.setMoisture(Double.parseDouble(soilMoisture.getText()));
        garden.setWaterVolume(Double.parseDouble(waterVolume.getText()));
        garden.setSoilVolume(Double.parseDouble(areaOfGarden.getText()) * 0.1666); // soil depth in inches

        if (garden.checkCondition()) {
            garden.watering(garden.getWaterVolume(), garden.getSoilVolume(), garden.getMoisture());

            if (garden.getWaterUsed() > garden.getWaterVolume()) {
                garden.setWaterUsed(garden.getWaterVolume());
                garden.setWaterVolume(0);
                mTwilioMessage.TwilioMessage();
                resultBox.setText("All water used. User intervention required.\n");
            } else {
                garden.setWaterVolume(garden.getWaterVolume() - garden.getWaterUsed());
            }

            DecimalFormat dc = new DecimalFormat("0.000");
            resultBox.appendText("Used " + dc.format(garden.getWaterUsed()) + " gallons of water to raise " +
                    "water moisture to "  + (garden.getOptimalWater() * garden.getAmtWater()) * 100 + "%.\n" );
        }else {

            resultBox.appendText("No water needed!\n");


        }



    }
}
