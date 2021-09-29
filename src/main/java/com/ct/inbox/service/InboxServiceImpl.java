package com.ct.inbox.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.inbox.model.Staff;

@Service
public class InboxServiceImpl implements InboxService {
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<Staff> getAllPhysicians() {
		return Arrays.asList(restTemplate.getForObject("http://USER-SERVICE/employees/physicians", Staff[].class));
	}
}
