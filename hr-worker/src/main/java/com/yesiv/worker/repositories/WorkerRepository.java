package com.yesiv.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yesiv.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
