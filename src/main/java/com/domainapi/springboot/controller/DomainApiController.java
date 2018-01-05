package com.domainapi.springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domainapi.springboot.model.DomainURL;
import com.domainapi.springboot.service.DomainApiService;

@RestController
public class DomainApiController {

	@Autowired
	private DomainApiService domainApiService;

	@GetMapping("/domainApi")
	public List<String> retrieveDomainURL() {
		return domainApiService.retrievHighestDomain();
	}
	
	@GetMapping("/domainApi/{url}/count/{count}")
	public Map addDomainURL(@PathVariable String url,
			@PathVariable int count) {
		return domainApiService.addDomainUrlWithCount(url, count);
	}
	
	/*@PostMapping("/domainApi/{url}/count/{count}")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable String url, int count, @RequestBody DomainURL doamin) {

		domainApiService.addDomainUrlWithCount(url, count);
		
		if (doamin == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{url}").buildAndExpand(doamin.getUrl()).toUri();

		return ResponseEntity.created(location).build();
	}
*/	
}
