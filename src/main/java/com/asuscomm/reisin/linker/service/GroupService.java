package com.asuscomm.reisin.linker.service;

import com.asuscomm.reisin.linker.model.Group;

import java.util.List;

public interface GroupService {
    int save(Group group);

    Group get(int id);

    List<Group> list();

    void update(int id, Group group);

    void delete(int id);
}
