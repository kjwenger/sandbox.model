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
	default U getId() { return null; }
	default void setId(final U id) {
		throw new UnsupportedOperationException();
	}

	interface ByHash extends Identifiable<Long> {
		/**
		 * @return
		 */
		default Long getId() {
			final long id = hashCode();
			return id >= 0 ? id : Long.MAX_VALUE + id;
		}
	}
}
