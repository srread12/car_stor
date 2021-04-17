import java.util.ArrayList;

public class SportsCar extends Car {

    private boolean Customized;

    public SportsCar(String b, String name, int r, double p, int n, int m, int k, boolean c) {

        super(b, name, r, p, n, m, k);
        this.Customized = c;

    }//end constructor

    public boolean isCustomized() {
        return Customized;
    }

    public void setCustomized(boolean customized) {
        Customized = customized;
    }

    public static void bubbleSortArrayListPriceSP(ArrayList<SportsCar> allSportsCar) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allSportsCar.size() - 1; i++) {
                if (allSportsCar.get(i).getPrice() > allSportsCar.get(i + 1).getPrice()) {

                    swapNSP(allSportsCar, i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void swapNSP(ArrayList<SportsCar> allSportsCar, int i) {

        String BrandName = allSportsCar.get(i).getBrandName();
        String ModelName = allSportsCar.get(i).getModelName();
        int ReleaseYear = allSportsCar.get(i).getReleaseYear();
        double Price = allSportsCar.get(i).getPrice();
        int NumberOfAccidents = allSportsCar.get(i).getNumberOfAccidents();
        int Mileage = allSportsCar.get(i).getMileage();
        int topSpeed = allSportsCar.get(i).getTopSpeed();
        boolean Customized = allSportsCar.get(i).isCustomized();

        allSportsCar.get(i).setBrandName(allSportsCar.get(i + 1).getBrandName());
        allSportsCar.get(i).setModelName(allSportsCar.get(i + 1).getModelName());
        allSportsCar.get(i).setReleaseYear(allSportsCar.get(i + 1).getReleaseYear());
        allSportsCar.get(i).setPrice(allSportsCar.get(i + 1).getPrice());
        allSportsCar.get(i).setNumberOfAccidents(allSportsCar.get(i + 1).getNumberOfAccidents());
        allSportsCar.get(i).setMileage(allSportsCar.get(i + 1).getMileage());
        allSportsCar.get(i).setTopSpeed(allSportsCar.get(i + 1).getTopSpeed());
        allSportsCar.get(i).setCustomized(allSportsCar.get(i + 1).isCustomized());

        allSportsCar.get(i + 1).setBrandName(BrandName);
        allSportsCar.get(i + 1).setModelName(ModelName);
        allSportsCar.get(i + 1).setReleaseYear(ReleaseYear);
        allSportsCar.get(i + 1).setPrice(Price);
        allSportsCar.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allSportsCar.get(i + 1).setMileage(Mileage);
        allSportsCar.get(i + 1).setTopSpeed(topSpeed);
        allSportsCar.get(i + 1).setCustomized(Customized);

    }//end swap

    public static int binarySearchStringsSportsCar(String target, ArrayList<SportsCar> allSportsCars) {
        int low = 0;
        int high = allSportsCars.size();
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (allSportsCars.get(mid).getModelName().compareTo(target) < 0) {
                low = mid + 1;
            } else if (allSportsCars.get(mid).getModelName().compareTo(target) > 0) {
                high = mid - 1;
            } else if (allSportsCars.get(mid).getModelName() == target) {
                return mid;
            }
        }
        return -1;

    }//end binary search

}//end class
