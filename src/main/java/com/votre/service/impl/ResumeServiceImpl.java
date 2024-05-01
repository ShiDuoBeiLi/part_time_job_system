package com.votre.service.impl;

import com.votre.dao.ResumeDao;
import com.votre.entity.Resume;
import com.votre.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    ResumeDao resumeDao;
    @Override
    public Resume getResumeByUserid(Integer userid) {
        return resumeDao.getResumeByUserid(userid);
    }

    @Override
    public Integer editResume(Resume resume) {
        return resumeDao.editResume(resume);
    }

    @Override
    public Integer addResume(Resume resume, Integer userid) {
        return resumeDao.addResume(resume,userid);
    }
}
