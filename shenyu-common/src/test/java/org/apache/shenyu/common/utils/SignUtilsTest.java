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

package org.apache.shenyu.common.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test cases for SignUtils.
 */
public final class SignUtilsTest {

    @Test
    public void testGenerateSign() {
        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("a", "1");
        jsonParams.put("b", "2");
        Map<String, String> queryParams = new HashMap<>();
        jsonParams.put("a", "1");
        jsonParams.put("b", "2");
        assertNotNull(SignUtils.generateSign("test", jsonParams, queryParams));
    }

    @Test
    public void testValid() {
        final String sign = "7AA98F7D67F8E4730E2D1D3902295CE6";
        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("a", "1");
        jsonParams.put("b", "2");
        Map<String, String> queryParams = new HashMap<>();
        jsonParams.put("a", "1");
        jsonParams.put("b", "2");
        assertTrue(SignUtils.getInstance().isValid(sign, jsonParams, queryParams, "test"));
    }

    @Test
    public void testGenerateKey() {
        assertNotNull(SignUtils.getInstance().generateKey());
    }
}
