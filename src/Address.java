
public class Address {

    private String townName;
    private String streetName;

    public Address (String townName, String streetName){
        this.townName = townName;
        this.streetName = streetName;
    }

    public String getTownName(){
        return this.townName;
    }
    public String getStreetName(){
        return this.streetName;
    }
    public void setTownName(String townName){
        this.townName = townName;
    }
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }
}
