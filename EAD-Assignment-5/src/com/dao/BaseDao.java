package com.dao;

import java.util.List;

public interface BaseDao<Object> {

    public List<Object> getAll();

    public void create(Object entity);
    
    public void update(Object t);

}

