package com.sistek.sos.analysis_dashboard.repositories;

import com.sistek.sos.analysis_dashboard.entities.PlcLog;
import com.sistek.sos.analysis_dashboard.entities.keys.PlcLogId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlcLogRepository extends JpaRepository<PlcLog, PlcLogId> {
    List<PlcLog> findAllByOrderByProcDateDesc();
}
