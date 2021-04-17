import java.util.ArrayList;

public class Truck extends Car {

    private double bedSize;
    private double MaxTowing;

    public Truck(String b, String name, int r, double p, int n, int m, int k, double bs, double mx) {

        super(b, name, r, p, n, m, k);
        this.bedSize = bs;
        this.MaxTowing = mx;

    }//end constructor

    public double getBedSize() {
        return bedSize;
    }

    public void setBedSize(double bedSize) {
        this.bedSize = bedSize;
    }

    public double getMaxTowing() {
        return MaxTowing;
    }

    public void setMaxTowing(double maxTowing) {
        MaxTowing = maxTowing;
    }

    public static void bubbleSortArrayListPriceTruck(ArrayList<Truck> allTruck) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allTruck.size() - 1; i++) {
                if (allTruck.get(i).getPrice() > allTruck.get(i + 1).getPrice()) {

                    swapNT(allTruck,i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void swapNT(ArrayList<Truck> allTruck, int i){

        String BrandName = allTruck.get(i).getBrandName();
        String ModelName = allTruck.get(i).getModelName();
        int ReleaseYear = allTruck.get(i).getReleaseYear();
        double Price = allTruck.get(i).getPrice();
        int NumberOfAccidents = allTruck.get(i).getNumberOfAccidents();
        int Mileage = allTruck.get(i).getMileage();
        int topSpeed = allTruck.get(i).getTopSpeed();
        double bedSize = allTruck.get(i).getBedSize();
        double MaxTowing = allTruck.get(i).getMaxTowing();

        allTruck.get(i).setBrandName(allTruck.get(i + 1).getBrandName());
        allTruck.get(i).setModelName(allTruck.get(i + 1).getModelName());
        allTruck.get(i).setReleaseYear(allTruck.get(i + 1).getReleaseYear());
        allTruck.get(i).setPrice(allTruck.get(i + 1).getPrice());
        allTruck.get(i).setNumberOfAccidents(allTruck.get(i + 1).getNumberOfAccidents());
        allTruck.get(i).setMileage(allTruck.get(i + 1).getMileage());
        allTruck.get(i).setTopSpeed(allTruck.get(i + 1).getTopSpeed());
        allTruck.get(i).setBedSize(allTruck.get(i + 1).getBedSize());
        allTruck.get(i).setMaxTowing(allTruck.get(i + 1).getMaxTowing());

        allTruck.get(i + 1).setBrandName(BrandName);
        allTruck.get(i + 1).setModelName(ModelName);
        allTruck.get(i + 1).setReleaseYear(ReleaseYear);
        allTruck.get(i + 1).setPrice(Price);
        allTruck.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allTruck.get(i + 1).setMileage(Mileage);
        allTruck.get(i + 1).setTopSpeed(topSpeed);
        allTruck.get(i + 1).setBedSize(bedSize);
        allTruck.get(i + 1).setMaxTowing(MaxTowing);

    }

    public static int binarySearchStringsTruck(String target, ArrayList<Truck> allTruck) {

        int low = 0;
        int high = allTruck.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (allTruck.get(mid).getModelName().compareTo(target) < 0) {
                low = mid + 1;
            } else if (allTruck.get(mid).getModelName().compareTo(target) > 0) {
                high = mid - 1;
            } else if (allTruck.get(mid).getModelName() == target) {
                return mid;
            }
        }
        return -1;

    }//end binary search

}//end class