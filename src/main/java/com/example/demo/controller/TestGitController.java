package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGitController {
	@RequestMapping("/get/file") // rsp->capability type
	private ResponseEntity<?> trueUpUtility() throws Exception {
//		ResponseEntity<?> responseEntity = 
//		new ResponseEntity<>(
//			      ".git.roperties", HttpStatus.OK);
//		return responseEntity;

		File file = new File("C:\\Users\\aninmazu\\git\\trueup-utility-backend\\git.properties");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				// Content-Type
//	                .contentType(file.ge)
				// Contet-Length
				.contentLength(file.length()) //
				.body(resource);

	}

	@RequestMapping("/demo") // rsp->capability type
	private String getData() throws Exception {
		return "hello";
	}
}
