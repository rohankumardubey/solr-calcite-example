/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.adapter;

import com.google.common.collect.ImmutableMap;
import org.apache.calcite.linq4j.tree.Types;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Builtin methods in the Solr adapter.
 */
public enum SolrMethod {
  SOLR_QUERYABLE_QUERY(SolrTable.SolrQueryable.class, "query", List.class, String.class, List.class, String.class);

  public final Method method;

  public static final ImmutableMap<Method, SolrMethod> MAP;

  static {
    final ImmutableMap.Builder<Method, SolrMethod> builder = ImmutableMap.builder();
    for (SolrMethod value : SolrMethod.values()) {
      builder.put(value.method, value);
    }
    MAP = builder.build();
  }

  SolrMethod(Class clazz, String methodName, Class... argumentTypes) {
    this.method = Types.lookupMethod(clazz, methodName, argumentTypes);
  }
}