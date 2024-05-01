package com.votre.service;

import com.votre.entity.Resume;

public interface ResumeService {
    Resume getResumeByUserid(Integer userid);

    Integer  editResume(Resume resume);

    Integer addResume(Resume resume, Integer userid);
}
