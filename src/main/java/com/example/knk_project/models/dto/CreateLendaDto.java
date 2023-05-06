package com.example.knk_project.models.dto;

public class CreateLendaDto {

        private int id;
        private String emri;

        public CreateLendaDto(int id, String emri) {
            this.id = id;
            this.emri = emri;
        }

        public int getId() {
            return id;
        }

        public String getEmri() {
            return emri;
        }
    }


