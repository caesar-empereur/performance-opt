package com.repository;

import com.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/4/28.
 */
@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Transactional
    @Modifying
    @Query(value = "update t_storage set count = count - :count where sku_code='iphone 11 pro' and count > 0 ", nativeQuery = true)
    Integer descreaseCount(Long count);
}
