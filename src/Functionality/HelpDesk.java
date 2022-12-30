package Functionality;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.Objects;


public class HelpDesk extends JFrame {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JFrame frame;
    JButton question;
    JButton back_btn;
    ImageIcon back_icon;
    public HelpDesk() throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }

        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Time Panel");
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
        main_title.setText("Election Help Desk");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
        //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(315,130,170,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());


        JPanel container = new JPanel();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.white);
//        container.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        int panel_creation_counter = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
            PreparedStatement ps = con.prepareStatement("select question from helpdesk");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String question_text = rs.getString("question");
                question = new JButton(question_text);
                question.setActionCommand(question_text);
                question.setFocusable(false);
                question.setContentAreaFilled(false);
                question.setOpaque(false);
                question.setFont(new Font("Calibri",Font.PLAIN,17));
                question.setPreferredSize(new Dimension(500,30));
                container.add(question);
                panel_creation_counter++;
                question.addActionListener(ae2 -> connection_call(question_text));
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception : "+e);
        }


        container.setPreferredSize(new Dimension(300,panel_creation_counter*40));
        JScrollPane sp = new JScrollPane(container);
        sp.setLayout(new ScrollPaneLayout());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(BorderFactory.createLineBorder(Color.white));
        sp.setBackground(Color.white);
        sp.getVerticalScrollBar().setBorder(BorderFactory.createLineBorder(null));
        //sp.setBorder(BorderFactory.createLineBorder(Color.red));
        sp.getViewport().setBackground(Color.white);
        sp.setBounds(100,250,600,160);

        back_btn = new JButton();
        back_icon = new ImageIcon("./src/Resources/back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(ae2 -> frame.dispose());
        frame.add(back_btn);

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(sp);
        frame.setVisible(true);
    }
    public boolean connection_call(String command) {
        if(Objects.equals(command, "Test")){
            return true;
        }
        try {
            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter = null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;

            try {
                socket = new Socket("localhost", 6856);
                System.out.println("Server accepted the request");
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(command);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String server_reply = bufferedReader.readLine();
                System.out.println("Server: " + server_reply);  //printing the server message
                JOptionPane.showMessageDialog(null, server_reply.substring(19));
                return true;

            } catch (IOException e) {
                System.out.println("Exception : " + e);
                JOptionPane.showMessageDialog(null,"The connection to server could not be established. Please try again in a few moments.","Connection Error",JOptionPane.WARNING_MESSAGE);
                return false;
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                    if (inputStreamReader != null)
                        inputStreamReader.close();
                    if (outputStreamWriter != null)
                        outputStreamWriter.close();
                    if (bufferedReader != null)
                        bufferedReader.close();
                    if (bufferedWriter != null)
                        bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Exception : " + e);
                }

            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    return false;

    }
}
