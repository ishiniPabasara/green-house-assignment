/*
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
public class Batch {
    private int batchNo;
    ArrayList<Plant> plant=new ArrayList<Plant>();
    private PlantDate dateOfPlanted;
    private PlantDate endDateOfBatch;
    
    public Batch(int batchNo,ArrayList<Plant> plant,PlantDate dateOfPlanted,PlantDate endDateOfBatch){
        
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setPlant(ArrayList<Plant> plant) {
        this.plant=plant;
    }

    public ArrayList<Plant> getPlant() {
        return plant;
    }

    public void setDateOfPlanted(PlantDate dateOfPlanted) {
        this.dateOfPlanted = dateOfPlanted;
    }

    public PlantDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public void setEndDateOfBatch(PlantDate endDateOfBatch) {
        this.endDateOfBatch = endDateOfBatch;
    }

    public PlantDate getEndDateOfBatch() {
        return endDateOfBatch;
    }
    
}
