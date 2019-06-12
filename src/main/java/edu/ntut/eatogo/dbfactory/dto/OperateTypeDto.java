package edu.ntut.eatogo.dbfactory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperateTypeDto implements Serializable {

    private static final long serialVersionUID = 3585198316376895409L;
    private Integer operateTypeId;
    private String operateType;
    private String operateTypeDescription;

    public Integer getOperateTypeId() {
        return operateTypeId;
    }

    public void setOperateTypeId(Integer operateTypeId) {
        this.operateTypeId = operateTypeId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateTypeDescription() {
        return operateTypeDescription;
    }

    public void setOperateTypeDescription(String operateTypeDescription) {
        this.operateTypeDescription = operateTypeDescription;
    }
}
