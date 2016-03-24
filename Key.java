public class Key {
    private String name;
    private Password pass;
    private String description;
    private String address;
    
    public Key(String _name, Password _pass){
        name = _name;
        pass = _pass;
        description = "";
        address = "";
    }
    
    public Key(String _name, Password _pass, String _description, String _address){
        name = _name;
        pass = _pass;
        description = _description;
        address = _address;
    }
    
    public String getName(){
        return name;
    }
    public Password getPasswordObj(){
        return pass;
    }
    public String getDescription(){
        return description;
    }
    public String getAddress(){
        return address;
    }
    
    public void setName(String _name){
        name = _name;
    }
    public void setPassword(Password _pass){
        pass = _pass;
    }
    public void setDescription(String _description){
        description = _description;
    }
    public void setAddress(String _address){
        address = _address;
    }
    
    public int checkName(){
        if(name.length() < 1){
            return -1;
        }else{
            return 0;
        }
    }
}
