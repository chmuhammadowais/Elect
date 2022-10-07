import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame0 extends JFrame implements ActionListener {
    JButton button0;
    JButton button1;
    JButton button2;
    public Frame0(){
        this.setSize(800,500);
        this.setTitle("Elect");
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
        label1.setText("Welcome to Elect! Let's get started.");
        label1.setFont(new Font("Calibri",Font.BOLD,20));
        //label1.setBorder(border);
        label1.setBounds(250,130,300,60);

        JPanel panel = new JPanel();
        panel.setBounds(100,210,600,3);
        panel.setBorder(BorderFactory.createRaisedBevelBorder());

        button0 = new JButton();
        button0.setText("Candidate Registration");
        button0.setFocusable(false);
        button0.setContentAreaFilled(false);
        button0.setOpaque(true);
        button0.setFont(new Font("Calibri",Font.PLAIN,17));
        button0.setBounds(180,230,200,50);
        button0.setBorder(new RoundedBorder(20));
        button0.addActionListener(this);

        button1 = new JButton();
        button1.setText("Start Election");
        button1.setFocusable(false);
        button1.setContentAreaFilled(false);
        button1.setOpaque(true);
        button1.setFont(new Font("Calibri",Font.PLAIN,17));
        button1.setBounds(420,230,200,50);
        button1.setBorder(new RoundedBorder(20));
        button1.addActionListener(this);

        button2 = new JButton();
        button2.setText("View Result");
        button2.setFocusable(false);
        button2.setContentAreaFilled(false);
        button2.setOpaque(true);
        button2.setFont(new Font("Calibri",Font.PLAIN,17));
        button2.setBounds(300,314,200,50);
        button2.setBorder(new RoundedBorder(20));
        button2.addActionListener(this);


        this.add(label0);
        this.add(label1);
        this.add(panel);
        this.add(button0);
        this.add(button1);
        this.add(button2);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
          if(e.getSource() == button0){
              button0.setEnabled(false);
              System.out.println("Button 0");
          }
          else if(e.getSource() == button1){
              button1.setEnabled(false);
              System.out.println("Button 1");
          }
          else if(e.getSource() == button2){
              button2.setEnabled(false);
              System.out.println("Button 2");
          }
    }
}
