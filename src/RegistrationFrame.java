import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class RegistrationFrame extends JFrame implements ActionListener {
JLabel elect_heading;
ImageIcon icon;
ImageIcon header_icon;
JLabel reg_title;
JButton reg_btn;
JPanel upper_line;
JButton back_btn;
JPanel pic_panel;
JButton pic_chooser_btn;
JLabel pic_path_label;
JLabel pic_panel_def_pic;
ImageIcon avatar;
ImageIcon back_icon;
JLabel st_id;
JTextField st_id_textfield;
JLabel st_name;
JTextField st_name_textfield;
JLabel st_email;
JTextField st_email_textfield;

    public RegistrationFrame(){
        this.setSize(800,500);
        this.setTitle("Candidate Registration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());

        header_icon = new ImageIcon("heading.png");
        elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365,0,70,100);

        reg_title = new JLabel();
        reg_title.setText("Candidate Registration Panel");
        reg_title.setFont(new Font("Calibri",Font.BOLD,20));
       // reg_title.setBorder(BorderFactory.createLineBorder(Color.red));
        reg_title.setBounds(274,130,248,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon(new ImageIcon("avatar.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
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

        st_id= new JLabel();
        st_id.setText("Student ID");
        st_id.setFont(new Font("Calibri",Font.BOLD,18));
        //st_id.setBorder(BorderFactory.createLineBorder(Color.red));
        st_id.setBounds(325,230,85,20);
        JPanel st_id_line= new JPanel();
        st_id_line.setBounds(325,250,350,3);
        st_id_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        st_id_textfield = new JTextField();
        st_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_id_textfield.setBorder(null);
        st_id_textfield.setBounds(410,230,265,20);

        st_name = new JLabel();
        st_name.setText("Student Name");
        st_name.setFont(new Font("Calibri",Font.BOLD,18));
        //st_name.setBorder(BorderFactory.createLineBorder(Color.red));
        st_name.setBounds(325,290,115,20);
        JPanel st_name_line= new JPanel();
        st_name_line.setBounds(325,310,350,3);
        st_name_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        st_name_textfield = new JTextField();
        st_name_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_name_textfield.setBorder(null);
        st_name_textfield.setBounds(440,290,235,20);

        st_email = new JLabel();
        st_email.setText("Student Email");
        st_email.setFont(new Font("Calibri",Font.BOLD,18));
        //st_email.setBorder(BorderFactory.createLineBorder(Color.red));
        st_email.setBounds(325,350,110,20);
        JPanel st_email_line = new JPanel();
        st_email_line.setBounds(325,370,350,3);
        st_email_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        st_email_textfield = new JTextField();
        st_email_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_email_textfield.setBorder(null);
        st_email_textfield.setBounds(435,350,240,20);

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
        back_icon = new ImageIcon("back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(this);


        this.add(elect_heading);
        this.add(reg_title);
        this.add(upper_line);
        this.add(pic_panel);
        this.add(st_id);
        this.add(st_id_line);
        this.add(st_id_textfield);
        this.add(st_name);
        this.add(st_name_line);
        this.add(st_name_textfield);
        this.add(st_email);
        this.add(st_email_line);
        this.add(st_email_textfield);
        //this.add(bottom_line);
        this.add(reg_btn);
        this.add(pic_chooser_btn);
        this.add(pic_path_label);
        this.add(back_btn);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reg_btn){
            try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
            System.out.println("Connection succeed");
            String id = st_id_textfield.getText();
            String name = st_name_textfield.getText();
            String email = st_email_textfield.getText();

                PreparedStatement ps = con.prepareStatement("insert into TestB values(?,?,?,?)");
                ps.setInt(1, Integer.parseInt(id));
                ps.setString(2,name);
                ps.setString(3,email);
                FileInputStream fis;

                if(pic_path_label != null){
                     fis = new FileInputStream(pic_path_label.getText());

                }
                else{
                     fis = new FileInputStream("avatar.png");
                }

                ps.setBinaryStream(4 ,fis, fis.available());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Information stored successfully", "Operation Successful",JOptionPane.INFORMATION_MESSAGE);



            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
            avatar = new ImageIcon(new ImageIcon("avatar.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            pic_panel_def_pic.setIcon(avatar);
            pic_path_label.setText(null);
            st_id_textfield.setText(null);
            st_name_textfield.setText(null);
            st_email_textfield.setText(null);

        }
        else if(e.getSource() == pic_chooser_btn){
            JFileChooser file = new JFileChooser();
            file.setMultiSelectionEnabled(true);
            file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            file.setFileHidingEnabled(false);
            if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                java.io.File f = file.getSelectedFile();
                String path = f.getPath();
                pic_path_label.setText(path);
                //System.out.println(pic_path);
                avatar = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                pic_panel_def_pic.setIcon(avatar);
            }

        }
        else if(e.getSource() == back_btn){
            this.dispose();
            new RegDeregFrame();
        }
    }
}
