package Functionality;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisteredCandidates implements ActionListener {
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JLabel elect_heading;
    JPanel upper_line;
    JButton back_btn;
    ImageIcon back_icon;
    JTable table;
    JFrame frame;
    public RegisteredCandidates(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Registered Candidates Panel");
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
        //elect_heading.setBorder(border);
        elect_heading.setBounds(365,0,70,100);


        main_title = new JLabel();
        main_title.setText("Registered Candidates");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
        //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(305,130,190,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

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

        JPanel info_panel = new JPanel();
        info_panel.setBounds(100,250,600,200);
        info_panel.setLayout(null);
        info_panel.setBackground(Color.white);
        String[] Headings = { "ID", "Name", "Position" };
        String[][] Data = {};
        DefaultTableModel model = new DefaultTableModel(Data,Headings);
        table = new JTable(model);
        table.setFont(new Font("Calibri",Font.BOLD,15));
        table.setBounds(0, 0, 600, 190);
        table.setShowVerticalLines(false);
        table.getTableHeader().setFont(new Font("Calibri",Font.BOLD,18));
        table.getTableHeader().setBackground(Color.lightGray);
        table.setRowHeight(30);
        table.setBackground(Color.white);


        JScrollPane sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(BorderFactory.createLineBorder(Color.white));
        sp.setBackground(Color.white);
        sp.getVerticalScrollBar().setBorder(BorderFactory.createLineBorder(null));
        sp.getViewport().setBackground(Color.white);
        sp.setBounds(0,0,600,200);
        info_panel.add(sp);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
            String query = "select ID, Name, Position from Candidates";
            try (java.sql.Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                int counter = 0;
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String Name = rs.getString("Name");
                    String Post = rs.getString("Position");
                    model.insertRow(counter,new Object[]{ID,Name,Post});
                    counter++;
                }
            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
            }
        }     catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
        }

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(back_btn);
        frame.add(info_panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_btn){
        back_call();
        }
    }
    public boolean back_call(){
        try{
            new CandidatteManagement();
            frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }
    }
}
