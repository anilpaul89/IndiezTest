package com.indiez.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indiez.test.entity.TaskInfoEntity;

public interface TaskInfoRepository extends
		JpaRepository<TaskInfoEntity, Integer> {

	public List<TaskInfoEntity> findByCreatedByContaining(String createdBy);

	public List<TaskInfoEntity> findByEndDateBefore(Date endDate);

	public List<TaskInfoEntity> findByCrtTsAfter(Date startDate);

	public List<TaskInfoEntity> findByNameStartingWith(String name);

	public List<TaskInfoEntity> findByDescriptionStartingWith(String description);

	public List<TaskInfoEntity> findByDescriptionStartingWithAndNameStartingWith(
			String description, String name);
}
