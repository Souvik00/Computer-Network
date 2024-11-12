import java.io.*;
import javax.net.ssl.*;
import java.util.*;

class mail{

  private static DataOutputStream dos;
  public static BufferedReader br;

  public static void main(String argv[]) throws Exception {
    String user = "";
    String pass = "";
    
    String username =new String(Base64.getEncoder().encode(user.getBytes()));
    String password =new String(Base64.getEncoder().encode(pass.getBytes()));;// new String(Base64.getEncoder().encode(pass.getBytes()));
    SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
    dos = new DataOutputStream(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(s.getInputStream()));



    send("EHLO smtp.gmail.com\r\n");
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());
    //           System.out.println("SERVER: "+ br.readLine());


    
    send("AUTH LOGIN\r\n");
              //System.out.println("SERVER: "+ br.readLine());


    send(username + "\r\n");
              //System.out.println("SERVER: "+ br.readLine());



    send(password + "\r\n");
              //System.out.println("SERVER: "+ br.readLine());


    send("MAIL FROM:<>\r\n");
              //System.out.println("SERVER: "+ br.readLine());


    send("RCPT TO:<>\r\n");
              //System.out.println("SERVER: "+ br.readLine());



    send("DATA\r\n");
           // System.out.println("SERVER: "+ br.readLine());


    send("FROM:\r\n");
    send("TO: \r\n");
    send("Subject: Email test\r\n");
    send("THIS IS A TEST EMAIL. THANK YOU\r\n");
    send(".\r\n");
          //System.out.println("SERVER: "+ br.readLine());


          
    send("QUIT\r\n");
    //System.out.println("SERVER: "+ br.readLine());
  }

  private static void send(String s) throws Exception {
    System.out.println("SERVER: "+ br.readLine());
    dos.writeBytes(s);
    Thread.sleep(1000);
    System.out.println("CLIENT: " + s);
     }
}
