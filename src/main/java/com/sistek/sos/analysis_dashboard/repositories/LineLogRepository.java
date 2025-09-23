package com.sistek.sos.analysis_dashboard.repositories;

import com.sistek.sos.analysis_dashboard.entities.LineLog;
import com.sistek.sos.analysis_dashboard.entities.keys.LineLogId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineLogRepository extends JpaRepository<LineLog, LineLogId> {
    List<LineLog> findAllByOrderByProcDateDesc();

    long countByStatusIgnoreCase(String status);

    List<LineLog> findTop10ByOrderByProcDateDesc();

}
