import java.util.Scanner;

public class RealEstate {

    private User[] users;
    private Property[] properties;
    private Address[] addresses;

    public User[] getUsers() {
        return this.users;
    }

    public Property[] getProperties() {
        return this.properties;
    }

    public Address[] getAddresses() {
        return this.addresses;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public RealEstate() {
        this.users = new User[0];
        this.properties = new Property[0];
        this.addresses = new Address[10];
        Address address1 = new Address("Tel aviv","Alenbi st");
        Address address2 = new Address("Tel aviv","Rabin st");
        Address address3 = new Address("Tel aviv","Rothschild");
        Address address4 = new Address("Ashkelon","Ben Gurion st");
        Address address5 = new Address("Ashkelon","Bialik st");
        Address address6 = new Address("Ashkelon","Ben Tzvi st");
        Address address7 = new Address("Ashkelon","Eli Cohen st");
        Address address8 = new Address("Ashdod","Eshkol st");
        Address address9 = new Address("Ashdod","Sharet st");
        Address address10 = new Address("Ashdod","Golda st");
        addresses[0]=address1;
        addresses[1] = address2;
        addresses[2] = address3;
        addresses[3] = address4;
        addresses[4] = address5;
        addresses[5] = address6;
        addresses[6] = address7;
        addresses[7] = address8;
        addresses[8] = address9;
        addresses[9] = address10;
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        String username, password, phone;
        boolean regularUser=true, strongPass = false, correctPhone = false;
        int index = 0, counterDig = 0, counterChar = 0, userType;
        System.out.println("Enter a username");
        username = scanner.nextLine();
        if (this.getUsers()!=null) {
            while (index < getUsers().length) {
                if (this.getUsers()[index].getUsername().equals(username)) {
                    System.out.println("The username in use, enter new username");
                    username = scanner.nextLine();
                    index = 0;
                }
                index++;
            }
        }
        index = 0;
        System.out.println("Enter a password");
        password = scanner.nextLine();
        while (strongPass == false){
        while (index < password.length()) {
            if (password.charAt(index) == '%' || password.charAt(index) == '_' || password.charAt(index) == '$') {
                counterChar++;
            }
            if (Character.isDigit(password.charAt(index)) == true) {
                counterDig++;
            }
            index++;
        }
            if (counterChar > 0 && counterDig > 0) {
                strongPass = true;
                break;
            }
            else {
            index=0;
            counterChar=0;
            counterDig=0;
            System.out.println("Enter a strong password with one digit and char %/$/_");
            password = scanner.nextLine();
            }
        }
        System.out.println("Enter a phone number");
        phone = scanner.nextLine();
        while (correctPhone==false)
        {
            index = 0;
            while (index<phone.length()) {
                if (!Character.isDigit(phone.charAt(index))) {
                    correctPhone = false;
                    break;
                }
                else {
                    correctPhone = true;
                }
                index++;
            }
            if (phone.length() != 10 || phone.charAt(0) != '0' || phone.charAt(1) != '5' || correctPhone==false) {
                System.out.println("Enter a correct phone number");
                phone = scanner.nextLine();
            }
            else {
                correctPhone = true;
            }
        }
        System.out.println("1. regular user" + "\n" + "2. real estate");
        userType=scanner.nextInt();
            while (userType!=1 && userType!=2) {
                System.out.println("1. regular user" + "\n" + "2. real estate");
                userType=scanner.nextInt();
            }
        if (userType == 1) {
            regularUser = true;
        }
        if (userType == 2){
            regularUser = false;
        }
        User newUser = new User(username, password, phone, regularUser);
        this.addUser(newUser);
    }

    public void addUser(User newUser) {
        int index = 0;
        User[] newUsers = new User[this.getUsers().length + 1];
        while (index < this.getUsers().length) {
            newUsers[index] = this.getUsers()[index];
            index++;
        }
        newUsers[newUsers.length - 1] = newUser;
        this.setUsers(newUsers);
        System.out.println("The user was created successfully"+"\n");
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        User loginUser = null;
        System.out.println("enter a username");
        username = scanner.nextLine();
        System.out.println("enter a password");
        password = scanner.nextLine();
        int index = 0;
        while (index < getUsers().length) {
            if (getUsers()[index].getUsername().equals(username) && getUsers()[index].getPassword().equals(password) ) {
                loginUser = getUsers()[index];
                System.out.println("login successful"+"\n");
                break;
            }
            index++;
        }
        if (loginUser==null){
            System.out.println("login fail"+"\n");
        }
        return loginUser;
    }
    public boolean postNewProperty(User onlineUser) {
        Scanner scanner = new Scanner(System.in);
        int index = 0, counter = 0, index1 = 0,rent;
        boolean result = false, forRent = false;
        int floor = 0, room, price, kind=0, homeNum;
        Address newAddress = new Address("a","a");
        Property newProperty;
        if (this.getProperties().length != 0) {
            while (index < this.getProperties().length) {
                if (getProperties()[index].getUser().getUsername().equals(onlineUser.getUsername())) {
                    counter++;
                }
                index++;
            }
            if (onlineUser.getRegularUser() == false) {
                if (counter < 10) {
                    result = true;
                } else {
                    System.out.println("you cant publish new property");
                    result = false;
                }
            }
            if (onlineUser.getRegularUser() == true) {
                    if (counter < 3) {
                        result = true;
                    } else {
                        System.out.println("you cant publish new property");
                        result = false;
                    }
                }
            }
             else {
                result = true;
            }
            if (result == true) {
                newAddress = chooseTown();
                System.out.println("Property Type?" + "\n" + "1.apartment" + "\n" + "2.penthouse" + "\n" + "3.private house");
                kind = scanner.nextInt();
                while (kind != 1 && kind != 2 && kind != 3) {
                    System.out.println("Property Type?" + "\n" + "1.apartment" + "\n" + "2.penthouse" + "\n" + "3.private house");
                    kind = scanner.nextInt();
                }
                if (kind == 1) {
                    System.out.println("floor number?");
                    floor = scanner.nextInt();
                }
                System.out.println("room numbers?");
                room = scanner.nextInt();
                System.out.println("home number?");
                homeNum = scanner.nextInt();
                System.out.println("if for rent press 1 else press 2");
                rent = scanner.nextInt();
                while (rent != 1 && rent != 2) {
                    System.out.println("if for rent press 1 else press 2");
                    rent = scanner.nextInt();
                }
                if (rent == 1) {
                    forRent = true;
                }
                System.out.println("price?");
                price = scanner.nextInt();
                newProperty = new Property(newAddress, room, floor, price, homeNum, kind, forRent, onlineUser);
                this.addProperty(newProperty);
                System.out.println("The property was created successfully");
            }
        return result;
            }

    public Address chooseTown() {
        Scanner scanner = new Scanner(System.in);
        int index1 = 0, index2 = 0,counter = 0, index3=0;
        boolean correctTown = false;
        String town, street = "";
        Address newAddress;
        String[] townsName = new String[getAddresses().length];
        while (index1 < getAddresses().length) {
            while (index2 < townsName.length) {
                if (getAddresses()[index1].getTownName().equals(townsName[index2])) {
                    counter++;
                    break;
                }
                index2++;
            }
            if (counter==0){
                townsName[index3] = getAddresses()[index1].getTownName();
                index3++;
            }
            index1++;
            index2 = 0;
            counter=0;
        }
        index1 = 0;
        while (index1 < townsName.length&&townsName[index1]!=null) {
            System.out.println(townsName[index1]);
            index1++;
        }
        System.out.println("enter a town name"+"\n");
        town = scanner.nextLine();
        index1 = 0;
        while (index1 < townsName.length) {
            if (town.equals(townsName[index1])) {
                correctTown = true;
                break;
            }
            index1++;
        }
        if (correctTown == true) {
            street = chooseStreet(town);
        } else {
            System.out.println("the town doesn't exist"+"\n");
            chooseTown();
        }
        newAddress = new Address(town, street);
        return newAddress;
    }

    public String chooseStreet(String town) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        String street;
        boolean correctStreet = false;
        while (index < getAddresses().length) {
            if (getAddresses()[index].getTownName().equals(town)) {
                System.out.println(getAddresses()[index].getStreetName());
            }
            index++;
        }
        System.out.println("choose street");
        street = scanner.nextLine();
        index = 0;
        while (index < getAddresses().length) {
            if (getAddresses()[index].getStreetName().equals(street)) {
                correctStreet = true;
                break;
            }
            index++;
        }
        if (correctStreet == false) {
            System.out.println("the street doesn't exist");
            chooseStreet(town);
        }
        return street;
    }

    public void addProperty(Property newProperty) {
        int index = 0;
        Property[] newProperties = new Property[properties.length + 1];
        while (index < this.properties.length) {
            newProperties[index] = properties[index];
            index++;
        }
        newProperties[newProperties.length - 1] = newProperty;
        this.setProperties(newProperties);
    }

    public void removeProperty(User onlineUser) {
        Scanner scanner = new Scanner(System.in);
        int index1 = 0, index2 = 0, counter = 0, userChoice = 0;
        while (index1 < getProperties().length) {
            if (getProperties()[index1].getUser() == onlineUser) {
                System.out.println(index1 + " . " + getProperties()[index1].toString());
                counter++;
            }
            index1++;
        }
        if (counter == 0) {
            System.out.println("no have properties");
        } else {
            System.out.println("choose property to remove");
            userChoice = scanner.nextInt();
        }
        getProperties()[userChoice] = null;
        Property[] newProperties = new Property[getProperties().length - 1];
        index1 = 0;
        while (index1 < getProperties().length) {
            if (getProperties()[index1] != null) {
                newProperties[index2] = getProperties()[index1];
                index2++;
            }
            index1++;
        }
        setProperties(newProperties);
    }

    public void printUserProperties(User onlineUser) {
        int index1 = 0;
            while (index1 < getProperties().length) {
                if (getProperties()[index1].getUser() == onlineUser) {
                    System.out.println(index1 + " . " + getProperties()[index1].toString());
                }
                index1++;
        }
    }
    public void printAllProperties() {
        int index1 = 0;
        if (getProperties().length==0){
            System.out.println("don't have properties");
        }
        else {
            while (index1 < getProperties().length) {
                System.out.println(index1 + " . " + getProperties()[index1].toString());
                index1++;
            }
        }
    }
    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        int index = 0, counter = 0, index2=0;
        int kind, minPrice, maxPrice = 0, room, forRent;
        System.out.println("the property is for rent? 1.yes 2.no -999. for all");
        forRent = scanner.nextInt();
        System.out.println("the kind of property? 1.regular house 2.penthouse 3.privet house -999. for all");
        kind = scanner.nextInt();
        System.out.println("the number of room? -999. for all");
        room = scanner.nextInt();
        System.out.println("the min price? -999. for all range of price");
        minPrice = scanner.nextInt();
        if (minPrice != -999) {
            System.out.println("the max price?");
            maxPrice = scanner.nextInt();
        }
        Property[] tempProperty = new Property[this.getProperties().length];
        while (index < tempProperty.length) {
            tempProperty[index] = this.getProperties()[index];
            index++;
        }
        index = 0;
        while (index < tempProperty.length) {
            if (forRent == -999) {
                break;
            } else {
                if (forRent == 1) {
                    if (tempProperty[index].getForRent() != true) {
                        tempProperty[index] = null;
                    }
                }
                if (forRent == 2) {
                    if (tempProperty[index].getForRent() == true) {
                        tempProperty[index] = null;
                    }
                }
            }
            index++;
        }
        index = 0;
        while (index < tempProperty.length) {
            if (kind == -999) {
                break;
            } else {
                if (tempProperty[index].getKindProperty() != kind) {
                    tempProperty[index] = null;
                }
            }
            index++;
        }
        index = 0;
        while (index < tempProperty.length) {
            if (room == -999) {
                break;
            } else {
                if (tempProperty[index].getRoom() != room) {
                    tempProperty[index] = null;
                }
            }
            index++;
        }
        index = 0;
        while (index < tempProperty.length) {
            if (minPrice == -999) {
                break;
            } else {
                if (tempProperty[index].getPrice() < minPrice || tempProperty[index].getPrice() > maxPrice) {
                    tempProperty[index] = null;
                }
            }
            index++;
        }
        index = 0;
        Property [] filterProperty;
        while (index<tempProperty.length){
            if (tempProperty[index]!=null){
                counter++;
            }
            index++;
        }
        index = 0;
        filterProperty = new Property[counter];
        while (index<tempProperty.length){
            if (tempProperty[index]!=null){
                filterProperty[index2] = tempProperty[index];
                index2++;
            }
            index++;
        }
        return filterProperty;
    }
}



