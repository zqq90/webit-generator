/**
 * Copyright 2013-present febit.org (support@febit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.febit.generator.util;

import java.util.Map;

/**
 *
 * @author zqq90
 */
public class Maps {

    public static interface Handler<K, V> {

        boolean each(K key, V value);
    }

    public static <K, V> boolean each(Map<K, V> map, Handler<K, V> handler) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!handler.each(entry.getKey(), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}