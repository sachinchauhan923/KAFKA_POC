package com.demo.kafkademo.beans;

public class Customar {
	private int id;
	private String email;
	private String contractNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@Override
	public String toString() {
		return "Customar [id=" + id + ", email=" + email + ", contractNo=" + contractNo + "]";
	}
	
	
	

}
