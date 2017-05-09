package com.baidu.hugegraph.type.schema;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.javatuples.Pair;

import com.baidu.hugegraph.schema.HugePropertyKey;
import com.baidu.hugegraph.schema.SchemaElement;
import com.baidu.hugegraph.type.HugeType;
import com.baidu.hugegraph.type.define.Frequency;
import com.baidu.hugegraph.type.define.Multiplicity;

/**
 * Created by jishilei on 17/3/18.
 */
public abstract class EdgeLabel extends SchemaElement {

    public EdgeLabel(String name) {
        super(name);
    }

    @Override
    public HugeType type() {
        return HugeType.EDGE_LABEL;
    }

    @Override
    public EdgeLabel properties(String... propertyNames) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        for (String propertyName : propertyNames) {
            this.properties.put(propertyName, new HugePropertyKey(propertyName));
        }
        return this;
    }

    public abstract boolean isDirected();

    public abstract Frequency frequency();

    public abstract EdgeLabel singleTime();

    public abstract EdgeLabel multiTimes();

    public abstract Multiplicity multiplicity();

    public abstract EdgeLabel linkOne2One();

    public abstract EdgeLabel linkOne2Many();

    public abstract EdgeLabel linkMany2Many();

    public abstract EdgeLabel linkMany2One();

    public abstract EdgeLabel link(String src, String tgt);

    public abstract List<Pair<String, String>> links();

    public abstract EdgeLabel sortKeys(String... keys);

    public abstract Set<String> sortKeys();

    @Override
    public abstract EdgeLabel create();
}