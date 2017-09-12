package com.indiez.test.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiez.test.entity.TaskInfoEntity;
import com.indiez.test.exception.ApiException;
import com.indiez.test.repository.TaskInfoRepository;
import com.indiez.test.request.TaskInfoReqest;
import com.indiez.test.response.BaseResponse;
import com.indiez.test.response.MetadataResponse;
import com.indiez.test.response.TaskInfoResponse;
import com.indiez.test.util.TaskInfoResponseUtil;

@Service
public class TaskService {

	@Autowired
	private TaskInfoRepository taskInfoRepo;

	public BaseResponse getAllTasks(String createdby, String endson,
			String startdate) throws ParseException {
		BaseResponse response = new BaseResponse();
		List<TaskInfoResponse> tasks = new ArrayList<TaskInfoResponse>();
		List<TaskInfoEntity> entities = null;
		if (StringUtils.isNotEmpty(createdby)) {
			entities = taskInfoRepo.findByCreatedByContaining(createdby);
		} else if (StringUtils.isNotEmpty(endson)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date endDate = format.parse(endson);
			entities = taskInfoRepo.findByEndDateBefore(endDate);
		} else if (StringUtils.isNotEmpty(startdate)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = format.parse(startdate);
			entities = taskInfoRepo.findByCrtTsAfter(startDate);
		} else {
			entities = taskInfoRepo.findAll();
		}

		for (TaskInfoEntity entity : entities) {
			tasks.add(TaskInfoResponseUtil.getTaskInfoResponse(entity));
		}
		// response.s
		MetadataResponse metadata = new MetadataResponse();
		metadata.setCount(tasks.size());
		response.setMetadata(metadata);
		response.setTasks(tasks);

		return response;
	}

	public BaseResponse getSpecifiedTask(Integer id) throws ApiException {
		BaseResponse response = new BaseResponse();
		TaskInfoEntity entity = taskInfoRepo.findOne(id);
		if (entity != null) {
			response.setTask(TaskInfoResponseUtil.getTaskInfoResponse(entity));
		} else {
			throw new ApiException("Id not found in the system");
		}
		return response;
	}

	public void deleteSpecifiedTask(Integer id) {
		taskInfoRepo.delete(id);
	}

	public BaseResponse addTask(TaskInfoReqest task) throws ApiException {
		BaseResponse response = new BaseResponse();
		TaskInfoEntity entity = new TaskInfoEntity();
		entity.setName(task.getName());
		entity.setCreatedBy(task.getCreatedby());
		entity.setDescription(task.getDescription());
		entity.setEndDate(task.getEndson());
		Calendar calendar = Calendar.getInstance();
		entity.setCrtTs(new Timestamp(calendar.getTimeInMillis()));
		entity = taskInfoRepo.save(entity);
		if (entity.getId() > 0) {
			response.setTask(TaskInfoResponseUtil.getTaskInfoResponse(entity));
		} else {
			throw new ApiException("Issue with persisting data");
		}
		return response;
	}

	public BaseResponse updateTask(TaskInfoReqest task, Integer id)
			throws ApiException {
		BaseResponse response = new BaseResponse();
		TaskInfoEntity entity = taskInfoRepo.findOne(id);
		if (entity != null) {
			entity.setName(task.getName());
			entity.setCreatedBy(task.getName());
			entity.setDescription(task.getDescription());
			entity.setEndDate(task.getEndson());
			entity = taskInfoRepo.save(entity);
		} else {
			throw new ApiException("Id not found in the system");
		}
		if (entity.getId() > 0) {
			response.setTask(TaskInfoResponseUtil.getTaskInfoResponse(entity));
		}
		return response;
	}

}
