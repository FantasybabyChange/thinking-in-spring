package com.fantasybaby.spring.ioc.overview.model;
/**
 * Created on 3/22/2023.
 *
 * @author FantasyBaby
 */
@UserLook
public class VipUser extends  User{
    private String pay;

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "VipUser{} " + super.toString();
    }
}


