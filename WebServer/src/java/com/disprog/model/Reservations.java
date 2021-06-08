/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disprog.model;

import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ohanna
 */
public class Reservations extends DbConnection {

    //<editor-fold defaultstate="collapsed" desc="Data Member">
    private Integer idreservation;
    private Timestamp res_timestamp;
    private Date chekin_date;
    private Date checkout_date;
    private String status;
    private Integer total_gusest;
    private String notes;
    private String bukti_pembayaran;
    private Integer idvilla;
    private Integer iduser;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Reservations() {
        getConnection();
    }

    public Reservations(Integer idreservation, Timestamp res_timestamp, Date chekin_date, Date checkout_date, String status, Integer total_gusest, String notes, String bukti_pembayaran, Integer idvilla, Integer iduser) {
        getConnection();
        this.idreservation = idreservation;
        this.res_timestamp = res_timestamp;
        this.chekin_date = chekin_date;
        this.checkout_date = checkout_date;
        this.status = status;
        this.total_gusest = total_gusest;
        this.notes = notes;
        this.bukti_pembayaran = bukti_pembayaran;
        this.idvilla = idvilla;
        this.iduser = iduser;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    public Integer getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Timestamp getRes_timestamp() {
        return res_timestamp;
    }

    public void setRes_timestamp(Timestamp res_timestamp) {
        this.res_timestamp = res_timestamp;
    }

    public Date getChekin_date() {
        return chekin_date;
    }

    public void setChekin_date(Date chekin_date) {
        this.chekin_date = chekin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotal_gusest() {
        return total_gusest;
    }

    public void setTotal_gusest(Integer total_gusest) {
        this.total_gusest = total_gusest;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public Integer getIdvilla() {
        return idvilla;
    }

    public void setIdvilla(Integer idvilla) {
        this.idvilla = idvilla;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public Integer CalculateTotalPrice(Date checkIn, Date checkout, Integer idvilla) {
        try {
            // calculate different days
            int diffInDays = (int) (checkout.getTime() - checkIn.getTime() / (1000 * 60 * 60 * 24)
                    % 365);

            // calculate price
            //1. get the price of the villa
            String query = "SELECT price FROM villas WHERE idvilla =?";
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(query);

            //set paramater
            sql.setInt(1, idvilla);
            result = sql.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String InsertReservation(Date checkIn, Date checkout, Integer total_guest, String notes, Integer iduser, Integer idvilla) {
        getConnection();
        String message = "";
        try {
            Integer totalPrice = this.CalculateTotalPrice(checkIn, checkout, idvilla);

            // set query
            String query = "INSERT INTO reservations(`checkin_date`,`checkout_date`,`total_guest`,`notes`,`total_price`,`iduser`,`idvilla`) "
                    + "VALUES(?,?,?,?,?,?,?)";

            // set preparedStatement
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(query);

            //set paramater
            sql.setDate(1, checkIn);
            sql.setDate(2, checkout);
            sql.setInt(3, total_guest);
            sql.setString(4, notes);
            sql.setInt(5, totalPrice);
            sql.setInt(6, iduser);
            sql.setInt(7, idvilla);

            result = sql.executeQuery();
            if (result.next()) {
                message = "true";
                return message;
            } else {
                message = "false";
            }
            connect.close();
            return message;
        } catch (SQLException ex) {
            System.out.println("Error Input Reservation: " + ex);
        }
        return message;
    }

    public String UploadPayment(String bukti_pembayaran, Integer idreservation) {
        String message = "";
        try {
            // set query
            String query = "UPDATE reservations SET bukti_pembayaran =? WHERE idreservation=?";

            // read file
            File file = new File(bukti_pembayaran);
            FileInputStream inputFile = new FileInputStream(file);

            // set preparedStatement
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(query);

            //set paramater
            sql.setBinaryStream(1, inputFile);
            sql.setInt(2, idreservation);

            result = sql.executeQuery();
            if (result.next()) {
                message = "true";
                return message;
            } else {
                message = "false";
            }
            connect.close();
            return message;
        } catch (SQLException | FileNotFoundException ex) {
            System.out.println("Error Upload Payment: " + ex);
        }
        return message;
    }

    public String ChangeStatus(String status, String idreservation) {
        String message = "";
        try {
            // set query
            String query = "UPDATE reservations SET status =? WHERE idreservation=?";

            // set preparedStatement
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(query);

            //cek status
            if (!(status.equals("PENDING") || status.equals("ACCEPTED") || status.equals("DECLINED") || status.equals("CANCELED"))) {
                return "false";
            }

            //set paramater
            sql.setString(1, status);
            sql.setString(2, idreservation);

            result = sql.executeQuery();
            if (result.next()) {
                return "true";
            } else {
                return "false";
            }
        } catch (Exception ex) {
            System.out.println("Error Upload Payment: " + ex);
        }
        return message;
    }
//masih belum 
    public String BacaData(String kriteria, String dicari) {
        String message = "";
        try {
            // set query
            String query = "SELECT r.idreservation, r.res_timestamp, r.checkin_date, "
                    + "r.checkout_date, r.status, r.total_guest, r.notes, r.bukti_pembayaran "
                    + "FROM reservations r";

            String query2 = "SELECT r.idreservation, r.res_timestamp, r.checkin_date, "
                    + "r.checkout_date, r.status, r.total_guest, r.notes, r.bukti_pembayaran, "
                    + "v.idvilla, v.name, v.address, v."
                    + "FROM reservations r "
                    + "INNER JOIN villas v ON r.idvilla = v.idvilla";
            // set preparedStatement
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(query);

            //cek status
            if (!(status.equals("PENDING") || status.equals("ACCEPTED") || status.equals("DECLINED") || status.equals("CANCELED"))) {
                return "false";
            }

            //set paramater
            sql.setString(1, status);
//            sql.setString(2, idreservation);

            result = sql.executeQuery();
            if (result.next()) {
                return "true";
            } else {
                return "false";
            }
        } catch (Exception ex) {
            System.out.println("Error Upload Payment: " + ex);
        }
        return message;
    }
    //</editor-fold> 
}