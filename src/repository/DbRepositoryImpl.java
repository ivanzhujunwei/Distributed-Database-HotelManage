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
//        try {
//            stmt = connB.createStatement();
//            String sql = "INSERT INTO Booking VALUES("
//                    + booking.getNumber()+ ",'"
//                    + booking.getTitle()+ "','"
//                    + booking.getFirstName()+ "','"
//                    + booking.getLastName()+ "','"
//                    + booking.getDob()+ "','"
//                    + booking.getCountry()+ "','"
//                    + booking.getCity()+ "','"
//                    + booking.getStreet()+ "','"
//                    + booking.getPostcode()+ "','"
//                    + booking.getMs().getMem_tier()+ "','"
//                    + booking.getCredit()+ "','"
//                    + customer.getPhone()+ "','"
//                    + customer.getEmail()+ "')";
//            System.out.println("Add guest sql: "+sql);
//            stmt.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DbRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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
                    + customer.getLastName()+ "','"
                    + customer.getDob()+ "','"
                    + customer.getCountry()+ "','"
                    + customer.getCity()+ "','"
                    + customer.getStreet()+ "','"
                    + customer.getPostcode()+ "','"
                    + customer.getMs().getMem_tier()+ "','"
                    + customer.getCredit()+ "','"
                    + customer.getPhone()+ "','"
                    + customer.getEmail()+ "')";
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
            String sql = "INSERT INTO MEMBERSHIP VALUES("
                    + membership.getMem_tier() + ","
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
    public void addPayment(Payment payment)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void deleteCustomer(int customerNum)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGuest(int guestNum)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMembership(String mem_tier)
    {
        try {
            stmt = connB.createStatement();
            String sql = "DELETE FROM MEMBERSHIP WHERE mem_tier = " + mem_tier;
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
    public Customer getCustomerById(int customerID)
    {
        Customer customer = new Customer();
        try {
            stmt = connB.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM GUEST WHERE CUS_NUM = " + customerID);
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
            ResultSet rset = stmt.executeQuery("SELECT * FROM Membership WHERE mem_tier = " + memTier);
            while (rset.next()) {
                  ms.setMem_tier(memTier);
                  ms.setTier_credit(rset.getInt("TIER_CREDIT"));
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
        return !ms.getMem_tier().equals("");
    }

    @Override
    public boolean isRoomExisted(int roomId)
    {
        Room room = getRoomById(roomId);
        return room.getRm_num() != 0;
    }

    @Override
    public void updateCustomer(Customer customer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGuest(Guest guest)
    {
//        try {
//            stmt = connA.createStatement();
//            /* update a student record using the values from JTextField txtID1 and txtName1 */
//            String sql = "UPDATE HOTEL SET HT_NAME = '" + hotel.getHotelName() + "',"
//                    + "HT_TYPE = '" + hotel.getHotelType() + "',"
//                    + "CONSTRUCTION_YEAR = " + hotel.getYear() + ","
//                    + "COUNTRY = '" + hotel.getCountry() + "',"
//                    + "CITY = '" + hotel.getCity() + "',"
//                    + "ADDRESS = '" + hotel.getAddress() + "',"
//                    + "CONTACT_NUMBER = " + hotel.getContact_phone() + ","
//                    + "EMAIL = '" + hotel.getContact_email() + "'"
//                    + " WHERE HT_ID = " + hotel.getHotelId();
//            System.out.println(sql);
//            stmt.executeUpdate(sql);
//            stmt.close();
//        } catch (SQLException f) {
//            System.out.println(f.getMessage());
//        }
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
                    + "discount = '" + ms.getDiscount() + "',"
                    + "reward = " + ms.getReward();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }       
    }

    public void updateRoom(Room room)
    {
        try {
            stmt = connB.createStatement();
            /* update a student record using the values from JTextField txtID1 and txtName1 */
            String sql = "UPDATE ROOM SET rm_type = '" + room.getRm_type() + "',"
                    + "rm_price = " + room.getRm_price() + ","
                    + "rm_des = '" + room.getRm_des() + "',"
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
