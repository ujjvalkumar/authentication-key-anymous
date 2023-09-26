import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class OwnerRegister implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JLabel b1,b2,b3,b4,b5;
	JButton submit,reset;
	JTextField t1,t3,t4,t5;
	JPasswordField t2;
	JLabel lab1;
	JComboBox cb;
	
	public OwnerRegister() 
	{
		frame = new JFrame("Register ::Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud");
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		b1 = new JLabel("Owner Name");
		b1.setBounds(80, 50, 80, 30);
		b2 = new JLabel("Password");
		b2.setBounds(80, 120, 80, 30);
		b3 = new JLabel("E-Mail");
		b3.setBounds(80, 190, 80, 30);
		b4 = new JLabel("Mobile ");
		b4.setBounds(80, 260, 80, 30);
		b5 = new JLabel("Address");
		b5.setBounds(80, 330, 80, 30);
		
		t1 = new JTextField();
		t1.setBounds(180, 50, 150, 30);
		t2 = new JPasswordField();
		t2.setBounds(180, 120, 150, 30);
		t3 = new JTextField();
		t3.setBounds(180, 190, 150, 30);
		t4 = new JTextField();
		t4.setBounds(180, 260, 150, 30);
		t5 = new JTextField();
		t5.setBounds(180, 330, 150, 30);
		submit = new JButton("Register");
		submit.setBounds(110, 400, 100, 30);
		
		reset = new JButton("Reset");
		reset.setBounds(230, 400, 80, 30);
		
		submit.addActionListener(this);
		reset.addActionListener(this);
	
		cb=new JComboBox();
		
//		ImageIcon img1 = new ImageIcon(this.getClass().getResource("register.jpg"));
//		lab1 = new JLabel();
//		lab1.setIcon(img1);
//		lab1.setBounds(120, 10, 400, 350);
		
		cb.addItem("DATA SET 1");
		cb.addItem("DATA SET 2");
		cb.addItem("DATA SET 3");
		cb.addItem("DATA SET 4");
		cb.addItem("DATA SET 5");
		
		cb.setBounds(180, 330, 150, 30);
		cb.addActionListener(this);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		
		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(submit);
		panel.add(reset);
//		panel.add(lab1);
		//panel.add(cb);
//		panel.setBackground(Color.white);
		frame.add(panel);
		
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public static void main(String[] args) 
		{

		}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource()==submit)
		{
			try{
			String name = t1.getText();
			String password = t2.getText();
			String email = t3.getText();
			String mob = t4.getText();
			String addr = t5.getText();
			
			String ip=JOptionPane.showInputDialog("Enter the cloud server IP address");
			
			Socket sc = new Socket(ip,3090);
			DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
			
			dout.writeUTF(name);
			dout.writeUTF(password);
			dout.writeUTF(email);
			dout.writeUTF(mob);
			dout.writeUTF(addr);
			
			
			DataInputStream din = new DataInputStream(sc.getInputStream());
			String msg = din.readUTF();
			
			JOptionPane.showMessageDialog(null, "Registered Successfully");
			
			}catch (Exception e1) {
				// TODO: handle exception
			}
			
		}
		
		if(e.getSource()==reset)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
	}
	
}
