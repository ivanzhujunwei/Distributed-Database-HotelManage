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
public class Membership
{

    private String mem_tier;
    private int tier_credit;
    private double discount;
    private double reward;

    public String getMem_tier()
    {
        return mem_tier;
    }

    public void setMem_tier(String mem_tier)
    {
        this.mem_tier = mem_tier;
    }

    public int getTier_credit()
    {
        return tier_credit;
    }

    public void setTier_credit(int tier_credit)
    {
        this.tier_credit = tier_credit;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public double getReward()
    {
        return reward;
    }

    public void setReward(double reward)
    {
        this.reward = reward;
    }

}
