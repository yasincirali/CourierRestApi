package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AttendanceLog;

@Repository
public interface AttendanceLogRepository extends JpaRepository<AttendanceLog,Long> {
	
	@Query(value="SELECT * FROM attendance_log where courierid=?1 and storeid=?2 order by insertdate desc fetch first 1 rows only", nativeQuery = true)
	AttendanceLog getRecordByCourierIdAndStoreId(long courierId,long storeId);
	
	@Query(value="SELECT * FROM attendance_log where courierid=?1 order by insertdate desc", nativeQuery = true)
	List<AttendanceLog> getLogsByCourierId(long courierId);
}
