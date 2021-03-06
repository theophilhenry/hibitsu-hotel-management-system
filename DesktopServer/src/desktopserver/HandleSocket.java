/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopserver;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOTO
 */

public class HandleSocket extends Thread{
    FormDashboard parent;
    Socket client;
    DataOutputStream output;
    BufferedReader input;
    String email,displayName,idUser,statusBot;
    Boolean chatWithBot;
    Integer botStep;
    
    
    public HandleSocket(FormDashboard _parent, Socket _client)
    {
        try {
            this.parent = _parent;
            this.client = _client;
            
            output = new DataOutputStream(client.getOutputStream());
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SendChat(String msg)
    {
        try {
            output.writeBytes(msg + "\n");
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                String tmp = input.readLine();
               
                if(tmp.contains("JOIN"))
                {
                    chatWithBot = true;
                    botStep = 0;
                    
                     
                     parent.clientsArr.add(this);
                     parent.AddComboBoxClient(displayName, email);
                    
                    String msgWelcome = "Selamat datang di hibitsu\n"
                            + "Jika ingin konsultasi langsung dengan Admin,\nanda dapat menekan chat/audio/video call di atas,\n"
                            + "Jika ingin berbicara dengan saya(BotChat),\nanda dapat melakukannya dengan memilih salah satu angka dari opsi di bawah :\n" 
                            + "1) Reservasi\n" 
                            + "2) Track Order Booking\n";
                    
                    String historyChat =  parent.TampilChat(email, parent.emailAdmin,"client");
                    
                    
                    
                    
                   
                    
                    
                                  
                    
                    String selectedComboBox =  parent.comboBoxClient.getSelectedItem().toString();
                    String thisClient = email ;
                     parent.SimpanChat(parent.emailAdmin,email, msgWelcome);
                   
                    if(selectedComboBox.contains(thisClient))
                    {
                        
                        parent.textArea.append("BotChat :\n" + msgWelcome + "\n");
                        parent.ScrollDown();
                    }
                    
                    msgWelcome += "EndFromBot";
                    SendChat(historyChat + "\n;;DONE;;");
                    SendChat(msgWelcome);
                   
                    
                               
                   
                                      
                }
                else if(tmp.contains("CHATWITHBOT"))
                {
                    
                   
                    
                    String selectedComboBox =  parent.comboBoxClient.getSelectedItem().toString();
                    String thisClient = email ;
                    botStep = 0;
                    statusBot = "";
                    
                    if(tmp.contains("true"))
                    {
                        chatWithBot = true;
                        String msgWelcome = "Selamat Datang Kembali!\n"
                            + "Jika ingin berbicara dengan saya(BotChat),\nanda dapat melakukannya dengan memilih salah satu angka dari opsi di bawah :\n" 
                            + "1) Reservasi\n" 
                            + "2) Track Order Booking\n";
                        

                        if(selectedComboBox.contains(thisClient))
                        {
                            parent.textArea.append("BotChat :\n" + msgWelcome + "\n");
                            parent.labelBot.setText("ON");
                            parent.labelBot.setForeground(Color.green);
                            
                        }
                        msgWelcome += "EndFromBot";
                       
                        SendChat(msgWelcome);

                        parent.SimpanChat(parent.emailAdmin,email, msgWelcome);
                    }
                    else
                    {
                        
                        chatWithBot = false;
                        
                        if(selectedComboBox.contains(thisClient))
                        {
                            parent.labelBot.setText("OFF");
                            parent.labelBot.setForeground(Color.red);
                            
                        }
                        
                    }
            
                    
                    
                }
                else if(tmp.contains("LOGIN"))
                {
                    String[] login = tmp.split(";;");
                    String loginEmail = login[1];
                    String loginPassword = login[2];
                   
                    
                    String status = parent.loginClient(loginEmail, loginPassword);
                    
                    //status = arr[1];
                    
                    if(status.contains("true"))
                    {
                        String[] arr = status.split(";;");
                        displayName = arr[4];
                        email = loginEmail;
                        idUser = arr[2];
                    }
                    
                   
                    output.writeBytes(status+"\n");
                    
                    
                    
                }
                else if(tmp.contains("LOGOUT"))
                {
                    
                    
                    String selectedComboBox =  parent.comboBoxClient.getSelectedItem().toString();
                    String thisClient = email ;
                    
                    if(selectedComboBox.contains(thisClient))
                    {
                        parent.labelBot.setText("NONE");
                        parent.labelBot.setForeground(Color.black);
                        parent.textArea.setText("");

                    }
                    
                    parent.RemoveComboBoxClient(displayName, email);
                    client.close();
                    parent.clientsArr.remove(this);
                    
                    
                }
                else if(chatWithBot == true)
                {
                    
                    String selectedComboBox =  parent.comboBoxClient.getSelectedItem().toString();
                    String msg = "";
                    String thisClient = email ;
                    
                    String[] arr = tmp.split(";;");
                    parent.SimpanChat(email, parent.emailAdmin, arr[1]);
                    
                    
                  
                    
                    if(botStep == 0) 
                    {
                        
                        try
                        {
                            
                            botStep = 1;
                            Integer hasil = Integer.parseInt(arr[1]);
                            
                            if(hasil == 1)
                            {
                                statusBot = "reservasi";
                                msg = "Anda memilih 'Reservasi'.\nOpsi Menu : \n"
                                        + "0) Kembali\n"
                                        + "1) Cek ketersediaan villa pada tanggal tertentu\n"
                                        + "2) Booking villa\n";
                            }
                            else if(hasil == 2)
                            {
                                statusBot = "trackorder";
                                msg = "Anda memilih 'Check Booking/Track order'.\nSilahkan masukkan order id : \n"
                                        + "Opsi Menu : \n"
                                        + "0) Kembali\n";
                            }
                            
                            else
                            {
                                msg = "Harap menginputkan angka sesuai dengan menu yang ada.";
                                botStep = 0;
                            }
                            
                        }
                        catch(Exception ex)
                        {
                           
                            msg = "Harap memberi input dalam bentuk angka saja sesuai opsi.";
                            System.out.println(ex);
                            botStep = 0;
                                    
                            
                        }
                        
                    }
                    else if(botStep == 1)
                    {
                        try
                        {
                            botStep = 2;
                            Integer hasil = Integer.parseInt(arr[1]);
                            
                            if(statusBot.equals("reservasi"))
                            {
                                if(hasil == 1)
                                {
                                    msg = "Anda memilih 'Cek Ketersediaan villa pada tnaggal tertentu'.\n"
                                            + "----Keterangan----\n"
                                            + "Tanggal check-in dan check-out menggunakan format ini : yyyy-MM-dd\n"
                                            + "Daftar Villa : \n"
                                            + parent.TampilSemuaVilla() + "\n"
                                            + "Contoh Pesan (NoVilla#check-in#check-out) : 1#2021-06-25#2021-06-30\n"
                                            + "Opsi Menu : \n"
                                            + "0) Kembali\n";
                                    statusBot = "cekVilla";
                                }
                                else if(hasil == 2)
                                {
                                    msg = "Anda memilih 'Booking Villa'.\n"
                                            + "----Keterangan----\n"
                                            + "Daftar Villa : \n"
                                            + parent.TampilSemuaVilla() + "\n"
                                            + "Tanggal check-in dan check-out menggunakan format ini : yyyy-MM-dd\n"
                                            + "Total Guest adalah berapa banyak yang akan menghuni villa\n"
                                            + "Notes adalah pesan tambahan yang ingin disampaikan kepada admin\n"
                                            + "FORMAT PESAN : \nidVilla#checkin#checkout#TotalGuest#Notes\n"
                                            + "Contoh : 2#2021-06-15#2021-06-20#5#Butuh kompor 2\n"
                                            + "Opsi Menu : \n"
                                            + "0) Kembali";
                                    statusBot = "bookingVilla";
                                }
                                else if(hasil == 0)
                                {
                                    statusBot = "";
                                    botStep = 0;
                                    msg = "Anda memilih 'Kembali'.\n\nOpsi Menu :\n"
                                            + "1) Reservasi\n" 
                                            + "2) Track Order Booking\n";
                                }
                                else
                                {
                                     msg = "Harap menginputkan angka sesuai dengan menu yang ada.";
                                     botStep = 1;
                                }
                            }
                            else
                            {
                                if(hasil == 0)
                                {
                                    statusBot = "";
                                    botStep = 0;
                                    msg = "Anda memilih 'Kembali'.\n\nOpsi Menu :\n"
                                            + "1. Reservasi\n" 
                                            + "2. Track Order Booking\n";
                                }
                                else
                                {
                                    String result = FormDashboard.trackOrderApp(hasil);
                                     
                                    if(result.contains(email))
                                    {
                                         String[] arrTrack = result.split(";;");
                                         String buktiBayar = "";
                                         if(arrTrack[10].equals("null"))
                                         {
                                             buktiBayar = "Belum ada";
                                         }
                                         else
                                         {
                                             buktiBayar = "Sudah Terkirim";
                                         }
                                         
                                         msg = "Berikut informasi Reservasi dengan Order ID : " + hasil + "\n"
                                                 + "Name : " +  arrTrack[14] + "\n"
                                                 + "Villa : " + arrTrack[12]  + "\n"
                                                 + "Date : " + arrTrack[4] + "-" + arrTrack[5]  + "\n"
                                                 + "Total Guest : " + arrTrack[7]  + "\n"
                                                 + "Notes : " +  arrTrack[9] + "\n"
                                                 + "Status : " + arrTrack[6]  + "\n"
                                                 + "Bukti Pembayaran : " +  buktiBayar + "\n"
                                                 + "Opsi Menu : \n"
                                                 + "0) Kembali";
                                         botStep = 1;
                                         
                                    }
                                    else
                                    {
                                        msg = "Maaf tidak ada reservasi dengan order ID = " + hasil + "\n"
                                                + "Opsi Menu : \n"
                                                + "0) Kembali";
                                        botStep = 1;
                                    }
                                }
                            }
                           
                            
                        }
                        catch(Exception ex)
                        {
                            
                            msg = "Harap memberi input dalam bentuk angka saja sesuai opsi.";
                            System.out.println(ex);
                            botStep = 1;
                                    
                            
                        }
                    }
                    else if(botStep == 2)
                    {
                        
                        try
                        {
                            String hasil = arr[1];
                            if(hasil.equals("0"))
                            {
                                statusBot = "";
                                botStep = 0;
                                msg = "Anda memilih 'Kembali'.\nOpsi Menu :\n"
                                        + "1. Reservasi\n" 
                                        + "2. Track Order Booking\n";
                            }
                            else
                            {
                                if(statusBot.equals("cekVilla"))
                                {
                                    String[] arrCek = hasil.split("#");
                                    
                                    Date in = new SimpleDateFormat("yyyy-MM-dd").parse(arrCek[1]);  
                                    Date out = new SimpleDateFormat("yyyy-MM-dd").parse(arrCek[2]);  
                                    
                                    if(in.after(out))
                                    {
                                        msg = "Tolong masukkan tanggal checkin lebih dulu daripada tanggal checkout.";
                                        
                                    }
                                    else
                                    {
                                        String[] checkin = arrCek[1].split("-");
                                        String[] checkout = arrCek[2].split("-");

                                        Integer villaId = Integer.parseInt(arrCek[0]);
                                        Integer test;


                                        for (int i = 0; i < 3; i++) 
                                        {
                                            test = Integer.parseInt(checkin[i]);

                                        }

                                        for (int i = 0; i < 3; i++) 
                                        {
                                            test = Integer.parseInt(checkout[i]);

                                        }
                                        String result = FormDashboard.checkAvailability(villaId, arrCek[1], arrCek[2]);

                                        if(result.contains("true"))
                                        {
                                            msg = "Villa tersedia pada tanggal " + arrCek[1] + "-" + arrCek[2] +"\n"
                                                    + "Opsi Menu : \n"
                                                    + "0) Kembali\n"
                                                    + "1) Cek Ketersediaan Villa pada tanggal tertentu\n"
                                                    + "2) Booking Villa\n";
                                            statusBot = "reservasi";
                                            botStep = 1;
                                        }
                                        else
                                        {
                                             msg = "Villa tidak tersedia pada tanggal " + arrCek[1] + "-" + arrCek[2] +"\n"
                                                    + "Opsi Menu : \n"
                                                    + "0) Kembali\n"
                                                    + "1) Cek Ketersediaan Villa pada tanggal tertentu\n"
                                                    + "2) Booking Villa\n";;
                                            statusBot = "reservasi";
                                            botStep = 1;
                                        }
                                    }
                                    
                                    
                                    
                                }
                                else
                                {
                                    //Contoh : 2#2021-06-15#2021-06-20#5#Butuh kompor 2
                                    
                                    String[] arrBook = hasil.split("#");
                                    
                                    Date in = new SimpleDateFormat("yyyy-MM-dd").parse(arrBook[1]);  
                                    Date out = new SimpleDateFormat("yyyy-MM-dd").parse(arrBook[2]);  
                                    
                                    if(in.after(out))
                                    {
                                        msg = "Tolong masukkan tanggal checkin lebih dulu daripada tanggal checkout.";
                                        
                                    }
                                    else
                                    {
                                        String[] checkin = arrBook[1].split("-");
                                        String[] checkout = arrBook[2].split("-");

                                       
                                        Integer villaId = Integer.parseInt(arrBook[0]);
                                        

                                        Integer totalGuest = Integer.parseInt(arrBook[3]);
                                        
                                        Integer test;

                                        for (int i = 0; i < 3; i++) 
                                        {
                                            test = Integer.parseInt(checkin[i]);

                                        }
                                       
                                        for (int i = 0; i < 3; i++) 
                                        {
                                            test = Integer.parseInt(checkout[i]);

                                        }

                                        
                                        String result = FormDashboard.insertReservation(arrBook[1], arrBook[2], totalGuest, arrBook[4], Integer.parseInt(idUser), villaId);
                                        
                                        String[] arrResult = result.split(";;");

                                      

                                        if(arrResult[1].equals("true"))
                                        {
                                            msg = "Villa sudah terbooking. Silahkan mengupload bukti pembayaran sebelum tanggal checkin\n"
                                                    + "Order Id reservasi : " + arrResult[2] + "\n"
                                                    + "Opsi Menu : \n"
                                                    + "0) Kembali\n"
                                                    + "1) Cek Ketersediaan Villa pada tanggal tertentu\n"
                                                    + "2) Booking Villa\n";;
                                            statusBot = "reservasi";
                                            botStep = 1;
                                        }
                                        else
                                        {
                                            msg = "Villa tidak dapat dibooking.\nKarena ada jadwal reservasi bertabrakan dengan pesanan lain.\n"
                                                    + "Opsi Menu : \n"
                                                    + "0) Kembali\n"
                                                    + "1) Cek Ketersediaan Villa pada tanggal tertentu\n"
                                                    + "2) Booking Villa\n";;
                                            statusBot = "reservasi";
                                            botStep = 1;

                                        }
                                    }
                                    
                                }
                            }
                        }
                        catch(Exception ex)
                        {
                            msg = "Harap memberi input dalam bentuk angka sesuai format yang ada.";
                            System.out.println(ex);
                            botStep = 1;
                        }
                     
                    }
                   
                    SendChat(msg);
                    parent.SimpanChat(parent.emailAdmin, email, msg);
                    if(selectedComboBox.contains(thisClient))
                    {
                        
                        parent.ShowChat(tmp);
                        parent.textArea.append("Admin : " + msg + "\n");
                    }
                }
                else
                {
                    
                    
                    String selectedComboBox =  parent.comboBoxClient.getSelectedItem().toString();
                    
                    String thisClient = email ;
                    
                    String[] arr = tmp.split(";;");
                    parent.SimpanChat(email, parent.emailAdmin, arr[1]);
                    
                    
                    
                    if(selectedComboBox.contains(thisClient))
                    {
                       
                        parent.ShowChat(tmp);
                    }
                    
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

    