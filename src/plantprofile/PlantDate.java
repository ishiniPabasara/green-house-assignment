/*
    Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

/**
 *
 * @author user
 */

public class PlantDate {
    private final int CURRENT_YEAR = 2021;
    private int day;
    private int month;
    private int year;
    
    public PlantDate(int day,int month,int year){
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public void setDay(int day) {
        if(day>0 && day<=30){
        this.day = day;
        }else{
            System.out.println("Days should be 1-30");
        }
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        if(month>0 && month<=12){
        this.month = month;
        
        } else {
            System.out.println("Month should be 1-12");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if(year>0 && year<=CURRENT_YEAR){
        this.year = year;
        }else{
            System.out.println("Year should be less than"+CURRENT_YEAR+1);
        }
    }

    public int getYear() {
        return year;
    }
    public int calculateDateDuration(PlantDate date){
        //Assuming months and years are equal
        if(this.day>date.getDay()){
            return this.day-date.getDay();
        }else{
            return date.getDay()-this.day;
        }
    }
    
    public String getDateString() {
        return this.getDay()+"/"+this.getMonth()+"/"+this.getYear();
    }
    
}