package Functionality;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    ImageIcon flush;
    JButton detailed_btn;
    JButton df_back;
    JButton flush_results;
    JFrame secondary_frame;
    JButton confirm_btn;
    JButton cancel_btn;
    String records_no;
    public Results(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
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
        main_title.setText("Elections Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        compile_icon = new ImageIcon("./src/Resources/compile.png");
        compile_btn = new JButton();
        compile_btn.setText("Compiled Results");
        compile_btn.setIcon(compile_icon);
        compile_btn.setFocusable(false);
        compile_btn.setContentAreaFilled(false);
        compile_btn.setOpaque(false);
        compile_btn.setFont(new Font("Calibri",Font.BOLD,17));
        compile_btn.setBounds(115,250,150,160);
        compile_btn.setBorder(null);
        compile_btn.setVerticalTextPosition(JButton.BOTTOM);
        compile_btn.setHorizontalTextPosition(JButton.CENTER);
        compile_btn.setIconTextGap(0);
        compile_btn.addActionListener(this);

        detailed_btn = new JButton();
        detail_icon = new ImageIcon("./src/Resources/details.png");
        detailed_btn.setText("Detailed Results");
        detailed_btn.setIcon(detail_icon);
        detailed_btn.setFocusable(false);
        detailed_btn.setContentAreaFilled(false);
        detailed_btn.setOpaque(false);
        detailed_btn.setFont(new Font("Calibri",Font.BOLD,17));
        detailed_btn.setBounds(325,250,150,160);
        detailed_btn.setBorder(null);
        detailed_btn.setVerticalTextPosition(JButton.BOTTOM);
        detailed_btn.setHorizontalTextPosition(JButton.CENTER);
        detailed_btn.addActionListener(this);

        flush_results = new JButton();
        flush = new ImageIcon("./src/Resources/flush.jpg");
        flush_results.setText("Flush Results");
        flush_results.setIcon(flush);
        flush_results.setFocusable(false);
        flush_results.setContentAreaFilled(false);
        flush_results.setOpaque(false);
        flush_results.setFont(new Font("Calibri",Font.BOLD,17));
        flush_results.setBounds(535,250,150,160);
        flush_results.setBorder(null);
        flush_results.setVerticalTextPosition(JButton.BOTTOM);
        flush_results.setHorizontalTextPosition(JButton.CENTER);
        flush_results.addActionListener(this);

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
        frame.add(back_btn);
        frame.add(flush_results);
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
        } else if (e.getSource() == flush_results) {
            flush_res();
        } else if (e.getSource()==cancel_btn) {
            cancel_call();
        }
        else if(e.getSource()==confirm_btn){
            if(Integer.parseInt(records_no) != 0){
                confirmation_call();
            }
            else if(Integer.parseInt(records_no) == 0){
                secondary_frame.dispose();
                JOptionPane.showMessageDialog(null,"There exist no data to wipe.","Error",JOptionPane.ERROR_MESSAGE);
            }

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
        if(secondary_frame == null){
            return true;
        }
        try{
            secondary_frame.dispose();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean DetailedResult_call(){
        secondary_frame = new JFrame();
        secondary_frame.setSize(800,500);
        secondary_frame.setTitle("Election Result Panel");
        secondary_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondary_frame.setLocationRelativeTo(null);
        secondary_frame.setResizable(false);
        secondary_frame.setLayout(null);
        secondary_frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("./src/Resources/logo.png");
        secondary_frame.setIconImage(icon.getImage());


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
        main_title.setText("Elections Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        df_back = new JButton();
        back_icon = new ImageIcon("./src/Resources/back.png");
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
            String query = "select * from DetailedResults";
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
            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
                return false;
            }
        }     catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
            return false;
        }
        secondary_frame.add(info_panel);
        secondary_frame.add(elect_heading);
        secondary_frame.add(main_title);
        secondary_frame.add(upper_line);
        secondary_frame.add(df_back);
        secondary_frame.setVisible(true);
        return true;
    }
    public boolean flush_res(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
            System.out.println("Connection succeed");
            PreparedStatement ps0 = con.prepareStatement("select count(distinct(VoterID)) as total_records from votes;");
            ResultSet rs = ps0.executeQuery();
            rs.next();
            records_no = rs.getString("total_records");
            System.out.println(records_no);
            secondary_frame = new JFrame();
            secondary_frame.setTitle("Confirmation");
            ImageIcon logo = new ImageIcon("./src/Resources/logo.png");
            secondary_frame.setIconImage(logo.getImage());
            secondary_frame.setSize(650,300);
            secondary_frame.getContentPane().setBackground(Color.white);
            secondary_frame.setLayout(null);
            secondary_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            secondary_frame.setLocationRelativeTo(null);
            secondary_frame.setResizable(false);
            ImageIcon bin = new ImageIcon("./src/Resources/bin.png");
            confirm_btn = new JButton();
            confirm_btn.setIcon(bin);
            confirm_btn.setFocusable(false);
            confirm_btn.setContentAreaFilled(false);
            confirm_btn.setOpaque(false);
            confirm_btn.setFont(new Font("Calibri",Font.BOLD,17));
            confirm_btn.setBounds(325,410,200,30);
            confirm_btn.setBorder(null);
            confirm_btn.addActionListener(this);
            confirm_btn.setBounds(285,225,30,30);

            ImageIcon cancel = new ImageIcon("./src/Resources/cancel.png");
            cancel_btn = new  JButton();
            cancel_btn.setIcon(cancel);
            cancel_btn.setFocusable(false);
            cancel_btn.setContentAreaFilled(false);
            cancel_btn.setOpaque(false);
            cancel_btn.setFont(new Font("Calibri",Font.BOLD,17));
            cancel_btn.setBorder(null);
            cancel_btn.addActionListener(this);
            cancel_btn.setBounds(335,225,30,30);

            JLabel title = new JLabel();
            title.setText("Are you sure you want to flush the results?");
            title.setFont(new Font("Calibri",Font.BOLD,23));
//    title.setBorder(BorderFactory.createLineBorder(Color.red));
            title.setBounds(130, 10, 410, 40);

            JLabel total_rec_label= new JLabel();
            total_rec_label.setText("Total Records");
            total_rec_label.setFont(new Font("Calibri",Font.BOLD,20));
//    total_rec_label.setBorder(BorderFactory.createLineBorder(Color.red));
            total_rec_label.setBounds(150,130,120,20);

            JTextField total_rec_textfield = new JTextField();
            total_rec_textfield.setBackground(null);
            total_rec_textfield.setFont(new Font("Calibri",Font.PLAIN,20));
            total_rec_textfield.setBorder(null);
            total_rec_textfield.setText(records_no);
            total_rec_textfield.setEditable(false);
            total_rec_textfield.setHorizontalAlignment(JTextField.CENTER);
            total_rec_textfield.setBounds(270,130,230,20);

            JPanel total_rec_line= new JPanel();
            total_rec_line.setBounds(150,150,350,3);
            total_rec_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));


            secondary_frame.add(title);
            secondary_frame.add(confirm_btn);
            secondary_frame.add(cancel_btn);
            secondary_frame.add(total_rec_label);
            secondary_frame.add(total_rec_textfield);
            secondary_frame.add(total_rec_line);
            secondary_frame.setVisible(true);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

}
    public boolean confirmation_call(){
        if(this.secondary_frame == null){
            return true;
        }
        else{
            try {
                secondary_frame.dispose();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
                System.out.println("Connection succeed");
                PreparedStatement ps1 = con.prepareStatement("truncate table Votes;");

                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Records wiped");
                System.out.println("Query execution successful");
                return true;

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Exception : "+ex);
                return false;
            }
        }

}
    public boolean cancel_call(){
        if(secondary_frame == null){
            return true;
        }
        else{
            try{
                secondary_frame.dispose();
                return true;
            }
            catch(Exception e){
                System.out.println("Exception : "+e);
                return false;
            }

        }
    }
    public boolean CompiledResults_call(){
        secondary_frame = new JFrame();
        secondary_frame.setSize(800,500);
        secondary_frame.setTitle("Election Result Panel");
        secondary_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondary_frame.setLocationRelativeTo(null);
        secondary_frame.setResizable(false);
        secondary_frame.setLayout(null);
        secondary_frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("./src/Resources/logo.png");
        secondary_frame.setIconImage(icon.getImage());

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
        main_title.setText("Elections Results");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
//        main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(328,130,145,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        df_back = new JButton();
        back_icon = new ImageIcon("./src/Resources/back.png");
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
            String query = "select * from DetailedResults D where votes = (select max(votes) from  DetailedResults E where D.position=E.position);";
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
            } catch (SQLException ex) {
                System.out.println("Exception : "+ex);
                return false;
            }
        }     catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
            return false;
        }
        secondary_frame.add(info_panel);

        secondary_frame.add(elect_heading);
        secondary_frame.add(main_title);
        secondary_frame.add(upper_line);
        secondary_frame.add(df_back);
        secondary_frame.setVisible(true);
        return true;
    }
}
