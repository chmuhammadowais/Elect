import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CastVote extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel user_ID;
    JPanel upper_line;
    ImageIcon avatar;
    JPanel pic_panel;
    JLabel pic_panel_def_pic;
    JButton cast_btn;

    public CastVote(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        this.setSize(800,500);
        this.setTitle("Voting Panel");
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

        user_ID = new JLabel();
        user_ID.setText("Click the button to cast your vote.");
        user_ID.setFont(new Font("Calibri",Font.BOLD,20));
       // main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        user_ID.setBounds(255,130,290,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon("Vote.png");
        pic_panel = new JPanel();
        pic_panel.setLayout(null);
        pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBackground(Color.white);
        pic_panel_def_pic.setOpaque(true);
        pic_panel_def_pic.setBounds(0, 0, 150, 150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(325, 230, 150, 150);

        cast_btn = new JButton();
        cast_btn.setText("Cast Vote");
        cast_btn.setFocusable(false);
        cast_btn.setContentAreaFilled(false);
        cast_btn.setOpaque(false);
        cast_btn.setFont(new Font("Calibri", Font.BOLD, 17));
        cast_btn.setBounds(300, 400, 200, 30);
        cast_btn.setBorder(new RoundedBorder(20));
        cast_btn.addActionListener(this);

        this.add(elect_heading);
        this.add(user_ID);
        //this.add(upper_line);
        this.add(pic_panel);
        this.add(cast_btn);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cast_btn){
            new VoterVerification();
            this.dispose();
        }

    }
}
