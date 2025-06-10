package org.fj.minhaapi;


import org.fj.minhaapi.rest.*;
import org.fj.minhaapi.rest.filter.LogFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ClientesRest.class);
        classes.add(UserRest.class);
        classes.add(RacaRest.class);
        classes.add(EnderecoRest.class);
        classes.add(AtendimentoRest.class);
        classes.add(PetRest.class);
        classes.add(JacksonConfig.class);
        classes.add(LogFilter.class);
        return classes;
    }
}