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
}

