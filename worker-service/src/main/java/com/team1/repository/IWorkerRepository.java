package com.team1.repository;

import com.team1.repository.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IWorkerRepository extends JpaRepository<Worker, Long> {
    @Query("SELECT w.username, w.email, w.firstName, w.lastName, w.phone, w.address, " +
            "w.salary FROM Worker w where w.companyId = :companyId")
    List<Worker> workerInformation(@Param("companyId") Long companyId);
    List<Worker> findAllByCompanyId(Long companyId);

}
