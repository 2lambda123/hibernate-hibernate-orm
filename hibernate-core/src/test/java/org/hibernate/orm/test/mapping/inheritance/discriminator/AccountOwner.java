/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id: Auction.java 5733 2005-02-14 15:56:06Z oneovthafew $
package org.hibernate.orm.test.mapping.inheritance.discriminator;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jan Schatteman
 */
public class AccountOwner {
	private Long id;
	private String description;
	private Set<AbstractAccount> creditAccounts = new HashSet<>();
	private Set<AbstractAccount> debitAccounts = new HashSet<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<AbstractAccount> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(Set<AbstractAccount> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

	public Set<AbstractAccount> getDebitAccounts() {
		return debitAccounts;
	}

	public void setDebitAccounts(Set<AbstractAccount> debitAccounts) {
		this.debitAccounts = debitAccounts;
	}
}
