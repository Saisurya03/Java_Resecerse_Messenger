package reversemessage;

import java.io.*;
import java.net.*;


public class Client {
public static void main(String[] args) throws IOException { 
        System.out.println("Enter something to start communication...");
        try{
                while(true)
                {
                Socket s1 = new Socket("localhost",3000);
                BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader server_input = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                DataOutputStream server_out = new DataOutputStream(s1.getOutputStream());
                String str, str1;
                System.out.print("Input: " );
                str = user_input.readLine();
                server_out.writeBytes(str + "\n");
                str1 = server_input.readLine();             
                if(str.equals("bye"))
                {
                     System.out.println("\nConnection terminated!...");
                     s1.close();
                     break;
                }
                System.out.println("Reverse string: " + str1+ "\n" );
                }
        }catch(IOException e){
            System.out.println("Connection terminated!...");
        }    
    }
    
}

