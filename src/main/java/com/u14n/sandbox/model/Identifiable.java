/**
 * 
 */
package com.u14n.sandbox.model;

/**
 * @author Klaus Wenger
 *
 */
public interface Identifiable<U> {
	/**
	 * @return
	 */
	default U getIdentifier() { return null; }
}
