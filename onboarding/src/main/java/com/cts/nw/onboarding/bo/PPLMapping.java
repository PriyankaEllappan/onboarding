package com.cts.nw.onboarding.bo;

public class PPLMapping {

	/*
	CREATE TABLE PPLMAPPING (
	    ID INT NOT NULL AUTO_INCREMENT,
	    BSAID INT NOT NULL,
	    PPLID INT NOT NULL,
	    PRIMARY KEY (ID),
	    FOREIGN KEY (BSAID)
	        REFERENCES BSAINFO (ID),
	    FOREIGN KEY (PPLID)
	        REFERENCES PPLINFO (ID)
	);
	*/
	private Integer id ;
    private Integer bsaID ;
    private Integer pplID ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBsaID() {
		return bsaID;
	}
	public void setBsaID(Integer bsaID) {
		this.bsaID = bsaID;
	}
	public Integer getPplID() {
		return pplID;
	}
	public void setPplID(Integer pplID) {
		this.pplID = pplID;
	}
	@Override
	public String toString() {
		return "PPLMapping [id=" + id + ", bsaID=" + bsaID + ", pplID=" + pplID + "]";
	}
    
    
}
