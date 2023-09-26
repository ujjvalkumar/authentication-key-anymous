
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
 
public class Results {
    public static void main(String[] args) {
        
    
  int count=0;
  int count1=0;
  int count2=0;
  int count3=0;
  int count4=0;
  
  String rname1=null;
  String rname2=null;
  String rname3=null;
  String rname4=null;
  String rname5=null;
  
  double c1=0.0;
  double c2=0.0;
  double c3=0.0;
  double c4=0.0;
  double c5=0.0;
  double c6=0.0;
  double c7=0.0;
  double c8=0.0;
  
 
  
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj6","root","root");
    		
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("select * from CloudServer");
    	
    		while(rs.next()==true)
    		{
    			count++;	
    			
    		}
    		
    		
    		Statement st1=con.createStatement();
    		ResultSet rs1=st1.executeQuery("select * from Attacker");
    	
    		while(rs1.next()==true)
    		{
    			count1++;	
    			
    		}
    	
    		
    		
    		   	DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    	        dataSet.setValue(count, "No of Files", "Files");
    	        dataSet.setValue(count1, "No of Attackers", "Attackers");
    	       
    	      
    	        JFreeChart chart = ChartFactory.createBarChart3D("Authentication and Key Agreement Based on Anonymous Identity for Peer-to-Peer Cloud", "Files and Attacker Details", "No of Files and Attackers",
    	        dataSet, PlotOrientation.VERTICAL, true, true, true);
    	        ChartFrame chartFrame=new ChartFrame("Storage Server Details",chart);
    	        chartFrame.setVisible(true);
    	        chartFrame.setSize(800,500);
    	}
    	catch(Exception ex)
    	{
    	System.out.println(ex);	
    		
    	}
    
}
}