package com.example.demo.service;

import com.example.demo.repository.BaseRepository;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

    /**
     * 設定儲藏庫
     *
     * @param repository 儲藏庫
     */
    void setRepository(BaseRepository<T, ID> repository);

}
