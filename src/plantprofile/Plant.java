/*
 Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Plant {

    private String plantName;
    private int growingDuration;
    private int croppingInterval;
    private int lifeTime;
    private ArrayList<Crop> crops;

    public Plant(String plantName, int growingDuration, int croppingInterval, int lifeTime, ArrayList<Crop> crops) {
        this.setPlantName(plantName);
        this.setGrowingDuration(growingDuration);
        this.setCroppingInterval(croppingInterval);
        this.setLifeTime(lifeTime);
        this.setCrops(crops);
    }

    public Plant(String plantName, int growingDuration, int croppingInterval, int lifeTime) {
        this.setPlantName(plantName);
        this.setGrowingDuration(growingDuration);
        this.setCroppingInterval(croppingInterval);
        this.setLifeTime(lifeTime);

    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName() {
        return this.plantName;
    }

    public void setGrowingDuration(int growingDuration) {
        this.growingDuration = growingDuration;
    }

    public int getGrowingDuration() {
        return growingDuration;
    }

    public void setCroppingInterval(int croppingInterval) {
        // Assuming that cropping interval 1 or more than 1
        if (croppingInterval > 0) {
            this.croppingInterval = croppingInterval;
        } else {
            this.croppingInterval = 1;
        }
    }

    public int getCroppingInterval() {
        return croppingInterval;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public ArrayList<Crop> getCrop() {
        return crops;
    }

    public boolean checkCropSize() {
        // returns true when maximum crops are reached
        if (this.crops.size() > 0) {
            int noOfCrops = (this.getLifeTime() - this.getGrowingDuration()) / this.getCroppingInterval();
            return noOfCrops > this.crops.size();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Plant Name=" + this.getPlantName() + ", Growing Duration=" + this.getGrowingDuration() + ", Cropping Interval=" + this.getCroppingInterval() + ", life Time=" + this.getLifeTime() + "Maximum crops are reached" + this.checkCropSize() ;
    }

}
