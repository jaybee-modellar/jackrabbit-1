/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.core.query.jsr283.qom;

import org.apache.jackrabbit.core.query.jsr283.PreparedQuery;

/**
 * A query in the JCR query object model.
 * <p/>
 * The JCR query object model describes the queries that can be evaluated
 * by a JCR repository independent of any particular query language, such
 * as SQL.
 * <p/>
 * A query consists of:
 * <ul>
 * <li>a source.  When the query is evaluated, the source evaluates its
 * selectors and the joins between them to produce a (possibly empty)
 * set of node-tuples.  This is a set of 1-tuples if the query has one
 * selector (and therefore no joins), a set of 2-tuples if the query has
 * two selectors (and therefore one join), a set of 3-tuples if the query
 * has three selectors (two joins), and so forth.</li>
 * <li>an optional constraint.  When the query is evaluated, the constraint
 * filters the set of node-tuples.</li>
 * <li>a list of zero or more orderings.  The orderings specify the order in
 * which the node-tuples appear in the query results.  The relative order
 * of two node-tuples is determined by evaluating the specified orderings,
 * in list order, until encountering an ordering for which one node-tuple
 * precedes the other.  If no orderings are specified, or if for none of
 * the specified orderings does one node-tuple precede the other, then the
 * relative order of the node-tuples is implementation determined (and may
 * be arbitrary).</li>
 * <li>a list of zero or more columns to include in the tabular view of the
 * query results.  If no columns are specified, the columns available in
 * the tabular view are implementation determined, but minimally include,
 * for each selector, a column for each single-valued non-residual property
 * of the selector's node type.</li>
 * </ul>
 * <p/>
 * The query object model representation of a query is created by factory
 * methods in the {@link QueryObjectModelFactory}.
 *
 * @since JCR 2.0
 */
public interface QueryObjectModel extends PreparedQuery {

    /**
     * Gets the node-tuple source for this query.
     *
     * @return the node-tuple source; non-null
     */
    Source getSource();

    /**
     * Gets the constraint for this query.
     *
     * @return the constraint, or null if none
     */
    Constraint getConstraint();

    /**
     * Gets the orderings for this query.
     *
     * @return an array of zero or more orderings; non-null
     */
    Ordering[] getOrderings();

    /**
     * Gets the columns for this query.
     *
     * @return an array of zero or more columns; non-null
     */
    Column[] getColumns();

}
