package com.example.knk_project.services;

import com.example.knk_project.models.NxenesiDashboardTableView;
import com.example.knk_project.repositories.NxenesiDashboardRepository;
import com.example.knk_project.repositories.interfaces.NxenesiDashboardRepositoryInterface;
import com.example.knk_project.services.interfaces.NxenesiDashboardServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class NxenesiDashboardService implements NxenesiDashboardServiceInterface {

    private NxenesiDashboardRepositoryInterface nxenesiDashboardRepository = new NxenesiDashboardRepository();
    @Override
    public List<NxenesiDashboardTableView> getNxenesiDashboardTableView(int studentiID) throws SQLException {
        return this.nxenesiDashboardRepository.getNxenesiDashboardTableView(studentiID);
    }

    @Override
    public List<NxenesiDashboardTableView> filterNotatByValue(int gradeValue) throws SQLException {
        return this.nxenesiDashboardRepository.filterNotatByValue(gradeValue);
    }

    @Override
    public List<NxenesiDashboardTableView> filterNotatBySubject(String subjectName) throws SQLException {
        return this.nxenesiDashboardRepository.filterNotatBySubject(subjectName);
    }

    @Override
    public List<NxenesiDashboardTableView> filterNotatByGradeAndBySubject(int gradeValue, String subjectName) throws SQLException {
        return this.nxenesiDashboardRepository.filterNotatByGradeAndBySubject(gradeValue, subjectName);
    }
}
