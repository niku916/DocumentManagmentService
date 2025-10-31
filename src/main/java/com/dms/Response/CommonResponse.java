package com.dms.Response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse<T> {
	private String responseType;
	private T response;
	private HttpStatus responseCode;
	private boolean IsError;

}
