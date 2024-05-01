package com.votre.service;

import com.votre.queryvo.Application;
import com.votre.queryvo.ApplicationAndResume;

import java.util.List;

public interface ApplicationService {
    Integer checkByUerIdAndJobIdAndRecruiterId(Integer userId, String jobId, Integer recruiterId);

    Integer addApplication(Application application);

    Integer deletePositionById(int id);

    List<ApplicationAndResume> getApplicationAndResume(Integer recruiterId);

    Integer setResumeStatus(Integer id, int i);

    Integer getApplicationIdByJobId(Integer id);
}
