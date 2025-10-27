package com.dms.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.Request.Dto.DmsRequestDto;
import com.dms.Response.Dto.DmsResponseDto;
import com.dms.Service.DmsService;
import com.dms.Util.CommonConstant;
import com.dms.Util.DmsDocumentUpload;
import com.dms.Util.DmsUploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DmsServiceImpl implements DmsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DmsServiceImpl.class);
	@Autowired
	private ObjectMapper mapper;

	@Override
	public DmsResponseDto getListOfDocument(String dmsRequestParam) throws Exception {

		String data = dmsRequestParam.replace("%2b", "+");
		String jsonData = DmsUploadUtil.decrypt(data, CommonConstant.TOKEN);

		if (jsonData == null) {
			throw new IllegalArgumentException("Invalid encrypted data");
		}

		DmsRequestDto request = mapper.readValue(jsonData, DmsRequestDto.class);
		DmsDocumentUpload upload = new DmsDocumentUpload();
		upload.setDmsRequest(request);

		setupEsignUrl(request);
		ensureAuthType(request);

		// Fetch document details
		DmsDocument document = dmsUploadUtil.getListofDocToUploadOrUploaded(request);
		upload.setDmsDocument(document);

		handleDocumentLists(upload, request, document);
		handleDoubleSign(upload, request, document);
		prepareFlags(document);

		return upload;
	}

}
