package Functionality;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Server {

    public static void main(String[] args) throws IOException {
        server_call(6856);
    }
    public static boolean server_call(int port) throws IOException {
        if (port == 0) {
            return true;
        }
        System.out.println("Server Started");
        Socket socket;
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        ServerSocket serversocket;
        String answer;
        serversocket = new ServerSocket(port);

        while (true) {
            try {

                socket = serversocket.accept();
                System.out.println("Client Accepted");

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                String msgFromClient = bufferedReader.readLine();
                System.out.println("Client: " + msgFromClient);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
                    PreparedStatement ps = con.prepareStatement("select answer from helpdesk where question=?");

                    ps.setString(1, msgFromClient);

                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    answer = rs.getString("answer");
                } catch (Exception e) {
                    System.out.println("Exception : " + e);
                    return false;
                }
                bufferedWriter.write("Request Received : " + answer);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();


                if (msgFromClient.equalsIgnoreCase("BYE")){
                    return true;
            }
            } catch (IOException e) {
                System.out.println("Exception : " + e);
                return false;
            }
        }
    }
}
