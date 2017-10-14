package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Admin;

public interface AdminService extends DataService<Admin>{
    Admin findByEmail(String email);
}
