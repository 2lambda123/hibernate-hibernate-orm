/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.spatial.integration.criteria;

import java.util.List;

import org.hibernate.dialect.OracleDialect;
import org.hibernate.query.Query;
import org.hibernate.spatial.criteria.GeolatteSpatialCriteriaBuilder;
import org.hibernate.spatial.criteria.JTSSpatialCriteriaBuilder;
import org.hibernate.spatial.testing.IsSupportedBySpatial;
import org.hibernate.spatial.testing.SpatialSessionFactoryAware;
import org.hibernate.spatial.testing.SpatialTestBase;
import org.hibernate.spatial.testing.datareader.TestSupport;
import org.hibernate.spatial.testing.domain.GeomEntity;
import org.hibernate.spatial.testing.domain.JtsGeomEntity;
import org.hibernate.spatial.testing.domain.SpatialDomainModel;

import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.RequiresDialectFeature;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SkipForDialect;
import org.junit.jupiter.api.Test;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Polygon;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.polygon;
import static org.geolatte.geom.builder.DSL.ring;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DomainModel(modelDescriptorClasses = SpatialDomainModel.class)
@SessionFactory
@RequiresDialectFeature(feature = IsSupportedBySpatial.class)
@SkipForDialect(dialectClass = OracleDialect.class, majorVersion = 11, reason = "See https://hibernate.atlassian.net/browse/HHH-15669")
public class SpatialCriteriaSmokeTest extends SpatialSessionFactoryAware {

	@Test
	public void test() {
		scope.inTransaction( (session) -> {
			GeolatteSpatialCriteriaBuilder cb = session.getCriteriaBuilder()
					.unwrap( GeolatteSpatialCriteriaBuilder.class );
			CriteriaQuery<GeomEntity> cr = cb.createQuery( GeomEntity.class );
			Root<GeomEntity> root = cr.from( GeomEntity.class );
			cr.select( root ).where( cb.intersects(
					root.get( "geom" ),
					filterGeometry
			) );
			List<GeomEntity> results = session.createQuery( cr ).getResultList();
		} );
	}
}
