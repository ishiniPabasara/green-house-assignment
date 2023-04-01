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
public class Fruit extends Plant {

    private int volume;
    private double averageColor;
    private int pH;

    public Fruit(String plantName, int growingDuration, int croppingInterval, int lifeTime, int volume, double averageColor, int pH, ArrayList<Crop> crops) {
        super(plantName, growingDuration, croppingInterval, lifeTime, crops);
        this.setVolume(volume);
        this.setAverageColor(averageColor);
        this.setpH(pH);
    }

    public Fruit(String plantName, int growingDuration, int croppingInterval, int lifeTime, int volume, double averageColor, int pH) {
        super(plantName, growingDuration, croppingInterval, lifeTime);
        this.setVolume(volume);
        this.setAverageColor(averageColor);
        this.setpH(pH);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return volume +"mm^3";
    }

    public void setAverageColor(double averageColor) {
        if (averageColor >= 0 && averageColor <= 16777215) {
            this.averageColor = averageColor;
        } else {
            System.out.println("Average Color 0-16,777,215");
        }
    }

    public double getAverageColor() {
        return averageColor;
    }

    public void setpH(int pH) {
        if (pH >= 0 && pH < 14) {
            this.pH = pH;
        } else {
            System.out.println("pH should be 0-14");
        }
    }

    public int getpH() {
        return pH;
    }

    @Override
    public String toString() {
        return super.toString()+ "Volume=" + volume + ", Average Color=" + averageColor + ", pH=" + pH;
    }

}