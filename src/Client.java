import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
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
import java.io.IOException;
import java.io.InputStreamReader;
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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Client implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b1, b2, b3, b4, b5, b6,b2m;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1, t2, t3;
	MenuBar mbr;
	Menu file;
	MenuItem item;
	Border b11, b22, b33;
	File path;
	JComboBox jb;
	Object type;
	String selItem,mac;
	Cipher encoder;
	Key prKey;
	int rank;
	JLabel ownername;
	JTextField ownertext;
	
	public static Key pubKey;
	public Font f = new Font("Times new roman", Font.BOLD, 16);
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";

	Client(String name) {
		jf = new JFrame("Client :: Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		//c.setBackground(new Color(188, 100, 100));
		
		mbr = new MenuBar();
		file = new Menu("File");
		item= new MenuItem("View Files");
		item.addActionListener(this);
		file.add(item);
		mbr.add(file);
		jf.setMenuBar(mbr);
		
		ownername = new JLabel("Owner Name");
		ownername.setFont(f);
		ownername.setBounds(70, 120, 120, 30);
		c.add(ownername);
		
		ownertext = new JTextField();
		ownertext.setBounds(70, 150, 120, 30);
		ownertext.setFont(f);
		ownertext.setText(name);
		ownertext.setEditable(false);
		
		c.add(ownertext);


		ta = new JTextArea();
		ta.setColumns(100);
		ta.setRows(100);

		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(325, 150, 315, 250);

		b1 = new JButton("Browse");
		b2 = new JButton("Upload File");
		b3 = new JButton("Verify");
		b4 = new JButton("CS Details");
		b5 = new JButton("Purchase");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		b1.setBackground(Color.CYAN);
		b2.setBackground(Color.CYAN);
		b3.setBackground(Color.CYAN);
		b4.setBackground(Color.CYAN);
		b5.setBackground(Color.CYAN);
		
		item.addActionListener(this);

		b1.setBounds(70, 210, 120, 30);
		b2.setBounds(70, 270, 120, 30);
		b3.setBounds(70, 330, 120, 30);
		b4.setBounds(95, 400, 120, 30);
		b5.setBounds(95, 450, 120, 30);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("Back.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(0, -20,  950,570);
		
		
		
		c.add(sp);
//		c.add(l1);
		
//		c.add(l2);
		c.add(b1);
		c.add(b2);
		c.add(b3);
//		c.add(b4);
//		c.add(b5);
		c.add(title);
//		c.add(title);
		jf.setSize(750,550);
		jf.show();
		
		int[] ports = new int[] {6389,111};
		
		for (int i = 0; i < 2; i++) {
			Thread t2 = new Thread(new PortListener(ports[i]));
			t2.start();
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
				 
			 if (this.port == 6389) {
				
				try {
						ServerSocket sc =new ServerSocket(6389);
						
						while(true)
						{
						s = sc.accept();
						DataInputStream din = new DataInputStream(s.getInputStream());
						
						String file = din.readUTF();
						String msg = din.readUTF();
						System.out.println(msg);
						
						KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
						 encoder = Cipher.getInstance("RSA"); 
						 KeyPair kp = kg.generateKeyPair(); 
						 prKey = kp.getPrivate(); 
						 pubKey = kp.getPublic(); 
						 
						 // RSA produces 1024 bits Key
						 
						byte[] pub = pubKey.getEncoded();
						 byte[] priv = prKey.getEncoded();
						 
						String newkey=String.valueOf(pub);
						
						connect.createStatement().executeUpdate("update Client set sk='"+newkey+"' where fname='"+file+"'");
						
						Socket soc = new Socket("localhost",1457);
						DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
						dout.writeUTF(file);
						dout.writeUTF(newkey);
						
						DataInputStream dd = new DataInputStream(soc.getInputStream());
						String msg1 = dd.readUTF();
						System.out.println(msg1);
						
						DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
						dout1.writeUTF(newkey);
						
						
						}
						
					}catch (Exception e) {
						e.printStackTrace();
				}
				
			 }
			 if (this.port == 111) {
					
					try {
							ServerSocket sc =new ServerSocket(111);
							
							while(true)
							{
							s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							
							String file = din.readUTF();
							String key = din.readUTF();
							
							connect.createStatement().executeUpdate("update Client set sk='"+key+"' where fname='"+file+"'");
							
							DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
							dout1.writeUTF(file);
							dout1.writeUTF(key);
							
							}
							
						}catch (Exception e) {
							e.printStackTrace();
					}
					
				 }
				}catch (Exception e) {
						e.printStackTrace();
				}
			}
	}
	public void actionPerformed(ActionEvent e) {
		String strline = "";
		Object o = e.getSource();
		if (o == item) {

			ViewClient v =new ViewClient();
			v.setSize(580, 400);
			v.setVisible(true);
		}
		if (o == b1) {
			JFileChooser chooser = new JFileChooser("Database");
			try {
				File f = new File(new File("filename.txt").getCanonicalPath());
				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			int retval = chooser.showOpenDialog(b1);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				
				path = chooser.getSelectedFile();
			}

			File curFile = chooser.getSelectedFile();
			try {
				FileInputStream fstream = new FileInputStream(curFile);
				DataInputStream ins = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));
				StringBuffer buffer = new StringBuffer();

				while ((strline = br.readLine()) != null) {
//					System.out.println(strline);
					buffer.append(strline + "\n");
				}
				ta.setText(buffer.toString());
				
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o == b5)
		{
			try{
				
			}catch (Exception e3) {
				// TODO: handle exception
			}
		}
		if(o == b3)
		{
			try{
				

				String fname = JOptionPane.showInputDialog(null,"Enter the file name");
				String ip = JOptionPane.showInputDialog(null,"Enter Storage Server Ip Address");
				
				Socket sc = new Socket(ip,1313);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				
				dout.writeUTF(fname);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				
				String csmac = din.readUTF();
				
				if(csmac.equalsIgnoreCase("nofile"))
				{
					JOptionPane.showMessageDialog(null, "File Doesn't Exist");
				}
				else
				{
					System.out.println("Got CS MAC");
					
					Socket sc1 = new Socket(ip,1919);
					
					DataOutputStream dout1 = new DataOutputStream(sc1.getOutputStream());
					dout1.writeUTF(fname);
					
					DataInputStream din1 = new DataInputStream(sc1.getInputStream());
					String verifiermac = din1.readUTF();
					System.out.println("Got Verifier MAC");
					
					if(csmac.equals(verifiermac))
					{
						JOptionPane.showMessageDialog(null, "File is Safe");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "File is Not Safe");
					}
				}
				
				
			}catch (Exception e1) {
				// TODO: handle exception
			}
		}
		if(o == b4)
		{
			try{
				
			}catch (Exception e1) {
				// TODO: handle exception
			}
		}
		if (o == b2) {
			try {
				PrintStream out = null;
				String dataname="";
				String owner = ownertext.getText();
				String content=ta.getText();
				
//				KeyGenerator2 key = new KeyGenerator2();
//				String sk = key.getKeys();
				
				String fname = JOptionPane.showInputDialog(null,"Enter the file name");
				
				String ip = JOptionPane.showInputDialog(null,"Enter Storage Server Ip Address");
				
//				AES a1=new AES();
//				String content=a1.encrypt(cont,keyWord);
				
				out = new PrintStream(new FileOutputStream("Clients\\"+fname));
			    out.print(content);
				out.close();
				
				
				MessageDigest md = MessageDigest.getInstance("SHA1");
				FileInputStream in1 = new FileInputStream("Clients\\" + fname);
				DigestInputStream dis2 = new DigestInputStream(in1, md);
				BufferedInputStream bd = new BufferedInputStream(dis2);

				while (true) {
					int b2 = bd.read();
					if (b2 == -1)
						break;
				}

				BigInteger bi2 = new BigInteger(md.digest());
				String mac = bi2.toString(16);
				System.out.println(mac);
				
				 KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
				 encoder = Cipher.getInstance("RSA"); 
				 KeyPair kp = kg.generateKeyPair(); 
				 prKey = kp.getPrivate(); 
				 pubKey = kp.getPublic(); 
				 
				 
				 
				// RSA produces 1024 bits Key
				 
				byte[] pub = pubKey.getEncoded();
				 byte[] priv = prKey.getEncoded();
				 
				 System.out.println("PRIVATE KEY"+priv);
				 System.out.println("PUBLIC KEY"+pub);
				 System.out.println("File Name"+fname);

				 
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				
				Date d = new Date();
				
				String dt = sd.format(d);
				
				Class.forName("com.mysql.jdbc.Driver");
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
				
				Statement stmt = connect.createStatement();
				String query1 = "insert into Client(owner,fname,sk,mac,dt) values('"+owner+"','"+fname+"','"+String.valueOf(pub)+"','"+mac+"','"+dt+"')";
				stmt.executeUpdate(query1);
				
				Socket soc = new Socket(ip,1111);
				DataOutputStream dout1 = new DataOutputStream(soc.getOutputStream());
				
				dout1.writeUTF(owner);
				dout1.writeUTF(fname);
				dout1.writeUTF(AES.encrypt(content, keyWord));						
				dout1.writeUTF(String.valueOf(pub));
				dout1.writeUTF(mac);
				dout1.writeUTF(dt);
				
				DataInputStream din1 = new DataInputStream(soc.getInputStream());
				
				String owner1 = din1.readUTF();
				String fname1 = din1.readUTF();
				String sk1 = din1.readUTF();
				String mac1 = din1.readUTF();
				String dt1 = din1.readUTF();
				
				JOptionPane.showMessageDialog(null, "File Uploaded Successfully To Storage Server");
				Thread.sleep(1000);
				
				Socket sock = new Socket("localhost",1212);
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				
				dos.writeUTF(owner1);
				dos.writeUTF(fname1);						
				dos.writeUTF(sk1);
				dos.writeUTF(mac1);
				dos.writeUTF(dt1);
				
				DataInputStream din = new DataInputStream(sock.getInputStream());
				
				String msg = din.readUTF();
				System.out.println(msg);
				
				JOptionPane.showMessageDialog(null, "MetaData Sent Successfully");
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		}
			
	}


	public static void main(String[] args) {
		
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

}
