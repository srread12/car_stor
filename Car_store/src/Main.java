import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner wordScan = new Scanner(System.in);
    public static Scanner numScan = new Scanner(System.in);
    public static String modelName;
    public static boolean admin = false;

    public static void main(String[] args) {

        ArrayList<Truck> allTruck = new ArrayList<>();
        Files.loadFileTruck("data/Truck.csv", allTruck);
        Truck.bubbleSortArrayListPriceTruck(allTruck);
        Files.saveFileTruck("data/Truck.csv", allTruck);

        ArrayList<Suv> allSuv = new ArrayList<>();
        Files.loadFileSuv("data/Suv.csv", allSuv);
        Suv.bubbleSortArrayListPriceSuv(allSuv);
        Files.saveFileSuv("data/Suv.csv", allSuv);

        ArrayList<Sedan> allSedan = new ArrayList<>();
        Files.loadFileSedan("data/Sedan.csv", allSedan);
        Sedan.bubbleSortArrayListPriceSedan(allSedan);
        Files.saveFileSedan("data/Sedan.csv", allSedan);

        ArrayList<SportsCar> allSportsCar = new ArrayList<>();
        Files.loadFileSportsCar("data/SportsCar.csv", allSportsCar);
        SportsCar.bubbleSortArrayListPriceSP(allSportsCar);
        Files.saveFileSportsCar("data/SportsCar.csv", allSportsCar);

        ArrayList<Minivan> allMinivan = new ArrayList<>();
        Files.loadFileMinivan("data/Minivan.csv", allMinivan);
        Minivan.bubbleSortArrayListPriceM(allMinivan);
        Files.saveFileMinivan("data/Minivan.csv", allMinivan);

        ArrayList<name_password> allNamesAndPasswords = new ArrayList<>();
        Files.loadFileNP("data/NameAndPassword.csv", allNamesAndPasswords);

        ArrayList<Car> allCars = new ArrayList<>();
        allCars.addAll(allTruck);
        allCars.addAll(allMinivan);
        allCars.addAll(allSportsCar);
        allCars.addAll(allSedan);
        allCars.addAll(allSuv);


        double totalPrice = 0;

        while (true) {
            admin = false;
            System.out.println("Are a customer or are you part of the administration. Enter Exit to leave and print the bill.");
            String user = wordScan.nextLine().toLowerCase();

            if (user.contains("exit")) {
                saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                if (totalPrice < 0) {
                    System.out.println("You gained $" + Math.abs(totalPrice) + " today.");
                    break;
                }
                System.out.println("You transferred $" + totalPrice + " today.");
                System.out.println("thank you for coming.");
                break;

            } else if (user.contains("admin")) {

                int good;
                while (true) {
                    System.out.println("What is your username.");
                    String name = wordScan.nextLine().toLowerCase();
                    System.out.println("What is your password.");
                    String password  = wordScan.nextLine().toLowerCase();
                    good = binarySearch(allNamesAndPasswords,name,password);
                    if(good != -1){
                        admin = true;
                        break;
                    }
                    System.out.println("The username or password is incorrect.");
                }

                System.out.println("What would you like to do.");
                System.out.println("1: remove car.");
                System.out.println("2: add car.");
                System.out.println("3: change username and password.");
                int want = numScan.nextInt();
                if(want == 1){
                    buyCar(allCars, totalPrice, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                    saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                    System.out.println();
                } else if (want == 2) {
                    addCar(totalPrice, allTruck, allSuv, allSportsCar, allMinivan, allSedan);
                    saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                    System.out.println();
                } else {
                    System.out.println("What is the new username.");
                    String Name = wordScan.nextLine().toLowerCase();
                    System.out.println("What is the new password.");
                    String Password = wordScan.nextLine().toLowerCase();
                    allNamesAndPasswords.get(good).setName(Name);
                    allNamesAndPasswords.get(good).setPassword(Password);
                    Files.saveFileNP("data/NameAndPassword.csv", allNamesAndPasswords);
                }

            } else {

                while (true) {

                    System.out.println("What would you like to do today? Enter the corresponding number to go further.");
                    System.out.println("1: Buy.");
                    System.out.println("2: Trade.");
                    System.out.println("3: Buy and trade.");
                    System.out.println("4: Exit.");
                    int customer = numScan.nextInt();

                    if (customer == 1) {

                        totalPrice = totalPrice + buyCar(allCars, totalPrice, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                        saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                        System.out.println();

                    } else if (customer == 2) {

                        totalPrice = totalPrice - Math.abs(addCar(totalPrice, allTruck, allSuv, allSportsCar, allMinivan, allSedan));
                        saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                        System.out.println();

                    } else if (customer == 3) {

                        totalPrice = Math.abs(addCar(totalPrice, allTruck, allSuv, allSportsCar, allMinivan, allSedan) - buyCar(allCars, totalPrice, allSedan, allTruck, allMinivan, allSuv, allSportsCar));
                        saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                        System.out.println();

                    } else {
                        System.out.println("Bye for now.");
                        saveFiles(allCars, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
                        System.out.println();
                        break;
                    }
                }//end buy loop

            }//end customer

        }//end while


    }//end main

    public static double addCar(double totalPrice, ArrayList<Truck> allTruck, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar, ArrayList<Minivan> allMinivan, ArrayList<Sedan> allSedan) {

        System.out.println("Please have correct spelling and capitalization.");
        System.out.println("What is the brand name of your car.");
        String carBrand = wordScan.nextLine();
        System.out.println("What is the model name of your car.");
        String model = wordScan.nextLine();
        System.out.println("What year is the car from.");
        int year = numScan.nextInt();
        System.out.println("What is the price of the car.");
        double price = numScan.nextInt();
        System.out.println("How many accidents was this car in.");
        int accidents = numScan.nextInt();
        System.out.println("What is the mileage of your car.");
        int mileage = numScan.nextInt();
        System.out.println("What is the top speed of your car.");
        int speed = numScan.nextInt();
        System.out.println("What type of car do you have.(truck, suv, minivan, super car, sedan)");
        String type = wordScan.nextLine().toLowerCase();
        if (type.contains("truck")) {
            System.out.println("What is the bed size in meters.");
            double bedSize = numScan.nextDouble();
            System.out.println("What is the max towing in tons.");
            double MaxTowing = numScan.nextDouble();
            allTruck.add(new Truck(carBrand, model, year, price, accidents, mileage, speed, bedSize, MaxTowing));
        } else if (type.contains("suv")) {
            System.out.println("What is the fuel economy of the car.");
            int FuelEconomy = numScan.nextInt();
            allSuv.add(new Suv(carBrand, model, year, price, accidents, mileage, speed, FuelEconomy));
        } else if (type.contains("minivan")) {
            System.out.println("How many seats does the minivan have.");
            int NumberOfSeats = numScan.nextInt();
            System.out.println("What is the fuel economy of this car.");
            int FuelEconomy = numScan.nextInt();
            allMinivan.add(new Minivan(carBrand, model, year, price, accidents, mileage, speed, NumberOfSeats, FuelEconomy));
        } else if (type.contains("super car")) {
            boolean Customized = false;
            System.out.println("Is this car customized?");
            String custom = wordScan.nextLine();
            if (custom.contains("y")) {
                Customized = true;
            }
            allSportsCar.add(new SportsCar(carBrand, model, year, price, accidents, mileage, speed, Customized));
        } else {
            allSedan.add(new Sedan(carBrand, model, year, price, accidents, mileage, speed));
        }

        totalPrice = totalPrice - price;
        return totalPrice;

    }//end give car

    public static double buyCar(ArrayList<Car> allCar, double totalPrice, ArrayList<Sedan> allSedan, ArrayList<Truck> allTruck, ArrayList<Minivan> allMinivan, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar) {

        while (true) {

            int place;
            System.out.println("What filter would you like to use.");
            System.out.println("1: Print all cars.");
            System.out.println("2: Print all Trucks.");
            System.out.println("3: Print all SUVs");
            System.out.println("4: Print all Minivans");
            System.out.println("5: Print all Sedans");
            System.out.println("6: Print all Sports cars");
            System.out.println("7: Exit");
            int want = numScan.nextInt();

            if (want == 1) {

                if(!admin) {
                    place = printCar(allCar);
                }else{
                    place = printCar2(allCar);
                }
                setModelName(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, place);

            } else if (want == 2) {

                place = printCar2(allCar, want);
                return setModelName(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, place);

            } else if (want == 3) {

                palaceOfCar(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, want);

            } else if (want == 4) {

                return palaceOfCar(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, want);

            } else if (want == 5) {

                return palaceOfCar(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, want);

            } else if (want == 6) {

                return palaceOfCar(allCar, allSedan, allTruck, allMinivan, allSuv, allSportsCar, want);

            } else {
                System.out.println("Thank you for coming.");
                return totalPrice;
            }

        }
    }//end buy car

    public static double palaceOfCar(ArrayList<Car> allCar, ArrayList<Sedan> allSedan, ArrayList<Truck> allTruck, ArrayList<Minivan> allMinivan, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar, int want) {
        int place;
        place = printCar2(allCar, want);
        modelName = allCar.get(place).getModelName();
        System.out.println("Do you want this car.");
        if (wordScan.nextLine().contains("yes")) {
            Car.removeCar(modelName, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
            return allCar.get(place).getPrice();
        }
        return 0;
    }

    public static double setModelName(ArrayList<Car> allCar, ArrayList<Sedan> allSedan, ArrayList<Truck> allTruck, ArrayList<Minivan> allMinivan, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar, int place) {
        modelName = allCar.get(place).getModelName();
        print(allCar, place);
        System.out.println("Do you want this car.");
        if (wordScan.nextLine().contains("yes")) {
            Car.removeCar(modelName, allSedan, allTruck, allMinivan, allSuv, allSportsCar);
            return allCar.get(place).getPrice();
        }
        return 0;
    }

    public static int printCar(ArrayList<Car> allCar) {

        System.out.println("Do you want a sorter.");
        System.out.println("1: sort by price.");
        System.out.println("2: sort by model name.");
        System.out.println("3: no filter");
        int sort = numScan.nextInt();
        if (sort == 1) {
            Car.bubbleSortArrayListPrice(allCar);
        } else if (sort == 2) {
            Car.bubbleSortArrayListName(allCar);
        }

        int id = 1;
        for (Car car : allCar) {

            System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());

        }
        System.out.println("What car would you like to have please enter in the corresponding id number.");
        return numScan.nextInt() - 1;

    }//end print car

    public static void print(ArrayList<Car> allCar, int id) {
        System.out.println("BrandName: " + allCar.get(id).getBrandName() + "   Model name: " + allCar.get(id).getModelName() + "   Price: $" + allCar.get(id).getPrice());
    }//end print car

    public static int printCar2(ArrayList<Car> allCar, int want) {

        int id = 1;
        for (Car car : allCar) {

            if (want == 2 && car instanceof Truck) {
                System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());
            } else if (want == 3 && car instanceof Suv) {
                System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());
            } else if (want == 4 && car instanceof Minivan) {
                System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());
            } else if (want == 6 && car instanceof SportsCar) {
                System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());
            } else if (want == 5 && car instanceof Sedan) {
                System.out.println("id: " + id++ + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());
            }

        }
        System.out.println("What car would you like to have please enter in the corresponding id number.");
        return numScan.nextInt() - 1;

    }//end print car

    public static void saveFiles(ArrayList<Car> allCars, ArrayList<Sedan> allSedan, ArrayList<Truck> allTruck, ArrayList<Minivan> allMinivan, ArrayList<Suv> allSuv, ArrayList<SportsCar> allSportsCar) {
        Files.saveFileSuv("data/Suv.csv", allSuv);
        Files.saveFileSedan("data/Sedan.csv", allSedan);
        Files.saveFileSportsCar("data/SportsCar.csv", allSportsCar);
        Files.saveFileMinivan("data/Minivan.csv", allMinivan);
        Files.saveFileTruck("data/Truck.csv", allTruck);
        allCars.clear();
        allCars.addAll(allTruck);
        allCars.addAll(allMinivan);
        allCars.addAll(allSportsCar);
        allCars.addAll(allSedan);
        allCars.addAll(allSuv);
    }//end save

    public static int binarySearch(ArrayList<name_password> list, String name, String password) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (list.get(mid).getName().equalsIgnoreCase(name) && list.get(mid).getPassword().equalsIgnoreCase(password)) {
                return mid;
            } else if (list.get(mid).getName().compareToIgnoreCase(name) < 0 && list.get(mid).getPassword().compareToIgnoreCase(password) < 0) {
                end = mid -1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    } //end binarySearch

    public static int printCar2(ArrayList<Car> allCar) {

        int id = 1;
        for (Car car : allCar) {

            String type = "";
            if (car instanceof Truck) {
                type = "Truck";
            } else if (car instanceof Suv) {
                type = "Suv";
            } else if (car instanceof Minivan) {
                type = "Minivan";
            } else if (car instanceof SportsCar) {
                type = "Sports Car";
            } else if (car instanceof Sedan) {
                type = "Sedan";
            }

            System.out.println("id: " + id++ + " Type: " + type + "  BrandName: " + car.getBrandName() + "   Model name: " + car.getModelName() + "   Price: $" + car.getPrice());

        }
        System.out.println("What car would you like to have please enter in the corresponding id number.");
        return numScan.nextInt() - 1;

    }//end print car

}//end class

