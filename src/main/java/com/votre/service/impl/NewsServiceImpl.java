package com.votre.service.impl;

import com.votre.dao.NewsDao;
import com.votre.entity.News;
import com.votre.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Override
    public List<News> getallNews() {
        return newsDao.getallNews();
    }

    @Override
    public List<News> listNews() {
        return newsDao.listNews();
    }

    @Override
    public Integer addNews(News news) {
        news.setCreatetime(new Date());
        return newsDao.addNews(news);
    }

    @Override
    public int deleteNews(String ids) {
        List<Integer>del_ids=new ArrayList<>();
        String[] str_ids=ids.split("-");
        for (String string:str_ids){
            del_ids.add(Integer.parseInt(string));
        }

            return newsDao.deleteNews(del_ids);
    }

    @Override
    public int deleteNew(Integer id) {
        return newsDao.deleteNew(id);
    }

    @Override
    public News getNewsById(Integer id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public int editNews(News news) {
        news.setCreatetime(new Date());
        return newsDao.editNews(news);
    }
}
