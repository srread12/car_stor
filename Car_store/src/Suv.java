import java.util.ArrayList;

public class Suv extends Car {

    private int FuelEconomy;

    public Suv(String b, String name, int r, double p, int n, int m, int k, int mi) {

        super(b, name, r, p, n, m, k);
        this.FuelEconomy = mi;

    }//end constructor

    public int getFuelEconomy() {
        return FuelEconomy;
    }

    public void setFuelEconomy(int fuelEconomy) {
        FuelEconomy = fuelEconomy;
    }

    public static void bubbleSortArrayListPriceSuv(ArrayList<Suv> allSuv) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allSuv.size() - 1; i++) {
                if (allSuv.get(i).getPrice() > allSuv.get(i + 1).getPrice()) {

                    swapNSV(allSuv,i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void swapNSV(ArrayList<Suv> allSuv, int i){

        String BrandName = allSuv.get(i).getBrandName();
        String ModelName = allSuv.get(i).getModelName();
        int ReleaseYear = allSuv.get(i).getReleaseYear();
        double Price = allSuv.get(i).getPrice();
        int NumberOfAccidents = allSuv.get(i).getNumberOfAccidents();
        int Mileage = allSuv.get(i).getMileage();
        int topSpeed = allSuv.get(i).getTopSpeed();
        int fuelEconomy = allSuv.get(i).getFuelEconomy();

        allSuv.get(i).setBrandName(allSuv.get(i + 1).getBrandName());
        allSuv.get(i).setModelName(allSuv.get(i + 1).getModelName());
        allSuv.get(i).setReleaseYear(allSuv.get(i + 1).getReleaseYear());
        allSuv.get(i).setPrice(allSuv.get(i + 1).getPrice());
        allSuv.get(i).setNumberOfAccidents(allSuv.get(i + 1).getNumberOfAccidents());
        allSuv.get(i).setMileage(allSuv.get(i + 1).getMileage());
        allSuv.get(i).setTopSpeed(allSuv.get(i + 1).getTopSpeed());
        allSuv.get(i).setFuelEconomy(allSuv.get(i + 1).getFuelEconomy());

        allSuv.get(i + 1).setBrandName(BrandName);
        allSuv.get(i + 1).setModelName(ModelName);
        allSuv.get(i + 1).setReleaseYear(ReleaseYear);
        allSuv.get(i + 1).setPrice(Price);
        allSuv.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allSuv.get(i + 1).setMileage(Mileage);
        allSuv.get(i + 1).setTopSpeed(topSpeed);
        allSuv.get(i + 1).setFuelEconomy(fuelEconomy);

    }//end swap

    public static int binarySearchStringsSuv(String target, ArrayList<Suv> allSuv) {

        int low = 0;
        int high = allSuv.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (allSuv.get(mid).getModelName().compareTo(target) < 0) {
                low = mid + 1;
            } else if (allSuv.get(mid).getModelName().compareTo(target) > 0) {
                high = mid - 1;
            } else if (allSuv.get(mid).getModelName() == target) {
                return mid;
            }
        }
        return -1;

    }//end binary search

}//end class
