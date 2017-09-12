package com.indiez.test.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_EMPTY)
public class BaseResponse {

	@JsonProperty
	private MetadataResponse metadata;
	
	@JsonProperty
	private ErrorDescription error;

	@JsonProperty
	private List<TaskInfoResponse> tasks;

	@JsonProperty
	private TaskInfoResponse task;

	public MetadataResponse getMetadata() {
		return metadata;
	}

	public void setMetadata(MetadataResponse metadata) {
		this.metadata = metadata;
	}

	public List<TaskInfoResponse> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskInfoResponse> tasks) {
		this.tasks = tasks;
	}

	public TaskInfoResponse getTask() {
		return task;
	}

	public void setTask(TaskInfoResponse task) {
		this.task = task;
	}

	public ErrorDescription getError() {
		return error;
	}

	public void setError(ErrorDescription error) {
		this.error = error;
	}

}
