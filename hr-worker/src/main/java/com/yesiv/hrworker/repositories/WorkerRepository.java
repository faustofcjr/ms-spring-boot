package com.yesiv.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yesiv.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
