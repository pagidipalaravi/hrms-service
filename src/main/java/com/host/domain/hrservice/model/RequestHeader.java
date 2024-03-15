package com.host.domain.hrservice.model;

public class RequestHeader {
	private String requestId;
	private String userId;
	private long timeStamp;
	private String  corelationId;
	
	public RequestHeader(String requestId, String userId, String corelationId) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.corelationId = corelationId;
		this.timeStamp = timeStamp;
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
	public String getCorelationId() {
		return corelationId;
	}
	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
