import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CandidateDeregistration extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel dereg_title;
    JButton dereg_cancel;
    JPanel upper_line;
    JLabel user_id;
    JTextField user_id_textfield;
    JButton dereg_btn;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel pic_panel;
    ImageIcon avatar;
    JLabel pic_panel_def_pic;
    JButton dereg_conf;
    JFrame confirmation_frame;

    public CandidateDeregistration(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        this.setSize(800,500);
        this.setTitle("Candidate Deregistration Panel");
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

        dereg_title = new JLabel();
        dereg_title.setText("Candidate Deregister Panel");
        dereg_title.setFont(new Font("Calibri",Font.BOLD,20));
        //dereg_title.setBorder(BorderFactory.createLineBorder(Color.red));
        dereg_title.setBounds(283,130,234,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        user_id = new JLabel();
        user_id.setText("User ID");
        user_id.setFont(new Font("Calibri",Font.BOLD,18));
        //user_id.setBorder(BorderFactory.createLineBorder(Color.red));
        user_id.setBounds(325,290,60,20);
        JPanel user_id_line= new JPanel();
        user_id_line.setBounds(325,310,350,3);
        user_id_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        user_id_textfield = new JTextField();
        user_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        user_id_textfield.setBorder(null);
        user_id_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_id_textfield.setBounds(385,290,290,20);

        dereg_btn = new JButton();
        dereg_btn.setText("Deregister");
        dereg_btn.setFocusable(false);
        dereg_btn.setContentAreaFilled(false);
        dereg_btn.setOpaque(false);
        dereg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        dereg_btn.setBounds(400,360,200,30);
        dereg_btn.setBorder(new RoundedBorder(20));
        dereg_btn.addActionListener(this);

        avatar = new ImageIcon(new ImageIcon("shredder.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
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
        this.add(dereg_title);
        this.add(upper_line);
        this.add(user_id);
        this.add(user_id_textfield);
        this.add(user_id_line);
        this.add(dereg_btn);
        this.add(pic_panel);
        this.add(back_btn);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dereg_btn){
            String id = user_id_textfield.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
                System.out.println("Connection succeed");
                PreparedStatement ps0 = con.prepareStatement("select * from Candidates where ID = ?");
                ps0.setInt(1, Integer.parseInt(id));
                ResultSet rs = ps0.executeQuery();
                rs.next();
                Blob blob = rs.getBlob("Picture");

                ImageIcon image = new ImageIcon(blob.getBytes(1, (int)blob.length()));

                String st_id = rs.getString("ID");
                String st_name = rs.getString("Name");
                String st_email = rs.getString("Position");
                ImageIcon imgThisImg = new ImageIcon(new ImageIcon(image.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


                confirmation_frame = new JFrame();
                confirmation_frame.setTitle("Confirmation");
                ImageIcon logo = new ImageIcon("logo.png");
                confirmation_frame.setIconImage(logo.getImage());
                confirmation_frame.setSize(650,300);
                confirmation_frame.getContentPane().setBackground(Color.white);
                confirmation_frame.setLayout(null);
                confirmation_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                confirmation_frame.setLocationRelativeTo(null);
                confirmation_frame.setResizable(false);
                ImageIcon bin = new ImageIcon("bin.png");
                dereg_conf = new JButton();
                dereg_conf.setIcon(bin);
                dereg_conf.setFocusable(false);
                dereg_conf.setContentAreaFilled(false);
                dereg_conf.setOpaque(false);
                dereg_conf.setFont(new Font("Calibri",Font.BOLD,17));
                dereg_conf.setBounds(475,410,200,30);
                dereg_conf.setBorder(null);
                dereg_conf.addActionListener(this);
                dereg_conf.setBounds(570,225,30,30);

                ImageIcon cancel = new ImageIcon("cancel.png");
                dereg_cancel = new  JButton();
                dereg_cancel.setIcon(cancel);
                dereg_cancel.setFocusable(false);
                dereg_cancel.setContentAreaFilled(false);
                dereg_cancel.setOpaque(false);
                dereg_cancel.setFont(new Font("Calibri",Font.BOLD,17));
                dereg_cancel.setBorder(null);
                dereg_cancel.addActionListener(this);
                dereg_cancel.setBounds(520,225,30,30);

                JPanel conf_pic_panel = new JPanel();
                conf_pic_panel.setLayout(null);
                conf_pic_panel.setBounds(50, 60, 150, 150);
                JLabel conf_pic_panel_pic = new JLabel();
                conf_pic_panel_pic.setBounds(0,0,150,150);
                conf_pic_panel_pic.setIcon(new ImageIcon(imgThisImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)));
                conf_pic_panel_pic.setSize(150,150);
                conf_pic_panel.add(conf_pic_panel_pic);
                conf_pic_panel.setFocusable(false);
                conf_pic_panel.setOpaque(true);
                conf_pic_panel.setBorder(new RoundedBorder(10));
                JLabel title = new JLabel();
                title.setText("Are you sure you want to deregister the candidate?");
                title.setFont(new Font("Calibri",Font.BOLD,18));
                //title.setBorder(BorderFactory.createLineBorder(Color.red));
                title.setBounds(130, 0, 390, 20);
                JLabel conf_user_id= new JLabel();
                conf_user_id.setText("User ID");
                conf_user_id.setFont(new Font("Calibri",Font.BOLD,18));
               // conf_user_id.setBorder(BorderFactory.createLineBorder(Color.red));
                conf_user_id.setBounds(250,60,90,20);
                JTextField conf_user_id_textfield = new JTextField();
                conf_user_id_textfield.setBackground(null);
                conf_user_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
                conf_user_id_textfield.setBorder(null);
                conf_user_id_textfield.setText(st_id);
                conf_user_id_textfield.setEditable(false);
                conf_user_id_textfield.setHorizontalAlignment(JTextField.CENTER);
                conf_user_id_textfield.setBounds(340,60,260,20);
                JPanel conf_user_id_line= new JPanel();
                conf_user_id_line.setBounds(250,80,350,3);
                conf_user_id_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));

                JLabel conf_user_name = new JLabel();
                conf_user_name.setText("User Name");
                conf_user_name.setFont(new Font("Calibri",Font.BOLD,18));
              // conf_user_name.setBorder(BorderFactory.createLineBorder(Color.red));
                conf_user_name.setBounds(250,120,90,20);
                JTextField conf_user_name_textfield = new JTextField();
                conf_user_name_textfield.setBackground(null);
                conf_user_name_textfield.setText(st_name);
                conf_user_name_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
                conf_user_name_textfield.setBorder(null);
                conf_user_name_textfield.setHorizontalAlignment(JTextField.CENTER);
                conf_user_name_textfield.setBounds(340,120,260,20);
                JPanel conf_user_name_line= new JPanel();
                conf_user_name_line.setBounds(250,140,350,3);
                conf_user_name_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));


                JLabel conf_user_post = new JLabel();
                conf_user_post.setText("Position");
                conf_user_post.setFont(new Font("Calibri",Font.BOLD,18));
               // conf_user_post.setBorder(BorderFactory.createLineBorder(Color.red));
                conf_user_post.setBounds(250,180,90,20);
                JTextField conf_user_post_textfield = new JTextField();
                conf_user_post_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
                conf_user_post_textfield.setBackground(null);
                conf_user_post_textfield.setText(st_email);
                conf_user_post_textfield.setBorder(null);
                conf_user_post_textfield.setHorizontalAlignment(JTextField.CENTER);
                conf_user_post_textfield.setBounds(340,180,260,20);
                JPanel conf_user_post_line = new JPanel();
                conf_user_post_line.setBounds(250,200,350,3);
                conf_user_post_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));


                confirmation_frame.add(title);
                confirmation_frame.add(dereg_conf);
                confirmation_frame.add(dereg_cancel);
                confirmation_frame.add(conf_pic_panel);
                confirmation_frame.add(conf_user_id);
                confirmation_frame.add(conf_user_id_textfield);
                confirmation_frame.add(conf_user_id_line);
                confirmation_frame.add(conf_user_name);
                confirmation_frame.add(conf_user_name_textfield);
                confirmation_frame.add(conf_user_name_line);
                confirmation_frame.add(conf_user_post_textfield);
                confirmation_frame.add(conf_user_post);
                confirmation_frame.add(conf_user_post_line);
                confirmation_frame.setVisible(true);

                System.out.println("Query execution successful");

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null,"Candidate Information not found.","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception : "+ex);
            }
        } else if (e.getSource() == back_btn) {
            new CandidatteManagement();
            this.dispose();

        }
        else if(e.getSource() == dereg_cancel){
            confirmation_frame.dispose();
        }
        else if(e.getSource() == dereg_conf){
            try {
                confirmation_frame.dispose();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect","root","admin");
                System.out.println("Connection succeed");
                String id = user_id_textfield.getText();
                PreparedStatement ps1 = con.prepareStatement("delete from Candidates where ID = ?");
                ps1.setInt(1, Integer.parseInt(id));
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Candidate Deregistered");
                user_id_textfield.setText(null);
                System.out.println("Query execution successful");

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Exception : "+ex);
            }
        }
    }
}
