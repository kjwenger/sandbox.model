/**
 * 
 */
package com.u14n.sandbox.model;

/**
 * @author Klaus Wenger
 *
 */
public interface Revisionable<U> {
	/**
	 * @return
	 */
	default U getRevision() { return null; }
	/**
	 * @param newRevision
	 */
	default void setRevision(U newRevision) { }
}
