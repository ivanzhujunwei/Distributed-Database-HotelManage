/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 * 
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class Hotel {
    private int hotelId;
    private String hotelName;
    private String hotelType;
    private int year;
    private String country;
    private String city;
    private String address;
    private String contact_phone;
    private String contact_email;
    
    public int getHotelId()
    {
        return hotelId;
    }

    public void setHotelId(int hotelId)
    {
        this.hotelId = hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getHotelType()
    {
        return hotelType;
    }

    public void setHotelType(String hotelType)
    {
        this.hotelType = hotelType;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContact_phone()
    {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone)
    {
        this.contact_phone = contact_phone;
    }

    public String getContact_email()
    {
        return contact_email;
    }

    public void setContact_email(String contact_email)
    {
        this.contact_email = contact_email;
    }
}
