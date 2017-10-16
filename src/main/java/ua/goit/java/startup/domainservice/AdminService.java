package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Admin;
/*
A main method for Admin's side
 */
public interface AdminService extends DataService<Admin>{
    Admin findByEmail(String email);
}