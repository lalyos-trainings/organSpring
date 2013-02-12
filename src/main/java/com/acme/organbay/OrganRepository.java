package com.acme.organbay;

import java.util.List;

public interface OrganRepository {

    public List<Organ> getAllOrgans();

    public Organ findOrganByName(String name);

}