package com.feja.blog.model;

public class Type {
    private Integer typeId;

    private String type;

    
    public Type(){
    	
    }
    
    public Type(int typeId, String typeString){
    	this.typeId = typeId;
    	this.type = typeString;
    }
    
    
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}