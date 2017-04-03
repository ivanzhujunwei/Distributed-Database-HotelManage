/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.List;

/**
 * 
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class Booking {
    
    private int bookingId;
    private Customer customer;
    private List<Guest> guestList;
    private String checkOut;
    private String checkIn;
    private String person;
    private String email;
    private double totalAmount;
    private Room room;
    private Payment payment;

    public int getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public List<Guest> getGuestList()
    {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList)
    {
        this.guestList = guestList;
    }

    public String getCheckOut()
    {
        return checkOut;
    }

    public void setCheckOut(String checkOut)
    {
        this.checkOut = checkOut;
    }

    public String getCheckIn()
    {
        return checkIn;
    }

    public void setCheckIn(String checkIn)
    {
        this.checkIn = checkIn;
    }

    public String getPerson()
    {
        return person;
    }

    public void setPerson(String person)
    {
        this.person = person;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
    
    
            
}
