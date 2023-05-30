package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.NxenesiDashboardTableView;

import java.sql.SQLException;
import java.util.List;

public interface NxenesiDashboardServiceInterface {
    List<NxenesiDashboardTableView> getNxenesiDashboardTableView(int studentiID) throws SQLException;
    List<NxenesiDashboardTableView> filterNotatByValue(int gradeValue) throws SQLException;
    List<NxenesiDashboardTableView> filterNotatBySubject(String subjectName) throws SQLException;

    List<NxenesiDashboardTableView> filterNotatByGradeAndBySubject(int gradeValue, String subjectName) throws SQLException;


}
