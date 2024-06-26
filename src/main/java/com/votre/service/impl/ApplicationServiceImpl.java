package com.votre.service.impl;

import com.votre.dao.ApplicationDao;
import com.votre.queryvo.Application;
import com.votre.queryvo.ApplicationAndResume;
import com.votre.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationDao applicationDao;
    @Override
    public Integer checkByUerIdAndJobIdAndRecruiterId(Integer userId, String jobId, Integer recruiterId) {
        return applicationDao.checkByUerIdAndJobIdAndRecruiterId(userId,jobId,recruiterId);
    }

    @Override
    public Integer addApplication(Application application) {
        application.setStatus(1);
        application.setCreatetime(new Date());
        return applicationDao.addApplication(application);
    }

    @Override
    public Integer deletePositionById(int id) {
        return applicationDao.deletePositionById(id);
    }

    @Override
    public List<ApplicationAndResume> getApplicationAndResume(Integer recruiterId) {
        return applicationDao.getApplicationAndResume(recruiterId);
    }

    @Override
    public Integer setResumeStatus(Integer id, int i) {
        return applicationDao.setResumeStatus(id,i);
    }

    @Override
    public Integer getApplicationIdByJobId(Integer id) {
        return applicationDao.getApplicationIdByJobId(id);
    }
}
