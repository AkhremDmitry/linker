package com.asuscomm.reisin.linker.service;

import com.asuscomm.reisin.linker.dao.GroupDao;
import com.asuscomm.reisin.linker.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupDao groupDao;

    @Transactional
    public int save(Group group) {
        return groupDao.save(group);
    }

    public Group get(int id) {
        return groupDao.get(id);
    }

    public List<Group> list() {
        return groupDao.list();
    }

    @Transactional
    public void update(int id, Group group) {
        groupDao.update(id, group);
    }

    @Transactional
    public void delete(int id) {
        groupDao.delete(id);
    }

}
