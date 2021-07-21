import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class DbHandler
{
public static void addStudent(int rno, String name, int marks1, int marks2, int marks3)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

String sql = "insert into student values(?, ?, ?, ?, ?)";
PreparedStatement pst = con.prepareStatement(sql);
if (rno <= 0)
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid rno");
}
else if (name.length() < 2 || ! name.matches("^[a-zA-Z ]*$"))
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid name");
}
else if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100)
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid marks");
}
else
{
pst.setInt(1, rno);
pst.setString(2, name);
pst.setInt(3, marks1);
pst.setInt(4, marks2);
pst.setInt(5, marks3);
pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(), "Record added");
}
con.close();
}
catch(SQLException e)
{
	JOptionPane.showMessageDialog(new JDialog(), "Record already exists");
}
}

public static String viewStudent()
{
String data = "";
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

String sql = "select * from student";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next())
	data = data + " rno = " + rs.getInt(1) + " name = " + rs.getString(2) + " marks1 = " + rs.getInt(3) + " marks2 = " + rs.getInt(4) + " marks3 = " + rs.getInt(5) + "\n";
con.close();
}
catch(SQLException e)
{
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
return data;
}

public static void updateStudent(int rno, String name, int marks1, int marks2, int marks3)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

String sql = "update student set name = ?, marks1 = ?, marks2 = ?, marks3 = ?  where rno = ?";
PreparedStatement pst = con.prepareStatement(sql);
if (rno <= 0)
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid rno");
}
else if (name.length() < 2 || ! name.matches("^[a-zA-Z ]*$"))
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid name");
}
else if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100)
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid marks");
}
else
{
pst.setInt(5, rno);
pst.setString(1, name);
pst.setInt(2, marks1);
pst.setInt(3, marks2);
pst.setInt(4, marks3);
int r = pst.executeUpdate();
if ( r == 0)
{
	JOptionPane.showMessageDialog(new JDialog(), "Record does not exists");
}
else
{
	JOptionPane.showMessageDialog(new JDialog(), "Record updated");
}
}
con.close();
}
catch(SQLException e)
{
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
}

public static void deleteStudent(int rno)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

String sql = "delete from student where rno = ?";
PreparedStatement pst = con.prepareStatement(sql);
if (rno <= 0)
{
	JOptionPane.showMessageDialog(new JDialog(), "Invalid rno");
}
else
{
pst.setInt(1, rno);
int r = pst.executeUpdate();
if ( r == 0)
{
	JOptionPane.showMessageDialog(new JDialog(), "Record does not exists");
}
else
{
JOptionPane.showMessageDialog(new JDialog(), "Record deleted");
}
}
con.close();
}
catch(SQLException e)
{
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
}
}