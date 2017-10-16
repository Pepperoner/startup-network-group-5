package ua.goit.java.startup.domainservice;

import ua.goit.java.startup.bom.Developer;
import ua.goit.java.startup.bom.Startup;

import java.util.Collection;
import java.util.Set;

/*
a main methods for Startup's side
 */
public interface StartupService extends DataService<Startup> {
    Startup findByName(String name);
    void removeByName(String name);
    public Collection<Developer> getStartupsDevelopers(long id);
    Set<Startup> findStartupsByKeyWord(String key);
}