package com.googlecode.lucene.osem.api;

import java.util.List;

import com.googlecode.lucene.osem.IndexManager;

public class IndexManagerImpl implements IndexManager {

    @Override
    public String getIndexName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void index(final Object... objects) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(final Object... objects) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean indexExist() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteIndex() {
        // TODO Auto-generated method stub

    }

    @Override
    public void optimize() {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> T getById(final Class<T> clazz, final String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> getByIds(final Class<T> clazz, final List<String> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Long count(final Class<T> clazz) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> search(final Class<T> clazz) {
        // TODO Auto-generated method stub
        return null;
    }

}
