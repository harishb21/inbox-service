package com.ct.inbox.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Role {
	private int roleId;
	private String roleName;
}
