import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

import javax.swing.*;


public class OwnerLogin extends JFrame implements ActionListener
{
	Font f1 = new Font("Times new Roman",Font.BOLD,16);
	Container c;
	JButton j1,j2,j3;
	JLabel a1,a2,a3;
	JTextField t1;
	JPasswordField p1;
	File path;
	String path1;
	String content;
	String username,password;
	OwnerLogin()
	{
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.orange);
		setTitle("Owner Login :: Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		a3 = new JLabel("Client Login!!!!!!!!!!");
		a3.setFont(f1);
		a3.setBounds(100,20,200,100);
		c.add(a3);
		
		a1 = new JLabel("Username");
		a1.setFont(f1);
		a1.setBounds(50,100,80,30);
		c.add(a1);
		
		a2 = new JLabel("Password");
		a2.setFont(f1);
		a2.setBounds(50,150,80,30);
		c.add(a2);
		
		t1 = new JTextField(20);
		t1.setBounds(150,100,100,30);
		c.add(t1);
		p1 = new JPasswordField(20);
		p1.setBounds(150,150,100,30);
		c.add(p1);
		
		j2 = new JButton("Login");
		j2.setBounds(150,220,80,30);
		j2.addActionListener(this);
		j2.setFont(f1);
		c.add(j2);
		
		j3 = new JButton("Register");
		j3.setBounds(20,220,110,30);
		j3.addActionListener(this);
		j3.setFont(f1);
		c.add(j3);
		
		j1 = new JButton("Reset");
		j1.setBounds(250,220,80,30);
		j1.addActionListener(this);
		j1.setFont(f1);
		c.add(j1);
		
		setSize(380,320);
		setVisible(true);
		//c.setBackground(Color.WHITE);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==j2)
		{
			String name = t1.getText();
			  String pwd = p1.getText();
			  
			  String ip=JOptionPane.showInputDialog("Enter the cloud server IP address");
			  
			  try
			  {
				  Socket cn11 = new Socket(ip,4090);
				  DataOutputStream dos1 = new DataOutputStream(cn11.getOutputStream());
				  
				  dos1.writeUTF(name);
				  dos1.writeUTF(pwd);
				  
				  DataInputStream din1 = new DataInputStream(cn11.getInputStream());
				  
				  String status=din1.readUTF();
				  
				  if(status.equals("yes"))
				  {
					  JOptionPane.showMessageDialog(null, "Login Success");
					  new Client(name);
					  
				  }
				  else 
				  {
					  JOptionPane.showMessageDialog(null, "You are not a Valid User");
				  }
				  
				  System.out.println("Checking login");
				  
			  }catch(Exception ee)
			  {
				  ee.printStackTrace();
			  }

		}
		if(e.getSource()==j1)
		{
			
			t1.setText(null);
			p1.setText(null);
		}
		if(e.getSource()==j3)
		{
			
			new OwnerRegister();
		}
		
	}
	
	
	public static void main(String[] args) {
		//new OwnerLogin();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OwnerLogin();
			}
		});
	}

}
