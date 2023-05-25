package com.example.knk_project.services;

import com.example.knk_project.models.Admini;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.services.interfaces.SessionInterface;

public class ProfesoriSessionService implements SessionInterface {
    private static ProfesoriSessionService instance;

    private Profesori profesori;


    private ProfesoriSessionService(Profesori profesori) {
        this.profesori = profesori;
    }

    public static ProfesoriSessionService getInstace(Profesori profesori) {
        if(instance == null) {
            instance = new ProfesoriSessionService(profesori);
        }
        return instance;
    }

    @Override
    public void cleanUserSession() {
        instance = null;
        profesori = null;
    }

    public Profesori getAdmin(){
        return this.profesori;
    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "userName='" + userName + '\'' +
//                ", privileges=" + privileges +
//                '}';
//    }
}