package com.indiez.test.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indiez.test.entity.TaskInfoEntity;
import com.indiez.test.exception.ApiException;
import com.indiez.test.request.TaskInfoReqest;
import com.indiez.test.response.BaseResponse;
import com.indiez.test.response.TaskInfoResponse;
import com.indiez.test.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<BaseResponse> getAllTask(
			@RequestParam(value = "enddate", required = false) String enddate,
			@RequestParam(value = "startdate", required = false) String startdate,
			@RequestParam(value = "createdby", required = false) String createdby)
			throws ParseException {
		BaseResponse response = taskService.getAllTasks(createdby, enddate,
				startdate);
		return sendResponse(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaseResponse> getTask(
			@PathVariable(required = true) Integer id) throws ApiException {
		BaseResponse response = taskService.getSpecifiedTask(id);
		return sendResponse(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BaseResponse> updateTask(
			@Valid @RequestBody TaskInfoReqest task,
			@PathVariable(required = true) Integer id) throws ApiException {
		BaseResponse response = taskService.updateTask(task, id);
		return sendResponse(response);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> addTask(
			@Valid @RequestBody TaskInfoReqest task) throws ApiException {
		BaseResponse response = taskService.addTask(task);
		return sendResponse(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable(required = true) Integer id) {
		taskService.deleteSpecifiedTask(id);
	}

	private ResponseEntity<BaseResponse> sendResponse(BaseResponse response) {
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
