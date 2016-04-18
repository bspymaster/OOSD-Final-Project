import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class MainWindowUI extends JFrame {
    
    //the safe
    private Safe safe;
    private int okButtonMode; //0 for off, 1 for add key, 2 for edit key
    private int editIndex; //index of the smallest item selected, for key editing purposes
    
    //main window elements
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
    
    //secondary window elements
    private JFrame secondaryFrame;
    
    private JPanel editPanel;
    private JLabel s_nameLabel;
    private JLabel s_usernameLabel;
    private JLabel s_passwordLabel;
    private JLabel s_descriptionLabel;
    private JLabel s_websiteLabel;
    
    private JTextField s_nameField;
    private JTextField s_usernameField;
    private JTextField s_passwordField;
    private JTextField s_descriptionField;
    private JTextField s_websiteField;
    
    private JButton s_confirmButton;
    private JButton s_cancelButton;

    // Constructor of main frame
    public MainWindowUI(Safe _safe) {
        
        safe = _safe;
        okButtonMode = 0;
        
        // Set the main frame data
        mainWindow = new JPanel();
        mainWindow.setLayout(new FlowLayout());
        setTitle("Password Safe");
        setSize(700,250);
        setResizable(false);
        
        // Set the secondary frame data
        secondaryFrame = new JFrame();
        secondaryFrame.setVisible(false);
        secondaryFrame.setDefaultCloseOperation(secondaryFrame.HIDE_ON_CLOSE);
        setResizable(false);
        
        createMainWindow();
        
        createSecondaryWindow();
    }
    private void createMainWindow(){
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
                    s_nameField.setText("");
                    s_usernameField.setText("");
                    s_passwordField.setText("");
                    s_websiteField.setText("");
                    s_descriptionField.setText("");
                    
                    secondaryFrame.setTitle("Add an Entry");
                    okButtonMode = 1;
                    secondaryFrame.setVisible(true);
                    
                    updateJList(safe.getKeyList());
                }
            }
        );
        
        // Edit entry button
        editKeyButton = new JButton("Edit a Key");
        editKeyButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    editIndex = listBox.getSelectedIndex();
                    
                    if(editIndex > -1){
                        Key keyToModify = safe.getKeyByIndex(editIndex);
                        s_nameField.setText(keyToModify.getName());
                        s_usernameField.setText(keyToModify.getUsername());
                        s_passwordField.setText(keyToModify.getPasswordObj().getPassword());
                        s_websiteField.setText(keyToModify.getAddress());
                        s_descriptionField.setText(keyToModify.getDescription());
                        
                        secondaryFrame.setTitle("Edit an Entry");
                        okButtonMode = 2;
                        secondaryFrame.setVisible(true);
                        
                        updateJList(safe.getKeyList());
                    }
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
    private void createSecondaryWindow(){
        
        JPanel editPanel = new JPanel(); // contains the entry data
        
        secondaryFrame.getContentPane().add(editPanel);
        editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.Y_AXIS));
        
        // labels for each entry
        s_nameLabel = new JLabel("Name:");
        s_websiteLabel = new JLabel("Website:");
        s_usernameLabel = new JLabel("Username:");
        s_passwordLabel = new JLabel("Password:");
        s_descriptionLabel = new JLabel("Description:");
        
        //fields for each entry
        s_nameField = new JTextField(40);
        s_usernameField = new JTextField(40);
        s_passwordField = new JTextField(40);
        s_descriptionField = new JTextField(40);
        s_websiteField = new JTextField(40);
        
        s_confirmButton = new JButton("Ok");
        s_confirmButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    if(okButtonMode == 1){
                        safe.addKey(new Key(s_nameField.getText(),s_usernameField.getText(),new Password(s_passwordField.getText()),s_websiteField.getText(),s_descriptionField.getText()));
                    }else if(okButtonMode == 2){
                        safe.removeKeyByIndex(editIndex);
                        safe.addKey(new Key(s_nameField.getText(),s_usernameField.getText(),new Password(s_passwordField.getText()),s_websiteField.getText(),s_descriptionField.getText()));
                    }
                    okButtonMode = 0;
                    updateJList(safe.getKeyList());
                    secondaryFrame.setVisible(false);
                }
            }
        );
        s_cancelButton = new JButton("Cancel");
        s_cancelButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    okButtonMode = 0;
                    updateJList(safe.getKeyList());
                    secondaryFrame.setVisible(false);
                }
            }
        );
        
        editPanel.add(s_nameLabel);
        editPanel.add(s_nameField);
        editPanel.add(s_usernameLabel);
        editPanel.add(s_usernameField);
        editPanel.add(s_passwordLabel);
        editPanel.add(s_passwordField);
        editPanel.add(s_websiteLabel);
        editPanel.add(s_websiteField);
        editPanel.add(s_descriptionLabel);
        editPanel.add(s_descriptionField);
        editPanel.add(s_confirmButton);
        editPanel.add(s_cancelButton);
        
        secondaryFrame.pack();
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
