package com.cq.web.service.admin;

import com.cq.web.entity.BaseEntity;
import com.cq.web.repository.BaseRepository;
import com.cq.web.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Celine on 17/09/2017.
 */
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {

    public abstract BaseRepository<T, ID> getBaseRespository();

    @Override
    public T find(ID id) {
        return getBaseRespository().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getBaseRespository().findAll();
    }

    @Override
    public List<T> findList(ID[] ids) {
        List<ID> idList = Arrays.asList(ids);
        return getBaseRespository().findAll(idList);
    }

    @Override
    public List<T> findList(Specification<T> spec, Sort sort) {
        return getBaseRespository().findAll(spec, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseRespository().findAll(pageable);
    }

    @Override
    public long count() {
        return getBaseRespository().count();
    }

    @Override
    public long count(Specification<T> spec) {
        return getBaseRespository().count(spec);
    }

    @Override
    public boolean exists(ID id) {
        return getBaseRespository().exists(id);
    }

    @Override
    public void save(T entity) {
        getBaseRespository().save(entity);
    }

    public void save(Iterable<T> entitys) {
        getBaseRespository().save(entitys);
    }

    @Override
    public T update(T entity) {
        return getBaseRespository().saveAndFlush(entity);
    }

    @Override
    public void delete(ID id) {
        getBaseRespository().delete(id);
    }

    @Override
    public void deleteByIds(@SuppressWarnings("unchecked") ID... ids) {
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                ID id = ids[i];
                this.delete(id);
            }
        }
    }

    @Override
    public void delete(T[] entitys) {
        List<T> tList = Arrays.asList(entitys);
        getBaseRespository().delete(tList);
    }

    @Override
    public void delete(Iterable<T> entitys) {
        getBaseRespository().delete(entitys);
    }

    @Override
    public void delete(T entity) {
        getBaseRespository().delete(entity);
    }

    @Override
    public List<T> findList(Iterable<ID> ids) {
        return getBaseRespository().findAll(ids);
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        // TODO Auto-generated method stub
        return getBaseRespository().findAll(spec, pageable);
    }


}
