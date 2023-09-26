import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;


public class MetaDataServer extends JFrame implements ActionListener
{

	JPanel p1;
	JLabel cs1;
	ImageIcon c1;
	
	JButton b1;
	
	MenuBar mbr;
	Menu file;
	MenuItem  assign,item2;
	
	JTable table;
	int v,h;
	String s,d,call,dt;
	JScrollPane pane;
	
	Vector heading,data;
	
	JLabel title;
	ImageIcon c11;
	
	Container c;
	JFrame jf;
	
	MetaDataServer()
	{
		jf = new JFrame("Meta Data Server::Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.orange);
		
		mbr = new MenuBar();
		file = new Menu("VIEW");
		
		assign= new MenuItem("Virtual Memory");
		item2 = new MenuItem("Data Owner Details");
		
		assign.addActionListener(this);
		item2.addActionListener(this);
		
		file.add(assign);
		file.add(item2);
		
	//	mbr.add(file);
		jf.setMenuBar(mbr);

		
		b1=new JButton("View All Files");
		b1.setBounds(220,300,200,30);
		b1.addActionListener(this);

		         
		
		//p1.add(cs1);
//		p1.add(title);
		 c.add(b1);
		 
		 jf.setBounds(0, 0, 680	,400);
			jf.show();
		//add(p1);
		//setSize(680,400);
		//setVisible(true);
		
		int[] ports = new int[]
			              		{ 1212,1919,1457,333};

			              		for (int i = 0; i < 4; i++)
			              		{
			              			Thread t = new Thread(new PortListener(ports[i]));
			              			t.setName("Listener-" + ports[i]);
			              			t.start();

			              		}
	}
	
	public void actionPerformed(ActionEvent a1)
	{
			if(a1.getSource()==b1)
			{
				try
				{
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
	            Statement stmt = connect.createStatement();
	            
	            heading = new Vector();
	   		 
	   		 heading.addElement("Owner Name");
	   		 heading.addElement("File Name");
	   		 heading.addElement("Secret Key");
	   		 heading.addElement("Keyword");
	   		 heading.addElement("Date");
	            data=new Vector();
		     	  
	            String query = "SELECT * FROM MetaData";
	            ResultSet rs = stmt.executeQuery(query);
	            ResultSetMetaData rsm=rs.getMetaData();
	            int col=rsm.getColumnCount();

	            while(rs.next())
	            {
	        	   Vector row = new Vector();
	        	   for(int i = 1; i <=col; i++)
	        	   {
	               row.addElement(rs.getObject(i));

	        	   }

	        	   data.addElement(row);
	            }
			  
	           table = new JTable(data,heading);
			  
	           pane = new JScrollPane(table);
			 
	           pane.setBounds(30,50,600,200);
	           c.add(pane);
			 
				} catch(Exception ex) {ex.printStackTrace();}
			}
			
			if(a1.getSource()==assign)
			{
				try
				{
					Dbcon db=new Dbcon();
					Connection connect=db.getConnection();
		            Statement stmt = connect.createStatement();
		            
		            heading = new Vector();
		   		 
		   		 heading.addElement("Memory");
		            data=new Vector();
			     	  
		            String query = "SELECT * FROM VM3";
		            ResultSet rs = stmt.executeQuery(query);
		            ResultSetMetaData rsm=rs.getMetaData();
		            int col=rsm.getColumnCount();

		            while(rs.next())
		            {
		        	   Vector row = new Vector();
		        	   for(int i = 1; i <=col; i++)
		        	   {
		               row.addElement(rs.getObject(i));

		        	   }

		        	   data.addElement(row);
		            }
				  
		           table = new JTable(data,heading);
				  
		           pane = new JScrollPane(table);
				 
		           pane.setBounds(30,50,600,200);
		           c.add(pane);
				 
					}catch (Exception e) {
					// TODO: handle exception
				}
			}	
			if(a1.getSource()==item2)
			{
				try
				{
					Dbcon db=new Dbcon();
					Connection connect=db.getConnection();
		            Statement stmt = connect.createStatement();
		            
		            heading = new Vector();
		   		 
		   		 heading.addElement("Owner");
		   		heading.addElement("Cost Paid");
		   		heading.addElement("Remaining Memory");
		   		
		            data=new Vector();
			     	  
		            String query = "SELECT * FROM CS3";
		            ResultSet rs = stmt.executeQuery(query);
		            ResultSetMetaData rsm=rs.getMetaData();
		            int col=rsm.getColumnCount();

		            while(rs.next())
		            {
		        	   Vector row = new Vector();
		        	   for(int i = 1; i <=col; i++)
		        	   {
		               row.addElement(rs.getObject(i));

		        	   }

		        	   data.addElement(row);
		            }
				  
		           table = new JTable(data,heading);
				  
		           pane = new JScrollPane(table);
				 
		           pane.setBounds(30,50,600,200);
		           c.add(pane);
				 
					}catch (Exception e) {
					// TODO: handle exception
				}
			}	
		
	
	}
	
	
	class PortListener implements Runnable
	{

		BufferedOutputStream bos = null;
		ServerSocket ss1, ss2;
		Socket s1, s2;
		ServerSocket server, server1,server2,server3;
		Socket connection, so;
		BufferedReader br = null;
		int port;

		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{
			
			if(this.port==1212)
			{
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Dbcon db=new Dbcon();
					Connection connect=db.getConnection();
					Socket s;
					ServerSocket sc =new ServerSocket(1212);
					while (true) 
					{
						s = sc.accept();
						DataInputStream din = new DataInputStream(s.getInputStream());
						
						String owner = din.readUTF();
						String fname = din.readUTF();
						String sk = din.readUTF();
						String mac = din.readUTF();
						String dt = din.readUTF();
						
						Statement stmt = connect.createStatement();
						String query1 = "insert into MetaData(owner,fname,sk,mac,dt) values('"+owner+"','"+fname+"','"+sk+"','"+mac+"','"+dt+"')";
						stmt.executeUpdate(query1);
						
						DataOutputStream dos1 = new DataOutputStream(s.getOutputStream());
						dos1.writeUTF("success");
						}
				}catch(Exception es){System.out.println(es);}
			}
			if (this.port == 1919)
			{

				
				try
				{
					ServerSocket server909 = new ServerSocket(1919);
					Socket con777;
					Dbcon db=new Dbcon();
					Connection connect = db.getConnection();
					while (true) 
					{
						
					con777 = server909.accept();
					
					DataInputStream dis = new DataInputStream(con777.getInputStream());
					
					String file	= dis.readUTF();
					
					String mac="";
					ResultSet r1=connect.createStatement().executeQuery("select * from MetaData where fname='"+file+"'");
					
					if(r1.next()==true)
					{					
						mac=r1.getString(4);
						
						DataOutputStream dos2 = new DataOutputStream(con777.getOutputStream());
						dos2.writeUTF(mac);
					}
					
					
					
					
					}
				}catch (Exception e) {
					
				}
			
			}
			 if(this.port==1457)
			 {
				 ServerSocket sc =null;
				 Socket s = null;
				 DataInputStream in =null;
				 
				 try
				 {
					Dbcon d1=new Dbcon();
					Connection connect=d1.getConnection();
					 
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				       //get current date time with Date()
				    Date date = new Date();
				       
				    String dt=dateFormat.format(date);
				    
					 sc = new ServerSocket(1457);
					 s = sc.accept();
					 in = new DataInputStream(s.getInputStream());
					 
					 String file = in.readUTF();
					 String newkey = in.readUTF();

					 connect.createStatement().executeUpdate("update MetaData set sk='"+newkey+"' where fname='"+file+"'");
					 
					DataOutputStream ds = new DataOutputStream(s.getOutputStream());
					 ds.writeUTF("success");
				 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
				 
				 
				 
			 }
			 if (this.port == 333) {
					
					try {
						Socket s;
							ServerSocket sc =new ServerSocket(333);
							Dbcon d1=new Dbcon();
							Connection connect=d1.getConnection();
							while(true)
							{
							s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							
							String file = din.readUTF();
							String key = din.readUTF();
							
							connect.createStatement().executeUpdate("update MetaData set sk='"+key+"' where fname='"+file+"'");
							
							DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
							dout1.writeUTF(file);
							dout1.writeUTF(key);
							
							}
							
						}catch (Exception e) {
							e.printStackTrace();
					}
			}
			
		}
	}

	
	public static void main(String[] args) 
	{
		new MetaDataServer();
	}
	
}
