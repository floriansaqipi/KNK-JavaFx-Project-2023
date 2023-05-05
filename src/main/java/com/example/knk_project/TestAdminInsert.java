package com.example.knk_project;

import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.repositories.AdminiRepository;
import com.example.knk_project.services.PasswordHasher;

import java.sql.SQLException;

public class TestAdminInsert {
    public static void main(String[] args) throws SQLException {
        AdminiRepository adminiRepository = new AdminiRepository();
        String salt = PasswordHasher.generateSalt();
        CreateAdminiDto createAdminiDto = new CreateAdminiDto(
                "gentriti851",
                salt,
                PasswordHasher.generateSaltedHash("test123",salt));
        adminiRepository.insert(createAdminiDto);
    }
}
