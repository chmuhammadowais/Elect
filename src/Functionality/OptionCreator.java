package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedList;

public class OptionCreator implements ActionListener, Runnable {
    String post_to_retrieve;
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JPanel container;
    ButtonGroup btn_grp;
    JButton vote_button;
    JScrollPane sp;
    static JFrame frame;
    public OptionCreator(String post_to_retrieve){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        this.post_to_retrieve = post_to_retrieve;
        frame.setSize(800, 500);
        frame.setTitle("Selection Panel");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("./src/Resources/logo.png");
        frame.setIconImage(icon.getImage());

        header_icon = new ImageIcon("./src/Resources/heading.png");
        elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri", Font.BOLD, 32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
       // elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365, 0, 70, 100);

        main_title = new JLabel();
        main_title.setText("Candidate selection panel");
        main_title.setFont(new Font("Calibri", Font.BOLD, 20));
      //  main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(290, 130, 220, 60);

        upper_line = new JPanel();
        upper_line.setBounds(100, 210, 600, 3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        container = new JPanel();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.white);
       // container.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        ImageIcon selected = new ImageIcon("./src/Resources/check.png");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
            PreparedStatement ps = con.prepareStatement("select Name,Position,Picture from candidates where Position=?");

            try {
                ps.setString(1,post_to_retrieve);
                ResultSet rs = ps.executeQuery();
                int panel_creation_counter = 0;
                btn_grp = new ButtonGroup();
                while (rs.next()) {
                    String Name = rs.getString("Name");
                    String post = rs.getString("Position");
                    Blob blob = rs.getBlob("Picture");
                    ImageIcon image = new ImageIcon(blob.getBytes(1, (int)blob.length()));
                    ImageIcon imgThisImg = new ImageIcon(new ImageIcon(image.getImage()).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    JRadioButton but = new JRadioButton();
                    but.setActionCommand(Name);
                    but.setBackground(Color.white);
                    but.setIcon(imgThisImg);
                    but.setSelectedIcon(selected);
                    but.setFont(new Font("Calibri",Font.BOLD,17));
                    but.setFocusable(false);
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.white);
                    but.addActionListener(this);
                    but.setText(Name+" standing as "+post);
                    panel.add(but);
                    btn_grp.add(but);
                    //panel.setBorder(BorderFactory.createLineBorder(Color.red));
                    panel.setPreferredSize(new Dimension(300,50));
                    container.add(panel);

//                    System.out.println(Name+post);
                    panel_creation_counter++;
                }


                container.setPreferredSize(new Dimension(300,panel_creation_counter*56));
                sp = new JScrollPane(container);
                sp.setLayout(new ScrollPaneLayout());
                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                sp.setBorder(BorderFactory.createLineBorder(Color.white));
                sp.setBackground(Color.white);
                sp.getVerticalScrollBar().setBorder(BorderFactory.createLineBorder(null));
                //sp.setBorder(BorderFactory.createLineBorder(Color.red));
                sp.getViewport().setBackground(Color.white);
                sp.setBounds(200,250,400,160);

                vote_button = new JButton("Vote");
                vote_button.setPreferredSize(new Dimension(200,50));
                vote_button.setFocusable(false);
                vote_button.setContentAreaFilled(false);
                vote_button.setOpaque(false);
                vote_button.setFont(new Font("Calibri",Font.BOLD,17));
                vote_button.addActionListener(this);
                vote_button.setBorder(new RoundedBorder(5));
                vote_button.setBounds(300,420,200,30);

            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
        }

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(sp);
        frame.add(vote_button);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vote_button){
            vote_call();
        }
    }
    public boolean vote_call(){
        if(Positions.btn_grp == null){
            return true;
        }
        Positions.btn_grp.clearSelection();
        try{
            System.out.println(btn_grp.getSelection().getActionCommand());
            frame.dispose();
            Connection con;
            try{
                int VoterID = VoterVerification.Voter_ID;
                String Candidate = btn_grp.getSelection().getActionCommand();
                con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
                PreparedStatement ps = con.prepareStatement("insert into Votes values(?,?)");

                ps.setInt(1,VoterID);
                ps.setString(2,Candidate);
                ps.executeUpdate();
                run();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Vote already casted, cannot caste vote more than once.","Error casting vote",JOptionPane.ERROR_MESSAGE);
                OptionCreator.frame.dispose();
                Positions.frame.dispose();
                System.out.println("Exception : "+ex);
                return false;
            }
            if(Positions.counter_for_btngrp == 0){
                JOptionPane.showMessageDialog(null, "Vote Cast Successful","Vote Casted",JOptionPane.INFORMATION_MESSAGE);
                Positions.frame.dispose();
                if(CastVote.frame == null){
                    new CastVote("Timeless");
                }
                return true;
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"At least select one of the given options.","Error",JOptionPane.WARNING_MESSAGE);
            System.out.println("Exception : "+ex);
            return false;
        }
        return false;
    }

    public void sub_run(){
        try{
            System.out.println("Notification for : Vote cast");
            System.out.println("User ID : "+VoterVerification.Voter_ID +" voted for "+btn_grp.getSelection().getActionCommand());
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
    }

    @Override
    public void run() {
        try{
            LinkedList<String> admins = new LinkedList<>();
            Connection con;
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
                PreparedStatement ps = con.prepareStatement("select username from Admin");

                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String admin = rs.getString("username");
                    admins.add(admin);
                }

                for (String ad : admins) {
                    System.out.println("-----------------------------------");
                    System.out.println("Administrator "+ad);
                    sub_run();
                    System.out.println("-----------------------------------");
                }

            }   catch (SQLException ex) {
                System.out.println("Exception : " + ex);

            }
        }
        catch(Exception ex){
            System.out.println("Exception : "+ex);
        }
    }
}
