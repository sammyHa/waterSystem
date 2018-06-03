package sample;


public class Garden{
    private double moisture;
    private double forecast;
    private double waterVolume;
    private double soilVolume;
    private double waterUsed;
    private final double TANKCAP = 100;
    private double optimalWater ;
    double amtWater;



    public Garden(){


    }

    public Garden(double moisture, double forecast, double waterVolume, double soilVolume) {
        this.moisture = moisture;
        this.forecast = forecast;
        this.waterVolume = waterVolume;
        this.soilVolume = soilVolume;
    }

    //check for the moisture and weather condition to start irrigation
    public  boolean checkCondition(){
        if (moisture < 40){ // moisture of the soil less than 40% and
            return forecast < 60;
        }
        return false; // otherwise no
    }

    private double waterCal(double waterVolume){

        double currentVol = (waterVolume / TANKCAP) * 100;

        if (currentVol >=60){
            //System.out.println("water normally ");
            return 1.0;
        } else if(currentVol < 60 && currentVol >= 50){
            //System.out.println("water at 90%");
            return 0.8;
        }else  if(currentVol < 50 && currentVol >= 40){
            //System.out.println("water at 65%");
            return 0.65;
        }else if ( currentVol < 40 && currentVol >= 30){
            //System.out.println("water at 40%");
            return 0.40;
        }else {
            //System.out.println("water at 25%");
            return 0.25;
        }

    }

    public void watering(double waterVolume, double soilVolume, double moisture){

        optimalWater = 0.60; // moisture to 60%
        amtWater = waterCal(waterVolume);

        waterUsed = soilVolume * (optimalWater - (moisture/100)) * amtWater;
        waterUsed *= 7.48; // convert the cubic ft to gallons
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getForecast() {
        return forecast;
    }

    public void setForecast(double forecast) {
        this.forecast = forecast;
    }

    public double getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(double waterVolume) {
        this.waterVolume = waterVolume;
    }

    public double getSoilVolume() {
        return soilVolume;
    }

    public void setSoilVolume(double soilVolume) {
        this.soilVolume = soilVolume;
    }

    public double getWaterUsed() {
        return waterUsed;
    }

    public void setWaterUsed(double waterUsed) {
        this.waterUsed = waterUsed;
    }

    public double getOptimalWater() {
        return optimalWater;
    }

    public double getAmtWater() {
        return amtWater;
    }
}
