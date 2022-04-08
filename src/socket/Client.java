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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriele Fronduti
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //apertura socket          
            Socket client=new Socket(InetAddress.getLocalHost(),2000);
             
             
        BufferedWriter bw;
        
        //serve per leggere il messaggio di saluto del Server
        BufferedReader br;
             
            bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            br=new BufferedReader( new InputStreamReader(client.getInputStream()));
            
            String messaggio;
            messaggio=br.readLine();
            System.out.println("messaggio in arrivo dal server " +messaggio+"\n");           
            //richiesta data e ora
            bw.write("digita data e ora\n");
              
            //invia effettivamente i dati 
            //serve per svuotare il buffer o il dato dalla RAM dell’host alla scheda di rete
            bw.flush();
            
            messaggio=br.readLine();
            System.out.println("data ottenuta " +messaggio+"\n");
          
            //chiusura connessione
            client.close();
            System.out.println("connessione chiusa\n");
        }
            catch (Exception e) {
            System.out.println("errore di connessione\n");
            }
    }
}