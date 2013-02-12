package com.acme.organbay.inmemory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.organbay.Address;
import com.acme.organbay.Hospital;
import com.acme.organbay.HospitalRepository;
import com.acme.organbay.Organ;

@Component
@Qualifier("inmemory")
public class InMemoryHospitalRepository implements HospitalRepository {
    
    private List<Hospital> hospitals = new ArrayList<Hospital>();
    
    @PostConstruct
    public void init() {
        hospitals.add(getHospital1());
        hospitals.add(getHospital2());
        hospitals.add(getHospital3());
    }

    private Hospital getHospital3() {
        Hospital hospital = createHospitalInBudapest("Lipotmezo", "Lipotmezo vege", "1234");
        hospital.addOrgan(new Organ("brain", 999, "Balamber"));
        hospital.addOrgan(new Organ("Left Hand", 16000, "Dezso"));
        return hospital;
    }

    private Hospital getHospital2() {
        Hospital hospital = createHospitalInBudapest("Honved Korhaz", "Róbert Károly krt. 44", "1134");
        hospital.addOrgan(new Organ("prostata", 8000, "Jolan"));
        hospital.addOrgan(new Organ("hipotalamus", 23000, "Jolan"));
        return hospital;
    }

    private Hospital getHospital1() {
        Hospital hospital = createHospitalInBudapest("Laszlo Korhaz", "Gyáli ut 5-7", "1097");
        hospital.addOrgan(new Organ("heart", 55000, "Feri"));
        hospital.addOrgan(new Organ("lung", 32000, "Gyuri"));
        hospital.addOrgan(new Organ("liver", 4000, "Viktor"));
        return hospital;
    }
    
    private Hospital createHospitalInBudapest(String name, String street, String zip) {
        Address address = new Address(street, "Budapest", zip, "Hungary");
        Hospital ret = new Hospital(address, name);
        return ret;
    }

    /* (non-Javadoc)
     * @see com.acme.organbay.HospitalRepository#getHospitals()
     */
    public List<Hospital> getHospitals() {
        return hospitals;
    }


}
