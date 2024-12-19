package com.fitjourney.back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitjourney.back_end.model.Metric;

public interface MetricRepository extends JpaRepository<Metric, Long> {

}
