package com.asuscomm.reisin.linker.dao;

import com.asuscomm.reisin.linker.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GroupDao {
    int save(Group group);
    Group get(int id);
    List<Group> list();
    void update(Group group);
    void delete(int id);
}
