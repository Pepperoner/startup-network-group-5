package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Developer;
/*
A main method for Developer's side
 */
public interface DeveloperService extends DataService<Developer> {
    Developer findByEmail(String email);
}