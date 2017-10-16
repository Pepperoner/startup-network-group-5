package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Startup;

import java.util.Collection;

public interface StartupService extends DataService<Startup> {
    Startup findByName(String name);
    void removeByName(String name);
    public Collection<Developer> getStartapsDevelopers(long id);
}

