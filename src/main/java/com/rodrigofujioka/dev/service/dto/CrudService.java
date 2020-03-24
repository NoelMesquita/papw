package com.rodrigofujioka.dev.service.dto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService<T> {

    public T salvar(T t);
    public T atualizar(T t);
    public List<T> getQuarentena();
    public T getQuarentenaById(Long id);
    public void deleteById(Long id);

}
