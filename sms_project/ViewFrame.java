import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame()
{
c = getContentPane();
c.setLayout(null);

taData = new TextArea(10, 50);
btnBack = new JButton("Back");
taData.setBounds(20,20,350,200);
btnBack.setBounds(120,250,150,50);

c.add(taData);
c.add(btnBack);

ActionListener a1 = (ae) -> { MainFrame a = new MainFrame(); dispose(); };
btnBack.addActionListener(a1);

String data = DbHandler.viewStudent();
taData.setText(data);
taData.setEditable(false);
taData.setBackground(Color.YELLOW);

Font f = new Font("Arial",Font.BOLD,24);
Font f1 = new Font("Arial",Font.PLAIN,15);
taData.setFont(f1);
btnBack.setFont(f);

setTitle("View St");
setSize(400, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
c.setBackground(Color.YELLOW);
}
}