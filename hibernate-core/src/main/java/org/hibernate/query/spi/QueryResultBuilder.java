/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.query.spi;

import org.hibernate.sql.results.graph.DomainResult;
import org.hibernate.sql.results.graph.DomainResultCreationState;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;

/**
 * A builder for {@link DomainResult} instances related to native SQL query results.
 *
 * todo (6.0) : Perhaps this should be a builder for QueryResultProducer instances instead?
 *
 * @author Steve Ebersole
 */
public interface QueryResultBuilder {
	// todo (6.0) : need to add the notion of "builders" that nest inside other builders.
	//		Nesting can happen as:
	//
	//		For a scalar, it might represent:
	//			1) a top-level QueryResult
	//			2) a column within the attribute mapping for entity (or composite?)
	//			3) an argument to a dynamic-instantiation
	//
	//		For an attribute, it always represents a non-QueryResult.  At least I
	// 		think that is accurate - validate this, can an attribute be defined
	//		as a top-level QueryResult?  dynamic-instantiation argument? - JPA at least does not support that
	//
	//		For dynamic-instantiation, it might represent:
	//			1) a top-level QueryResult
	//			2) dynamic-instantiation argument (non-JPA)

	JavaTypeDescriptor getResultType();

	DomainResult buildReturn(DomainResultCreationState creationState);
}
