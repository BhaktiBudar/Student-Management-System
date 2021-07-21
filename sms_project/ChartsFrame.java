import javax.swing.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.io.*;
import java.sql.*;

class Charts extends JFrame
{
Charts()
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");
String sql = "select * from student";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

DefaultCategoryDataset ds = new DefaultCategoryDataset();
while(rs.next())
{
ds.addValue(rs.getInt(3), rs.getString(2), "s1");
ds.addValue(rs.getInt(3), rs.getString(2), "s2");
ds.addValue(rs.getInt(3), rs.getString(2), "s3");
}
rs.close();

JFreeChart ch = ChartFactory.createBarChart("Students Performance", "Subject", "Marks", ds, PlotOrientation.VERTICAL, true, true, true);

ChartPanel cp = new ChartPanel(ch);
setContentPane(cp);

try
{
	File f = new File("Student.jpeg");
	ChartUtilities.saveChartAsJPEG(f, ch, 700, 400);
}
catch(IOException e)
{
System.out.println("issue " + e);
}
}
catch(SQLException e)
{
System.out.println("issue " + e);
}

setSize(700, 400);
setLocationRelativeTo(null);
setTitle("Mark Sheet");
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

class ChartsFrame
{
public static void main(String args[])
{
Charts a = new Charts();
}
}