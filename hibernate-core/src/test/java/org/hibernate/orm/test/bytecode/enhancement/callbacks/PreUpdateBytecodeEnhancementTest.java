/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.bytecode.enhancement.callbacks;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import jakarta.persistence.Basic;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.orm.test.jpa.BaseEntityManagerFunctionalTestCase;

import org.hibernate.testing.bytecode.enhancement.BytecodeEnhancerRunner;
import org.hibernate.testing.orm.junit.JiraKey;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@JiraKey("HHH-12718")
@RunWith(BytecodeEnhancerRunner.class)
public class PreUpdateBytecodeEnhancementTest extends BaseEntityManagerFunctionalTestCase {

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class<?>[] { Person.class };
	}

	@Override
	protected void addConfigOptions(Map options) {
		options.put( AvailableSettings.CLASSLOADERS, getClass().getClassLoader() );
		options.put( AvailableSettings.ENHANCER_ENABLE_LAZY_INITIALIZATION, "true" );
		options.put( AvailableSettings.ENHANCER_ENABLE_DIRTY_TRACKING, "true" );
	}

	@Test
	public void testPreUpdateModifications() {
		Person person = new Person();

		doInJPA( this::entityManagerFactory, entityManager -> {
			entityManager.persist( person );
		} );

		doInJPA( this::entityManagerFactory, entityManager -> {
			Person p = entityManager.find( Person.class, person.id );
			assertNotNull( p );
			assertNotNull( p.createdAt );
			assertNull( p.lastUpdatedAt );

			p.setName( "Changed Name" );
		} );

		doInJPA( this::entityManagerFactory, entityManager -> {
			Person p = entityManager.find( Person.class, person.id );
			assertNotNull( p.lastUpdatedAt );
		} );
	}

	@Entity(name = "Person")
	private static class Person {
		@Id
		@GeneratedValue
		private int id;

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private Instant createdAt;

		public Instant getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Instant createdAt) {
			this.createdAt = createdAt;
		}

		private Instant lastUpdatedAt;

		public Instant getLastUpdatedAt() {
			return lastUpdatedAt;
		}

		public void setLastUpdatedAt(Instant lastUpdatedAt) {
			this.lastUpdatedAt = lastUpdatedAt;
		}

		@ElementCollection
		private List<String> tags;

		@Lob
		@Basic(fetch = FetchType.LAZY)
		private byte[] image;

		@PrePersist
		void beforeCreate() {
			this.setCreatedAt( Instant.now() );
		}

		@PreUpdate
		void beforeUpdate() {
			this.setLastUpdatedAt( Instant.now() );
		}
	}
}
