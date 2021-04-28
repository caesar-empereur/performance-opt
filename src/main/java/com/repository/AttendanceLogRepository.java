package com.repository;

import com.model.AttendanceLog;
import com.view.AttendanceLogCheckView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Repository
public interface AttendanceLogRepository extends JpaRepository<AttendanceLog, Long> {

    @Query(value = "SELECT aa.id,aa.checkin_photo,aa.checkin_status,aa.checkin_time,aa.checkout_photo,aa.checkout_status,aa.checkout_time,"
                   + " aa.CODE,aa.date,aa.schedule_id,ac.clear_hour,ac.early_hour,ac.late_hour,ac.total_hour "
                   + " FROM (SELECT * FROM t_attendance_log_2000w "
                   + " WHERE id IN ( SELECT id FROM ( SELECT id FROM t_attendance_log_2000w WHERE id BETWEEN ?1 AND ?2 ORDER BY id DESC ) tt )) aa "
                   + " JOIN t_attendance_check_2000w ac ON ac.`code` = aa.CODE AND ac.date = aa.date", nativeQuery = true)
    List<Map<String, Object>> queryList(Long start, Long end);

    @Query(value = "SELECT aa.id,aa.checkin_photo,aa.checkin_status,aa.checkin_time,aa.checkout_photo,aa.checkout_status,aa.checkout_time,\n"
                   + "aa.CODE,aa.date,aa.schedule_id,ac.clear_hour,ac.early_hour,ac.late_hour,ac.total_hour \n"
                   + "FROM (SELECT * FROM t_attendance_log_2000w \n"
                   + "WHERE id IN ( SELECT id FROM ( SELECT id FROM t_attendance_log_2000w WHERE date=?1 and code=?2) tt )) "
                   + "aa JOIN t_attendance_check_2000w ac ON ac.`code` = aa.CODE AND ac.date = aa.date", nativeQuery = true)
    Map<String, Object> queryOne(LocalDate date, String code);

    @Query(value = "select max(id) from t_attendance_log_2000w", nativeQuery = true)
    Long countTotal();
}
