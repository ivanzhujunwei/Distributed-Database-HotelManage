/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.*;
import java.util.List;

/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public interface DbRepository
{
    /***
     * Get all hotels
     * @return hotel list
     */
    public List<Hotel> getHotels();
    
    /***
     * Delete hotel
     * @param hotelId hotel id
     */
    public void deleteHotel(int hotelId);
    
    /***
     * Add a hotel
     * @param hotel hotel entity
     */
    public void addHotel(Hotel hotel);
    
    /***
     * Update a hotel
     * @param hotel hotel entity
     */
    public void updateHotel(Hotel hotel);
    
    public void updateRoom(Room room);
    
    public void deleteRoom(int roomId);
    
    public void updateGuest(Guest guest);
    
    public void deleteGuest(int guestNum);
    
    public void updateCustomer(Customer customer);
    
    public void deleteCustomer(int customerNum);
    
    /***
     * Find hotels by hotel type
     * @param type hotel type
     * @return hotel list 
     */
    public List<Hotel> findHotelsByType(String type);
    
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Judge object is existed or not : START  ////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    
    /****
     * Judge if the hotel id is existed before adding a new hotel
     * @param hotelId hotel id
     * @return return true if the hotel is existed
     */
    public boolean isHotelExisted(int hotelId);
    
    public boolean isRoomExisted(int roomId);
    
    public boolean isCustomerExisted(int customerId);
    
    public boolean isGuestExisted(int guestId);
    
    public boolean isMembershipExisted(String mem_tier);
    
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Judge object is existed or not : END  ////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Add object : START  ////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    
    public void addRoom(Room room);
    
    public void addCustomer(Customer customer);
    
    public void addGuest(Guest guest);
    
    public void addMembership(Membership membership);
    
    public void addBooking(Booking booking);
    
    public void addPayment(Payment payment);
    
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Add object : END  ////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Get object by its primary id : START  //////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
     /***
     * Get hotel by hotel id
     * @param hotelId hotel id
     * @return hotel object
     */
    public Hotel getHotelById(int hotelId);
    
    public Room getRoomById(int roomid);
    
    public Customer getCustomerById(int customerID);
    
    public Guest getGusetById(int guestId);
    
    public Membership getMembershipByTier(String memTier);

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// Get object by its primary id : END  //////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
}