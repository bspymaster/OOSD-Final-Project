import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class MainWindowUI extends JFrame {
    
    private Safe safe;
    
    private JPanel mainWindow;
    
    private JList listBox;
    private JScrollPane scrollListBox;
    
    private JLabel nameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel descriptionLabel;
    private JLabel websiteLabel;
    
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField descriptionField;
    private JTextField websiteField;
    
    private JButton addKeyButton;
    private JButton editKeyButton;
    private JButton removeKeyButton;
    

    // Constructor of main frame
    public MainWindowUI(Safe _safe) {
        
        safe = _safe;
        
        // Set the frame data
        mainWindow = new JPanel();
        mainWindow.setLayout(new FlowLayout());
        setTitle("Password Safe");
        setSize(700,250);
        setResizable(false);
        
        // Create master panel
        getContentPane().add(mainWindow);

        // List of key entries
        listBox = new JList();
        listBox.setFixedCellWidth(200);
        updateJList(safe.getKeyList());
        
        listBox.addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent e){
                    int keyIndex = listBox.getSelectedIndex();
                    if(keyIndex < 0){
                        clearFields();
                    }else {
                        updateFields(safe.getKeyList().get(keyIndex));
                    }
                }
            }
        );
        
        scrollListBox = new JScrollPane(listBox);
        
        // labels for each entry
        nameLabel = new JLabel("Name:");
        websiteLabel = new JLabel("Website:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        descriptionLabel = new JLabel("Description:");
        
        //fields for each entry
        nameField = new JTextField(30);
        nameField.setEditable(false);
        usernameField = new JTextField(30);
        usernameField.setEditable(false);
        passwordField = new JTextField(30);
        passwordField.setEditable(false);
        descriptionField = new JTextField(30);
        descriptionField.setEditable(false);
        websiteField = new JTextField(30);
        websiteField.setEditable(false);
        
        // Add entry button
        addKeyButton = new JButton("Add a Key");
        addKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.out.println("generate a new window to create a new key");
                    //TEMP
                    safe.addKey(new Key("addedKey","addedUsername",new Password("12345")));
                    
                    updateJList(safe.getKeyList());
                }
            }
        );
        
        // Edit entry button
        editKeyButton = new JButton("Edit a Key");
        editKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    System.out.println("generate a new window to edit a new key");
                }
            }
        );
        
        // Remove entry button
        removeKeyButton = new JButton("Remove a Key");
        removeKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    int[] removeIndices = listBox.getSelectedIndices();
                    if(removeIndices.length > 0){
                        int optionSelected = JOptionPane.showConfirmDialog(mainWindow,"Are you sure you want to delete the selected key(s)?","Confirm Deletion",JOptionPane.YES_NO_OPTION); //0 if yes, 1 if no
                        if(optionSelected == 0){
                            for(int i = 0; i < removeIndices.length; i++){
                                safe.removeKeyByIndex(removeIndices[i]-i);//remove the original index minus the number of indices already removed (since after removing a key, the rest get shifted down to fill the space)
                            }
                            updateJList(safe.getKeyList());
                        }
                    }
                }
            }
        );
        
        // TOP ROW
        JPanel topRow = new JPanel();
        topRow.setLayout(new GridLayout());
        
        topRow.add(scrollListBox); // top grid(0,0)
        
        JPanel entryInfoPanel = new JPanel(); // contains the entry data
        entryInfoPanel.setLayout(new BoxLayout(entryInfoPanel,BoxLayout.Y_AXIS));
        
        entryInfoPanel.add(nameLabel);
        entryInfoPanel.add(nameField);
        entryInfoPanel.add(usernameLabel);
        entryInfoPanel.add(usernameField);
        entryInfoPanel.add(passwordLabel);
        entryInfoPanel.add(passwordField);
        entryInfoPanel.add(websiteLabel);
        entryInfoPanel.add(websiteField);
        entryInfoPanel.add(descriptionLabel);
        entryInfoPanel.add(descriptionField);
        
        topRow.add(entryInfoPanel); // top grid(0,1)
        
        mainWindow.add(topRow);
        
        //BOT ROW
        JPanel botRow = new JPanel();
        botRow.setLayout(new GridLayout());
        
        botRow.add(addKeyButton); // bottom grid(0,0)
        botRow.add(editKeyButton); // bottom grid(0,1)
        botRow.add(removeKeyButton); // bottom grid(0,2)
        
        mainWindow.add(botRow);
    }
    
    private void updateJList(ArrayList<Key> list){
        String[] JListNameList = new String[list.size()];
        for(int i = 0; i < list.size();i++){
            JListNameList[i] = list.get(i).getName();
        }
        listBox.setListData(JListNameList);
    }
    private void updateFields(Key key){
        nameField.setText(key.getName());
        usernameField.setText(key.getUsername());
        passwordField.setText(key.getPasswordObj().getPassword());
        websiteField.setText(key.getAddress());
        descriptionField.setText(key.getDescription());
    }
    private void clearFields(){
        nameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        websiteField.setText("");
        descriptionField.setText("");
    }
}
