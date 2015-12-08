package com.u14n.sandbox.model.geography;

/**
 * @author Klaus Wenger
 */
public interface Addressed extends Located {
	/**
	 * @return
	 */
	public String getAdditional();
	/**
	 * @param newAdditional
	 */
	public void setAdditional(String newAdditional);
}
