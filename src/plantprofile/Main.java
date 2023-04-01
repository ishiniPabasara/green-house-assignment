/*
Index number: AS2019473
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantprofile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    static ArrayList<Batch> batchList = new ArrayList<Batch>();
    static ArrayList<Plant> plantsList = new ArrayList<Plant>();
    static ArrayList<Crop> cropArray = new ArrayList<Crop>();
    static Scanner scan = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    public static void main(String[] args) {
        menuAction();
    }

    public static void menuAction() {

        int input = 0;
        do {
            printMenu();
            input = scan.nextInt();
            checkInput(input);

        } while (input != 0);

    }

    public static void printMenu() {
        System.out.println("1. Add a batch\n2. View a plant details\n3. Print sensors values\n0. Exit");
        System.out.println("Enter option number: ");

    }

    public static void checkInput(int input) {
        switch (input) {
            case 0:

                break;
            case 1:
                createBatch();
                break;
            case 2:
                viewPlantDetails();
                break;
            case 3:
                getSensorType();
                break;
            default:
                System.out.println("Invalid input: " + input + " Please enter again valid input");
        }
    }

    public static void getSensorType() {
        System.out.println("1. Temperature Sensor");
        System.out.println("2. PH Sensor");
        System.out.println("3. Humidity Sensor");
        boolean retry = false;
        int choice = 0;
        do {
            System.out.println("Please enter option value");
            choice = scan.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                retry = false;
            } else {
                System.out.println("Entered option is incorrect.Please enter again");
                retry = true;
            }
        } while (retry);
        if (choice == 1) {
            getSensorsValues(SensorTypes.TEMPERATURE);
        } else if (choice == 2) {
            getSensorsValues(SensorTypes.PH);

        } else if (choice == 3) {
            getSensorsValues(SensorTypes.HUMIDITY);
        }
    }

    public static void createBatch() {
        System.out.println("Creating a batch");

        System.out.println("Enter year of planted the batch of plants: ");
        int yearPlanted = scan.nextInt();
        System.out.println("Enter month of planted the batch of plants: ");
        int monthPlanted = scan.nextInt();
        System.out.println("Enter day of planted the batch of plants: ");
        int dayPlanted = scan.nextInt();

        PlantDate dateOfPlanted = new PlantDate(dayPlanted, monthPlanted, yearPlanted);

        System.out.println("Enter year of end of the batch of plants: ");
        int yearEnd = scan.nextInt();
        System.out.println("Enter month of nd of the batch of plants: ");
        int monthEnd = scan.nextInt();
        System.out.println("Enter day of nd of the batch of plants: ");
        int dayEnd = scan.nextInt();

        PlantDate endDateOfBatch = new PlantDate(dayEnd, monthEnd, yearEnd);

        if (checkCurrentBatchForGivenDate(dateOfPlanted, endDateOfBatch)) {
            System.out.println("There is another batch currently inprogress in the greenhouse at this given time period.");
            return;
        }

        boolean retry = false;
        do {
            System.out.println("Please select the plant type:\n 1. Fruit plant\n 2. Vegetable plant\n Enter option number");
            int input = scan.nextInt();

            if (input == 1) {
                retry = false;
                createFruit();

            } else if (input == 2) {
                retry = false;
                createVegetable();

            } else {
                System.out.println("Wrong option number. Please enter again");
                retry = true;
            }
        } while (retry);

        if (plantsList.isEmpty()) {
            System.out.println("There is no plants to be batched");
            return;
        }

        Batch batch = new Batch(getCurrentBatchNum() + 1, plantsList, dateOfPlanted, endDateOfBatch);
        batchList.add(batch);
        plantsList.clear();
        cropArray.clear();

    }

    public static boolean checkCurrentBatchForGivenDate(PlantDate dateOfPlanted, PlantDate dateOfEnd) {
//       Assumming only day.Skipping year and months
        if (batchList.size() > 0) {
            for (int i = 0; i <= batchList.size(); i++) {
                if ((dateOfPlanted.getDay() <= batchList.get(i).getDateOfPlanted().getDay()) && (batchList.get(i).getDateOfPlanted().getDay() <= dateOfEnd.getDay())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int getCurrentBatchNum() {
        if (!batchList.isEmpty()) {
            return batchList.size();
        }
        return 0;
    }

    public static void createCrop(Plant plant) {
        System.out.println("Creating a crop");
        int input = 0;
        do {
            System.out.println("Do you want to add a crop? 1-yes or 0-no");
            input = scan.nextInt();
            if (input == 1) {
//            PlantDate date,int totalWeight,state cropState
                System.out.println("Enter Year of the crop taken: ");
                int year = scan.nextInt();

                System.out.println("Enter month of the crop taken: ");
                int month = scan.nextInt();

                System.out.println("Enter day of the crop taken: ");
                int day = scan.nextInt();

                System.out.println("Enter total weight of the crop taken in kg: ");
                int weight = scan.nextInt();

                boolean retry = false;
                int status = 0;
                state cropStatus = state.STANDARD;
                do {
                    System.out.println("Select crop status: \n 1. STANDARD\n 2. BELOW_STANDARD\n 3. ABOVE_STANDARD\nEnter option number: ");
                    status = scan.nextInt();
                    if (status == 1) {
                        retry = false;
                        cropStatus = state.STANDARD;
                    } else if (status == 2) {
                        retry = false;
                        cropStatus = state.BELOW_STANDARD;
                    } else if (status == 3) {
                        retry = false;
                        cropStatus = state.ABOVE_STANDARD;
                    } else {
                        System.out.println("Entered option is incorrect. Enter valid option");
                        retry = true;
                    }
                } while (retry);
                PlantDate date = new PlantDate(day, month, year);
                Crop crop = new Crop(date, weight, cropStatus);
                if (plant != null) {
                    plant.addCrop(crop);
                    return;
                }
                cropArray.add(crop);

            } else if (input != 0) {
                System.out.println("Invalid input. Please enter valid option");
            }
        } while (input != 0);
    }

    public static void createFruit() {
//String plantName,int growingDuration,int croppingInterval,int lifeTime,int volume,double averageColor,int pH,Crop crop
        System.out.println("Enter fruit name: ");
        String fruitName = scanStr.nextLine();

        System.out.println("Enter growing duration of " + fruitName + " :");
        int duration = scan.nextInt();

        System.out.println("Enter cropping interval of " + fruitName + " :");
        int croppingInterval = scan.nextInt();

        System.out.println("Enter life time of " + fruitName + " :");
        int lifeTime = scan.nextInt();

        System.out.println("Enter volume of " + fruitName + " in mm^3:");
        int volume = scan.nextInt();

        System.out.println("Enter average color of " + fruitName + " :");
        int avgColor = scan.nextInt();

        System.out.println("Enter pH value of " + fruitName + " :");
        int ph = scan.nextInt();

        int input;
        System.out.println("Do you want to add a crop? 1-yes or 0-no");
        input = scan.nextInt();
        if (input == 1) {
            createCrop(null);
        }

        Fruit fruit;
        if (cropArray.isEmpty()) {
            fruit = new Fruit(fruitName, duration, croppingInterval, lifeTime, volume, avgColor, ph);
        } else {
            fruit = new Fruit(fruitName, duration, croppingInterval, lifeTime, volume, avgColor, ph, cropArray);
        }
        plantsList.add(fruit);
        cropArray.clear();
    }

    public static void createVegetable() {
//  String plantName,int growingDuration,int croppingInterval,int lifeTime,int areaPerLeaf,int thickness,ArrayList<Crop> crops
        int input;
        System.out.println("Do you want to add a crop? 1-yes or 0-no");
        input = scan.nextInt();
        if (input == 1) {
            createCrop(null);
        }
        System.out.println("Enter fruit name: ");
        String vegetableName = scanStr.nextLine();

        System.out.println("Enter growing duration of " + vegetableName + " :");
        int duration = scan.nextInt();

        System.out.println("Enter cropping interval of " + vegetableName + " :");
        int croppingInterval = scan.nextInt();

        System.out.println("Enter life time of " + vegetableName + " :");
        int lifeTime = scan.nextInt();

        System.out.println("Enter area per leaf of " + vegetableName + " in mm^2:");
        int areaPerLeaf = scan.nextInt();

        System.out.println("Enter thickness color of " + vegetableName + " in um:");
        int thickness = scan.nextInt();

        Vegetable vegetable;
        if (cropArray.isEmpty()) {
            vegetable = new Vegetable(vegetableName, duration, croppingInterval, lifeTime, areaPerLeaf, thickness);
        } else {
            vegetable = new Vegetable(vegetableName, duration, croppingInterval, lifeTime, areaPerLeaf, thickness, cropArray);
        }
        plantsList.add(vegetable);
        cropArray.clear();
    }

    public static void viewPlantDetails() {
        if (batchList.isEmpty()) {
            System.out.println("There is no batch list to show");
            return;
        }
        listingBatches();
        int index = 0;
        boolean retry = false;
        do {
            System.out.println("Select batch number: ");
            index = scan.nextInt();
            if (!isValidBatchIndex(index)) {
                retry = true;
            }
            listAllCropsByPlants(batchList.get(index));
        } while (retry);

        System.out.println("Do you want to add a crop to above plant? 1-yes or 0-no");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Enter plant number: ");
            int plantNo = scan.nextInt();
            if (isValidPlantIndex(index, plantNo)) {
                createCrop(batchList.get(index).plant.get(plantNo));
                System.out.println("Crop added successfully");
            }
        }

    }

    public static void listingBatches() {
        if (batchList.size() > 0) {
            System.out.println("No\tPlanted Date");
            for (int i = 0; i < batchList.size(); i++) {
                System.out.println(batchList.get(i).getBatchNo() + "\t" + batchList.get(i).getDateOfPlanted().getDateString());
            }
        }
    }

    public static boolean isValidBatchIndex(int index) {
        if (batchList.size() > 0 && index < batchList.size()) {
            return true;
        }
        return false;
    }

    public static boolean isValidPlantIndex(int batchIndex, int index) {
        if (isValidBatchIndex(batchIndex)) {
            if (batchList.get(batchIndex).plant.size() > 0 && index < batchList.get(batchIndex).plant.size()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void listAllCropsByPlants(Batch batch) {
        if (batch.plant.size() > 0) {
            System.out.println("No\tPlant Details");
            for (int i = 0; i < batch.plant.size(); i++) {
                System.out.println((i + 1) + "\t" + batch.plant.get(i));
                System.out.println("Crops List:\n");
                listCrops(batch.plant.get(i));
            }
        }
    }

    public static void listCrops(Plant plant) {
        if (plant.getCrop().size() < 0) {
            System.out.println("No Crops found");
        } else {
            for (int i = 0; i < plant.getCrop().size(); i++) {
                System.out.println("\t" + (i + 1) + "\t" + plant.getCrop().get(i));
            }
        }
    }

    public static void getSensorsValues(SensorTypes type) {
        SensorListener sensor = new SensorModule();
        Sensor sensors = new Sensor(type);
        sensors.setSensorListener(sensor);
        sensors.startSensor();
       
       

//        sensors.createPhSensor().startSensor();
//        sensors.createHumditySensor().startSensor();
    }
}
