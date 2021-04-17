public class name_password {
    private String Name;
    private String Password;

    public name_password(String name, String password){

        this.Name = name;
        this.Password = password;

    }
    public String toString (){
        System.out.println("Name: " + getName());
        System.out.println("Password: " + getPassword());
        return null;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}//end class
