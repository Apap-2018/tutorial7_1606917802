package com.apap.tutorial7.controller;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

@RestController
@RequestMapping("/model")
public class ModelController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@GetMapping()
	 private ResponseEntity<String> modelCar(@RequestParam("factory") String factory) throws Exception{
	  HttpHeaders headers = new HttpHeaders();
	  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  headers.add("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
	  HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	  int year = Calendar.getInstance().get(Calendar.YEAR);
	  String path = Setting.modelUrl +"/?cmd=getModels&make="+ factory+"&year="+year;
	  ResponseEntity<String> response = restTemplate.exchange(path,HttpMethod.GET, entity, String.class);
	  return response;
	 }

}
