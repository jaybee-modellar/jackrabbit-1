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

/**
 * Evaluates to the value (or values, if multi-valued) of a property.
 * <p/>
 * If, for a node-tuple, the {@link #getSelectorName selector} node does not
 * have a property named {@link #getPropertyName property}, the operand
 * evaluates to null.
 * <p/>
 * The query is invalid if:
 * <ul>
 * <li>{@link #getSelectorName selector} is not the name of a selector in the
 * query, or</li>
 * <li>{@link #getPropertyName property} is not a syntactically valid JCR
 * name.</li>
 * </ul>
 *
 * @since JCR 2.0
 */
public interface PropertyValue extends DynamicOperand {

    /**
     * Gets the name of the selector against which to evaluate this operand.
     *
     * @return the selector name; non-null
     */
    String getSelectorName();

    /**
     * Gets the name of the property.
     *
     * @return the property name; non-null
     */
    String getPropertyName();

}
