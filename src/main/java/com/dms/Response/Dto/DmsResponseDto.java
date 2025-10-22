package com.dms.Response.Dto;

import lombok.Data;

@Data
public class DmsResponseDto {

	private Integer status;
	private String statusValue;
	private String message;
}
