import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;
public class MessageAttacker extends JFrame implements ActionListener
{
	JPanel p1;
	JLabel l1,l2;
	JTextField t1,t2;
	JTextArea ta;
	JScrollPane pane;
	JButton b1,b2;
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	
	public Font f1 = new Font("Times new roman", Font.BOLD, 25);
	public Font f2 = new Font("Times new roman", Font.BOLD, 15);
	
	MessageAttacker()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.red);
		setTitle("Message Attacker ::Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		
		l1=new JLabel("File Name :");
		l1.setFont(f2);
		l1.setForeground(Color.white);
		l1.setBounds(55,70,100,30);
		l2=new JLabel("Keyword");
		
		t1=new JTextField();
		t1.setBounds(150,70,100,25);
		t2=new JTextField();
		
		b1=new JButton("Hack");
		b1.setBounds(290,100,100,25);
		
		b2=new JButton("Attack");
		b2.setBounds(150,400,100,25);
		
		ta=new JTextArea();
		pane=new JScrollPane();
		pane.setViewportView(ta);
		ta.setRows(50);
		ta.setColumns(50);
		pane.setBounds(50,120,300,250);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		p1.add(pane);
		p1.add(l1);p1.add(l2);
		p1.add(t1);
		p1.add(t2);
		//p1.add(b1);
		p1.add(b2);
		add(p1);
		setSize(410,480);
		setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		new MessageAttacker();
		
	}
	public void actionPerformed(ActionEvent a1) 
	{
		if(a1.getSource()==b2)
		{
			String fname=t1.getText();
			
			try
			{
				String text = ta.getText();
				String ip = JOptionPane.showInputDialog(null,"Enter Cloud Server Ip Address");

				InetAddress ia = InetAddress.getLocalHost();
				String ip1 = ia.getHostAddress();
				
				Socket sc = new Socket(ip,4949);
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				
				dout.writeUTF(fname);
				dout.writeUTF(text);
				dout.writeUTF(ip1);
				
				DataInputStream din = new DataInputStream(sc.getInputStream());
				
				String msg = din.readUTF();
				
				 if(msg.equalsIgnoreCase("attack"))
					{  
						 JOptionPane.showMessageDialog(null, "Successfully Attacked");
						 ta.setText("");
					}
				  if(msg.equalsIgnoreCase("notfound"))
					{
						JOptionPane.showMessageDialog(null, "File Doesn't Exixt");
					}
				  if(msg.equalsIgnoreCase("block"))
					{
						JOptionPane.showMessageDialog(null, "You Are Blocked");
					}
				  
			}catch(Exception es){System.out.println(es);}
		}
		
		if(a1.getSource()==b1)
		{
			
		}
		
	}
	

}
