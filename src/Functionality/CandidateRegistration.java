package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CandidateRegistration implements ActionListener {
JLabel elect_heading;
ImageIcon icon;
ImageIcon header_icon;
JLabel main_title;
JButton reg_btn;
JPanel upper_line;
JButton back_btn;
JPanel pic_panel;
JButton pic_chooser_btn;
JLabel pic_path_label;
JLabel pic_panel_def_pic;
ImageIcon avatar;
ImageIcon back_icon;
JLabel user_id;
JTextField user_id_textfield;
JLabel user_name;
JTextField user_name_textfield;
JLabel user_standing_post;
JTextField user_standing_post_textfield;
JFrame frame;

    public CandidateRegistration(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Candidate Registration Panel");
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
        main_title.setText("Candidate Registration Panel");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
       // reg_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(274,130,248,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon(new ImageIcon("./src/Resources/avatar.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        pic_panel = new JPanel();
        pic_panel.setLayout(null);
        pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBackground(Color.white);
        pic_panel_def_pic.setOpaque(true);
        pic_panel_def_pic.setBounds(0,0,150,150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(125,230,150,150);

        user_id = new JLabel();
        user_id.setText("User ID");
        user_id.setFont(new Font("Calibri",Font.BOLD,18));
       // user_id.setBorder(BorderFactory.createLineBorder(Color.red));
        user_id.setBounds(325,230,85,20);
        JPanel user_id_line= new JPanel();
        user_id_line.setBounds(325,250,350,3);
        user_id_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        user_id_textfield = new JTextField();
        user_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        user_id_textfield.setBorder(null);
        user_id_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_id_textfield.setBounds(410,230,265,20);

        user_name = new JLabel();
        user_name.setText("User Name");
        user_name.setFont(new Font("Calibri",Font.BOLD,18));
       // user_name.setBorder(BorderFactory.createLineBorder(Color.red));
        user_name.setBounds(325,290,85,20);
        JPanel user_name_line= new JPanel();
        user_name_line.setBounds(325,310,350,3);
        user_name_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        user_name_textfield = new JTextField();
        user_name_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        user_name_textfield.setBorder(null);
        user_name_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_name_textfield.setBounds(410,290,265,20);

        user_standing_post = new JLabel();
        user_standing_post.setText("Position");
        user_standing_post.setFont(new Font("Calibri",Font.BOLD,18));
       // user_standing_post.setBorder(BorderFactory.createLineBorder(Color.red));
        user_standing_post.setBounds(325,350,85,20);
        JPanel user_standing_post_line = new JPanel();
        user_standing_post_line.setBounds(325,370,350,3);
        user_standing_post_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        user_standing_post_textfield = new JTextField();
        user_standing_post_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        user_standing_post_textfield.setBorder(null);
        user_standing_post_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_standing_post_textfield.setBounds(410,350,265,20);

        reg_btn = new JButton();
        reg_btn.setText("Register");
        reg_btn.setFocusable(false);
        reg_btn.setContentAreaFilled(false);
        reg_btn.setOpaque(false);
        reg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        reg_btn.setBounds(475,410,200,30);
        reg_btn.setBorder(new RoundedBorder(20));
        reg_btn.addActionListener(this);

        pic_chooser_btn = new JButton();
        pic_chooser_btn.setText("Choose Picture");
        pic_chooser_btn.setFocusable(false);
        pic_chooser_btn.setContentAreaFilled(false);
        pic_chooser_btn.setOpaque(false);
        pic_chooser_btn.setFont(new Font("Calibri",Font.BOLD,12));
        pic_chooser_btn.setVerticalTextPosition(JButton.CENTER);
        pic_chooser_btn.setHorizontalTextPosition(JButton.CENTER);
        pic_chooser_btn.setBounds(150,400,100,17);
        pic_chooser_btn.setBorder(new RoundedBorder(10));
        pic_chooser_btn.addActionListener(this);

        pic_path_label = new JLabel();
        pic_path_label.setText(null);
        pic_path_label.setFont(new Font("Calibri",Font.PLAIN,12));
        //pic_path_label.setBorder(BorderFactory.createLineBorder(Color.red));
        pic_path_label.setBounds(125,385,150,15);

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
        frame.add(pic_panel);
        frame.add(user_id);
        frame.add(user_id_line);
        frame.add(user_id_textfield);
        frame.add(user_name);
        frame.add(user_name_line);
        frame.add(user_name_textfield);
        frame.add(user_standing_post);
        frame.add(user_standing_post_line);
        frame.add(user_standing_post_textfield);
        frame.add(reg_btn);
        frame.add(pic_chooser_btn);
        frame.add(pic_path_label);
        frame.add(back_btn);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reg_btn) {
          reg_call(user_id_textfield.getText(), user_name_textfield.getText(),user_standing_post_textfield.getText());
        }
        else if(e.getSource() == pic_chooser_btn){
         pic_choose_call();
        }
        else if(e.getSource() == back_btn){
           back_call();
        }
    }
    public boolean reg_call(String id, String name, String post){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
            System.out.println("Connection succeed");

            try {
                PreparedStatement ps0 = con.prepareStatement("select ID, Name from users where ID=?");
                ps0.setInt(1, Integer.parseInt(id));
                ResultSet rs1 = ps0.executeQuery();
                rs1.next();
                String ID = rs1.getString("ID");
                String Name = rs1.getString("Name");
                if (id.equals(ID) && name.equals(Name)) {
                    try {

                        PreparedStatement ps = con.prepareStatement("insert into Candidates values(?,?,?,?)");
                        ps.setInt(1, Integer.parseInt(id));
                        ps.setString(2, name);
                        ps.setString(3, post);
                        FileInputStream fis = null;

                        if (pic_path_label.getText() != null) {
                            fis = new FileInputStream(pic_path_label.getText());

                        } else if (pic_path_label.getText() == null) {
                            fis = new FileInputStream("./src/Resources/avatar.png");
                        }

                        assert fis != null;
                        ps.setBinaryStream(4, fis, fis.available());
                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Information stored successfully", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
                        avatar = new ImageIcon(new ImageIcon("./src/Resources/avatar.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                        pic_panel_def_pic.setIcon(avatar);
                        pic_path_label.setText(null);
                        user_id_textfield.setText(null);
                        user_name_textfield.setText(null);
                        user_standing_post_textfield.setText(null);
                        return true;

                    } catch (SQLException | NumberFormatException | IOException | HeadlessException ex) {
                        JOptionPane.showMessageDialog(null, "User ID not found in registered users list or already exists. Thus, cannot be registered as a Candidate", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Exception : " + ex);
                        pic_path_label.setText(null);
                        user_id_textfield.setText(null);
                        user_name_textfield.setText(null);
                        user_standing_post_textfield.setText(null);
                        return false;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error in input fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Exception : " + ex);
                        return false;
                    }

                } else {
                    JOptionPane.showMessageDialog(null,"Problem with the entered credentials.","Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Integer type required for ID.","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception : "+ex);
                pic_path_label.setText(null);
                user_id_textfield.setText(null);
                user_name_textfield.setText(null);
                user_standing_post_textfield.setText(null);
                return false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
            pic_path_label.setText(null);
            user_id_textfield.setText(null);
            user_name_textfield.setText(null);
            user_standing_post_textfield.setText(null);
            return false;
        }

    }
    public boolean pic_choose_call(){
        try{
            JFileChooser file = new JFileChooser();
            file.setMultiSelectionEnabled(true);
            file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            file.setFileHidingEnabled(false);
            if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                java.io.File f = file.getSelectedFile();
                String path = f.getPath();
                pic_path_label.setText(path);
                avatar = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                pic_panel_def_pic.setIcon(avatar);
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean back_call(){
        try{
            frame.dispose();
            new CandidatteManagement();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            pic_path_label.setText(null);
            user_id_textfield.setText(null);
            user_name_textfield.setText(null);
            user_standing_post_textfield.setText(null);
            return false;
        }

    }
}
