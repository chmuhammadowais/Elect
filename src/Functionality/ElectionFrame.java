package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectionFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    ImageIcon Timed_icon;
    JButton Timed_btn;
    JButton Timeless_btn;
    ImageIcon Timeless_icon;
    JButton back_btn;
    ImageIcon back_icon;
    JFrame frame;

    public ElectionFrame() {
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
        main_title.setText("Election Mode Setup");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
        //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(312,130,175,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        Timed_icon = new ImageIcon("./src/Resources/timed.png");
        Timed_btn = new JButton();
        Timed_btn.setIcon(Timed_icon);
        Timed_btn.setText("Timed");
        Timed_btn.setFocusable(false);
        Timed_btn.setContentAreaFilled(false);
        Timed_btn.setOpaque(false);
        Timed_btn.setFont(new Font("Calibri",Font.BOLD,17));
        Timed_btn.setBounds(180,230,200,200);
        Timed_btn.setBorder(null);
        Timed_btn.setVerticalTextPosition(JButton.TOP);
        Timed_btn.setHorizontalTextPosition(JButton.CENTER);
        Timed_btn.setIconTextGap(18);
        Timed_btn.addActionListener(this);

        Timeless_icon = new ImageIcon("./src/Resources/timeless.png");
        Timeless_btn = new JButton();
        Timeless_btn.setIcon(Timeless_icon);
        Timeless_btn.setText("Timeless");
        Timeless_btn.setFocusable(false);
        Timeless_btn.setContentAreaFilled(false);
        Timeless_btn.setOpaque(false);
        Timeless_btn.setFont(new Font("Calibri",Font.BOLD,17));
        Timeless_btn.setBounds(420,230,200,200);
        Timeless_btn.setBorder(null);
        Timeless_btn.setVerticalTextPosition(JButton.TOP);
        Timeless_btn.setHorizontalTextPosition(JButton.CENTER);
        Timeless_btn.setIconTextGap(20);
        Timeless_btn.addActionListener(this);



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

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(Timed_btn);
        frame.add(Timeless_btn);
        frame.add(back_btn);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Timed_btn){
           timed_call();
        } else if (e.getSource() == Timeless_btn) {
           timeless_call();
        }
        else if(e.getSource() == back_btn){
            back_call();
        }
    }
    public boolean timed_call(){
        try{
            new Timed();
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
    public boolean timeless_call(){
        try{
            new Timeless();
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
            new MainFrame();
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
}