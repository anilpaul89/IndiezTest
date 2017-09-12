package com.indiez.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indiez.test.service.SearchService;

@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public void searchText(
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "description", required = false) String desc) {

		searchService.searchText(title, desc);

	}
}
