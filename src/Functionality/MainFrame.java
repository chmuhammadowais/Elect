package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    JButton cand_mgmt_btn;
    JButton elec_start_btn;
    JButton result_btn;
    JButton adm_signupdete_btn;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel elect_heading;
    JLabel welcome_title;
    JPanel upper_line;
    static JFrame frame;
    JButton logout_btn;
    public MainFrame(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Admin Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("./src/Resources/logo.png");
        frame.setIconImage(icon.getImage());


        header_icon = new ImageIcon("./src/Resources/heading.png");
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
        cand_mgmt_btn.setBounds(165,250,215,50);
        cand_mgmt_btn.setBorder(new RoundedBorder(20));
        cand_mgmt_btn.addActionListener(this);

        elec_start_btn = new JButton();
        elec_start_btn.setText("Start Election");
        elec_start_btn.setFocusable(false);
        elec_start_btn.setContentAreaFilled(false);
        elec_start_btn.setOpaque(false);
        elec_start_btn.setFont(new Font("Calibri",Font.BOLD,17));
        elec_start_btn.setBounds(420,250,215,50);
        elec_start_btn.setBorder(new RoundedBorder(20));
        elec_start_btn.addActionListener(this);

        result_btn = new JButton();
        result_btn.setText("View Result");
        result_btn.setFocusable(false);
        result_btn.setContentAreaFilled(false);
        result_btn.setOpaque(false);
        result_btn.setFont(new Font("Calibri",Font.BOLD,17));
        result_btn.setBounds(165,334,215,50);
        result_btn.setBorder(new RoundedBorder(20));
        result_btn.addActionListener(this);

        adm_signupdete_btn = new JButton();
        adm_signupdete_btn.setText("Admin Signup / Delete");
        adm_signupdete_btn.setFocusable(false);
        adm_signupdete_btn.setContentAreaFilled(false);
        adm_signupdete_btn.setOpaque(false);
        adm_signupdete_btn.setFont(new Font("Calibri",Font.BOLD,17));
        adm_signupdete_btn.setBounds(420,334,215,50);
        adm_signupdete_btn.setBorder(new RoundedBorder(20));
        adm_signupdete_btn.addActionListener(this);


        logout_btn = new JButton();
        ImageIcon logout = new ImageIcon("./src/Resources/logout.png");
        logout_btn.setIcon(logout);
        logout_btn.setFocusable(false);
        logout_btn.setContentAreaFilled(false);
        logout_btn.setOpaque(false);
        logout_btn.setFont(new Font("Calibri",Font.BOLD,17));
        logout_btn.setBounds(30,410,30,30);
        logout_btn.setBorder(null);
        logout_btn.addActionListener(this);

        frame.add(elect_heading);
        frame.add(welcome_title);
        frame.add(upper_line);
        frame.add(cand_mgmt_btn);
        frame.add(elec_start_btn);
        frame.add(result_btn);
        frame.add(adm_signupdete_btn);
        frame.add(logout_btn);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
          if(e.getSource() == cand_mgmt_btn){
              cand_mgmt_call();
          }
          else if(e.getSource() == elec_start_btn){
             elec_start_call();
          }
          else if(e.getSource() == result_btn){
             res_call();
          }
          else if(e.getSource() == adm_signupdete_btn){
              adm_signupdelete_call();
          }
          else if(e.getSource() == logout_btn){
             logout_call();
          }
    }
    public boolean cand_mgmt_call(){
        try{
            cand_mgmt_btn.setEnabled(false);
            frame.dispose();
            new CandidatteManagement();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean elec_start_call(){
        try{
            frame.dispose();
            new ElectionFrame();
            elec_start_btn.setEnabled(false);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean res_call(){
        try{
            frame.dispose();
            new Results();
            result_btn.setEnabled(false);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }


    }
    public boolean adm_signupdelete_call(){
        try{
            new AdminLogin("verification");
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean logout_call(){
        try{
            new AdminLogin("MainFrame");
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
}
