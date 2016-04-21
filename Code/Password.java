public class Password {
    private String encryptedPwd;
    private Encryptor encryptor;
    
    public Password(String plainText,Encryptor _encryptor){
        encryptor = _encryptor;
        encryptedPwd = encryptor.encrypt(plainText);
    }
    
    public String getPassword(){
        return encryptor.decrypt(encryptedPwd);
    }
    public void setEncryptedPassword(String _encryptedPwd){
        encryptedPwd = _encryptedPwd;
    }
}
