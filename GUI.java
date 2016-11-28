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
    
    tfName    = new JTextField(20);
    tfAddress = new JTextField(20);
    tfPhone   = new JTextField(20);
    tfEmail   = new JTextField(20);
    
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
//********************************************************************************************
             //implementing ActionListener's method i.e actionPerformed
  public void actionPerformed (ActionEvent){
    
            /*if button bSave generates the event*/
    if (event.getSource() == bSave){
      savePerson();
      
      //Clear fields
      clear();
    }
    
           /*if button bDelet generates the event*/
    else if (event.getSource () == bDelete){
      deletePerson ();
      
      //clear fields
      clear();
      
    }
     
         /*if button bUpdate generates the event */
    else if (event.getSource () == bUpdate){
      updatePerson();
      
      //clear fields
      clear();
      
    }
    
        /*if button bSearch generates the event*/
    else if (event.getSource () == bSearch){
      searchPerson();
    
    }
  
      /*if button bForward generates the event */
  else if (event.getSource () == bForward){
   
    displayNextRecord();
    }
    

     /*if button bBack generates the event */
else if (event.getSource () == bBack){
  
  displayPreviousRecord();
  
    }
    /*if button bClear generates the event*/
    else if (event.getSource () == bClear){
      
      clear();
      
    }
    
    /*if button bExit generates the event */
    else if (event.getSource () == bExit){
      
      System.exit(0);
      
    }
  }//End actionPerformed
  
  //********************************************************************************************
  
  //used to save person information into DataBase using PersonDAO
  
  public void savePerson(){
    
     /*get values from text fields*/
    name    = tfName.getText();
    address = tfAddress.getText();
    phone   = Integer.parseInt(tfPhone.getText());
    email   = tfEmail.getText();
    
    if(name.quals ("")){
      
      JOptionPane.showMessageDialog(null, "Please enter person name.");
    
    }else{
      
      /*Create a new PersonInfo object and pass it to PersonDAO to save it*/
     PersonInfo person = new PersonInfo(name, address, phone, Email);
     pDAO.savePerson(person);
      
      JOptionPane.showMessageDialog(null, "Records added");
    
    }
  }
  
  //************************************************************************************************
  
     //used to delete person information from DataBase, using PersonDAO
  public void deletePerson(){
    
       /*get values from text fields*/
    name = tfName.getText();
    
    if (name.equals("")){
      
      JOptionPane.showMessageDialog(null, "Please enter person name to delete.");
    
    }else{
      
          /*remove Person of the given name*/
      int no = pDAO.removePerson(name);
      JOptionPane.showMessageDialog(null, no + "Records(s) deleted.");
      
    }
  }
  
  //*******************************************************************************************************
  //used to updatePerson record in DataBase using PersonDAO
  public void updatePerson(){
    
          //Generally update is performed after search
         //need to find out which record is going to update
    
    if (recordNumber >= 0 && recordNumber < personList.size()){
      
      PersonInfo person = (PersonInfo)personList.get(recordNumber);
      
      int id = person.getId();
      
      /*get values from text fields*/
      
      name    = tfName.getText();
      address = tfAddress.getText();
      phone   = Integer.parseInt(tfPhone.getText());
      email   = tfEmail.getText();
      
       /*update data of the given person name*/
      
      person = new PersonInfo(id, name, address, phone, email);
      pDAO.updatePerson(person);
      
      JOptionPane.showMessageDialog(null, "Person ifo record updated succesfully.");
      
    }else{
      
      JOptin.showMessageDialog(null, "No record to update.");
      
    }
  }
  
  //*********************************************************************************************************
  
  //used to search person against given name and display to find results
 public void searchPerson(){
   
     /*get values from text fields*/
  name = tfName.getText();
   
    /*clear contents of ArrayList if there are any records from previous search*/
   personsList.clear();
   
   //initialize recordNumber to 0
   recordNumber = 0;
   
    if(name.equals("")){
      
      JOption.showMessageDialog(null,"Please enter person name to search.");
      
    }else{
      
                 /*get an ArrayList of searched person using PersonDAO*/
                 personsList = pDAO.searchPerson(name);
      
                 if(personsList.size() == 0){
        
                 JOptionPane.showMessageDialog(null, "No records found.");
        
                }else{
                      /*downcast the object from ArrayList to PersonInfo*/
                      PersonInfo person = (PersonInfo) personsList.get(recordNumber);
                   
               //displaying search record in text fields
                    tfName.setText(person.getName());
                    tfAddress.setText(person.getAddress());
                    tfPhone.setText(person.getPhone());
                    tfEmail.setText(person.getEmail());
                   
                 }
    }
 
 }
      
//****************************************************************************************************
//called when >> button clicked
  
  public void displayNextRecord(){
    
        //increment in recordNumber to display next person info, already stored in personsList during search
    recordNumber++;
    
    if(recordNumber >= personsList.size()){
      
       JOptionPane.showMessageDialog(null, "You have reached the end of search results");
      
           /*if user has reached the end of results, diable forward button*/
           bForward.setEnabled(false);
           bBack.setEnabled(true);
      
      //decrement by 1 to counter last increment
      recordNumber--;
      
    }else{
      
           bBack.setEnabled(true);
           PersonInfo person = (PersonInfo) personsList.get(recordNumber);
       
      //displaying search record in text fields
         tfName.setText(person.getName());
         tfAddress.setText(person.getAddress());
         tfPhone.setText("" + person.getPhone());
         tfEmail.setText(person.getEmail());
      
    }
    
  }
  
  //**************************************************************************************************
  
    //the method is called when << button is clicked
  public void displayPreviousRecord(){
    
         //decrement in recordNumber to display previous person info, already stored in personsList during search
         recordNumber--;
     
         if(recordNumber < 0){
           
            JOptionPane.showMessageDialog(null, "You have reached at the beginning of search results");
            
               /*if user has reached the begining of results, disable back button*/
               bForward.setEnabled(true);
               bBack.setEnabled(false);
           
           //increment by one to counter last decrement
           recordNumber++;
           
         }else{
           
                bForward.setEnabled(true);
                PersonInfo person = (PersonInfo) personsList.get(recordNumber);
           
                //displaying search record in text fieds
               tfName.setText(person.getName());
               tfAddress.setText(person.getAddress());
               tfPhone.setText("" + person.getPhone());
               tfEmail.setText(person.getEmail());
           
         }
  
  }
  
  //*****************************************************************************************************
  
  public clear(){
    
     /*clear text fields*/
    tfName.setText("");
    tfAddress.setText("");
    tfPhone.setText("");
    tfEmail.setText("");
    
    /*clear contents of ArrayList*/
    recordNumber = -1;
      personslist.clear();
      bForward.setEnabled(true);
      bBack.setEnabled(true);
  }//end of GUI
                    
    
      
    
   
      
      
     
      
  
      
      
      

