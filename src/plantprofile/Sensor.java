/*
 Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

import java.util.*;
/**
 *
 * @author VS
 */

interface SensorListener{
 public void onValueUpdated(SensorTypes type, double value);
}

enum SensorTypes
{
 TEMPERATURE, PH, HUMIDITY;
}


class Sensor extends Thread {

    private SensorTypes type;
    private Random rnd;
    private SensorListener listener;

    public void setSensorListener(SensorListener listener) {
        this.listener = listener;
    }

    public void setType(SensorTypes type) {
        this.type = type;
    }

    public SensorTypes getType() {
        return this.type;
    }

    public Sensor(SensorTypes type) {
        this.type = type;
        rnd = new Random();
    }

    public void startSensor() {
        start();
    }

    public void run() {
        while (true) {
            try {
                if (listener != null) {
                    listener.onValueUpdated(type, rnd.nextDouble());
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
        }
    }
}
