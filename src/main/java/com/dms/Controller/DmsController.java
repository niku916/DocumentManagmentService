package com.dms.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.Response.Dto.CommonResponse;
import com.dms.Response.Dto.DmsResponse;
import com.dms.Response.Dto.DmsResponseDto;
import com.dms.Service.DmsService;
import com.dms.Util.ResponseStatusDesc;

@RestController
public class DmsController {
	private static final Logger logger = LogManager.getLogger(DmsController.class);
	@Autowired
	private DmsService dmsService;

	@PostMapping("/list-docs")
	public ResponseEntity<CommonResponse<DmsResponse>> getListOfDoc(@RequestParam(required = false) String dmsRequest) {

		if (dmsRequest == null || dmsRequest.trim().isEmpty()) {
			CommonResponse<DmsResponse> errorResponse = new CommonResponse<>(ResponseStatusDesc.ERROR.getValue(), null,
					HttpStatus.BAD_REQUEST, true);
			return ResponseEntity.badRequest().body(errorResponse);
		}

		DmsResponseDto listOfDocument = dmsService.getListOfDocument(dmsRequest);

		CommonResponse<DmsResponse> response = new CommonResponse<>(ResponseStatusDesc.SUCCESS.getValue(),
				new DmsResponse(listOfDocument), HttpStatus.OK, false);

		return ResponseEntity.ok(response);

	}

}
