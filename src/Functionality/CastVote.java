package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CastVote implements ActionListener {
    String implementation_type;
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel user_ID;
    JPanel upper_line;
    ImageIcon avatar;
    JPanel pic_panel;
    JLabel pic_panel_def_pic;
    JButton cast_btn;
    static JFrame frame;
    JButton end_btn;
    JButton helpdesk;
    ImageIcon helpdesk_icon;
    public CastVote(String implementation_type){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        this.implementation_type = implementation_type;
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Voting Panel");
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
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365,0,70,100);

        user_ID = new JLabel();
        user_ID.setText("Click the button to cast your vote.");
        user_ID.setFont(new Font("Calibri",Font.BOLD,20));
       // main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        user_ID.setBounds(255,130,290,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon("./src/Resources/Vote.png");
        pic_panel = new JPanel();
        pic_panel.setLayout(null);
        pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBackground(Color.white);
        pic_panel_def_pic.setOpaque(true);
        pic_panel_def_pic.setBounds(0, 0, 150, 150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(325, 230, 150, 150);

        cast_btn = new JButton();
        cast_btn.setText("Cast Vote");
        cast_btn.setFocusable(false);
        cast_btn.setContentAreaFilled(false);
        cast_btn.setOpaque(false);
        cast_btn.setFont(new Font("Calibri", Font.BOLD, 17));
        cast_btn.setBounds(300, 400, 200, 30);
        cast_btn.setBorder(new RoundedBorder(20));
        cast_btn.addActionListener(this);

        helpdesk_icon = new ImageIcon("./src/Resources/help-icon.png");
        helpdesk = new JButton();
        helpdesk.setIcon(helpdesk_icon);
        helpdesk.setFocusable(false);
        helpdesk.setContentAreaFilled(false);
        helpdesk.setOpaque(false);
        helpdesk.addActionListener(this);
        helpdesk.setBounds(700,400,48,30);


        if(implementation_type.equals("Timeless")){
            end_btn = new JButton();
            end_btn.setText("End");
            end_btn.setFocusable(false);
            end_btn.setContentAreaFilled(false);
            end_btn.setOpaque(false);
            end_btn.setFont(new Font("Calibri", Font.BOLD, 17));
            end_btn.setBorder(new RoundedBorder(20));
            end_btn.addActionListener(this);
            cast_btn.setBounds(420, 400, 200, 30);
            end_btn.setBounds(180,400,200,30);
            frame.add(end_btn);

        }
        frame.add(elect_heading);
        frame.add(user_ID);
        frame.add(upper_line);
        frame.add(pic_panel);
        frame.add(cast_btn);
        frame.add(helpdesk);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cast_btn){
            cast_call();
        }
        else if (e.getSource() == end_btn) {
           end_call();
        } else if (e.getSource() == helpdesk) {
            System.out.println("Calling helpdesk");
            try {
                new HelpDesk();
            } catch (IOException ex) {
                System.out.println("Exception while calling Help Desk");
                JOptionPane.showMessageDialog(null,"We're Sorry Help Desk is currently unavailable.","Error retrieving help",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean cast_call(){
        try{
            new VoterVerification();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean end_call(){
        try{
            new AdminLogin("verification");
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }

}
