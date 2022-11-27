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

public class Results implements ActionListener {
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JLabel elect_heading;
    JPanel upper_line;
    JButton back_btn;
    ImageIcon back_icon;
    JTable table;
    JFrame frame;
    JButton compile_btn;
    ImageIcon compile_icon;
    ImageIcon detail_icon;
    JButton detailed_btn;
    JButton df_back;
    JFrame df ;
    public Results(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Election Result Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());


        header_icon = new ImageIcon("heading.png");
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
        main_title.setText("Elections ProgramClasses.Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        compile_icon = new ImageIcon("compile.png");
        compile_btn = new JButton();
        compile_btn.setText("Compiled ProgramClasses.Results");
        compile_btn.setIcon(compile_icon);
        compile_btn.setFocusable(false);
        compile_btn.setContentAreaFilled(false);
        compile_btn.setOpaque(false);
        compile_btn.setFont(new Font("Calibri",Font.BOLD,17));
        compile_btn.setBounds(220,250,150,160);
        compile_btn.setBorder(null);
        compile_btn.setVerticalTextPosition(JButton.BOTTOM);
        compile_btn.setHorizontalTextPosition(JButton.CENTER);
        compile_btn.setIconTextGap(0);
        compile_btn.addActionListener(this);

        detailed_btn = new JButton();
        detail_icon = new ImageIcon("details.png");
        detailed_btn.setText("Detailed ProgramClasses.Results");
        detailed_btn.setIcon(detail_icon);
        detailed_btn.setFocusable(false);
        detailed_btn.setContentAreaFilled(false);
        detailed_btn.setOpaque(false);
        detailed_btn.setFont(new Font("Calibri",Font.BOLD,17));
        detailed_btn.setBounds(430,250,150,160);
        detailed_btn.setBorder(null);
        detailed_btn.setVerticalTextPosition(JButton.BOTTOM);
        detailed_btn.setHorizontalTextPosition(JButton.CENTER);
        detailed_btn.addActionListener(this);


        back_btn = new JButton();
        back_icon = new ImageIcon("back.png");
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
        frame.add(back_btn);

        frame.add(compile_btn);
        frame.add(detailed_btn);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compile_btn){
            CompiledResults_call();
        }
        else if(e.getSource() == detailed_btn){
            DetailedResult_call();
        } else if (e.getSource() == back_btn) {
            back_call();
        } else if (e.getSource() == df_back) {
          df_back_call();
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
    public boolean df_back_call(){
        if(df == null){
            return true;
        }
        try{
            df.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean DetailedResult_call(){
        df = new JFrame();
        df.setSize(800,500);
        df.setTitle("Election Result Panel");
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setLocationRelativeTo(null);
        df.setResizable(false);
        df.setLayout(null);
        df.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        df.setIconImage(icon.getImage());


        header_icon = new ImageIcon("heading.png");
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
        main_title.setText("Elections ProgramClasses.Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        df_back = new JButton();
        back_icon = new ImageIcon("back.png");
        df_back.setIcon(back_icon);
        df_back.setFocusable(false);
        df_back.setContentAreaFilled(false);
        df_back.setOpaque(false);
        df_back.setFont(new Font("Calibri",Font.BOLD,17));
        df_back.setBounds(30,410,30,30);
        df_back.setBorder(null);
        df_back.addActionListener(this);

        JPanel info_panel = new JPanel();
        info_panel.setBounds(100,250,600,200);
        info_panel.setLayout(null);
        info_panel.setBackground(Color.white);
        String[] Headings = { "Name", "Post", "Votes" };
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
            String query = "select * from DetailedResult;";
            try (java.sql.Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                int counter = 0;
                while (rs.next()) {
                    String Candidate = rs.getString("Candidate");
                    String Post = rs.getString("Position");
                    String Votes = rs.getString("Votes");
                    model.insertRow(counter,new Object[]{Candidate,Post,Votes});
                    counter++;

                }
                return true;
            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
            }
            return true;
        }     catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);

        }
        df.add(info_panel);
        df.add(elect_heading);
        df.add(main_title);
        df.add(upper_line);
        df.add(df_back);
        df.setVisible(true);
        return false;
    }

    public boolean CompiledResults_call(){
        df = new JFrame();
        df.setSize(800,500);
        df.setTitle("Election Result Panel");
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setLocationRelativeTo(null);
        df.setResizable(false);
        df.setLayout(null);
        df.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        df.setIconImage(icon.getImage());


        header_icon = new ImageIcon("heading.png");
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
        main_title.setText("Elections ProgramClasses.Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        df_back = new JButton();
        back_icon = new ImageIcon("back.png");
        df_back.setIcon(back_icon);
        df_back.setFocusable(false);
        df_back.setContentAreaFilled(false);
        df_back.setOpaque(false);
        df_back.setFont(new Font("Calibri",Font.BOLD,17));
        df_back.setBounds(30,410,30,30);
        df_back.setBorder(null);
        df_back.addActionListener(this);

        JPanel info_panel = new JPanel();
        info_panel.setBounds(100,250,600,200);
        info_panel.setLayout(null);
        info_panel.setBackground(Color.white);
        String[] Headings = { "Name", "Post", "Votes" };
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
            String query = "select * from DetailedResult where Votes = (select max(votes) from DetailedResult);";
            try (java.sql.Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                int counter = 0;
                while (rs.next()) {
                    String Candidate = rs.getString("Candidate");
                    String Post = rs.getString("Position");
                    String Votes = rs.getString("Votes");
                    model.insertRow(counter,new Object[]{Candidate,Post,Votes});
                    counter++;
                }
                return true;
            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
                return false;
            }
        }     catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
        }
        df.add(info_panel);

        df.add(elect_heading);
        df.add(main_title);
        df.add(upper_line);
        df.add(df_back);
        df.setVisible(true);
        return false;
    }
}
