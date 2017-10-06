package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Startup;

public interface StartupService extends DataService<Startup> {
    Startup findByName(String name);

    void removeByName(String name);
}
