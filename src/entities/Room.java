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
public class Room
{

    private int rm_num;
    private Hotel hotel;
    private String rm_type;
    private double rm_price;
    private String rm_des;
    private int rm_occupancy;

    public int getRm_occupancy() {
        return rm_occupancy;
    }

    public void setRm_occupancy(int rm_occupancy) {
        this.rm_occupancy = rm_occupancy;
    }

    public int getRm_num()
    {
        return rm_num;
    }

    public void setRm_num(int rm_num)
    {
        this.rm_num = rm_num;
    }

    public Hotel getHotel()
    {
        return hotel;
    }

    public void setHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }

    public String getRm_type()
    {
        return rm_type;
    }

    public void setRm_type(String rm_type)
    {
        this.rm_type = rm_type;
    }

    public double getRm_price()
    {
        return rm_price;
    }

    public void setRm_price(double rm_price)
    {
        this.rm_price = rm_price;
    }

    public String getRm_des()
    {
        return rm_des;
    }

    public void setRm_des(String rm_des)
    {
        this.rm_des = rm_des;
    }

}
