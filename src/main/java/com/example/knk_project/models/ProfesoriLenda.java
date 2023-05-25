package com.example.knk_project.models;

public class ProfesoriLenda {
   private int profesoriId;
   private int lendaId;
   public ProfesoriLenda(int profesoriId, int lendaId) {
      this.profesoriId = profesoriId;
      this.lendaId = lendaId;
   }

   public int getProfesoriId() {
      return profesoriId;
   }

   public int getLendaId() {
      return lendaId;
   }
}
