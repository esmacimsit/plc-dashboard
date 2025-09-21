package com.sistek.sos.analysis_dashboard.repositories;

import com.sistek.sos.analysis_dashboard.entities.LineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineInfoRepository extends JpaRepository<LineInfo, String> {
    List<LineInfo> findAllByOrderByLineIdAsc(); // select * from line_info order by line_id asc;
}