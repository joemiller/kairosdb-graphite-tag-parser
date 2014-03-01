//
//  TagGroupByResultTest.java
//
// Copyright 2013, Proofpoint Inc. All rights reserved.
//        
package org.kairosdb.core.carbon;

import org.kairosdb.core.DataPointSet;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.*;

public class GraphiteTagParserTest
{
    @Test
    public void test_parse() {
        GraphiteTagParser parser = new GraphiteTagParser();
        DataPointSet dps = parser.parseMetricName("metric.name;tag1=val1,tag-2=val2_special-chars");

        SortedMap<String, String> expected_tags = new TreeMap<String, String>();
        expected_tags.put("tag1", "val1");
        expected_tags.put("tag-2", "val2_special-chars");

        assertThat(dps.getName(), equalTo("metric.name"));
        assertThat(dps.getTags(), equalTo(expected_tags));
    }
}
