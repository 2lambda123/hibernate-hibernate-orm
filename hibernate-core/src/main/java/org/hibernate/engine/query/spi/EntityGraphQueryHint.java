/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.engine.query.spi;

import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.spi.AppliedGraph;
import org.hibernate.graph.spi.RootGraphImplementor;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Encapsulates a JPA EntityGraph provided through a JPQL query hint.  Converts the fetches into a list of AST
 * FromElements.  The logic is kept here as much as possible in order to make it easy to remove this in the future,
 * once our AST is improved and this "hack" is no longer needed.
 *
 * @author Brett Meyer
 *
 * @deprecated use {@link AppliedGraph} instead
 */
@Deprecated(since = "6.0")
public class EntityGraphQueryHint implements AppliedGraph {
	private final AppliedGraph delegate;

	public EntityGraphQueryHint(AppliedGraph delegate) {
		this.delegate = delegate;
	}

	@Override
	public @Nullable GraphSemantic getSemantic() {
		return delegate.getSemantic();
	}

	@Override
	public @Nullable RootGraphImplementor<?> getGraph() {
		return delegate.getGraph();
	}
}
