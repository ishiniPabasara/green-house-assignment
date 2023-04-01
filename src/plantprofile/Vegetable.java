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
public class Vegetable extends Plant{
    private int areaPerLeaf;
    private int thickness;
    
    public Vegetable(String plantName,int growingDuration,int croppingInterval,int lifeTime,int areaPerLeaf,int thickness,ArrayList<Crop> crops){
        super(plantName,growingDuration,croppingInterval,lifeTime,crops);
        this.setAreaPerLeaf(areaPerLeaf);
        this.setThickness(thickness);
    }
        public Vegetable(String plantName,int growingDuration,int croppingInterval,int lifeTime,int areaPerLeaf,int thickness){
        super(plantName,growingDuration,croppingInterval,lifeTime);
        this.setAreaPerLeaf(areaPerLeaf);
        this.setThickness(thickness);
    }

    public void setAreaPerLeaf(int areaPerLeaf) {
        this.areaPerLeaf = areaPerLeaf;
    }

    public String getAreaPerLeaf() {
        return areaPerLeaf + " mm^2";
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public String getThickness() {
        return thickness + "um";
    }

    @Override
    public String toString() {
        return super.toString() + "Area Per Leaf=" + areaPerLeaf + ", Thickness=" + thickness ;
    }
    
}
