import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
JButton submit;
    public Frame1(){
        this.setSize(800,500);
        this.setTitle("Candidate Registration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.red);
        ImageIcon icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());

        ImageIcon header = new ImageIcon("heading.png");
        JLabel label0 = new JLabel();
        label0.setText("Elect");
        label0.setFont(new Font("Calibri",Font.BOLD,32));
        label0.setIcon(header);
        label0.setIconTextGap(4);
        label0.setVerticalTextPosition(JLabel.BOTTOM);
        label0.setHorizontalTextPosition(JLabel.CENTER);
        //label0.setBorder(border);
        label0.setBounds(365,0,70,100);

        JLabel label1 = new JLabel();
        label1.setText("Candidate Registration Panel");
        label1.setFont(new Font("Calibri",Font.BOLD,20));
        //label1.setBorder(border);
        label1.setBounds(274,130,248,60);

        JPanel panel0= new JPanel();
        panel0.setBounds(100,210,600,3);
        panel0.setBorder(BorderFactory.createRaisedBevelBorder());

        ImageIcon avatar = new ImageIcon("avatar.png");
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        JLabel label_avatar = new JLabel();
        label_avatar.setIcon(avatar);
        label_avatar.setBounds(0,0,150,150);
        panel1.add(label_avatar);
        panel1.setFocusable(false);
        panel1.setOpaque(true);
        panel1.setBorder(new RoundedBorder(10));
        panel1.setBounds(125,230,150,150);

        JLabel StID = new JLabel();
        StID.setText("Student ID");
        StID.setFont(new Font("Calibri",Font.BOLD,18));
        //StID.setBorder(border);
        StID.setBounds(325,230,85,20);
        JPanel panel2= new JPanel();
        panel2.setBounds(325,250,350,3);
        panel2.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField ID = new JTextField();
        ID.setFont(new Font("Calibri",Font.PLAIN,15));
        ID.setBorder(null);
        ID.setBounds(410,230,265,20);

        JLabel Name = new JLabel();
        Name.setText("Student Name");
        Name.setFont(new Font("Calibri",Font.BOLD,18));
        //Name.setBorder(border);
        Name.setBounds(325,290,115,20);
        JPanel panel3= new JPanel();
        panel3.setBounds(325,310,350,3);
        panel3.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField Nm = new JTextField();
        Nm.setFont(new Font("Calibri",Font.PLAIN,15));
        Nm.setBorder(null);
        Nm.setBounds(440,290,235,20);

        JLabel Email = new JLabel();
        Email.setText("Student Email");
        Email.setFont(new Font("Calibri",Font.BOLD,18));
        //Email.setBorder(border);
        Email.setBounds(325,350,110,20);
        JPanel panel4= new JPanel();
        panel4.setBounds(325,370,350,3);
        panel4.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField Em = new JTextField();
        Em.setFont(new Font("Calibri",Font.PLAIN,15));
        Em.setBorder(null);
        Em.setBounds(435,350,240,20);


        JPanel test = new JPanel();
        test.setBounds(125,400,550,3);
        test.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));

        submit = new JButton();
        submit.setText("Register");
        submit.setFocusable(false);
        submit.setContentAreaFilled(false);
        submit.setOpaque(false);
        submit.setFont(new Font("Calibri",Font.BOLD,17));
        submit.setBounds(300,410,200,30);
        submit.setBorder(new RoundedBorder(20));

        this.add(label0);
        this.add(label1);
        this.add(panel0);
        this.add(panel1);
        this.add(StID);
        this.add(panel2);
        this.add(ID);
        this.add(Name);
        this.add(panel3);
        this.add(Nm);
        this.add(Email);
        this.add(panel4);
        this.add(Em);
        //this.add(test);
        this.add(submit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

        }
    }
}
