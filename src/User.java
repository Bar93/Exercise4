public class User {

    private String username;
    private String password;
    private String phone;
    private boolean regularUser;

    public User (String username, String password, String phone, boolean regularUser){
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.regularUser = regularUser;
    }

    public String getUsername (){
        return this.username;
    }
    public String getPassword (){
        return this.password;
    }
    public String getPhone (){
        return this.phone;
    }
    public boolean getRegularUser (){
        return this.regularUser;
    }
    public void setUsername (String username){
        this.username = username;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public void setPhone (String phone){
        this.phone = phone;
    }
    public void setRegularUser (boolean regularUser){
        this.regularUser = regularUser;
    }



}
