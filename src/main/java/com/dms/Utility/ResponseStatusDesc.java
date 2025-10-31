package com.dms.Utility;

public enum ResponseStatusDesc {
    SUCCESS("Success"),
    INFORMATION("Information"),
    ERROR("Error"),
    WARNING("Warning"),
    EXCEPTION("Exception"),
    CONFIRM("Confirm"),
    FILE("File");

    private final String value;

    
    private ResponseStatusDesc(String value) {
        this.value = value;
    }

    
    public String getValue() {
        return value;
    }
}
