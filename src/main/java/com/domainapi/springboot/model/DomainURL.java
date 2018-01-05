package com.domainapi.springboot.model;

public class DomainURL implements Comparable<DomainURL> {
	private String url;
	private int count;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public int compareTo(DomainURL o) {
		// TODO Auto-generated method stub
		return count - o.getCount();
	}
	
	
	

}
