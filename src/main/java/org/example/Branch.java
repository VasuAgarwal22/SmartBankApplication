package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Branch {

    @Id
    private int branchId;
    private String BranchName;
    private String IFSCCODE;
    private String Address;

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public int getBranchId() {
        return branchId;
    }
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public String getBranchName() {
        return BranchName;
    }
    public void setBranchName(String branchName) {
        BranchName = branchName;
    }
    public String getIFSCCODE() {
        return IFSCCODE;
    }
    public void setIFSCCODE(String IFSCCODE) {
        this.IFSCCODE = IFSCCODE;
    }
    @Override
    public String toString() {
        return "Branch{" +
                "Address='" + Address + '\'' +
                ", branchId=" + branchId +
                ", BranchName='" + BranchName + '\'' +
                ", IFSCCODE='" + IFSCCODE + '\'' +
                '}';
    }
}
