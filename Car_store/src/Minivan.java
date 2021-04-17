import java.util.ArrayList;

public class Minivan extends Car {

    private int NumberOfSeats;
    private int FuelEconomy;

    public Minivan(String b, String name, int r, double p, int n, int m, int k, int s, int mi) {

        super(b, name, r, p, n, m, k);
        this.NumberOfSeats = s;
        this.FuelEconomy = mi;

    }//end constructor

    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }

    public int getFuelEconomy() {
        return FuelEconomy;
    }

    public void setFuelEconomy(int fuelEconomy) {
        FuelEconomy = fuelEconomy;
    }

    public static void bubbleSortArrayListPriceM(ArrayList<Minivan> allMinivan) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allMinivan.size() - 1; i++) {
                if (allMinivan.get(i).getPrice() > allMinivan.get(i + 1).getPrice()) {

                    swapNSP(allMinivan, i);
                    swap = true;
                }   

            } // end for

        } // end while

    }// end sort

    public static void swapNSP(ArrayList<Minivan> allMinivan, int i) {

        String BrandName = allMinivan.get(i).getBrandName();
        String ModelName = allMinivan.get(i).getModelName();
        int ReleaseYear = allMinivan.get(i).getReleaseYear();
        double Price = allMinivan.get(i).getPrice();
        int NumberOfAccidents = allMinivan.get(i).getNumberOfAccidents();
        int Mileage = allMinivan.get(i).getMileage();
        int topSpeed = allMinivan.get(i).getTopSpeed();
        int NumberOfSeats = allMinivan.get(i).getNumberOfSeats();
        int FuelEconomy = allMinivan.get(i).getFuelEconomy();

        allMinivan.get(i).setBrandName(allMinivan.get(i + 1).getBrandName());
        allMinivan.get(i).setModelName(allMinivan.get(i + 1).getModelName());
        allMinivan.get(i).setReleaseYear(allMinivan.get(i + 1).getReleaseYear());
        allMinivan.get(i).setPrice(allMinivan.get(i + 1).getPrice());
        allMinivan.get(i).setNumberOfAccidents(allMinivan.get(i + 1).getNumberOfAccidents());
        allMinivan.get(i).setMileage(allMinivan.get(i + 1).getMileage());
        allMinivan.get(i).setTopSpeed(allMinivan.get(i + 1).getTopSpeed());
        allMinivan.get(i).setNumberOfSeats(allMinivan.get(i + 1).getNumberOfSeats());
        allMinivan.get(i).setFuelEconomy(allMinivan.get(i + 1).getFuelEconomy());

        allMinivan.get(i + 1).setBrandName(BrandName);
        allMinivan.get(i + 1).setModelName(ModelName);
        allMinivan.get(i + 1).setReleaseYear(ReleaseYear);
        allMinivan.get(i + 1).setPrice(Price);
        allMinivan.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allMinivan.get(i + 1).setMileage(Mileage);
        allMinivan.get(i + 1).setTopSpeed(topSpeed);
        allMinivan.get(i + 1).setNumberOfSeats(NumberOfSeats);
        allMinivan.get(i + 1).setFuelEconomy(FuelEconomy);

    }

    public static int binarySearchStringsMinivan(String target, ArrayList<Minivan> allMinivan) {

        int low = 0;
        int high = allMinivan.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (allMinivan.get(mid).getModelName().compareTo(target) < 0) {
                low = mid + 1;
            } else if (allMinivan.get(mid).getModelName().compareTo(target) > 0) {
                high = mid - 1;
            } else if (allMinivan.get(mid).getModelName().contains(target)) {
                return mid;
            }
        }
        return -1;

    }//end binary search

}//end class
