package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timeless implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JPanel lower_line;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel image_panel;
    ImageIcon avatar;
    JLabel image_panel_piclabel;
    JFrame frame;
    JButton proceed_btn;

    public Timeless(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Time Panel");
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

        main_title = new JLabel();
        main_title.setText("ProgramClasses.Timeless Election Setup");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
       // main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(300,130,200,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        lower_line = new JPanel();
        lower_line.setBounds(338, 350, 318, 3);
        lower_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon("./src/Resources/timeless.png");
        image_panel = new JPanel();
        image_panel.setLayout(null);
        image_panel_piclabel = new JLabel();
        image_panel_piclabel.setIcon(avatar);
        image_panel_piclabel.setBackground(Color.white);
        image_panel_piclabel.setOpaque(true);
        image_panel_piclabel.setBounds(0,0,150,150);
        image_panel.add(image_panel_piclabel);
        image_panel.setFocusable(false);
        image_panel.setOpaque(true);
        image_panel.setBorder(new RoundedBorder(10));
        image_panel.setBounds(135,250,150,150);

        JTextPane text = new JTextPane();
        text.setText("The timeless election shall have an 'End Election' button requiring administrative credentials to End Election process.");
        text.setFont(new Font("Calibri",Font.BOLD,18));
       // text.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        text.setEditable(false);
        text.setBounds(393,250,250,120);
        frame.add(text);

        back_btn = new JButton();
        back_icon = new ImageIcon("./src/Resources/back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(this);

        proceed_btn = new JButton();
        proceed_btn.setText("Proceed");
        proceed_btn.setFocusable(false);
        proceed_btn.setContentAreaFilled(false);
        proceed_btn.setOpaque(false);
        proceed_btn.setFont(new Font("Calibri",Font.BOLD,17));
        proceed_btn.setBounds(415,390,200,30);
        proceed_btn.setBorder(new RoundedBorder(20));
        proceed_btn.addActionListener(this);

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(image_panel);
        frame.add(back_btn);
        frame.add(proceed_btn);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proceed_btn){
           proceed_call();
        }
        else if(e.getSource() == back_btn){
            back_call();
        }
    }
    public boolean proceed_call(){
        try{
            new CastVote("Timeless");
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
    public boolean back_call(){
        try{
            new ElectionFrame();
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
    public static boolean complete_frame(){
        try{
            JFrame timesup_frame = new JFrame();
            timesup_frame.setSize(400,200);
            ImageIcon icon = new ImageIcon("./src/Resources/logo.png");
            timesup_frame.setIconImage(icon.getImage());
            timesup_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            timesup_frame.getContentPane().setBackground(Color.white);
            timesup_frame.setLocationRelativeTo(null);
            timesup_frame.setLayout(null);

            ImageIcon image = new ImageIcon("./src/Resources/complete.png");

            JLabel title = new JLabel();
            title.setText("Election Ended");
//        title.setBorder(BorderFactory.createLineBorder(Color.red));
            title.setFont(new Font("Calibri",Font.BOLD,25));
            title.setIcon(image);
            title.setIconTextGap(20);
            title.setBounds(60,0,280,100);

            JButton btn = new JButton();
            btn.setText("OK");
            btn.setFocusable(false);
            btn.setContentAreaFilled(false);
            btn.setOpaque(false);
            btn.setFont(new Font("Calibri", Font.BOLD, 15));
            btn.setBorder(new RoundedBorder(20));
            btn.addActionListener(ae2 -> timesup_frame.dispose());
            btn.setBounds(165,120,70,30);
            timesup_frame.add(btn);
            timesup_frame.add(title);
            timesup_frame.setVisible(true);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
        return false;
    }

}
