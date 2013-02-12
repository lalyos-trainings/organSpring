package com.acme.organbay.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.acme.organbay.Hospital;
import com.acme.organbay.HospitalRepository;
import com.acme.organbay.Organ;
import com.acme.organbay.OrganRepository;

@Component
public class InMemoryOrganRepository implements OrganRepository {

    private Map<String, Organ> organMap = new HashMap<String, Organ>();

    private HospitalRepository hospitalRepository;
    
    @Autowired
    public InMemoryOrganRepository(@Qualifier("inmemory") HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
        for (Hospital hospital : hospitalRepository.getHospitals()) {
            addOrgans(hospital.getOrgans());
        }
    }

    private void addOrgans(List<Organ> organs) {
        for (Organ organ : organs) {
            organMap.put(organ.getName(), organ);
        }
    }


    /* (non-Javadoc)
     * @see com.acme.organbay.OrganRepository#getAllOrgans()
     */
    public List<Organ> getAllOrgans() {
        return new ArrayList<Organ>(organMap.values());
    }
    
    /* (non-Javadoc)
     * @see com.acme.organbay.OrganRepository#findOrganByName(java.lang.String)
     */
    public Organ findOrganByName(String name) {
        return organMap.get(name);
    }
}
