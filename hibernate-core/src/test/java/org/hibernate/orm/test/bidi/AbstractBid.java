/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id: Bid.java 5733 2005-02-14 15:56:06Z oneovthafew $
package org.hibernate.orm.test.bidi;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Jan Schatteman
 */
public abstract class AbstractBid {
	private Long id;
	private SpecialAuction item;
	private BigDecimal amount;
	private boolean successful;
	private Date datetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public SpecialAuction getItem() {
		return item;
	}

	public void setItem(SpecialAuction item) {
		this.item = item;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
