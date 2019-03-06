package com.cts.nw.onboarding.bo;

public class ProjectMapping {

/*	CREATE TABLE projectmapping (
		    id int not null auto_increment,
		    projectid int not null,
		    processorid int not null,
		    requesterid int not null,
		    status varchar(20) default 'active',
		    primary key (id),
		    foreign key (projectid)
		        references projectinfo (projectid),
		    foreign key (processorid)
		        references processors (processorid),
		    foreign key (requesterid)
		        references requesters (requesterid)
		);*/
	
	
	private Integer id;
	private Integer projectID ;
	private Integer processorID;
	private Integer requesterID ;
	private String status ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectID() {
		return projectID;
	}
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	public Integer getProcessorID() {
		return processorID;
	}
	public void setProcessorID(Integer processorID) {
		this.processorID = processorID;
	}
	public Integer getRequesterID() {
		return requesterID;
	}
	public void setRequesterID(Integer requesterID) {
		this.requesterID = requesterID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProjectMapping [id=" + id + ", projectID=" + projectID + ", processorID=" + processorID
				+ ", requesterID=" + requesterID + ", status=" + status + "]";
	}
	
	
    
}
