public class Property {

    private Address address;
    private int room;
    private int floor;
    private int price;
    private int homeNum;
    private int kindProperty;
    private boolean forRent;
    private User user;

    public Property (Address address, int room, int floor, int price, int homeNum, int kindProperty, boolean forRent, User user){
        this.address = address;
        this.room = room;
        this.floor = floor;
        this.price = price;
        this.homeNum = homeNum;
        this.kindProperty = kindProperty;
        this.forRent = forRent;
        this.user = user;
    }

    public Address getAddress (){
        return this.address;
    }
    public int getRoom (){
        return this.room;
    }
    public int getFloor (){
        return this.floor;
    }
    public int getPrice (){
        return this.price;
    }
    public int getHomeNum (){
        return this.homeNum;
    }
    public int getKindProperty (){
        return this.kindProperty;
    }
    public boolean getForRent (){
        return this.forRent;
    }
    public User getUser (){
        return this.user;
    }
    public void setAddress (Address address){
        this.address = address;
    }
    public void setRoom (int room){
        this.room = room;
    }
    public void setFloor (int floor){
        this.floor = floor;
    }
    public void setPrice (int price){
        this.price = price;
    }
    public void setHomeNum (int homeNum){
        this.homeNum = homeNum;
    }
    public void setKindProperty (int kindProperty){
        this.kindProperty = kindProperty;
    }
    public void setForRent (boolean forRent){
        this.forRent = forRent;
    }
    public void setUser (User user){
        this.user = user;
    }
    public String toString (){
        String stKInd="", stUser, stRent,finalSt;
        if (this.kindProperty==1){
            stKInd = "Regular apartment";
        }
        if (this.kindProperty==2){
            stKInd = "Penthouse";
        }
        if (this.kindProperty==3){
            stKInd = "Privat house";
        }
        if (this.getForRent()==true){
            stRent = "for rent";
        }
        else {
            stRent = "for sale";
        }
        if (this.getUser().getRegularUser()==true){
            stUser = "(private man)";
        }
        else {
            stUser = "(real estate broker)";
        }
        if (this.getFloor()==0){
           finalSt=(stKInd + " - "+stRent+": "+this.getRoom()+" rooms"+"\n"+
                   "Price: "+this.getPrice()+"$"+
                   "\n"+"Contact info: "+this.getUser().getUsername() + " " + this.getUser().getPhone()+" "+ stUser);
        }
        else {
            finalSt = (stKInd + " - "+stRent+": "+this.getRoom()+" rooms, floor "+this.getFloor() +"\n"+
                    "Price: "+this.getPrice()+"$"+
                    "\n"+"Contact info: "+this.getUser().getUsername() + " " + this.getUser().getPhone()+" "+ stUser);
        }
        return finalSt;
    }

}

