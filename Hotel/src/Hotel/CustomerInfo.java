package Hotel;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
	
	JTable table;
	JButton back;
	
	CustomerInfo(){
		
		setLayout(null);
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(510,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin time");
        l7.setBounds(760,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);
		
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		
		try {
			
			Jdbc_con c = new Jdbc_con();
			ResultSet rs = c.smt.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(420,500,120,30);
		add(back);
		
        getContentPane().setBackground(Color.white);
		
		setBounds(420,200,1000,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new CustomerInfo();

	}

}
