package com.example.knk_project.repositories.interfaces;

import java.sql.SQLException;

public interface KomunaRepositoryInterface {
    void insert(CreateKomunatDto createKomunatDto) throws SQLException;
}
