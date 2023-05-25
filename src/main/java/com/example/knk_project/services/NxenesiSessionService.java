package com.example.knk_project.services;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.services.interfaces.SessionInterface;

public class NxenesiSessionService implements SessionInterface {
    private static NxenesiSessionService instance;

    private Nxenesi nxenesi;


    private NxenesiSessionService(Nxenesi nxenesi) {
        this.nxenesi = nxenesi;
    }

    public static NxenesiSessionService getInstace(Nxenesi nxenesi) {
        if(instance == null) {
            instance = new NxenesiSessionService(nxenesi);
        }
        return instance;
    }

    @Override
    public void cleanUserSession() {
        instance = null;
        nxenesi = null;
    }

    public Nxenesi getAdmin(){
        return this.nxenesi;
    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "userName='" + userName + '\'' +
//                ", privileges=" + privileges +
//                '}';
//    }
}

