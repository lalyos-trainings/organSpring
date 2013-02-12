package com.acme.organbay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;

public class Hospital implements Ordered {
    
    private final Address address;
    private final String name;
    
    private List<Organ> organs = new ArrayList<Organ>();
    
    public Hospital(Address address, String name) {
        this.address = address;
        this.name = name;
    }
    
    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public List<Organ> getOrgans() {
        return organs;
    }

    public void setOrgans(List<Organ> organs) {
        this.organs = organs;
    }

    @Override
    public String toString() {
        return "Hospital [address=" + address + ", name=" + name + "]";
    }

    public int getOrder() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
