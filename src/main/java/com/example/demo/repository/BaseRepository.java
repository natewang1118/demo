package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 透過指定屬性與值取得一筆資料
     *
     * @param propertyName 屬性名稱
     * @param value        屬性值
     * @return 單一Entity
     */
    T findOne(String propertyName, Object value);

    /**
     * 透過指定條件取得單筆資料
     *
     * @param conditions 條件，屬性名稱當key，屬性值當value
     * @return 單一Entity
     */
    T findOne(Map<String, Object> conditions);

    /**
     * 透過指定屬性與值取得所有符合的資料
     *
     * @return 符合的Entity List
     */
    List<T> findAll();

    /**
     * 透過指定屬性與值取得所有符合的資料
     *
     * @param propertyName 屬性名稱
     * @param value        屬性值
     * @return 符合的Entity List
     */
    List<T> findAll(String propertyName, Object value);

    /**
     * 取得所有符合條件的資料
     *
     * @param conditions 條件，屬性名稱當key，屬性值當value
     * @return 符合的Entity List
     */
    List<T> findAll(Map<String, Object> conditions);
}
