public class Password {
    private String encryptedPwd;
    
    public Password(String plainText){
        encryptedPwd = encrypt(plainText);
    }
    
    public String getPassword(){
        return decrypt(encryptedPwd);
    }
    public void setEncryptedPassword(String _encryptedPwd){
        encryptedPwd = _encryptedPwd;
    }
    
    private String encrypt(String plainText){
        String cipherText = plainText;
        return cipherText;
    }
    private String decrypt(String cipherText){
        String plainText = cipherText;
        return plainText;
    }
}
