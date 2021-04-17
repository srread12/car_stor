import java.io.*;
import java.util.ArrayList;

public class Files {

    public static String toSave = "";
    public static String temp = "";

    public static void loadFileMinivan(String filename, ArrayList<Minivan> tempList) {
        temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new Minivan(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6]), Integer.parseInt(tempArray[7]), Integer.parseInt(tempArray[8])));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileMinivan(String filename, ArrayList<Minivan> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                toSave = "";
                toSave += tempList.get(i).getBrandName();
                toSave += ", " + tempList.get(i).getModelName();
                toSave += ", " + tempList.get(i).getReleaseYear();
                toSave += ", " + tempList.get(i).getPrice();
                toSave += ", " + tempList.get(i).getNumberOfAccidents();
                toSave += ", " + tempList.get(i).getMileage();
                toSave += ", " + tempList.get(i).getTopSpeed();
                toSave += ", " + tempList.get(i).getNumberOfSeats();
                toSave += ", " + tempList.get(i).getFuelEconomy();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void loadFileSportsCar(String filename, ArrayList<SportsCar> tempList) {
        temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new SportsCar(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6]), Boolean.parseBoolean(tempArray[7])));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileSportsCar(String filename, ArrayList<SportsCar> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                toSave = "";
                toSave += tempList.get(i).getBrandName();
                toSave += ", " + tempList.get(i).getModelName();
                toSave += ", " + tempList.get(i).getReleaseYear();
                toSave += ", " + tempList.get(i).getPrice();
                toSave += ", " + tempList.get(i).getNumberOfAccidents();
                toSave += ", " + tempList.get(i).getMileage();
                toSave += ", " + tempList.get(i).getTopSpeed();
                toSave += ", " + tempList.get(i).isCustomized();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void loadFileSedan(String filename, ArrayList<Sedan> tempList) {
        temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new Sedan(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6])));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileSedan(String filename, ArrayList<Sedan> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                toSave = "";
                toSave += tempList.get(i).getBrandName();
                toSave += ", " + tempList.get(i).getModelName();
                toSave += ", " + tempList.get(i).getReleaseYear();
                toSave += ", " + tempList.get(i).getPrice();
                toSave += ", " + tempList.get(i).getNumberOfAccidents();
                toSave += ", " + tempList.get(i).getMileage();
                toSave += ", " + tempList.get(i).getTopSpeed();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void loadFileSuv(String filename, ArrayList<Suv> tempList) {
        temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new Suv(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6]), Integer.parseInt(tempArray[7])));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileSuv(String filename, ArrayList<Suv> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                toSave = "";
                toSave += tempList.get(i).getBrandName();
                toSave += ", " + tempList.get(i).getModelName();
                toSave += ", " + tempList.get(i).getReleaseYear();
                toSave += ", " + tempList.get(i).getPrice();
                toSave += ", " + tempList.get(i).getNumberOfAccidents();
                toSave += ", " + tempList.get(i).getMileage();
                toSave += ", " + tempList.get(i).getTopSpeed();
                toSave += ", " + tempList.get(i).getFuelEconomy();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void loadFileTruck(String filename, ArrayList<Truck> tempList) {
        temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new Truck(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6]), Double.parseDouble(tempArray[7]), Double.parseDouble(tempArray[8])));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileTruck(String filename, ArrayList<Truck> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                toSave = "";
                toSave += tempList.get(i).getBrandName();
                toSave += ", " + tempList.get(i).getModelName();
                toSave += ", " + tempList.get(i).getReleaseYear();
                toSave += ", " + tempList.get(i).getPrice();
                toSave += ", " + tempList.get(i).getNumberOfAccidents();
                toSave += ", " + tempList.get(i).getMileage();
                toSave += ", " + tempList.get(i).getTopSpeed();
                toSave += ", " + tempList.get(i).getBedSize();
                toSave += ", " + tempList.get(i).getMaxTowing();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile


    public static void loadFileNP(String filename, ArrayList<name_password> tempList) {
        String temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(", ");

                tempList.add(new name_password(tempArray[0], tempArray[1]));

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFileNP(String filename, ArrayList<name_password> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                String toSave = "";
                toSave += tempList.get(i).getName();
                toSave += ", " + tempList.get(i).getPassword();

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

}//end files


