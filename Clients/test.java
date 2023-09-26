import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class KDC implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JPanel p1, p2;
	JButton b1,b2, b3, b4;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1;
	MenuBar mbr;
	Menu file;
	MenuItem  item2,item22, users,csfile,exit;
	Border b11, b22, b33;
	JScrollPane pane;
	String Scheme1, rank;
	String f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "", f7 = "",f8 = "";
	int count = 0;
	Timer timer;
	
	public static Key pubKey;
	static Cipher encoder;
	
	ImageIcon one,two,three,four,arrow1,arrow2,arrow3,arrow4,arrow5,arrow6;
	JLabel onel,twol,threel,fourl,arrow1l,arrow2l,arrow3l,arrow4l,arrow5l,arrow6l,arrow7l,arrow8l;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10,lab11;
	
	
	public Font f = new Font("Times new roman", Font.BOLD, 14);
	public Font font = new Font("Times new roman", Font.BOLD, 18);
	
	JLabel mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10, g11, g22, g33,
			g44, g55, g66, g77;

	
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";

	KDC() {
		jf = new JFrame("KDC ::Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		
		mbr = new MenuBar();
		file = new Menu("KDC");
		item2= new MenuItem("Schedule Date");
		item22= new MenuItem("View Scheduled Date");
		item2.addActionListener(this);
		item22.addActionListener(this);
		file.add(item2);
		file.add(item22);
		mbr.add(file);
		jf.setMenuBar(mbr);
		c.setBackground(Color.WHITE);
		timer = new Timer(0, null);
		
		b1=new JButton("KDC");
		b1.setBounds(200, 300, 120, 30);
		b1.addActionListener(this);
		
		c.add(b1);
		
		jf.setBounds(40, 0, 550,400);
		jf.show();

		int[] ports = new int[] {1333};
		
		for (int i = 0; i < 1; i++) {
			Thread t2 = new Thread(new PortListener(ports[i]));
			t2.start();
		}
	}

	public static void main(String args[])
	{
//		new CloudServer();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new KDC();
				call();
			}

			 void call() {

				 try
				 {
					 Class.forName("com.mysql.jdbc.Driver");
					 Dbcon db=new Dbcon();
					 Connection connect=db.getConnection();
					 String k ;
						String f ;
						
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				       //get current date time with Date()
				    Date date = new Date();
				       
				    String dt=dateFormat.format(date);
				   
				    ResultSet r1=connect.createStatement().executeQuery("select * from keyexchange");
					
					if(r1.next()==true)
					{
						String dscheduledt = r1.getString(1);
						
						if(dt.equalsIgnoreCase(dscheduledt))
						{
							
							 ResultSet r2=connect.createStatement().executeQuery("select * from client");
								
								while(r2.next()==true)
								{
									Generate g = new Generate();
									f = r2.getString("fname");
									k=g.gen();
									
									Socket sc = new Socket("localhost",111);
									DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
									dout.writeUTF(f);
									dout.writeUTF(k);
									
									DataInputStream din = new DataInputStream(sc.getInputStream());
									String file = din.readUTF();
									String key = din.readUTF();
									
									Socket sc1 = new Socket("localhost",222);
									DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
									dout1.writeUTF(file);
									dout1.writeUTF(key);
									
									DataInputStream din1 = new DataInputStream(sc1.getInputStream());
									String file1 = din1.readUTF();
									String key1 = din1.readUTF();
									
									Socket sc2 = new Socket("localhost",333);
									DataOutputStream dout2 = new DataOutputStream(sc2.getOutputStream());
									dout2.writeUTF(file1);
									dout2.writeUTF(key1);
									
									DataInputStream din2 = new DataInputStream(sc2.getInputStream());
									String file2 = din2.readUTF();
									String key2= din2.readUTF();
									
									System.out.println(file2);
									System.out.println(key2);
										
									connect.createStatement().executeUpdate("insert into KDC(fname,sk,dt) values ('"+f+"','"+k+"','"+dscheduledt+"')");
									
									
								}
								
						}
					}
					else
					{
						System.out.println("Date");
					}
				 }catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		

		if (o == b1) {
			
			try {

				Vector heading = new Vector();

				heading.addElement("File Name");
				heading.addElement("Secret Key");
				heading.addElement("Date");
			
				Vector data = new Vector();

				String query = "SELECT * FROM kdc";

				
				Dbcon con=new Dbcon();
				
				ResultSet rs =con.getConnection().createStatement().executeQuery(query);
				

				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();

				while (rs.next()) {
					Vector row = new Vector();
					for (int i = 1; i <= col; i++) {
						row.addElement(rs.getObject(i));

					}

					data.addElement(row);
				}

				JTable table = new JTable(data, heading);

				JScrollPane pane = new JScrollPane(table);

				pane.setBounds(20,30,500,250);
				c.add(pane);

			} catch (Exception ex) {
				ex.printStackTrace();
		}
			
			}
			

		if (o == item2) {
		
			try
			{
				String name = JOptionPane.showInputDialog("Schedule Date (dd/mm/yyyy)");
				
				Dbcon db = new Dbcon();
				Connection con = db.getConnection();
				
				Statement stmt = con.createStatement();
				
				String sql = "update keyexchange set dt='"+name+"'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Date Assigned Successfully");
				
				
			}catch (Exception e4) {
				// TODO: handle exception
			}

		}
		if (o == item22) {
			
			View_Key_ExchangeDate v1 =new View_Key_ExchangeDate();
			v1.setSize(600, 400);
			v1.setVisible(true);
		}
		
		if(o == exit)
		{
			System.exit(0);
		}
	}

class PortListener implements Runnable {
		
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {
			
			
			if (this.port == 3789)
			{

				try
				{
					ServerSocket server909 = new ServerSocket(3789);
					Socket con777;
					
					
					while (true) 
					{
						
					con777 = server909.accept();
					
					DataInputStream din = new DataInputStream(con777.getInputStream());
				
					String name = din.readUTF();

					Dbcon db = new Dbcon();
					Connection con = db.getConnection();
					
					Statement stmt = con.createStatement();
					
					String sql = "update keyexchange set dt='"+name+"'";
					stmt.executeUpdate(sql);
					
					
					DataOutputStream dos2 = new DataOutputStream(con777.getOutputStream());
					dos2.writeUTF("Assigned Successfully");
					
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			}
			if (this.port == 1333)
			{

				try
				{
					ServerSocket server909 = new ServerSocket(1333);
					Socket con777;
					
					Dbcon db=new Dbcon();
					Connection connect=db.getConnection();
					while (true) 
					{
						
					con777 = server909.accept();
					
					ObjectInputStream in3=new ObjectInputStream(con777.getInputStream());
					
					String cs=in3.readObject().toString();
					
					Vector data = new Vector();
					
					ResultSet r1=connect.createStatement().executeQuery("select fname,sk,dt from KDC");

					ResultSetMetaData rsm=r1.getMetaData();
					int col=rsm.getColumnCount();
					 
					while(r1.next()==true)
					{
						Vector row = new Vector();
		            	for(int i = 1; i <=col; i++){
		                row.addElement(r1.getObject(i));

		             }

		            	data.addElement(row);
					}	
//					System.out.println(data);
					ObjectOutputStream dout = new ObjectOutputStream(con777.getOutputStream());
					dout.writeObject(data);
					
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			}
		}


}
	
}
