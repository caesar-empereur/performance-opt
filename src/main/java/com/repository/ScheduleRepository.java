package com.repository;

import com.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
