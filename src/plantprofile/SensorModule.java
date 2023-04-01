/*
Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

/**
 *
 * @author VS
 */
public class SensorModule implements SensorListener {

    @Override
    public void onValueUpdated(SensorTypes type, double value) {
        System.out.println("Sensor Name: " + type + ", Measure: " + value);
    }

    public Sensor createTemperatureSensor() {
        return new Sensor(SensorTypes.TEMPERATURE);
    }

    public Sensor createPhSensor() {
        return new Sensor(SensorTypes.PH);
    }

    public Sensor createHumditySensor() {
        return new Sensor(SensorTypes.TEMPERATURE);
    }
}
