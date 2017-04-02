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
public class Customer extends Members
{

    private Membership ms;
    private int credit;

    public Membership getMs()
    {
        return ms;
    }

    public void setMs(Membership ms)
    {
        this.ms = ms;
    }

    public int getCredit()
    {
        return credit;
    }

    public void setCredit(int credit)
    {
        this.credit = credit;
    }

}
