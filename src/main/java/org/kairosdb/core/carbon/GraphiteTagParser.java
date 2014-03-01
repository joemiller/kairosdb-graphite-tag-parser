package org.kairosdb.core.carbon;

import org.kairosdb.core.DataPointSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class GraphiteTagParser implements TagParser
{
    @Override
    public DataPointSet parseMetricName(String graphitePath)
    {
        String[] parts = graphitePath.split(";");
        String remainder = parts[1];
        DataPointSet ret = new DataPointSet(parts[0]);

        Pattern p = Pattern.compile("\\G([a-zA-Z0-9-_\\.]+)=([a-zA-Z0-9-_\\.]+)");

        for (String pair: remainder.split(",")) {
            Matcher m = p.matcher(pair);
            while (m.find()) {
              //System.out.println("tag found: " + m.group(1) + " - " + m.group(2));
              ret.addTag(m.group(1), m.group(2));
            }
          }

        return (ret);
    }
}
