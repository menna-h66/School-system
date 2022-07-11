/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Allewaa
 */
public class student {
    private int id;
    private String fname,lname,address,departmentt;
    
    
    public student(int id ,String fname, String lname, String address, String departmentt) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.departmentt = departmentt;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentt() {
        return departmentt;
    }

    public void setDepartmentt(String departmentt) {
        this.departmentt = departmentt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
}
