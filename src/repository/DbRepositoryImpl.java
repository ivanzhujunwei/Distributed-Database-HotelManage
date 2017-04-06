/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Booking;
import entities.Customer;
import entities.Guest;
import entities.Hotel;
import entities.Membership;
import entities.Payment;
import entities.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class DbRepositoryImpl implements DbRepository
{

    // FIT5148A database connection
    public static Connection connA = null;
    // FIT5148B database connection
    public static Connection connB = null;

    Statement stmt = null;
//    ResultSetMetaData mdata;

    public DbRepositoryImpl()
    {
        connA = DBConnection.getConnectionA();
        connB = DBConnection.getConnectionB();
    }
    
    @Override
    public void addBooking(Booking booking)
    {
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO Booking (booking_id,cus_num,rm_num,checkin_date,checkout_date,contact_person,contact_email,total_amount) VALUES(s_booking.nextval,"
                    + booking.getCustomer().getNumber()+ ","
                    + booking.getRoom().getRm_num()+ ","
                    + "TO_DATE('"+ booking.getCheckIn()+ "','YYYY-MM-DD'),"
                    + "TO_DATE('"+ booking.getCheckOut()+ "','YYYY-MM-DD'),'"
                    + booking.getPerson()+ "','"
                    + booking.getEmail()+ "',"
                    + booking.getTotalAmount()+ ")";
            System.out.println("Add booking sql: "+sql);
            stmt.executeUpdate(sql);
            // add to booking_room
            String brSql = "INSERT INTO BOOKING_ROOM VALUES (s_bookingroom.nextval, s_booking.currval,"+ booking.getRoom().getRm_num()+")";
           System.out.println("Add bookingRoom sql: "+brSql);
            stmt.executeUpdate(brSql);
            // add to booking_guest
            for(Guest g: booking.getGuestList()){
                String bgSql = "INSERT INTO BOOKING_GUESTS VALUES (s_booking.currval,"+ g.getNumber()+")";
                stmt.executeUpdate(bgSql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addCustomer(Customer customer)
    {
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO Customer VALUES("
                    + customer.getNumber()+ ",'"
                    + customer.getTitle()+ "','"
                    + customer.getFirstName()+ "','"
                    + customer.getLastName()+ "',"
                    + "TO_DATE('"+ customer.getDob()+ "','YYYY-MM-DD'),'"
                    + customer.getCountry()+ "','"
                    + customer.getCity()+ "','"
                    + customer.getStreet()+ "','"
                    + customer.getPostcode()+ "','"
                    + customer.getMs().getMem_tier()+ "','"
                    + customer.getCredit()+ "','"
                    + customer.getPhone()+ "','"
                    + customer.getEmail()+ "')";
            System.out.println("Add customer sql: "+sql);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addGuest(Guest guest)
    {
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO GUEST VALUES("
                    + guest.getNumber()+ ",'"
                    + guest.getTitle()+ "','"
                    + guest.getFirstName()+ "','"
                    + guest.getLastName()+ "',"
                    + "TO_DATE('"+ guest.getDob()+ "','YYYY-MM-DD'),'"
                    + guest.getCountry()+ "','"
                    + guest.getCity()+ "','"
                    + guest.getStreet()+ "',"
                    + guest.getPostcode()+ ",'"
                    + guest.getPhone()+ "','"
                    + guest.getEmail()+ "')";
            System.out.println("Add guest sql: "+sql);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addHotel(Hotel hotel)
    {
        try {
            stmt = connA.createStatement();
            String sql = "INSERT INTO HOTEL VALUES("
                    + hotel.getHotelId() + ",'"
                    + hotel.getHotelName() + "','"
                    + hotel.getHotelType() + "',"
                    + hotel.getYear() + ",'"
                    + hotel.getCountry() + "','"
                    + hotel.getCity() + "','"
                    + hotel.getAddress() + "','"
                    + hotel.getContact_phone() + "','"
                    + hotel.getContact_email() + "'"
                    + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addMembership(Membership membership)
    {
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO MEMBERSHIP VALUES('"
                    + membership.getMem_tier() + "',"
                    + membership.getTier_credit() + ","
                    + membership.getDiscount() + ","
                    + membership.getReward()+")";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addPayment(int bookingId, double totalAmount, String payMethod)
    {
        // add the payment
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO Payment VALUES(s_payment.nextval,"
                    + "TO_DATE(sysdate,'YYYY-MM-DD'),'"
                    + payMethod + "',"
                    + totalAmount + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            // update the booking status, and customer credit will automatically increased
            String setBookingPaidSql = "UPDATE booking set pay_status = 1, pay_id = s_payment.currval where booking_id= " + bookingId;
            stmt.executeUpdate(setBookingPaidSql);
            // detect how many credit does the customer have and which membership tier he/she should be
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addRoom(Room room)
    {
        try {
            stmt = connB.createStatement();
            String sql = "INSERT INTO ROOM VALUES("
                    + room.getRm_num() + ","
                    + room.getHotel().getHotelId() + ",'"
                    + room.getRm_type() + "',"
                    + room.getRm_price() + ",'"
                    + room.getRm_des() + "',"
                    + room.getRm_occupancy() + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void cancelBooking(int bookingId)
    {
        try {
            stmt = connB.createStatement();
            String bgsql = "DELETE FROM booking_guests WHERE booking_id = " + bookingId;
            stmt.executeUpdate(bgsql);
            
            String broomsql = "DELETE FROM booking_room WHERE booking_id = " + bookingId;
            stmt.executeUpdate(broomsql);
            
            String sql = "DELETE FROM booking WHERE booking_id = " + bookingId;
            stmt.executeUpdate(sql);
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cancelPayment(int payId, int bookingId)
    {
        try {
            stmt = connB.createStatement();
            
            // update booking table
            String broomsql = "update booking set pay_id = null, pay_status = 0 WHERE booking_id = " + bookingId;
            stmt.executeUpdate(broomsql);
            // delete payment record
            String bgsql = "DELETE FROM payment WHERE pay_id = " + payId;
            stmt.executeUpdate(bgsql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCustomer(int customerNum)
    {
        try {
            stmt = connB.createStatement();
            String sql = "DELETE FROM CUSTOMER WHERE CUS_NUM = " + customerNum;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteGuest(int guestNum)
    {
         try {
            stmt = connB.createStatement();
            String sql = "DELETE FROM GUEST WHERE GUEST_NUM = " + guestNum;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteMembership(String mem_tier)
    {
        try {
            stmt = connB.createStatement();
            String sql = "DELETE FROM MEMBERSHIP WHERE mem_tier = '" + mem_tier + "'";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Override
    public void deleteRoom(int roomId)
    {
        try {
            stmt = connB.createStatement();
            String sql = "DELETE FROM ROOM WHERE rm_num = " + roomId;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteHotel(int hotelId)
    {
        try {
            stmt = connA.createStatement();
            String sql = "DELETE FROM HOTEL WHERE HT_ID = " + hotelId;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hotel> findHotelsByType(String type)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Booking getBookingById(String bookId)
    {
//        Customer customer = new Customer();
//        try {
//            stmt = connB.createStatement();
//            ResultSet rset = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUS_NUM = " + customerID);
//            while (rset.next()) {
//                customer.setNumber(customerID);
//                customer.setTitle(rset.getString("TITLE"));
//                customer.setFirstName(rset.getString("FIRST_NAME"));
//                customer.setLastName(rset.getString("Last_name"));
//                customer.setDob(rset.getString("DOB"));
//                customer.setCountry(rset.getString("Country"));
//                customer.setCity(rset.getString("City"));
//                customer.setStreet(rset.getString("Street"));
//                customer.setPostcode(rset.getInt("Postcode"));
//                customer.setPhone(rset.getString("Phone"));
//                customer.setEmail(rset.getString("Email"));
//                
//                String membershipStr = rset.getString("MEM_TIER");
//                Membership ms = getMembershipByTier(membershipStr);
//                customer.setMs(ms);
//            }
//            rset.close();
//        } catch (SQLException f) {
//            System.out.println(f.getMessage());
//        } finally {
//            try {
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return customer;
        return null;
    }

    @Override
    public Customer getCustomerById(int customerID)
    {
        Customer customer = new Customer();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUS_NUM = " + customerID);
            while (rset.next()) {
                customer.setNumber(customerID);
                customer.setTitle(rset.getString("TITLE"));
                customer.setFirstName(rset.getString("FIRST_NAME"));
                customer.setLastName(rset.getString("Last_name"));
                customer.setDob(rset.getString("DOB"));
                customer.setCountry(rset.getString("Country"));
                customer.setCity(rset.getString("City"));
                customer.setStreet(rset.getString("Street"));
                customer.setPostcode(rset.getInt("Postcode"));
                customer.setPhone(rset.getString("Phone"));
                customer.setEmail(rset.getString("Email"));
                customer.setCredit(rset.getInt("Credit"));
                String membershipStr = rset.getString("MEM_TIER");
                Membership ms = getMembershipByTier(membershipStr);
                customer.setMs(ms);
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return customer;
    }

    @Override
    public Guest getGusetById(int guestId)
    {
        Guest guest = new Guest();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM GUEST WHERE GUEST_NUM = " + guestId);
            while (rset.next()) {
                guest.setNumber(guestId);
                guest.setTitle(rset.getString("TITLE"));
                guest.setFirstName(rset.getString("FIRST_NAME"));
                guest.setLastName(rset.getString("Last_name"));
                guest.setDob(rset.getString("DOB"));
                guest.setCountry(rset.getString("Country"));
                guest.setCity(rset.getString("City"));
                guest.setStreet(rset.getString("Street"));
                guest.setPostcode(rset.getInt("Postcode"));
                guest.setPhone(rset.getString("Phone"));
                guest.setEmail(rset.getString("Email"));
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return guest;
    }

    @Override
    public Hotel getHotelById(int hotelId)
    {
        Hotel hotel = new Hotel();
        try {
            stmt = connA.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM HOTEL WHERE HT_ID = " + hotelId);
            while (rset.next()) {
                hotel.setHotelId(rset.getInt("HT_ID"));
                hotel.setHotelName(rset.getString("HT_NAME"));
                hotel.setHotelType(rset.getString("HT_TYPE"));
                hotel.setYear(Integer.parseInt(rset.getString("CONSTRUCTION_YEAR")));
                hotel.setCountry(rset.getString("COUNTRY"));
                hotel.setCity(rset.getString("CITY"));
                hotel.setAddress(rset.getString("ADDRESS"));
                hotel.setContact_phone(rset.getString("CONTACT_NUMBER"));
                hotel.setContact_email(rset.getString("EMAIL"));
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hotel;
    }

    @Override
    public List<Hotel> getHotels()
    {
        return null;
    }

    @Override
    public Membership getMembershipByTier(String memTier)
    {
        Membership ms = new Membership();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM Membership WHERE mem_tier = '" + memTier +"'");
            while (rset.next()) {
                  ms.setMem_tier(memTier);
                  ms.setTier_credit(rset.getInt("TIER_CREDITS"));
                  ms.setDiscount(rset.getDouble("DISCOUNT"));
                  ms.setReward(rset.getDouble("REWARD"));
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ms;
    }

    @Override
    public List<Membership> getMs()
    {
        List<Membership> lists = new ArrayList<>();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM Membership order by tier_credits desc");
            while (rset.next()) {
                Membership ms = new Membership();
                ms.setMem_tier(rset.getString("mem_tier"));
                ms.setTier_credit(Integer.parseInt(rset.getString("tier_credits")));
                ms.setDiscount(Double.parseDouble(rset.getString("discount")));
                ms.setReward(Double.parseDouble(rset.getString("reward")));
                lists.add(ms);
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lists;
        
    }

    @Override
    public Room getRoomById(int roomid)
    {
        Room room = new Room();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM Room WHERE rm_num = " + roomid);
            while (rset.next()) {
                room.setRm_num(roomid);
                room.setRm_type(rset.getString("rm_type"));
                room.setRm_price(rset.getDouble("rm_price"));
                room.setRm_des(rset.getString("rm_des"));
                Hotel hotel = getHotelById(rset.getInt("ht_id"));
                room.setHotel(hotel);
                room.setRm_occupancy(rset.getInt("occupancy"));
            }
            rset.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return room;
    }

    @Override
    public boolean isCustomerExisted(int customerId)
    {
        Customer customer= getCustomerById(customerId);
        return customer.getNumber()!= 0;
    }

    @Override
    public boolean isGuestExisted(int guestId)
    {
        Guest guest = getGusetById(guestId);
        return guest.getNumber()!= 0;
    }

    @Override
    public boolean isHotelExisted(int hotelId)
    {
        Hotel hotel = getHotelById(hotelId);
        return hotel.getHotelId() != 0;
    }

    @Override
    public boolean isMembershipExisted(String mem_tier)
    {
        Membership ms = getMembershipByTier(mem_tier);
        return ms.getMem_tier()!=null;
    }

    @Override
    public boolean isRoomExisted(int roomId)
    {
        Room room = getRoomById(roomId);
        return room.getRm_num() != 0;
    }

    @Override
    public void updateBooking(Booking booking)
    {
        try {
            stmt = connB.createStatement();
            String sql = "UPDATE Booking SET Contact_PERSON = '" + booking.getPerson()+ "',"
                    + "CONTACT_EMAIL = '" + booking.getEmail()+ "' "
                    + " WHERE booking_id = " + booking.getBookingId();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
    }

    @Override
    public void updateCustomer(Customer customer)
    {
        try {
            stmt = connB.createStatement();
            String sql = "UPDATE CUSTOMER SET CUS_NUM = '" + customer.getNumber()+ "',"
                    + "TITLE = '" + customer.getTitle()+ "',"
                    + "FIRST_NAME = '" + customer.getFirstName()+ "',"
                    + "LAST_NAME = '" + customer.getLastName()+ "',"
                    + "DOB = "   + "TO_DATE('"+ customer.getDob().substring(0,10)+ "','YYYY-MM-DD'),"
                    + "COUNTRY = '" + customer.getCountry()+ "',"
                    + "CITY = '" + customer.getCity() + "',"
                    + "STREET = '" + customer.getStreet() + "',"
                    + "POSTCODE = '" + customer.getPostcode()+ "',"
                    + "PHONE = '" + customer.getPhone()+ "',"
                    + "MEM_TIER = '" + customer.getMs().getMem_tier()+ "',"
                    + "CREDIT = " + customer.getCredit()+ ","
                    + "EMAIL = '" + customer.getEmail()+ "'"
                    + " WHERE CUS_NUM = " + customer.getNumber();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
    }

    @Override
    public void updateGuest(Guest guest)
    {
        try {
            stmt = connB.createStatement();
            String sql = "UPDATE GUEST SET GUEST_NUM = '" + guest.getNumber()+ "',"
                    + "TITLE = '" + guest.getTitle()+ "',"
                    + "FIRST_NAME = '" + guest.getFirstName()+ "',"
                    + "LAST_NAME = '" + guest.getLastName()+ "',"
                    + "DOB = "   + "TO_DATE('"+ guest.getDob()+ "','YYYY-MM-DD'),"
                    + "COUNTRY = '" + guest.getCountry()+ "',"
                    + "CITY = '" + guest.getCity() + "',"
                    + "STREET = '" + guest.getStreet() + "',"
                    + "POSTCODE = '" + guest.getPostcode()+ "',"
                    + "PHONE = '" + guest.getPhone()+ "',"
                    + "EMAIL = '" + guest.getEmail()+ "'"
                    + " WHERE GUEST_NUM = " + guest.getNumber();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
    }

    @Override
    public void updateHotel(Hotel hotel)
    {
        try {
            stmt = connA.createStatement();
            /* update a student record using the values from JTextField txtID1 and txtName1 */
            String sql = "UPDATE HOTEL SET HT_NAME = '" + hotel.getHotelName() + "',"
                    + "HT_TYPE = '" + hotel.getHotelType() + "',"
                    + "CONSTRUCTION_YEAR = " + hotel.getYear() + ","
                    + "COUNTRY = '" + hotel.getCountry() + "',"
                    + "CITY = '" + hotel.getCity() + "',"
                    + "ADDRESS = '" + hotel.getAddress() + "',"
                    + "CONTACT_NUMBER = " + hotel.getContact_phone() + ","
                    + "EMAIL = '" + hotel.getContact_email() + "'"
                    + " WHERE HT_ID = " + hotel.getHotelId();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }

    }

    public Connection getConnectionA()
    {
        return connA;
    }

    public Connection getConnectionB()
    {
        return connB;
    }

    @Override
    public void updateMembership(Membership ms)
    {
        try {
            stmt = connB.createStatement();
            /* update a student record using the values from JTextField txtID1 and txtName1 */
            String sql = "UPDATE MEMBERSHIP SET mem_tier = '" + ms.getMem_tier()+ "',"
                    + "tier_credits = " + ms.getTier_credit() + ","
                    + "discount = " + ms.getDiscount() + ","
                    + "reward = " + ms.getReward() 
                    + " WHERE MEM_TIER = '" + ms.getMem_tier() + "'" ;
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }       
    }

    @Override
    public void updateRoom(Room room)
    {
        try {
            stmt = connB.createStatement();
            /* update a student record using the values from JTextField txtID1 and txtName1 */
            String sql = "UPDATE ROOM SET rm_type = '" + room.getRm_type() + "',"
                    + "rm_price = " + room.getRm_price() + ","
                    + "rm_des = '" + room.getRm_des() + "',"
                     + "ht_id = " + room.getHotel().getHotelId()+ ","
                    + "occupancy = " + room.getRm_occupancy()
                    + " WHERE rm_num = " + room.getRm_num();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }

    }

}
