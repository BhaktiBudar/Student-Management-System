import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts;

MainFrame()
{
c = getContentPane();
c.setLayout(null);

btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
btnCharts = new JButton("Charts");
btnAdd.setBounds(30,50,150,50);
btnView.setBounds(210,50,150,50);
btnUpdate.setBounds(30,140,150,50);
btnDelete.setBounds(210,140,150,50);
btnCharts.setBounds(120,230,150,50);

ActionListener a1 = (ae) -> { AddFrame a = new AddFrame(); dispose(); };
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> { ViewFrame a = new ViewFrame(); dispose(); };
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> { UpdateFrame a = new UpdateFrame(); dispose(); };
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> { DeleteFrame a = new DeleteFrame(); dispose(); };
btnDelete.addActionListener(a4);

ActionListener a5 = (ae) -> { Charts a = new Charts(); };
btnCharts.addActionListener(a5);

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnCharts);

Font f = new Font("Arial",Font.BOLD,24);
btnAdd.setFont(f);
btnView.setFont(f);
btnUpdate.setFont(f);
btnDelete.setFont(f);
btnCharts.setFont(f);

setTitle("S. M. S. ");
setSize(400, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
c.setBackground(Color.GREEN);
}
}