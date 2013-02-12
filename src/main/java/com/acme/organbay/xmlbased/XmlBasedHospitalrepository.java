package com.acme.organbay.xmlbased;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.organbay.Hospital;
import com.acme.organbay.HospitalRepository;

@Component
@Qualifier("xml")
public class XmlBasedHospitalrepository implements HospitalRepository {

    private List<Hospital> hospitals;
    
    @Autowired
    public XmlBasedHospitalrepository(List<Hospital> hospitals) {
        super();
        this.hospitals = hospitals;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

}
