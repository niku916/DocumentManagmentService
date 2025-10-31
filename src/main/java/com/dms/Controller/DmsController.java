package com.dms.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dms.Dto.PreTransactionResponse;
import com.dms.Dto.Response.DmsResonseDto;
import com.dms.Response.CommonResponse;
import com.dms.Service.DmsService;
import com.dms.Utility.ResponseStatusDesc;

@RestController
@RequestMapping("/${api.domain}")
public class DmsController {
	private static final Logger logger = LogManager.getLogger(DmsController.class);
	@Autowired
	private DmsService dmsService;

	@GetMapping("/list-of-document")
	public ResponseEntity<CommonResponse<PreTransactionResponse>> getListOfData(@RequestParam String dmsRequest) {

		logger.info("Response prepared: {}", dmsRequest);

		DmsResonseDto listOfDocument = dmsService.getListOfDocument(dmsRequest);

		CommonResponse<PreTransactionResponse> response = new CommonResponse<>(ResponseStatusDesc.SUCCESS.getValue(),
				new PreTransactionResponse(listOfDocument), HttpStatus.OK, false);

		logger.info("Response prepared: {}", response);
		return ResponseEntity.ok(response);

	}

}
