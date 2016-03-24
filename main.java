import java.util.Scanner;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main {
    
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        Safe safe = new Safe();
        
        Key key1 = new Key("key1",new Password("abc"),"This is a description","www.nowhere.com");
        Key key2 = new Key("key2",new Password("this key does not have a description or website"));
        Key noName = new Key("",new Password("qwerty12345@&$"),"This key had '' as it's name.","www.google.com");
        Key copyName = new Key("key1",new Password(""),"This key had 'key1' as it's name & has no password or website","");
        
        safe.addKey(key1);
        safe.addKey(key2);
        safe.addKey(noName);
        safe.addKey(copyName);
        
        ArrayList<Key> listObj = safe.getKeyList();
        
        for(int i = 0; i < listObj.size();i++){
            System.out.println(listObj.get(i).getName());
            System.out.println("  password:\t" + listObj.get(i).getPasswordObj().getPassword());
            System.out.println("  description:\t" + listObj.get(i).getDescription());
            System.out.println("  address:\t" + listObj.get(i).getAddress());
        }
        
        safe.removeKeyByName("key2");
        System.out.println("\n\nkey2 was removed.\n\n");
        listObj = safe.getKeyList();
        
        for(int i = 0; i < listObj.size();i++){
            System.out.println(listObj.get(i).getName());
            System.out.println("  password:\t" + listObj.get(i).getPasswordObj().getPassword());
            System.out.println("  description:\t" + listObj.get(i).getDescription());
            System.out.println("  address:\t" + listObj.get(i).getAddress());
        }
        
        
        /* Framework for basic Java window
        JFrame mainWindow = new JFrame();
        
        JButton addKeyButton = new JButton("Add a Key");
        addKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.out.println("generate a new window to create a new key");
                }
            }
        );
        
        JButton removeKeyButton = new JButton("Remove a Key");
        removeKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.out.println("generate a new window to remove a new key");
                }
            }
        );
        
        mainWindow.setLayout(new FlowLayout());
        
        mainWindow.add(addKeyButton);
        mainWindow.add(removeKeyButton);
        
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Password Safe");
        mainWindow.pack();
        mainWindow.setVisible(true);
        */
        
    }
}
