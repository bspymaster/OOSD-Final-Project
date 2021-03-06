import java.util.Scanner;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main {
    
    public static void main (String args[]) {
        //create an instance of the safe
        Safe safe = new Safe();
        
        //create an encryptor instance
        CaesarCipher cipher = new CaesarCipher();
        
        //generate a few keys for testing
        Key key1 = new Key("key1","key1",new Password("ABC",cipher),"This is a description","www.nowhere.com");
        Key key2 = new Key("key2","key2",new Password("this key does not have a description or website",cipher));
        Key noName = new Key("","noName",new Password("qwerty12345@&$",cipher),"This key had '' as it's name.","www.google.com");
        Key copyName = new Key("key1","copyName",new Password("",cipher),"This key had 'key1' as it's name & has no password or website","");
        
        safe.addKey(key1);
        safe.addKey(key2);
        safe.addKey(noName);
        safe.addKey(copyName);
        
        //create the application
        MainWindowUI mainFrame = new MainWindowUI(safe,cipher);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
