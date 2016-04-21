public class CaesarCipher implements Encryptor{
    public String encrypt(String plainText){
        String cipherText = "";
        for(int i = 0; i < plainText.length();i++){
            char c = plainText.charAt(i);
            switch(c){
                case 'A': cipherText += 'B'; break;
                case 'B': cipherText += 'C'; break;
                case 'C': cipherText += 'D'; break;
                case 'D': cipherText += 'E'; break;
                case 'E': cipherText += 'F'; break;
                case 'F': cipherText += 'G'; break;
                case 'G': cipherText += 'H'; break;
                case 'H': cipherText += 'I'; break;
                case 'I': cipherText += 'J'; break;
                case 'J': cipherText += 'K'; break;
                case 'K': cipherText += 'L'; break;
                case 'L': cipherText += 'M'; break;
                case 'M': cipherText += 'N'; break;
                case 'N': cipherText += 'O'; break;
                case 'O': cipherText += 'P'; break;
                case 'P': cipherText += 'Q'; break;
                case 'Q': cipherText += 'R'; break;
                case 'R': cipherText += 'S'; break;
                case 'S': cipherText += 'T'; break;
                case 'T': cipherText += 'U'; break;
                case 'U': cipherText += 'V'; break;
                case 'V': cipherText += 'W'; break;
                case 'W': cipherText += 'X'; break;
                case 'X': cipherText += 'Y'; break;
                case 'Y': cipherText += 'Z'; break;
                case 'Z': cipherText += 'A'; break;
                case 'a': cipherText += 'b'; break;
                case 'b': cipherText += 'c'; break;
                case 'c': cipherText += 'd'; break;
                case 'd': cipherText += 'e'; break;
                case 'e': cipherText += 'f'; break;
                case 'f': cipherText += 'g'; break;
                case 'g': cipherText += 'h'; break;
                case 'h': cipherText += 'i'; break;
                case 'i': cipherText += 'j'; break;
                case 'j': cipherText += 'k'; break;
                case 'k': cipherText += 'l'; break;
                case 'l': cipherText += 'm'; break;
                case 'm': cipherText += 'n'; break;
                case 'n': cipherText += 'o'; break;
                case 'o': cipherText += 'p'; break;
                case 'p': cipherText += 'q'; break;
                case 'q': cipherText += 'r'; break;
                case 'r': cipherText += 's'; break;
                case 's': cipherText += 't'; break;
                case 't': cipherText += 'u'; break;
                case 'u': cipherText += 'v'; break;
                case 'v': cipherText += 'w'; break;
                case 'w': cipherText += 'x'; break;
                case 'x': cipherText += 'y'; break;
                case 'y': cipherText += 'z'; break;
                case 'z': cipherText += 'a'; break;
                default: cipherText += c; break;
            }
        }
        
        return cipherText;
    }
    public String decrypt(String cipherText){
        String plainText = "";
        for(int i = 0; i < cipherText.length();i++){
            char c = cipherText.charAt(i);
            
            switch(c){
                case 'A': plainText += 'Z'; break;
                case 'B': plainText += 'A'; break;
                case 'C': plainText += 'B'; break;
                case 'D': plainText += 'C'; break;
                case 'E': plainText += 'D'; break;
                case 'F': plainText += 'E'; break;
                case 'G': plainText += 'F'; break;
                case 'H': plainText += 'G'; break;
                case 'I': plainText += 'H'; break;
                case 'J': plainText += 'I'; break;
                case 'K': plainText += 'J'; break;
                case 'L': plainText += 'K'; break;
                case 'M': plainText += 'L'; break;
                case 'N': plainText += 'M'; break;
                case 'O': plainText += 'N'; break;
                case 'P': plainText += 'O'; break;
                case 'Q': plainText += 'P'; break;
                case 'R': plainText += 'Q'; break;
                case 'S': plainText += 'R'; break;
                case 'T': plainText += 'S'; break;
                case 'U': plainText += 'T'; break;
                case 'V': plainText += 'U'; break;
                case 'W': plainText += 'V'; break;
                case 'X': plainText += 'W'; break;
                case 'Y': plainText += 'X'; break;
                case 'Z': plainText += 'Y'; break;
                case 'a': plainText += 'z'; break;
                case 'b': plainText += 'a'; break;
                case 'c': plainText += 'b'; break;
                case 'd': plainText += 'c'; break;
                case 'e': plainText += 'd'; break;
                case 'f': plainText += 'e'; break;
                case 'g': plainText += 'f'; break;
                case 'h': plainText += 'g'; break;
                case 'i': plainText += 'h'; break;
                case 'j': plainText += 'i'; break;
                case 'k': plainText += 'j'; break;
                case 'l': plainText += 'k'; break;
                case 'm': plainText += 'l'; break;
                case 'n': plainText += 'm'; break;
                case 'o': plainText += 'n'; break;
                case 'p': plainText += 'o'; break;
                case 'q': plainText += 'p'; break;
                case 'r': plainText += 'q'; break;
                case 's': plainText += 'r'; break;
                case 't': plainText += 's'; break;
                case 'u': plainText += 't'; break;
                case 'v': plainText += 'u'; break;
                case 'w': plainText += 'v'; break;
                case 'x': plainText += 'w'; break;
                case 'y': plainText += 'x'; break;
                case 'z': plainText += 'y'; break;
                default: plainText += c; break;
            }
        }
        
        return plainText;
    }
}
