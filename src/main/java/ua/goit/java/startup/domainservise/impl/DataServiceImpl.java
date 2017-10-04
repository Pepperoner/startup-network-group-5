package ua.goit.java.startup.domainservise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.goit.java.startup.bom.Model;
import ua.goit.java.startup.dao.DataRepository;
import ua.goit.java.startup.domainservise.DataService;
import ua.goit.java.startup.dto.ModelDTO;
import ua.goit.java.startup.translator.DataTranslator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
        T modelDto = translator.toDto(model);
        repository.save(modelDto);
        return this.add(model);
    }

    @Override
    public Collection<V> updateAll(Collection<V> collection) {
        return null;
    }

    @Override
    public V get(long id) {
        T modelDto = repository.findOne(id);
        V model = translator.fromDto(modelDto);
        return model;
    }

    @Override
    public Collection<V> getAll() {
        Set<T> modelDto = (Set<T>) repository.findAll();
        Set<V> model = new HashSet<V>();
        model.addAll(translator.getListFromDto(modelDto));
        return model;
    }

    @Override
    public void remove(long id) {
        V model = this.get(id);
        T modelDto = translator.toDto(model);
        repository.delete(modelDto);
    }

    @Override
    public void remove(V model) {
        T modelDto = translator.toDto(model);
        repository.delete(modelDto);
    }

    @Override
    public void remove(Collection<V> collection) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public boolean exist(long id) {
        V model = this.get(id);
        T modelDto = translator.toDto(model);
        return repository.exists(modelDto.getId());
    }

    @Override
    public boolean exist(V model) {
        return this.exist(model.getId());
    }
}
