package com.dms.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
	public static final String PROP_PAYMENT_MODE = "vahanservice.payment.mode";
	public static final String PROP_KEY_MODE_ISTESTING = "istesting";
	public static final String PROP_KEY_MODE_ISLOCAL = "islocal";
	public static final String propertyFile = "Config.properties";
	public static Properties properties = new Properties();
	public String propPrefix;

	public static final String PROP_DMS_URL = "dms.urls";
	public static final String PROP_VDS_URL = "vds.urls";
	public static final String UPLOADED_FILE_PATH = "uploadedfilepath";
	public static final String STAGING_CONTEXT_PATH = "stagingcontextpath";
	public static final String LOCAL_CONTEXT_PATH = "localcontextpath";
	public static final String PROD_CONTEXT_PATH = "prodcontextpath";
	public static final String SMS_TEMPLATE_BUYER_ESIGN = "1007163273185568066";
	public static final String SMS_TEMPLATE_AFTER_BUYER_ESIGN = "1007163273181169576";
	public static final int PUR_DC = 3;
	public static final int PUR_COA = 4;
	public static final int PUR_TO = 5;
	public static final int PUR_HPA = 6;
	public static final int PUR_HPT = 7;
	public static final int PUR_HPC = 8;
	public static final String tOAuction = "2";
	public static final String tOSuccession = "3";
	public static final String OR_ESIGN_PASS = "12345678";
	public static final String DL_ESIGN_PASS = "changeit";
	public static final String JK_ESIGN_PASS = "123456";

	public ApplicationConfig(String propPrefix) {
		this.propPrefix = propPrefix;
	}

	static {
		InputStream inputStream = null;
		try {
			inputStream = ApplicationConfig.class.getResourceAsStream(propertyFile);
			if (!properties.isEmpty()) {
				properties.load(inputStream);
			}
		} catch (NullPointerException p) {
			LOGGER.error(p.getMessage());
		} catch (IOException io) {
			LOGGER.error(io.getMessage());
		} finally {
			if (inputStream != null) {
				safeClose(inputStream);
			}
		}
	}

	public String getProperties(String propName) {

		if (properties == null || properties.isEmpty()) {
			InputStream inputStream = null;
			try {
				inputStream = ApplicationConfig.class.getResourceAsStream(propertyFile);

				properties.load(inputStream);
			} catch (IOException io) {
				LOGGER.error(io.getMessage());
			} finally {
				if (inputStream != null) {
					safeClose(inputStream);
				}
			}
		}
		return properties.getProperty(propPrefix + "." + propName);
	}

	public static void safeClose(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException ioe) {
				// LOGGER.error(ioe.);
			}
		}
	}

}