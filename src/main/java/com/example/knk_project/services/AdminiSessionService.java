package com.example.knk_project.services;

import com.example.knk_project.models.Admini;
import com.example.knk_project.services.interfaces.SessionInterface;

public class AdminiSessionService implements SessionInterface {
    private static AdminiSessionService instance;

    private Admini admin;


    private AdminiSessionService(Admini admin) {
        this.admin = admin;
    }

    public static AdminiSessionService getInstace(Admini admin) {
        if(instance == null) {
            instance = new AdminiSessionService(admin);
        }
        return instance;
    }

    @Override
    public void cleanUserSession() {
        instance = null;
        admin = null;
    }

    public Admini getAdmin(){
        return this.admin;
    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "userName='" + userName + '\'' +
//                ", privileges=" + privileges +
//                '}';
//    }
}
