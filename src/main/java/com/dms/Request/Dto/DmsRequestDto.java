package com.dms.Request.Dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DmsRequestDto {

	private String dmsServiceUrl;
	private String stateCd;
	private String applNo;
	private String regnNo;
	private String purCd;
	private String ownerName;
	private Integer officeCd;
	private String serviceRgn;
	private Integer vhClassType;
	private String jKey;
	private String jSecurityKey;
	private String docOperationType;
	private boolean esignFlag;
	private Boolean mergeflag = false;
	private Boolean esignUserOptFlag;
	private Boolean dse = false;
	private Boolean dss = false;
	private Map<Integer, List<String>> purDoc = new HashMap<Integer, List<String>>();
	private Map<String, Boolean> docDoubleSignStatus = new HashMap<String, Boolean>();
	private String docType;
	// private TmEsign tmEsign = new TmEsign();
	private String clientReturnUrl;
	private String esignDetailUpdateApi;
	private String saveDoublesignPendUrl;
	private String moveDoublesignPendUrl;
	private Boolean popUpWin = false;
	private String buyerMobileNo;
	private String sellerMobileNo;
	private String pmtType;
	private String transType;
	private String portalCd;
	@JsonIgnore
	private String authType;

}
