package com.example.knk_project.services.interfaces;

import java.sql.SQLException;

public interface SignUpNxenesiServiceInterface {
    public void signUp(String username, String password) throws SQLException;
}
