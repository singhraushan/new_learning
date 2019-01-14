
package com.rakuten.fullstackrecruitmenttest.dto;

import java.util.List;

/**
 * @author Raushan kumar
 *
 */
public class ResponseDto {

	private List<String> error;
	private String status;

	public ResponseDto(String status) {
		this.status = status;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
