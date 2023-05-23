package com.example.knk_project.models.dto;

public class CreateLendaDto {
        private String emri;

        public CreateLendaDto(int id, String emri) {
            this.emri = emri;
        }

        public String getEmri() {
            return emri;
        }
    }


