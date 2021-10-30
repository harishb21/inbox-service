package com.ct.inbox.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.inbox.model.Staff;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InboxServiceImpl implements InboxService {
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<Staff> getAllPhysicians() {
		
		List<Staff> physicians = Arrays.asList(restTemplate.getForObject("http://USER-SERVICE/employees/physicians", Staff[].class));
		return physicians;
	}
}
