package com.booksystem.entity;

import java.util.Date;

public class Port {
    private int port_id;
    private int portsenderid;
    private String port_content;
    private Date port_time;
    
	public int getPort_id() {
		return port_id;
	}
	public void setPort_id(int port_id) {
		this.port_id = port_id;
	}
	public int getPortsenderid() {
		return portsenderid;
	}
	public void setPortsenderid(int portsenderid) {
		this.portsenderid = portsenderid;
	}
	public String getPort_content() {
		return port_content;
	}
	public void setPort_content(String port_content) {
		this.port_content = port_content;
	}
	public Date getPort_time() {
		return port_time;
	}
	public void setPort_time(Date port_time) {
		this.port_time = port_time;
	}
	@Override
	public String toString() {
		return "Port [port_id=" + port_id + ", portsenderid=" + portsenderid + ", port_content=" + port_content
				+ ", port_time=" + port_time + "]";
	}
		
}
