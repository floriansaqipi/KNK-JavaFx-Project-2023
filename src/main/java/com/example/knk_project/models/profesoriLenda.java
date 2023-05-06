package com.example.knk_project.models;

public class profesoriLenda {
   private int profesoriId;
   private int lendaId;
   public profesoriLenda(int profesoriId, int lendaId) {
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
