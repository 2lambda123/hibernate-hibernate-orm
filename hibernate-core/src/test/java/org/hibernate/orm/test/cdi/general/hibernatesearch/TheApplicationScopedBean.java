/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.orm.test.cdi.general.hibernatesearch;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author Yoann Rodiere
 */
@ApplicationScoped
public class TheApplicationScopedBean {

	@jakarta.inject.Inject
	private TheNestedDependentBean nestedDependentBean;

	public TheApplicationScopedBean() {
		Monitor.theApplicationScopedBean().instantiated();
	}

	public void ensureInitialized() {
		nestedDependentBean.ensureInitialized();
	}

	@PostConstruct
	public void postConstruct() {
		Monitor.theApplicationScopedBean().postConstructCalled();
	}

	@PreDestroy
	public void preDestroy() {
		Monitor.theApplicationScopedBean().preDestroyCalled();
	}

}
