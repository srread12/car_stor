import java.util.ArrayList;

public class Car {

    private String BrandName;
    private String ModelName;
    private int ReleaseYear;
    private double Price;
    private int NumberOfAccidents;
    private int Mileage;
    private int topSpeed;

    public Car(String b, String name, int r, double p, int n, int m, int k) {

        this.BrandName = b;
        this.ModelName = name;
        this.ReleaseYear = r;
        this.Price = p;
        this.NumberOfAccidents = n;
        this.Mileage = m;
        this.topSpeed = k;

    }//end constructor

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getNumberOfAccidents() {
        return NumberOfAccidents;
    }

    public void setNumberOfAccidents(int numberOfAccidents) {
        NumberOfAccidents = numberOfAccidents;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public static void bubbleSortArrayListName(ArrayList<Car> allCar) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allCar.size() - 1; i++) {
                if (allCar.get(i).getModelName().compareTo(allCar.get(i + 1).getModelName()) > 0) {

                    swapN(allCar, i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void bubbleSortArrayListPrice(ArrayList<Car> allCar) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allCar.size() - 1; i++) {
                if (allCar.get(i).getPrice() > allCar.get(i + 1).getPrice()) {

                    swapN(allCar, i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void swapN(ArrayList<Car> allCar, int i) {

        String BrandName = allCar.get(i).getBrandName();
        String ModelName = allCar.get(i).getModelName();
        int ReleaseYear = allCar.get(i).getReleaseYear();
        double Price = allCar.get(i).getPrice();
        int NumberOfAccidents = allCar.get(i).getNumberOfAccidents();
        int Mileage = allCar.get(i).getMileage();
        int topSpeed = allCar.get(i).getTopSpeed();

        allCar.get(i).setBrandName(allCar.get(i + 1).getBrandName());
        allCar.get(i).setModelName(allCar.get(i + 1).getModelName());
        allCar.get(i).setReleaseYear(allCar.get(i + 1).getReleaseYear());
        allCar.get(i).setPrice(allCar.get(i + 1).getPrice());
        allCar.get(i).setNumberOfAccidents(allCar.get(i + 1).getNumberOfAccidents());
        allCar.get(i).setMileage(allCar.get(i + 1).getMileage());
        allCar.get(i).setTopSpeed(allCar.get(i + 1).getTopSpeed());

        allCar.get(i + 1).setBrandName(BrandName);
        allCar.get(i + 1).setModelName(ModelName);
        allCar.get(i + 1).setReleaseYear(ReleaseYear);
        allCar.get(i + 1).setPrice(Price);
        allCar.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allCar.get(i + 1).setMileage(Mileage);
        allCar.get(i + 1).setTopSpeed(topSpeed);

    }//end swap



    public static void removeCar(String target, ArrayList<Sedan> allSedan, ArrayList<Truck> allTruck, ArrayList<Minivan> allMinivan, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar) {

        if (Truck.binarySearchStringsTruck(target, allTruck) != -1) {
            allTruck.remove(Truck.binarySearchStringsTruck(target, allTruck));
        } else if (Sedan.binarySearchStringsSedan(target, allSedan) != -1) {
            allSedan.remove(Sedan.binarySearchStringsSedan(target, allSedan));
        } else if (Minivan.binarySearchStringsMinivan(target, allMinivan) != -1) {
            allMinivan.remove(Minivan.binarySearchStringsMinivan(target, allMinivan));
        } else if (Suv.binarySearchStringsSuv(target, allSuv) != -1){
            allSuv.remove(Suv.binarySearchStringsSuv(target, allSuv));
        } else if (SportsCar.binarySearchStringsSportsCar(target, allSportsCar) != -1){
            allSportsCar.remove(SportsCar.binarySearchStringsSportsCar(target, allSportsCar));
        } else {
            System.out.println("This car does not exist.");
        }

    }//end remove car

}//end class
