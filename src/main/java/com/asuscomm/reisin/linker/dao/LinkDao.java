package com.asuscomm.reisin.linker.dao;

import com.asuscomm.reisin.linker.model.Link;

import java.util.List;

public interface LinkDao {
    int save(Link link);

    Link get(int id);

    List<Link> list();

    void update(int id, Link link);

    void delete(int id);
}
