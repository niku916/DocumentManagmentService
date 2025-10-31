package com.dms.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/*
@JsonPropertyOrder({
"cat_id",
"sub_cat_id",
"sub_cat_name"
})*/
public class SubcategoryMasterDataList {

@JsonProperty("cat_id")
private String catId;
@JsonProperty("sub_cat_id")
private String subCatId;
@JsonProperty("sub_cat_name")
private String subCatName;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("cat_id")
public String getCatId() {
return catId;
}

@JsonProperty("cat_id")
public void setCatId(String catId) {
this.catId = catId;
}

@JsonProperty("sub_cat_id")
public String getSubCatId() {
return subCatId;
}

@JsonProperty("sub_cat_id")
public void setSubCatId(String subCatId) {
this.subCatId = subCatId;
}

@JsonProperty("sub_cat_name")
public String getSubCatName() {
return subCatName;
}

@JsonProperty("sub_cat_name")
public void setSubCatName(String subCatName) {
this.subCatName = subCatName;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
