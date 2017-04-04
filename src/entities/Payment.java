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
public class Payment
{

    private int pay_id;
    private String pay_date;
    private String pay_method;
    private double pay_amount;

    public int getPay_id()
    {
        return pay_id;
    }

    public void setPay_id(int pay_id)
    {
        this.pay_id = pay_id;
    }

    public String getPay_date()
    {
        return pay_date;
    }

    public void setPay_date(String pay_date)
    {
        this.pay_date = pay_date;
    }

    public String getPay_method()
    {
        return pay_method;
    }

    public void setPay_method(String pay_method)
    {
        this.pay_method = pay_method;
    }

    public double getPay_amount()
    {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount)
    {
        this.pay_amount = pay_amount;
    }

}
