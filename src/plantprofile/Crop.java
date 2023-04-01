/*
 Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

enum state{
    STANDARD,
    BELOW_STANDARD,
    ABOVE_STANDARD
}
/**
 *
 * @author user
 */
public class Crop {
    private int totalWeight;
    private PlantDate date;
    private state cropState;
    
    public Crop(PlantDate date,int totalWeight,state cropState){
      this.setDate(date);
      this.setTotalWeight(totalWeight);
      this.setCropState(cropState);
    }

    public PlantDate getDate() {
        return date;
    }

    public void setDate(PlantDate date) {
        this.date = date;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setCropState(state cropState) {
        this.cropState = cropState;
    }

    public state getCropState() {
        return cropState;
    }
    

    @Override
    public String toString() {
        return "totalWeight=" + totalWeight + ", date=" + date ;
    }
    
    
}
