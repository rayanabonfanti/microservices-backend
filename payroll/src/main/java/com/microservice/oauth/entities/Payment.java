package com.microservice.oauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Double dailyIncome;
	private Integer days;

}
