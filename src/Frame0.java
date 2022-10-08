import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame0 extends JFrame implements ActionListener {
    JButton reg_btn;
    JButton start_btn;
    JButton result_btn;
    public Frame0(){
        this.setSize(800,500);
        this.setTitle("Admin Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.red);
        ImageIcon icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());


        ImageIcon header_icon = new ImageIcon("heading.png");
        JLabel elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(border);
        elect_heading.setBounds(365,0,70,100);

        JLabel welcome_title = new JLabel();
        welcome_title.setText("Welcome to Elect! Let's get started.");
        welcome_title.setFont(new Font("Calibri",Font.BOLD,20));
        //welcome_title.setBorder(border);
        welcome_title.setBounds(250,130,300,60);

        JPanel upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        reg_btn = new JButton();
        reg_btn.setText("Candidate Registration");
        reg_btn.setFocusable(false);
        reg_btn.setContentAreaFilled(false);
        reg_btn.setOpaque(false);
        reg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        reg_btn.setBounds(170,230,210,50);
        reg_btn.setBorder(new RoundedBorder(20));
        reg_btn.addActionListener(this);

        start_btn = new JButton();
        start_btn.setText("Start Election");
        start_btn.setFocusable(false);
        start_btn.setContentAreaFilled(false);
        start_btn.setOpaque(false);
        start_btn.setFont(new Font("Calibri",Font.BOLD,17));
        start_btn.setBounds(420,230,210,50);
        start_btn.setBorder(new RoundedBorder(20));
        start_btn.addActionListener(this);

        result_btn = new JButton();
        result_btn.setText("View Result");
        result_btn.setFocusable(false);
        result_btn.setContentAreaFilled(false);
        result_btn.setOpaque(false);
        result_btn.setFont(new Font("Calibri",Font.BOLD,17));
        result_btn.setBounds(295,314,210,50);
        result_btn.setBorder(new RoundedBorder(20));
        result_btn.addActionListener(this);


        this.add(elect_heading);
        this.add(welcome_title);
        this.add(upper_line);
        this.add(reg_btn);
        this.add(start_btn);
        this.add(result_btn);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
          if(e.getSource() == reg_btn){
              reg_btn.setEnabled(false);
              this.dispose();
              Frame1 frame1 = new Frame1();
          }
          else if(e.getSource() == start_btn){
              start_btn.setEnabled(false);
              this.dispose();
          }
          else if(e.getSource() == result_btn){
              result_btn.setEnabled(false);
              this.dispose();
          }
    }
}
