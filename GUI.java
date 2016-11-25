import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUI implements ActionListener{
  
  ArrayList personalsList;
  PersonalDAO pDAO;
  
  JFrame myFrame;
  
  //labels
  
  JLabel 1Name, 1Address, 1Phone, 1Email;

  //text fields
  JTextField tfName, tfAddress, tfPhone, tfEmail;
  
  //buttons
  JButton bSave, bDelete, bClear, bUpdate, bSearch, bForward, bBack, bExit;
  
  String name, address, email;
  int phone;
  
  // used to naviagate using >> and << buttons
  int recordNumber;
  
  
  //*******************************************************************************
  
  /* Gui Constructor */
  public GUI(){
    
    name = "";
    address = "";
    email = "";
    phone = 0;
    
    recordNumber = -1;
    
    initGUI();
    
    personalList = new ArrayList();
    
    // creating PersonalDAO object
    pDAO = new PersonalDAO();
  }
  
  //**********************************************************************************
  /*initGUI function will initialize our  GUI*/
  
  public void initGUI(){
    
    
       /*Create a frame, get it's contantpane and set layout*/
    myFRame = new JFrame ("Address Book");
    
    Container c = myFrame.getContentPane();
    c.setLayout(new FlowLayout());
    
    /*initializing labels*/
    1Name    = new JLabel("Name");
    1Address = new JLabel("Address"):
    1Phone   = new JLabel("Phone");
    1Email   = new JLabel("Email");
    
    /*initializing text fields*/
    
    ftName    = new JTextField(20);
    ftAddress = new JTextField(20);
    ftPhone   = new JTextField(20);
    ftEmail   = new JTextField(20);
    
    /*initializing buttons*/
    
    bSave    = new JButton("Save");
    bDelete  = new JButton("Delete");
    bClear   = new JButton("Clear");
    bUpdate  = new JButton("Update");
    bSearch  = new JButton("Search");
    
    bForward  = new JButton(">>");
    bBack     = new JButton("Back");
    bExit     = new JButton("Exit");
    
    /*add all initialized components to the container*/
    
    c.add(1Name);
    c.add(tfName);
    
    c.add(1Address);
    c.add(tfAddress);
    
    c.add(1Phone);
    c.add(tfPhone);
    
    c.add(1Email);
    c.add(tfEmail);
    
    c.add(bSave);
    c.add(bDelete);
    c.add(Update);
    
    c.add(bBack);
    c.add(bSearch);
    c.add(bFoward);
    
    c.add(bClear);
    c.add(bExit);
    
    /*registering buttons with actionListener*/
    bSave.addActionListener(this);
    bDelete.addActionListener(this);
    bClear.addActionListener(this);
    bUpdate.addActionListener(this);
    bSearch.addActionListener(this);
    bForward.addActionListener(this);
    bBack.addActionListener(this);
    bExit.addActionListener(this);
    
    myFrame.setSize(240,315);
    myFrame.setResizable(false);
    myFrame.setVisible(true);
    
   
    
}//end initGUI method

