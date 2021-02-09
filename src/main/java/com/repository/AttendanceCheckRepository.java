package com.repository;

import com.model.AttendanceCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Repository
public interface AttendanceCheckRepository extends JpaRepository<AttendanceCheck, Long> {

//    @Query()
//    Page<Map<String, Object>> pageQuery(Pageable pageable);
}
