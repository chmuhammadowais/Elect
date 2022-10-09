import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JButton cand_mgmt_btn;
    JButton start_btn;
    JButton result_btn;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel elect_heading;
    JLabel welcome_title;
    JPanel upper_line;
    public MainFrame(){
        this.setSize(800,500);
        this.setTitle("Admin Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());


        header_icon = new ImageIcon("heading.png");
        elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365,0,70,100);

        welcome_title  = new JLabel();
        welcome_title.setText("Welcome to Elect! Let's get started.");
        welcome_title.setFont(new Font("Calibri",Font.BOLD,20));
        //welcome_title.setBorder(BorderFactory.createLineBorder(Color.red));
        welcome_title.setBounds(250,130,300,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        cand_mgmt_btn = new JButton();
        cand_mgmt_btn.setText("Candidate Management");
        cand_mgmt_btn.setFocusable(false);
        cand_mgmt_btn.setContentAreaFilled(false);
        cand_mgmt_btn.setOpaque(false);
        cand_mgmt_btn.setFont(new Font("Calibri",Font.BOLD,17));
        cand_mgmt_btn.setBounds(165,230,215,50);
        cand_mgmt_btn.setBorder(new RoundedBorder(20));
        cand_mgmt_btn.addActionListener(this);

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
        this.add(cand_mgmt_btn);
        this.add(start_btn);
        this.add(result_btn);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
          if(e.getSource() == cand_mgmt_btn){
              cand_mgmt_btn.setEnabled(false);
              this.dispose();
              new RegUnregFrame();
          }
          else if(e.getSource() == start_btn){
              this.dispose();
              start_btn.setEnabled(false);
          }
          else if(e.getSource() == result_btn){
              this.dispose();
              result_btn.setEnabled(false);
          }
    }
}
