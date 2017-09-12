package com.indiez.test.util;

import java.text.SimpleDateFormat;

import com.indiez.test.entity.TaskInfoEntity;
import com.indiez.test.response.TaskInfoResponse;

public class TaskInfoResponseUtil {

	public static TaskInfoResponse getTaskInfoResponse(TaskInfoEntity entity) {
		TaskInfoResponse task = new TaskInfoResponse();
		task.setId(entity.getId());
		task.setName(entity.getName());
		task.setDescription(entity.getDescription());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		task.setEnddate(format.format(entity.getEndDate()));
		task.setCreateby(entity.getCreatedBy());
		task.setCreatedon(format.format(entity.getCrtTs()));
		return task;
	}
}
