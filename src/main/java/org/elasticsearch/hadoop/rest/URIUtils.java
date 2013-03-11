/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.elasticsearch.hadoop.rest;

import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;

/**
 * Utility class for handling URIs.
 */
public abstract class URIUtils {

    public static String addPath(String uri, String... path) {
        String p = URIUtil.getPath(uri);
        String fixedP = p.endsWith("/") ? p : p.concat("/");
        return uri.replace(p, fixedP + StringUtils.join(path, "/"));
    }

    public static String addParam(String uri, String... param) {
        String pq = URIUtil.getPathQuery(uri);
        String fixedPq = pq.contains("?") ? pq.concat("&") : pq.concat("?");
        return uri.replace(pq, fixedPq + StringUtils.join(param, "&"));
    }
}
