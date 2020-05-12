package com.app.staycomida.admin.func;

public class AdminCommonCode {
	private Integer successCode = 200; // 성공 코드
	private Integer noDataCode = 101; // 데이터 없음 코드
	private Integer validationCode = 100; // 폼 검증 실패 코드
	
	public Integer getSuccessCode() {
		return this.successCode;
	}
	
	public Integer getNoDataCode() {
		return this.noDataCode;
	}
	
	public Integer getValidationCode() {
		return this.validationCode;
	}
}
