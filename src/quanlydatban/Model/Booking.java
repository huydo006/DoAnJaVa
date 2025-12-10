/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydatban.Model;

/**
 *
 * @author HELLO
 */
public class Booking {
    int idBooking;
    
    String TimeStart;
    int guestCount;
    String Note;
    
    //PK
    int IdEmploy ;
    int IDcus;
    int IDtable;

    public Booking(int idBooking, String TimeStart, int guestCount, String Note, int IdEmploy, int IDcus, int IDtable) {
        this.idBooking = idBooking;
        this.TimeStart = TimeStart;
        this.guestCount = guestCount;
        this.Note = Note;
        this.IdEmploy = IdEmploy;
        this.IDcus = IDcus;
        this.IDtable = IDtable;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String TimeStart) {
        this.TimeStart = TimeStart;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public int getIdEmploy() {
        return IdEmploy;
    }

    public void setIdEmploy(int IdEmploy) {
        this.IdEmploy = IdEmploy;
    }

    public int getIDcus() {
        return IDcus;
    }

    public void setIDcus(int IDcus) {
        this.IDcus = IDcus;
    }

    public int getIDtable() {
        return IDtable;
    }

    public void setIDtable(int IDtable) {
        this.IDtable = IDtable;
    }

    
    
}