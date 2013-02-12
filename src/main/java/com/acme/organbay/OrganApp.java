package com.acme.organbay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrganApp {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/*.xml");
        OrganRepository organRepository = ctx.getBean(OrganRepository.class);
        
        
        String[] hospitals = ctx.getBeanNamesForType(Hospital.class);
        for (String next : hospitals) {
            System.out.println("next Hospital: " + ctx.getBean(next));
        }
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String organ = "";
        while (! "quit".equalsIgnoreCase(organ)){
            System.out.println("organ: ");
            organ = reader.readLine();
            Organ foundOrgan = organRepository.findOrganByName(organ);
            if (foundOrgan == null) {
                System.out.println("Organ not found ...");
            } else {
                System.out.println("Organ found: " + foundOrgan);
            }
        }

    }

}
