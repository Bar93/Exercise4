import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice1 = 0, userChoice2 = 0;
        RealEstate realEstate = new RealEstate();
        User onlineUser;
        while (userChoice1 != 3) {
            userChoice2=0;
            System.out.println("1. for create account " + "\n" + "2. login " + "\n" + "3. logout " + "\n");
            userChoice1 = scanner.nextInt();
            while (userChoice1 > 3 || userChoice1 < 1) {
                System.out.println("Enter correct choice");
                System.out.println("1. for create account " + "\n" + "2. login " + "\n" + "3. logout " + "\n");
                userChoice1 = scanner.nextInt();
            }
            if (userChoice1 == 1) {
                realEstate.createUser();
            }
            if (userChoice1 == 2) {
                onlineUser = realEstate.login();
                if (onlineUser != null) {
                    while (userChoice2 != 6) {
                        System.out.println("1. publish new property " + "\n"
                                + "2. remove publish " + "\n" + "3. show all property "
                                + "\n" + "4. show my property " + "\n" + "5. search " + "\n" + "6. to main menu " + "\n");
                        userChoice2 = scanner.nextInt();
                        while (userChoice2 > 6 || userChoice2 < 1) {
                            System.out.println("Enter correct choice");
                            System.out.println("1. publish new property " + "\n"
                                    + "2. remove publish " + "\n" + "3. show all property "
                                    + "\n" + "4. show my property " + "\n" + "5. search " + "\n" + "6. to main menu " + "\n");
                            userChoice2 = scanner.nextInt();
                        }
                        if (userChoice2 == 1) {
                            realEstate.postNewProperty(onlineUser);
                        }
                        if (userChoice2 == 2) {
                            realEstate.removeProperty(onlineUser);
                        }
                        if (userChoice2 == 3) {
                            realEstate.printAllProperties();
                        }
                        if (userChoice2 == 4) {
                            realEstate.printUserProperties(onlineUser);
                        }
                        if (userChoice2 == 5) {
                            Property[] filteredProperty = realEstate.search();
                            for (int i = 0; i < filteredProperty.length; i++) {
                                System.out.println(i + " . " + filteredProperty[i].toString() + "\n");
                            }
                        }
                        if (userChoice2==6){
                            onlineUser = null;
                        }
                    }
                }
            }
        }
    }
}

