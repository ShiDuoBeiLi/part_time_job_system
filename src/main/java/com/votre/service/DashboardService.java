package com.votre.service;

import com.votre.queryvo.Application;

import java.util.List;

public interface DashboardService {

    List<Application> getAllApplication(Integer id);

    List<Application> getPassApplication(Integer id);

    List<Application> getnoPassApplication(Integer id);

    List<Application> getCheckingApplication(Integer id);
}
