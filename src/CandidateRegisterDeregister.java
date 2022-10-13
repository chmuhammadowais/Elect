import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidateRegisterDeregister extends JFrame implements ActionListener {
    JPanel upper_line;
    JButton reg_btn;
    ImageIcon reg_icon;
    JButton dereg_btn;
    ImageIcon dereg_icon;
    JButton back_btn;
    JButton get_reg_cand_btn;
    ImageIcon get_reg_cand_icon;
    ImageIcon icon;
    ImageIcon header_icon;
    ImageIcon back_icon;
    JLabel elect_heading;
    JLabel main_title;
    public CandidateRegisterDeregister(){
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
        main_title.setText("Candidate Register / Deregister Panel");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
        //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(240,130,320,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        reg_icon = new ImageIcon("register.png");
        reg_btn = new JButton();
        reg_btn.setIcon(reg_icon);
        reg_btn.setText("Register Candidate");
        reg_btn.setFocusable(false);
        reg_btn.setContentAreaFilled(false);
        reg_btn.setOpaque(false);
        reg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        reg_btn.setBounds(100,230,200,230);
        reg_btn.setBorder(null);
        reg_btn.setVerticalTextPosition(JButton.TOP);
        reg_btn.setHorizontalTextPosition(JButton.CENTER);
        reg_btn.setIconTextGap(35);
        reg_btn.addActionListener(this);

        dereg_icon= new ImageIcon("deregister.png");
        dereg_btn = new JButton();
        dereg_btn.setIcon(dereg_icon);
        dereg_btn.setText("Deregister Candidate");
        dereg_btn.setFocusable(false);
        dereg_btn.setContentAreaFilled(false);
        dereg_btn.setOpaque(false);
        dereg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        dereg_btn.setBounds(300,230,200,230);
        dereg_btn.setBorder(null);
        dereg_btn.setVerticalTextPosition(JButton.TOP);
        dereg_btn.setHorizontalTextPosition(JButton.CENTER);
        dereg_btn.setIconTextGap(20);
        dereg_btn.addActionListener(this);

        get_reg_cand_icon = new ImageIcon("candidate.jpg");
        get_reg_cand_btn = new JButton();
        get_reg_cand_btn.setText("Registered Candidates");
        get_reg_cand_btn.setIcon(get_reg_cand_icon);
        get_reg_cand_btn.setFocusable(false);
        get_reg_cand_btn.setContentAreaFilled(false);
        get_reg_cand_btn.setOpaque(false);
        get_reg_cand_btn.setFont(new Font("Calibri",Font.BOLD,17));
        get_reg_cand_btn.setBounds(500,230,200,230);
        get_reg_cand_btn.setBorder(null);
        get_reg_cand_btn.setVerticalTextPosition(JButton.TOP);
        get_reg_cand_btn.setHorizontalTextPosition(JButton.CENTER);
        get_reg_cand_btn.addActionListener(this);

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
        this.add(upper_line);
        this.add(main_title);
        this.add(reg_btn);
        this.add(dereg_btn);
        this.add(get_reg_cand_btn);
        this.add(back_btn);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reg_btn){
            new CandidateRegistration();
            this.dispose();
        }
        else if(e.getSource() == dereg_btn){
            new CandidateDeregistration();
            this.dispose();
        }
        else if(e.getSource() == get_reg_cand_btn){
            this.dispose();
        }
        else if(e.getSource() == back_btn){
            new MainFrame();
            this.dispose();
        }
    }
}
