import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblrno, lblname, lblmarks1, lblmarks2, lblmarks3;
JTextField txtrno, txtname, txtmarks1, txtmarks2, txtmarks3;
JButton btnSave, btnBack;

AddFrame()
{
c = getContentPane();
c.setLayout(null);

lblrno = new JLabel("Enter rno:");
txtrno = new JTextField(35);
lblname = new JLabel("Enter name:");
txtname = new JTextField(35);
lblmarks1 = new JLabel("Enter sub marks 1:");
txtmarks1 = new JTextField(35);
lblmarks2 = new JLabel("Enter sub marks 2:");
txtmarks2 = new JTextField(35);
lblmarks3 = new JLabel("Enter sub marks 3:");
txtmarks3 = new JTextField(35);
btnSave = new JButton("Save");
btnBack = new JButton("Back");
lblrno.setBounds(20,10,350,30);
txtrno.setBounds(20,40,350,30);
lblname.setBounds(20,70,350,30);
txtname.setBounds(20,100,350,30);
lblmarks1.setBounds(20,130,350,30);
txtmarks1.setBounds(20,160,350,30);
lblmarks2.setBounds(20,190,350,30);
txtmarks2.setBounds(20,220,350,30);
lblmarks3.setBounds(20,250,350,30);
txtmarks3.setBounds(20,280,350,30);
btnSave.setBounds(120,330,150,50);
btnBack.setBounds(120,400,150,50);

c.add(lblrno);
c.add(txtrno);
c.add(lblname);
c.add(txtname);
c.add(lblmarks1);
c.add(txtmarks1);
c.add(lblmarks2);
c.add(txtmarks2);
c.add(lblmarks3);
c.add(txtmarks3);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) -> { MainFrame a = new MainFrame(); dispose(); };
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
	try
	{
	int rno = Integer.parseInt(txtrno.getText());
	String name = txtname.getText();
	int marks1 = Integer.parseInt(txtmarks1.getText());
	int marks2 = Integer.parseInt(txtmarks2.getText());
	int marks3 = Integer.parseInt(txtmarks3.getText());
	DbHandler db = new DbHandler();
	db.addStudent(rno, name, marks1, marks2, marks3);
	txtrno.setText("");
	txtname.setText("");
	txtmarks1.setText("");
	txtmarks2.setText("");
	txtmarks3.setText("");
	txtrno.requestFocus();
	}
	catch(NumberFormatException e)
	{
		JOptionPane.showMessageDialog(new JDialog(), "You need to enter correct values");
		txtrno.setText("");
		txtname.setText("");
		txtmarks1.setText("");
		txtmarks2.setText("");
		txtmarks3.setText("");
		txtrno.requestFocus();
	}
};
btnSave.addActionListener(a2);

Font f = new Font("Arial",Font.BOLD,24);
Font f1 = new Font("Arial",Font.BOLD,15);
lblrno.setFont(f1);
txtrno.setFont(f1);
lblname.setFont(f1);
txtname.setFont(f1);
lblmarks1.setFont(f1);
txtmarks1.setFont(f1);
lblmarks2.setFont(f1);
txtmarks2.setFont(f1);
lblmarks3.setFont(f1);
txtmarks3.setFont(f1);
btnSave.setFont(f);
btnBack.setFont(f);

setTitle("Add St");
setSize(400, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
c.setBackground(Color.BLUE);
}
}