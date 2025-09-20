package com.sistek.sos.analysis_dashboard.repositories;

import com.sistek.sos.analysis_dashboard.entities.PlcInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // its the repo interface
public interface PlcInfoRepository extends JpaRepository<PlcInfo, String> { // extends to built in interface
    // Additional query methods can be defined here if needed
    // you can use save(entity), findById(id), findAll(), deleteById(id), delete(entitiy), count() without adding an additional method
}