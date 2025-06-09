package org.fj.minhaapi;


import org.fj.minhaapi.controller.ClientesController;
import org.fj.minhaapi.controller.RacaController;
import org.fj.minhaapi.controller.UserController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ClientesController.class);
        classes.add(UserController.class);
        classes.add(RacaController.class);
        return classes;
    }
}