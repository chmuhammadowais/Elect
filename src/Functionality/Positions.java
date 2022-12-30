package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedList;

public class Positions implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JPanel container;
    JScrollPane sp;
    static ButtonGroup btn_grp;
    JRadioButton pos_btn;
    JButton proceed_btn;
    ImageIcon proceed;

    public static JFrame frame;
    public static int counter_for_btngrp = 0;
    public Positions(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Voting Panel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        main_title.setText("Select position you would like to vote for");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
       // main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(225,130,350,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        container.setBackground(Color.white);
        btn_grp = new ButtonGroup();
        ImageIcon selected = new ImageIcon("./src/Resources/selected.png");
        ImageIcon unselected = new ImageIcon("./src/Resources/unselected.png");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
            PreparedStatement ps = con.prepareStatement("select distinct Position from candidates");

            try {
                LinkedList<String> positions = new LinkedList<>();
                int btn_creation_counter = 0;
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    positions.add(rs.getNString("Position"));
                    pos_btn = new JRadioButton();
                    pos_btn.setText(positions.get(btn_creation_counter));
                    pos_btn.setActionCommand(positions.get(btn_creation_counter));
                    pos_btn.addActionListener(this);
                    pos_btn.setIcon(unselected);
                    pos_btn.setSelectedIcon(selected);
                    pos_btn.setIconTextGap(10);
                    pos_btn.setVerticalTextPosition(JRadioButton.CENTER);
                    pos_btn.setHorizontalTextPosition(JRadioButton.RIGHT);
                    pos_btn.setFocusable(false);
                    pos_btn.setContentAreaFilled(false);
                    pos_btn.setOpaque(false);
                    pos_btn.setFont(new Font("Calibri",Font.BOLD,20));
                    pos_btn.setPreferredSize(new Dimension(400,50));
                    btn_grp.add(pos_btn);
                    container.add(pos_btn);
                    btn_creation_counter++;
                }
                container.setPreferredSize(new Dimension(200,btn_creation_counter*56));
                sp = new JScrollPane(container);
                sp.setLayout(new ScrollPaneLayout());
                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                sp.setBackground(Color.white);
                sp.setBorder(null);
                sp.getVerticalScrollBar().setBorder(BorderFactory.createLineBorder(null));
                sp.getViewport().setBackground(Color.white);
                sp.setBounds(325,250,300,200);

            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
        }


        proceed_btn = new JButton();
        proceed = new ImageIcon("./src/Resources/forward.png");
        proceed_btn.setIcon(proceed);
        proceed_btn.setFocusable(false);
        proceed_btn.setContentAreaFilled(false);
        proceed_btn.setOpaque(false);
        proceed_btn.setFont(new Font("Calibri",Font.BOLD,17));
        proceed_btn.addActionListener(this);
        proceed_btn.setBounds(740,410,30,30);

        counter_for_btngrp = btn_grp.getButtonCount();

        frame.add(sp);
        frame.add(sp);
        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(proceed_btn);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proceed_btn){
           proceed_call();
        }
    }
    public boolean proceed_call(){
        if(btn_grp.getSelection() == null) return true;
        try{
            //correction to selection of radio button even after disabling
            counter_for_btngrp--;
            //System.out.println(btn_grp.getSelection().getActionCommand());
            btn_grp.getSelection().setEnabled(false);
            new OptionCreator(btn_grp.getSelection().getActionCommand());
            if(counter_for_btngrp == btn_grp.getButtonCount()){
                frame.dispose();
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
}
