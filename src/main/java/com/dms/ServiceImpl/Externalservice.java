//package com.dms.ServiceImpl;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClientResponseException;
//
//import com.dms.Configuration.WebClientConfiguration.WebClientFactory;
//import com.dms.Dto.DmsRequest;
//import com.dms.Dto.Response.DmsResonseDto;
//
//@Service
//public class Externalservice {
//
//	private static final Logger logger = LogManager.getLogger(Externalservice.class);
//
//	@Autowired
//	private WebClientFactory webClientFactory;
//
////	public DmsResonseDto getListofDocToUploadOrUploaded(DmsRequest request) {
////
////		WebClient webClientForOtpServices = webClientFactory.createWebClientForgetListofDocToUploadOrUploaded();
////		return webClientForOtpServices.post().uri(uriBuilder -> uriBuilder.path("/{param1}").build(request)).retrieve()
////				.bodyToMono(DmsResonseDto.class).doOnError(WebClientResponseException.class, ex -> {
////					logger.error("Error response: " + ex.getResponseBodyAsString());
////				}).block();
////
////	}
//	
//	public DmsResonseDto getListofDocToUploadOrUploaded(DmsRequest request) {
//	    WebClient webClient = webClientFactory.createWebClientForgetListofDocToUploadOrUploaded();
//
//	    return webClient.post()
//	            .uri("https://staging.parivahan.gov.in/dms-app/new-regn-type") // or whatever endpoint path
//	            .bodyValue(request)     // send JSON body
//	            .retrieve()
//	            .bodyToMono(DmsResonseDto.class)
//	            .doOnError(WebClientResponseException.class, ex -> {
//	                logger.error("Error response: " + ex.getResponseBodyAsString());
//	            })
//	            .block();
//	}
//
//}
