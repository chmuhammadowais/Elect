import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisteredCandidates extends JFrame implements ActionListener {
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JLabel elect_heading;
    JPanel upper_line;
    JButton back_btn;
    ImageIcon back_icon;
    public RegisteredCandidates(){
        this.setSize(800,500);
        this.setTitle("Candidate Registration / Deregistration Panel");
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
        back_icon = new ImageIcon("back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(this);

        JPanel info_panel = new JPanel();
        info_panel.setLayout(null);
        info_panel.setBounds(100,250,600,200);

        JLabel user_id = new JLabel("ID",SwingConstants.CENTER);
        user_id.setBounds(0,0,200,30);
        user_id.setFont(new Font("Calibri", Font.BOLD,20));
        user_id.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel user_name = new JLabel("Name",SwingConstants.CENTER);
        user_name.setBounds(200,0,200,30);
        user_name.setFont(new Font("Calibri", Font.BOLD,20));
        user_name.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel user_standing_post = new JLabel("Post",SwingConstants.CENTER);
        user_standing_post.setBounds(400,0,200,30);
        user_standing_post.setFont(new Font("Calibri", Font.BOLD,20));
        user_standing_post.setBorder(BorderFactory.createLineBorder(Color.red));



        info_panel.add(user_id);
        info_panel.add(user_name);
        info_panel.add(user_standing_post);
        this.add(elect_heading);
        this.add(main_title);
        this.add(upper_line);
        this.add(back_btn);
        this.add(info_panel);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_btn){
            new CandidatteManagement();
            this.dispose();
        }
    }
}
