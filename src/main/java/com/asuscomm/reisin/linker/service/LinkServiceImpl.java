package com.asuscomm.reisin.linker.service;

import com.asuscomm.reisin.linker.dao.LinkDao;
import com.asuscomm.reisin.linker.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkDao linkDao;

    @Transactional
    public int save(Link link) {
        return linkDao.save(link);
    }

    public Link get(int id) {
        return linkDao.get(id);
    }

    public List<Link> list() {
        return linkDao.list();
    }

    @Transactional
    public void update(int id, Link link) {
        linkDao.update(id, link);
    }

    @Override
    public void delete(int id) {
        linkDao.delete(id);
    }
}
