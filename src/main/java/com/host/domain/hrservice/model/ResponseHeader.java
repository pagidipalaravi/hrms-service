package com.host.domain.hrservice.model;

public class ResponseHeader {
	private String requestId;
	private String userId;
	private long timeStamp;
	private String  corelationId;
	private String statusCode;
	private String statusMsg;
	public ResponseHeader(String requestId, String userId, long timeStamp, String corelationId) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.corelationId = corelationId;
		
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getCorelationId() {
		return corelationId;
	}
	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	
}
