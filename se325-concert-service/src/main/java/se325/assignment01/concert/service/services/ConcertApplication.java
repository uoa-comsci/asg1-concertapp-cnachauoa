package se325.assignment01.concert.service.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import se325.assignment01.concert.service.util.ConcertUtils;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class ConcertApplication extends Application {

    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    public ConcertApplication() {
        classes.add(TestResource.class);
        classes.add(ConcertResource.class);
        singletons.add(PersistenceManager.instance());

        ConcertUtils.initConcerts();
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}
