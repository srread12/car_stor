import java.util.ArrayList;

public class Sedan extends Car {

    public Sedan(String b, String name, int r, double p, int n, int m, int k) {

        super(b, name, r, p, n, m, k);

    }//end constructor

    public static void bubbleSortArrayListPriceSedan(ArrayList<Sedan> allSedan) {

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < allSedan.size() - 1; i++) {
                if (allSedan.get(i).getPrice() > allSedan.get(i + 1).getPrice()) {

                    swapNS(allSedan,i);
                    swap = true;
                }

            } // end for

        } // end while

    }// end sort

    public static void swapNS(ArrayList<Sedan> allSedan, int i){

        String BrandName = allSedan.get(i).getBrandName();
        String ModelName = allSedan.get(i).getModelName();
        int ReleaseYear = allSedan.get(i).getReleaseYear();
        double Price = allSedan.get(i).getPrice();
        int NumberOfAccidents = allSedan.get(i).getNumberOfAccidents();
        int Mileage = allSedan.get(i).getMileage();
        int topSpeed = allSedan.get(i).getTopSpeed();

        allSedan.get(i).setBrandName(allSedan.get(i + 1).getBrandName());
        allSedan.get(i).setModelName(allSedan.get(i + 1).getModelName());
        allSedan.get(i).setReleaseYear(allSedan.get(i + 1).getReleaseYear());
        allSedan.get(i).setPrice(allSedan.get(i + 1).getPrice());
        allSedan.get(i).setNumberOfAccidents(allSedan.get(i + 1).getNumberOfAccidents());
        allSedan.get(i).setMileage(allSedan.get(i + 1).getMileage());
        allSedan.get(i).setTopSpeed(allSedan.get(i + 1).getTopSpeed());

        allSedan.get(i + 1).setBrandName(BrandName);
        allSedan.get(i + 1).setModelName(ModelName);
        allSedan.get(i + 1).setReleaseYear(ReleaseYear);
        allSedan.get(i + 1).setPrice(Price);
        allSedan.get(i + 1).setNumberOfAccidents(NumberOfAccidents);
        allSedan.get(i + 1).setMileage(Mileage);
        allSedan.get(i + 1).setTopSpeed(topSpeed);

    }//end

    public static int binarySearchStringsSedan(String target, ArrayList<Sedan> allSedan) {

        int low = 0;
        int high = allSedan.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (allSedan.get(mid).getModelName().compareTo(target) < 0) {
                low = mid + 1;
            } else if (allSedan.get(mid).getModelName().compareTo(target) > 0) {
                high = mid - 1;
            } else if (allSedan.get(mid).getModelName() == target) {
                return mid;
            }
        }
        return -1;

    }//end binary search

}//end class
