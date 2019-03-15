/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class Bands {
	
	private Integer id;
	private String bandName;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the bandName
	 */
	public String getBandName() {
		return bandName;
	}
	/**
	 * @param bandName the bandName to set
	 */
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bands [id=" + id + ", bandName=" + bandName + "]";
	}
}
