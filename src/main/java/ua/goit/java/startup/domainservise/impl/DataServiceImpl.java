package ua.goit.java.startup.domainservise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.domainservise.DataService;
import ua.goit.java.startup.dto.ModelDTO;
import ua.goit.java.startup.translator.DataTranslator;

import java.util.Collection;

public class DataServiceImpl<T extends ModelDTO, V extends Model> implements DataService<V> {


    @Autowired
    private DataRepository<T> repository;

    @Autowired
    private DataTranslator<T, V> translator;



    @Override
    public V add(V model) {

        T modelDto = translator.toDto(model);
        repository.save(modelDto);
        return model;
    }

    @Override
    public Collection<V> addAll(Collection<V> collection) {
        return null;
    }

    @Override
    public V update(V model) {
        return null;
    }

    @Override
    public Collection<V> updateAll(Collection<V> collection) {
        return null;
    }

    @Override
    public V get(long id) {
        return null;
    }

    @Override
    public Collection<V> getAll() {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void remove(V model) {

    }

    @Override
    public void remove(Collection<V> collection) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public boolean exist(long id) {
        return false;
    }

    @Override
    public boolean exist(V model) {
        return false;
    }
}
