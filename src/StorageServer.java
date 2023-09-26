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
import java.util.Random;
import java.util.Vector;

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

public class StorageServer implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JPanel p1, p2;
	JButton b2, b3, b4;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1;
	MenuBar mbr;
	Menu file;
	MenuItem  assign,item2, users,csfile,kdc,server,trans,exit,okeys;
	Border b11, b22, b33;
	JScrollPane pane;
	String Scheme1, rank;
	String f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "", f7 = "",f8 = "";
	int count = 0;
	Timer timer;

	
	public Font f = new Font("Times new roman", Font.BOLD, 12);
	public Font font = new Font("Times new roman", Font.BOLD, 18);
	
	JLabel mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10, g11, g22, g33,
			g44, g55, g66, g77;
	

	
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	ImageIcon one,two,three,four,five,six,seven,eight,arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,end,end1;
	JLabel onel,twol,threel,fourl,fivel,sixl,sevenl,eightl,arrow1l,arrow2l,arrow3l,arrow4l,arrow5l,arrow6l,arrow7l,arrow8l,endl,end1l;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10,lab11;
	
	
	StorageServer() {
		jf = new JFrame("Storage Server :: Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.WHITE);
		timer = new Timer(0, null);

		

		one = new ImageIcon(this.getClass().getResource("MetaData.png"));
		onel=new JLabel();
		onel.setIcon(one);
		onel.setBounds(120, 150, 500, 200);
		c.add(onel);
		
		two = new ImageIcon(this.getClass().getResource("Clients.png"));
		twol=new JLabel();
		twol.setIcon(two);
		twol.setBounds(300,20, 500, 200);
		c.add(twol);
		
		three = new ImageIcon(this.getClass().getResource("CloudServer.png"));
		threel=new JLabel();
		threel.setIcon(three);
		threel.setBounds(260, 280, 400, 200);
		
		
		four = new ImageIcon(this.getClass().getResource("cs1.png"));
		fourl=new JLabel();
		fourl.setIcon(four);
		fourl.setBounds(300,290, 500, 200);
		
		
		five = new ImageIcon(this.getClass().getResource("cs2.png"));
		fivel=new JLabel();
		fivel.setIcon(five);
		fivel.setBounds(340, 260, 500, 200);
		c.add(fivel);
		
		six = new ImageIcon(this.getClass().getResource("cs3.png"));
		sixl=new JLabel();
		sixl.setIcon(six);
		sixl.setBounds(405, 255, 500, 200);
		c.add(sixl);
		
		seven = new ImageIcon(this.getClass().getResource("cs4.png"));
		sevenl=new JLabel();
		sevenl.setIcon(seven);
		sevenl.setBounds(460, 260, 500, 200);
		c.add(sevenl);
		
		eight = new ImageIcon(this.getClass().getResource("cs5.png"));
		eightl=new JLabel();
		eightl.setIcon(eight);
		eightl.setBounds(510, 290, 500, 200);
		c.add(eightl);
		
		arrow1 = new ImageIcon(this.getClass().getResource("a1.png"));
		arrow1l=new JLabel();
		arrow1l.setIcon(arrow1);
		arrow1l.setBounds(190, 70, 300, 200);
		c.add(arrow1l);
		
		arrow2 = new ImageIcon(this.getClass().getResource("a2.png"));
		arrow2l=new JLabel();
		arrow2l.setIcon(arrow2);
		arrow2l.setBounds(420, 140, 300, 200);
		c.add(arrow2l);
		
		arrow3 = new ImageIcon(this.getClass().getResource("a3.png"));
		arrow3l=new JLabel();
		arrow3l.setIcon(arrow3);
		arrow3l.setBounds(180, 230, 500, 200);
		c.add(arrow3l);
		
		arrow4 = new ImageIcon(this.getClass().getResource("pnf.png"));
		arrow4l=new JLabel();
		arrow4l.setIcon(arrow4);
		arrow4l.setBounds(70, 40, 500, 200);
		c.add(arrow4l);
		
		arrow5 = new ImageIcon(this.getClass().getResource("control.png"));
		arrow5l=new JLabel();
		arrow5l.setIcon(arrow5);
		arrow5l.setBounds(80, 265, 200, 200);
		c.add(arrow5l);
		
		arrow6 = new ImageIcon(this.getClass().getResource("storage.png"));
		arrow6l=new JLabel();
		arrow6l.setIcon(arrow6);
		arrow6l.setBounds(440, 140, 300, 200);
		c.add(arrow6l);

		end = new ImageIcon(this.getClass().getResource("end.png"));
		endl=new JLabel();
		endl.setIcon(end);
		endl.setBounds(400, 450, 300, 200);
		c.add(endl);
		
		end1 = new ImageIcon(this.getClass().getResource("end1.png"));
		end1l=new JLabel();
		end1l.setIcon(end1);
		end1l.setBounds(420, 380, 300, 200);
		c.add(end1l);
		
		c.add(fourl);
		c.add(threel);
		
		lab1 = new JLabel("META DATA");
		lab1.setFont(f);
		lab1.setBounds(200, 230, 200, 30);
		c.add(lab1);
		lab1.setVisible(false);
		
		lab2 = new JLabel("UPLOAD");
		lab2.setFont(f);
		lab2.setBounds(410,285, 200, 30);
		c.add(lab2);
		lab2.setVisible(false);
		
		lab3 = new JLabel("VERIFY");
		lab3.setFont(f);
		lab3.setBounds(200, 230, 200, 30);
		c.add(lab3);
		lab3.setVisible(false);
		
		lab4 = new JLabel("VERIFY");
		lab4.setFont(f);
		lab4.setBounds(410,285, 200, 30);
		c.add(lab4);
		lab4.setVisible(false);
		
		lab5 = new JLabel("DOWNLOAD");
		lab5.setFont(f);
		lab5.setBounds(390, 355, 300, 200);
		c.add(lab5);
		lab5.setVisible(false);
		
		mbr = new MenuBar();
//		csfile = new MenuItem("Schedule Key Exchange");
		kdc = new MenuItem("View KDC");
		file = new Menu("File");
		assign= new MenuItem("View Storage Server Files");
		item2 = new MenuItem("View Data Owners");
		users = new MenuItem("View End Users");
		server= new MenuItem("View Attackers");
		trans= new MenuItem("View Blocked Users");
		okeys= new MenuItem("View Original Keys");
		exit = new MenuItem("Exit");
		
		assign.addActionListener(this);
		kdc.addActionListener(this);
		item2.addActionListener(this);
		users.addActionListener(this);
        okeys.addActionListener(this);
		server.addActionListener(this);
		trans.addActionListener(this);
		exit.addActionListener(this);
		
//		file.add(csfile);
		file.add(kdc);
		file.add(assign);
		file.add(item2);
		file.add(users);
		
		file.add(server);
		file.add(trans);
		file.add(okeys);
		file.add(exit);
		mbr.add(file);
		jf.setMenuBar(mbr);

//		c.add(l2);
		
//		c.add(title);
//		c.add(b1);
		jf.setBounds(40, 0, 700	,680);
		jf.show();

		int[] ports = new int[] {5757,4090,7373,3090,1111,4646,9988,1313,4949,5959,222};
		
		for (int i = 0; i < 11; i++) {
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
				new StorageServer();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		Dbcon db=new Dbcon();
		Connection con=db.getConnection();
		if (o == assign) {
			
			try
			{
				ViewStorageServerFiles vf = new ViewStorageServerFiles();
				vf.setSize(600, 400);
				vf.setVisible(true);
				
			}catch(Exception es){System.out.println(es);}
			
		}
			
		if (o == kdc) {
			
			try
			{
				String dat="view";
				Socket stm=new Socket("localhost",1333);
				ObjectOutputStream dos3=new ObjectOutputStream(stm.getOutputStream());
				dos3.writeObject(dat); 
				
				
				ObjectInputStream ins=new ObjectInputStream(stm.getInputStream());
				Vector a1=(Vector) ins.readObject();
				System.out.println(a1);
				
				ViewKDC v = new ViewKDC(a1);
				v.setSize(600,400);
				v.setVisible(true);
				
			}catch(Exception es){System.out.println(es);}
			
		}
		if (o == item2) {
			
			ViewDataOwners v = new ViewDataOwners();
			v.setSize(600, 400);
			v.setVisible(true);
			
		}
		if (o == users) {
			
			ViewRemoteUsers v =new ViewRemoteUsers();
			v.setSize(380, 450);
			v.setVisible(true);
		}
		if (o == csfile) {
			
			try
			{
				String name = JOptionPane.showInputDialog("Schedule Date (dd/mm/yyyy)");
				
				Socket s = new Socket("localhost",3789);
				DataOutputStream dout = new  DataOutputStream(s.getOutputStream());
				dout.writeUTF(name);
				
				DataInputStream din = new DataInputStream(s.getInputStream());
				String msg = din.readUTF();
				System.out.println(msg);
				
				JOptionPane.showMessageDialog(null, "Date "+msg);
				
			}catch (Exception e4) {
				// TODO: handle exception
			}
			
		}
		if (o == server) {
//	
		ViewAttackers v =new ViewAttackers();
		v.setSize(580, 400);
		v.setVisible(true);
}
		if (o == trans) {
			
			ViewBlocked d = new ViewBlocked();
			d.setSize(580, 400);
			d.setVisible(true);
		}
if (o == okeys) {
			
	View_Original_Keys d1= new View_Original_Keys();
			d1.setSize(580, 400);
			d1.setVisible(true);
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
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Dbcon db=new Dbcon();
			Connection connect=db.getConnection();
			Socket s;
			 
		 if (this.port == 1111) {
			
			try {
					ServerSocket sc =new ServerSocket(1111);
					
					while(true)
					{
					s = sc.accept();
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					
					Thread.sleep(2000);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					Thread.sleep(300);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					

					lab2.setVisible(true);
					Thread.sleep(200);
					lab2.setVisible(false);
					Thread.sleep(200);
					lab2.setVisible(true);
					Thread.sleep(200);
					lab2.setVisible(false);
					Thread.sleep(200);
					lab2.setVisible(true);
					
					Random r = new Random();
					
					int a = r.nextInt(10);
					int b = r.nextInt(10);
					int c = r.nextInt(10);
					int d = r.nextInt(10);
					int e = r.nextInt(10);
					
					if(a>b && a>c && a>d && a>e)
					{
						Thread.sleep(2000);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
						Thread.sleep(300);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
					}
					if(b>a && b>c && b>d && b>e)
					{
						Thread.sleep(2000);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
						Thread.sleep(300);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
					}
					if(c>a && c>b && c>d && c>e)
					{
						Thread.sleep(2000);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
						Thread.sleep(300);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
					}
					if(d>a && d>b && d>c && d>e)
					{
						Thread.sleep(2000);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
						Thread.sleep(300);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
					}
					if(e>a && e>b && e>c && e>d)
					{
						Thread.sleep(2000);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
						Thread.sleep(300);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
					}
					
					Thread.sleep(2000);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					Thread.sleep(300);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					
					Thread.sleep(2000);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					Thread.sleep(300);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);

					Thread.sleep(2000);
					onel.setVisible(false);
					Thread.sleep(500);
					onel.setVisible(true);
					Thread.sleep(500);
					onel.setVisible(false);
					Thread.sleep(500);
					onel.setVisible(true);
					
					lab1.setVisible(true);
					Thread.sleep(200);
					lab1.setVisible(false);
					Thread.sleep(200);
					lab1.setVisible(true);
					Thread.sleep(200);
					lab1.setVisible(false);
					Thread.sleep(200);
					lab1.setVisible(true);
					
					
					Thread.sleep(2000);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					Thread.sleep(300);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					clear();
					
					String owner = din.readUTF();
					String fname = din.readUTF();
					String content = din.readUTF();
					String sk = din.readUTF();
					String mac = din.readUTF();
					String dt = din.readUTF();
					
					Statement stmt = connect.createStatement();
					String query1 = "insert into CloudServer(owner,fname,sk,mac,dt) values('"+owner+"','"+fname+"','"+sk+"','"+mac+"','"+dt+"')";
					stmt.executeUpdate(query1);
					
					
					// Back Up
					
					Statement stmt1 = connect.createStatement();
					String query11 = "insert into Backup(owner,fname,sk,mac,dt) values('"+owner+"','"+fname+"','"+sk+"','"+mac+"','"+dt+"')";
					stmt1.executeUpdate(query11);
					
					PrintStream out = null;
					out = new PrintStream(new FileOutputStream("CloudServer\\"+fname));
				    out.print(content);
					out.close();
					
					DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
					
					
					dout1.writeUTF(owner);
					dout1.writeUTF(fname);					
					dout1.writeUTF(sk);
					dout1.writeUTF(mac);
					dout1.writeUTF(dt);
					
					}
					
				}catch (Exception e) {
					e.printStackTrace();
			}
			
		 }
		if (this.port == 4646)
		{

			
			try
			{
				ServerSocket server909 = new ServerSocket(4646);
				Socket con777;

				while (true) 
				{
					
				con777 = server909.accept();
				
				DataInputStream dis = new DataInputStream(con777.getInputStream());
			
				
				String file	= dis.readUTF();
				
				ResultSet r1=connect.createStatement().executeQuery("select * from CloudServer where fname='"+file+"'");
				
				if(r1.next()==true)
				{
					String k= r1.getString("sk");
					
					DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
					
					dos1.writeUTF("key");
					dos1.writeUTF(k);
						
				}
				if(r1.next()==false)
				{
					DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
					dos1.writeUTF("no");
					dos1.writeUTF("no");
						
					
				}
				
				}
				
				}catch (Exception e) {
				
			}
		
		}
		if (this.port == 9988) {

			try {
				
					ServerSocket sc =new ServerSocket(9988);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					Thread.sleep(2000);
					endl.setVisible(false);
					Thread.sleep(500);
					endl.setVisible(true);
					Thread.sleep(500);
					endl.setVisible(false);
					Thread.sleep(500);
					endl.setVisible(true);
					
					Thread.sleep(2000);
					end1l.setVisible(false);
					Thread.sleep(300);
					end1l.setVisible(true);
					Thread.sleep(300);
					end1l.setVisible(false);
					Thread.sleep(300);
					end1l.setVisible(true);
					

					lab5.setVisible(true);
					Thread.sleep(200);
					lab5.setVisible(false);
					Thread.sleep(200);
					lab5.setVisible(true);
					Thread.sleep(200);
					lab5.setVisible(false);
					Thread.sleep(200);
					lab5.setVisible(true);
					
					Random r9 = new Random();
					
					int a = r9.nextInt(10);
					int b = r9.nextInt(10);
					int c = r9.nextInt(10);
					int d = r9.nextInt(10);
					int e = r9.nextInt(10);
					
					if(a>b && a>c && a>d && a>e)
					{
						Thread.sleep(2000);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
						Thread.sleep(300);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
					}
					if(b>a && b>c && b>d && b>e)
					{
						Thread.sleep(2000);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
						Thread.sleep(300);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
					}
					if(c>a && c>b && c>d && c>e)
					{
						Thread.sleep(2000);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
						Thread.sleep(300);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
					}
					if(d>a && d>b && d>c && d>e)
					{
						Thread.sleep(2000);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
						Thread.sleep(300);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
					}
					if(e>a && e>b && e>c && e>d)
					{
						Thread.sleep(2000);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
						Thread.sleep(300);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
					}

					Thread.sleep(2000);
					end1l.setVisible(false);
					Thread.sleep(300);
					end1l.setVisible(true);
					Thread.sleep(300);
					end1l.setVisible(false);
					Thread.sleep(300);
					end1l.setVisible(true);
					
					Thread.sleep(2000);
					endl.setVisible(false);
					Thread.sleep(500);
					endl.setVisible(true);
					Thread.sleep(500);
					endl.setVisible(false);
					Thread.sleep(500);
					endl.setVisible(true);
					clear();
					
					String user = din.readUTF();
					String filename = din.readUTF();
					String sk = din.readUTF();
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				       //get current date time with Date()
				    Date date = new Date();
				       
				    String dt=dateFormat.format(date);
				   
				    ResultSet r1=connect.createStatement().executeQuery("select * from CloudServer where fname='"+filename+"' and sk='"+sk+"'");
					
					if(r1.next()==true)
					{
						FileInputStream fs = new FileInputStream("CloudServer\\"+filename);
						byte bs1[] = new byte[fs.available()];
						fs.read(bs1);
						String content = new String(bs1);
					 
						DataOutputStream  ds = new DataOutputStream(s.getOutputStream());
							
						ds.writeUTF("success");
						ds.writeUTF(AES.decrypt(content, keyWord));
						 
					}
					else
					{
						
							DataOutputStream  ds = new DataOutputStream(s.getOutputStream());
							
							ds.writeUTF("mismatch");
							ds.writeUTF("mismatch");
						
					}
					
				}
				}
			
					catch (Exception e) {
					e.printStackTrace();
				}
					
					
			}
			
		if (this.port == 4949) {

			try
			{
				
				ServerSocket server909 = new ServerSocket(4949);
				Socket con777;
				while (true) 
				{
				con777 = server909.accept();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			       //get current date time with Date()
			    Date date = new Date();
			       
			    String dt=dateFormat.format(date);
			       
				DataInputStream dis = new DataInputStream(con777.getInputStream());
				
				String file = dis.readUTF();
				String data = dis.readUTF();
				String ip = dis.readUTF();
				
				ResultSet rs=connect.createStatement().executeQuery("select * from Blocked");
				
				if(rs.next()==true)
				{
					String block = rs.getString(2);
					
					if(ip.equalsIgnoreCase(block))
					{
						DataOutputStream  ds2 = new DataOutputStream(con777.getOutputStream());
						ds2.writeUTF("block");
					}
				}
				else
				{
					ResultSet r1=connect.createStatement().executeQuery("select * from CloudServer where fname='"+file+"'");
					
					if(r1.next()==true)
					{
						FileInputStream fs = new FileInputStream("CloudServer\\"+file);
						byte bs1[] = new byte[fs.available()];
						fs.read(bs1);
						String content = new String(bs1);
						
						StringBuffer sb = new StringBuffer(content);
						String maldata = sb.append(data).toString();
						System.out.println("Malicious Data : "+data);
					 
						PrintStream out = new PrintStream(new FileOutputStream("CloudServer\\"+file));
					    out.print(maldata);
						out.close();
						
						MessageDigest md = MessageDigest.getInstance("SHA1");
						FileInputStream in1 = new FileInputStream("CloudServer\\" + file);
						DigestInputStream dis2 = new DigestInputStream(in1, md);
						BufferedInputStream bd = new BufferedInputStream(dis2);

						while (true) {
							int b2 = bd.read();
							if (b2 == -1)
								break;
						}

						BigInteger bi2 = new BigInteger(md.digest());
						String mac = bi2.toString(16);
						System.out.println("New MAC : "+mac);
						
						connect.createStatement().executeUpdate("update CloudServer set mac='"+mac+"' where fname='"+file+"'");
						
						String attack="Message Attacker";
						
						
						connect.createStatement().executeUpdate("insert into Attacker(fname,maldata,attacker,dt) values('"+file+"','"+data+"','"+attack+"','"+dt+"')");
						connect.createStatement().executeUpdate("insert into Blocked(fname,ip,dt) values('"+file+"','"+ip+"','"+dt+"')");
						DataOutputStream  ds = new DataOutputStream(con777.getOutputStream());
							
						ds.writeUTF("attack");
						 
					}
					else
					{
					
						DataOutputStream  ds2 = new DataOutputStream(con777.getOutputStream());
						
						   ds2.writeUTF("notfound");
					}
				}
				
				
				}
			}catch (Exception e) {
				
			}
		} 
		if(this.port==5959)
		{
			try
			{
				
				ServerSocket server909 = new ServerSocket(5959);
				Socket con777;
				while (true) 
				{
				con777 = server909.accept();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			       //get current date time with Date()
			    Date date = new Date();
			       
			    String dt=dateFormat.format(date);
			       
				DataInputStream dis = new DataInputStream(con777.getInputStream());
				
				String file = dis.readUTF();
				String data = dis.readUTF();
				String ip = dis.readUTF();
				
				ResultSet rs=connect.createStatement().executeQuery("select * from Blocked");
				
				if(rs.next()==true)
				{
					String block = rs.getString(2);
					
					if(ip.equalsIgnoreCase(block))
					{
						DataOutputStream  ds2 = new DataOutputStream(con777.getOutputStream());
						ds2.writeUTF("block");
					}
				}
				else
				{
					ResultSet r1=connect.createStatement().executeQuery("select * from CloudServer where fname='"+file+"'");
					
					if(r1.next()==true)
					{
						
						String sk=r1.getString("sk");
						
						StringBuffer sb = new StringBuffer(sk);
						String maldata = sb.append(data).toString();

						System.out.println("Malicious Data : "+data);
					 
						
						connect.createStatement().executeUpdate("update CloudServer set sk='"+maldata+"' where fname='"+file+"'");
						String attack="Key Attacker";
						
						
						connect.createStatement().executeUpdate("insert into Attacker(fname,maldata,attacker,dt) values('"+file+"','"+data+"','"+attack+"','"+dt+"')");
						connect.createStatement().executeUpdate("insert into Blocked(fname,ip,dt) values('"+file+"','"+ip+"','"+dt+"')");
						
						
						
						//connect.createStatement().executeUpdate("insert into Attacker(fname,maldata,attacker,dt) values('"+file+"','"+data+"','"+attack+"','"+dt+"')");
						
						JOptionPane.showMessageDialog(null, "Successfully Attacked");
						
						Thread.sleep(3000);
						
						JOptionPane.showMessageDialog(null, "Alert...!!!! Attacker Found\n Exchanging Secret Keys");
						
						Socket sc = new Socket("localhost",6389);
						
						DataOutputStream  dds = new DataOutputStream(sc.getOutputStream());
						dds.writeUTF(file);
						dds.writeUTF("recover");
						
						
						DataInputStream din = new DataInputStream(sc.getInputStream());
						String newkey = din.readUTF();
						connect.createStatement().executeUpdate("update CloudServer set sk='"+newkey+"' where fname='"+file+"'");
						
						Thread.sleep(5000);
						
						JOptionPane.showMessageDialog(null, "Keys Exchanged Successfully");
						
						DataOutputStream  ds = new DataOutputStream(con777.getOutputStream());
							
						ds.writeUTF("attack");
						 
					}
					else
					{
					
						DataOutputStream  ds2 = new DataOutputStream(con777.getOutputStream());
						
						   ds2.writeUTF("notfound");
					}
				
				}
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (this.port == 5757) {
			 
			try {
				
					ServerSocket sc =new ServerSocket(5757);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					
					String name = din.readUTF();
					String pass = din.readUTF();
					String email = din.readUTF();
					String mob = din.readUTF();
					String address = din.readUTF();
					String enduser="End User";
					
					connect.createStatement().executeUpdate("insert into Register(name,pass,email,mobile,address,user) values('"+name+"','"+pass+"','"+email+"','"+mob+"','"+address+"','"+enduser+"')");
					
					DataOutputStream dout =new DataOutputStream(s.getOutputStream());
					dout.writeUTF("success");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			} 
		if (this.port == 4090) {
			 
			try {
				
					ServerSocket sc =new ServerSocket(4090);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					String name = din.readUTF();
					String pass = din.readUTF();
					
					ResultSet rs=connect.createStatement().executeQuery("select * from Register where name='"+name+"' and pass='"+pass+"'");
					if(rs.next()==true)
					{
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF("yes");
					}
					else
					{
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF("no");
					}
					
				}
			}	
					catch (Exception e) {
					e.printStackTrace();
				}
					
					
			}
		if(this.port==7373)
		{
			try {

				
					ServerSocket sc =new ServerSocket(7373);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					
					
					String name = din.readUTF();
					String pass = din.readUTF();
					
					ResultSet rs=connect.createStatement().executeQuery("select * from Register where name='"+name+"' and pass='"+pass+"'");
					if(rs.next()==true)
					{
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF("yes");
					}
					else
					{
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF("no");
					}
					
				}
			}	
					catch (Exception e) {
					e.printStackTrace();
				}
					
					
			
		}
		if(this.port==3090)
		{
			try {

				
					ServerSocket sc =new ServerSocket(3090);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					String name = din.readUTF();
					String pass = din.readUTF();
					String email = din.readUTF();
					String mob = din.readUTF();
					String address = din.readUTF();
					String dataowner="Data Owner";
					
					connect.createStatement().executeUpdate("insert into Register(name,pass,email,mobile,address,user) values('"+name+"','"+pass+"','"+email+"','"+mob+"','"+address+"','"+dataowner+"')");
					
					DataOutputStream dout =new DataOutputStream(s.getOutputStream());
					dout.writeUTF("success");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
		}
		if(this.port==1313)
		{
			try {

				
					ServerSocket sc =new ServerSocket(1313);
					
					while(true)
					{
					
					s = sc.accept();
					
					DataInputStream din = new DataInputStream(s.getInputStream());
					
					String fname = din.readUTF();
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					
					Thread.sleep(2000);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					Thread.sleep(300);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					

					lab4.setVisible(true);
					Thread.sleep(200);
					lab4.setVisible(false);
					Thread.sleep(200);
					lab4.setVisible(true);
					Thread.sleep(200);
					lab4.setVisible(false);
					Thread.sleep(200);
					lab4.setVisible(true);
					
					Random r8 = new Random();
					
					int a = r8.nextInt(10);
					int b = r8.nextInt(10);
					int c = r8.nextInt(10);
					int d = r8.nextInt(10);
					int e = r8.nextInt(10);
					
					if(a>b && a>c && a>d && a>e)
					{
						Thread.sleep(2000);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
						Thread.sleep(300);
						fourl.setVisible(false);
						Thread.sleep(300);
						fourl.setVisible(true);
					}
					if(b>a && b>c && b>d && b>e)
					{
						Thread.sleep(2000);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
						Thread.sleep(300);
						fivel.setVisible(false);
						Thread.sleep(300);
						fivel.setVisible(true);
					}
					if(c>a && c>b && c>d && c>e)
					{
						Thread.sleep(2000);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
						Thread.sleep(300);
						sixl.setVisible(false);
						Thread.sleep(300);
						sixl.setVisible(true);
					}
					if(d>a && d>b && d>c && d>e)
					{
						Thread.sleep(2000);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
						Thread.sleep(300);
						sevenl.setVisible(false);
						Thread.sleep(300);
						sevenl.setVisible(true);
					}
					if(e>a && e>b && e>c && e>d)
					{
						Thread.sleep(2000);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
						Thread.sleep(300);
						eightl.setVisible(false);
						Thread.sleep(300);
						eightl.setVisible(true);
					}
					
					Thread.sleep(2000);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					Thread.sleep(300);
					arrow2l.setVisible(false);
					Thread.sleep(300);
					arrow2l.setVisible(true);
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					
					Thread.sleep(2000);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					Thread.sleep(300);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);

					Thread.sleep(2000);
					onel.setVisible(false);
					Thread.sleep(500);
					onel.setVisible(true);
					Thread.sleep(500);
					onel.setVisible(false);
					Thread.sleep(500);
					onel.setVisible(true);
					
					lab3.setVisible(true);
					Thread.sleep(200);
					lab3.setVisible(false);
					Thread.sleep(200);
					lab3.setVisible(true);
					Thread.sleep(200);
					lab3.setVisible(false);
					Thread.sleep(200);
					lab3.setVisible(true);
					
					
					Thread.sleep(2000);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					Thread.sleep(300);
					arrow1l.setVisible(false);
					Thread.sleep(300);
					arrow1l.setVisible(true);
					
					Thread.sleep(2000);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					Thread.sleep(500);
					twol.setVisible(false);
					Thread.sleep(500);
					twol.setVisible(true);
					clear();
					String mac="";
					ResultSet rs=connect.createStatement().executeQuery("select * from CloudServer where fname='"+fname+"'");
					if(rs.next()==true)
					{
						mac=rs.getString(4);
						
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF(mac);
					}	
					else
					{
						DataOutputStream dout =new DataOutputStream(s.getOutputStream());
						dout.writeUTF("nofile");
					}
					
					
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
		}
		 if (this.port == 222) {
				
				try {
						ServerSocket sc =new ServerSocket(222);
						
						while(true)
						{
						s = sc.accept();
						DataInputStream din = new DataInputStream(s.getInputStream());
						
						String file = din.readUTF();
						String key = din.readUTF();
						
						connect.createStatement().executeUpdate("update CloudServer set sk='"+key+"' where fname='"+file+"'");
						
						DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
						dout1.writeUTF(file);
						dout1.writeUTF(key);
						
						}
						
					}catch (Exception e) {
						e.printStackTrace();
				}
				
			 }
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
			
		}


		 void clear() throws InterruptedException {
			// TODO Auto-generated method stub
			 
			 	Thread.sleep(2000);
		

				
				lab1.setVisible(false);
				lab2.setVisible(false);
				
				lab3.setVisible(false);
				lab4.setVisible(false);
				lab5.setVisible(false);
		}

}