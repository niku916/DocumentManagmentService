package com.dms.ServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dms.Dto.DmsDocument;
import com.dms.Dto.DmsRequest;
import com.dms.Dto.Response.DmsResonseDto;
import com.dms.Service.DmsService;
import com.dms.Utility.DmsUploadUtil;
import com.np.dms.client.DmsRestClient;
import com.np.dms.dto.RequestDataDto;
import com.np.dms.dto.ResponseDto;

@Service
public class DmsServiceImpl implements DmsService {

	private static final Logger logger = LogManager.getLogger(DmsServiceImpl.class);

	private final DmsUploadUtil dmsUploadUtil;

	public DmsServiceImpl(DmsUploadUtil dmsUploadUtil) {
		this.dmsUploadUtil = dmsUploadUtil;
	}

	@Override
	public DmsResonseDto getListOfDocument(String dmsRequest) {

		// Convert JSON string to object
		DmsRequest request = dmsUploadUtil.readJsonRequest(dmsRequest);
		logger.info("Parsed DMS request: {}", request);

		try {
			// Initialize DmsRestClient
			String baseUrl = "https://staging.parivahan.gov.in/dms-app"; // confirm this with DMS team
			String apiMethod = "common-app"; // endpoint or method name
			String className = "VtDocuments"; // typically the class used for signing

			DmsRestClient client = new DmsRestClient(baseUrl, apiMethod, className);

			// Call the DMS API
			ResponseDto responseDto = client.invokeGetVtDocAPI(vahanCitizenConf(dmsRequest));
			logger.info("Received response from DMS: {}", responseDto);

			if (responseDto != null) {
				DmsDocument dmsDocument = dmsUploadUtil.fillaldetails(responseDto);
				dmsDocument.setApplno(dmsRequest.getApplNo());
				return dmsDocument;
			}
			// …map other fields

			return listOfDocument;

		} catch (Exception ex) {
			logger.error("Error while calling DMS service", ex);
			throw new RuntimeException("DMS call failed: " + ex.getMessage(), ex);
		}
	}
}
