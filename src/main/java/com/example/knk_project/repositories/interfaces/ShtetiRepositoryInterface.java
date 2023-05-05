package com.example.knk_project.repositories.interfaces;

import java.sql.SQLException;

public interface ShtetiRepositoryInterface {
    void insert(CreateShtetiDto createShtetiDto) throws SQLException;
}
