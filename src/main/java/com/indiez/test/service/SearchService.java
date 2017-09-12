package com.indiez.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indiez.test.entity.TaskInfoEntity;
import com.indiez.test.repository.TaskInfoRepository;
import com.indiez.test.response.BaseResponse;
import com.indiez.test.response.MetadataResponse;
import com.indiez.test.response.TaskInfoResponse;
import com.indiez.test.util.TaskInfoResponseUtil;

@Service
public class SearchService {

	private TaskInfoRepository taskInfoRepo;

	public BaseResponse searchText(String title, String desc) {
		BaseResponse response = new BaseResponse();
		List<TaskInfoResponse> tasks = new ArrayList<TaskInfoResponse>();
		List<TaskInfoEntity> entities = taskInfoRepo
				.findByDescriptionStartingWithAndNameStartingWith(desc, title);
		for (TaskInfoEntity entity : entities) {
			tasks.add(TaskInfoResponseUtil.getTaskInfoResponse(entity));
		}
		MetadataResponse metadata = new MetadataResponse();
		metadata.setCount(tasks.size());
		response.setMetadata(metadata);
		response.setTasks(tasks);

		return response;

	}
}
