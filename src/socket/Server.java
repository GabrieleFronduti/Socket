/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriele Fronduti
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket server=new ServerSocket(2000);
            System.out.println("server avviato \n");
            
            //il server rimane in ascolto dopo una richiesta di connessione
            Socket socket= server.accept();
            
       //serve per scrivere al Client un messaggio di saluto dopo l’avvenuta connessione     
       BufferedWriter bw;
       
       BufferedReader br;    
             
            bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader( new InputStreamReader(socket.getInputStream()));

            bw.write("Benvenuto\n");
            
            //invia effettivamente i dati 
            //serve per svuotare il buffer o il dato dalla RAM dell’host alla scheda di rete
            bw.flush();

            String messaggio;
            messaggio=br.readLine();
            System.out.println("richiesta " +messaggio+"\n");
 
            SimpleDateFormat data=new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
            String dataOra=data.format(new Date());
                   
            bw.write(dataOra+"\r\n");
            
            //invia effettivamente i dati 
            //serve per svuotare il buffer o il dato dalla RAM dell’host alla scheda di rete
            bw.flush();
            
            //chiusura connessione
            socket.close();
            System.out.println("connessione chiusa\n");
            server.close();
    }
            catch (IOException e) {
            System.out.println("Errore IO");
        }
        
    }
    
}