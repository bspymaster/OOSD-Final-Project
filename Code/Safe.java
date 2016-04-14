import java.util.ArrayList;

public class Safe {
    private ArrayList<Key> keyList;
    private int numDuplicates;
    
    public Safe(){
        keyList = new ArrayList();
        numDuplicates = 0;
    }
    
    public void addKey(Key entry){
        Key duplicateKey = getKeyByName(entry.getName()); //gets a duplicate key, if any
        if(duplicateKey == null && entry.checkName() == 0){ //no duplicates, and Key class approved the name
            keyList.add(entry);
        }else{ //replace the name with UnnamedKey_X, where X is the number of keys it has replaced previously 
            numDuplicates++;
            String newName = "UnnamedKey_" + Integer.toString(numDuplicates);
            entry.setName(newName);
            
            keyList.add(entry);
        }
    }
    
    public Key getKeyByUsername(String username){
        int index = findKeyIndex(username,"username");
        if(index == -1){
            return null; //matched key not found
        }else{
            return keyList.get(index); //returns key with matching name
        }
    }
    public Key getKeyByName(String name){
        int index = findKeyIndex(name,"name");
        if(index == -1){
            return null; //matched key not found
        }else{
            return keyList.get(index); //returns key with matching name
        }
    }
    
    public ArrayList<Key> getKeyList(){
        return keyList;
    }
    
    public Key removeKeyByName(String name){
        int index = findKeyIndex(name,"name");
        if(index == -1){
            return null; //matched key not found
        }else{
            return keyList.remove(index); //returns key that was removed
        }
    }
    public Key removeKeyByIndex(int index){
        if(index < 0){
            return null; //invalid index
        }else{
            return keyList.remove(index); //returns key that was removed
        }
    }
    
    private int findKeyIndex(Object searchTerm, String field){
        for(int i = 0; i < keyList.size(); i++){
            if(field.equals("name")){
                if(keyList.get(i).getName().equals(searchTerm)){
                    return i;
                }
            }
            else if(field.equals("username")){
                if(keyList.get(i).getUsername().equals(searchTerm)){
                    return i;
                }
            }
        }
        return -1;
    }
}
