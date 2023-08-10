/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author kaue_brito
 */
public class Account {

    private String ownerName;
    private Integer numberAccount;
    private Double balance;
    
    
    public Account (String ownerName, int numberAccount,Double balance){
        this.ownerName = ownerName;
        this.numberAccount = numberAccount;
        this.balance = 0.0;
    }
    
    
    public String getOwnerName() {
        return ownerName;
    }

    public Integer getAccountNumber() {
        return numberAccount;
    }
    public Double getBalance() {
        return balance;
    }
    
    public Double withDraw(Double value){
        if(balance  < value){
           return -1.0;
            
        }else{
            this.balance -= value;
            return this.balance;
        }
    }
    public Double deposit(Double value){
        return this.balance =+ value;
    }
    

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;

    }

    public void setnumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;

    }
    public void setBalance(Double balance) {
        this.balance = balance;

    }
    
}
