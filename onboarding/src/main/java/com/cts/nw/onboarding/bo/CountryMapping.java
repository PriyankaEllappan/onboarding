/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class CountryMapping {
	private String countryName;
	private String locationName;
	private int countryMappingID;
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the countryMappingID
	 */
	public int getCountryMappingID() {
		return countryMappingID;
	}
	/**
	 * @param countryMappingID the countryMappingID to set
	 */
	public void setCountryMappingID(int countryMappingID) {
		this.countryMappingID = countryMappingID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryMapping [countryName=" + countryName + ", locationName=" + locationName + ", countryMappingID="
				+ countryMappingID + "]";
	}

}
