package com.bukeetcakir.restaurantService.service;

import com.bukeetcakir.restaurantService.entity.BaseEntity;
import com.bukeetcakir.restaurantService.exceptions.ItemNotFoundException;
import com.bukeetcakir.restaurantService.general.BaseAdditionalFields;
import com.bukeetcakir.restaurantService.general.GeneralErrorMessage;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Getter
public abstract class BaseEntityService <E extends BaseEntity, R extends JpaRepository<E,Long>> {
    R repository;
    protected BaseEntityService(R repository) {
        this.repository = repository;
    }
    public E save(E entity){
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
        }

        LocalDateTime now = LocalDateTime.now();
        if (entity.getId() == null) {
            baseAdditionalFields.setCreateDate(now);
        }
        baseAdditionalFields.setUpdateDate(now);
        entity.setBaseAdditionalFields(baseAdditionalFields);
        entity = repository.save(entity);
        return entity;
    }
    public E findById(Long id){
        Optional<E> optionalE = repository.findById(id);
        E entity;
        if (optionalE.isPresent()) {
            entity = optionalE.get();
        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }
    public List<E> findAll(){
        return repository.findAll();
    }
    public void delete(E entity){
        repository.delete(entity);
    }

}
