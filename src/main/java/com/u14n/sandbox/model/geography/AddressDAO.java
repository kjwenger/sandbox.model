package com.u14n.sandbox.model.geography;

import com.u14n.sandbox.model.DAOProtocol;
import com.u14n.sandbox.model.DAOProtocol.ConcurrentMemory;

/**
 * @author Klaus Wenger
 *
 */
public interface AddressDAO extends DAOProtocol<Address, Long> {

	/**
	 * @author Klaus Wenger
	 *
	 */
	public static class ConcurrentMemory
		extends DAOProtocol.ConcurrentMemory<Address, Long>
		implements AddressDAO {

	}

}
