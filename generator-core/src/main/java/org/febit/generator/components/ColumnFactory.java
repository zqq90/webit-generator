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
package org.febit.generator.components;

import java.util.HashMap;
import java.util.Map;
import org.febit.generator.model.Column;
import org.febit.generator.model.Table;
import org.febit.generator.util.ResourceUtil;
import org.febit.generator.util.dbaccess.ColumnRaw;

/**
 *
 * @author zqq90
 */
public abstract class ColumnFactory {

    private static ColumnFactory _instance;
    private static final Map<ColumnRaw, Column> columnLinkRawMap = new HashMap<ColumnRaw, Column>();

    protected abstract Column createColumn(ColumnRaw raw, Table table);

    public static ColumnFactory instance() {
        ColumnFactory instance = _instance;
        if (instance == null) {
            instance = _instance = (ColumnFactory) ResourceUtil.loadComponent("columnFactory");
        }
        return instance;
    }

    public static Column getColumn(ColumnRaw raw) {
        return columnLinkRawMap.get(raw);
    }

    public static Column create(ColumnRaw raw, Table table) {
        Column column = instance().createColumn(raw, table);
        if (column != null) {
            columnLinkRawMap.put(raw, column);
        }
        return column;
    }
}