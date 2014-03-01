kairosdb-graphite-tag-parser
============================

This is a sample TagParser class for KairosDB's graphite ingestion support.

Since KairosDB supports tags, while Graphite does not, this provides a way to 
embed tags into a graphite metric path for KairosDB.

The format is simple, a metric sent to KairosDB with the following metric
name:

```
    metric.name;tag1=val1,tag2=val2
```

Stored in KairosDB as:

- metric:  metric.name
- tags  :  [tag1=val1, tag2=val2]


Install / Configure
-------------------

- Copy `GraphiteTagParser-0.1.jar` to KairosDB CLASSPATH such as kairosdb's `lib/` subdir.
- Modify `kairosdb.properties` and set the `kairosdb.carbon.tagparser` class:

```
    kairosdb.carbon.tagparser=org.kairosdb.core.carbon.GraphiteTagParser
```

- restart kairosdb

Build
-----

- `kairosdb.jar` is not available via maven. Download a copy and place it into a `lib/` subdir
  of this project. http://dl.bintray.com/brianhks/generic/
- run `mvn package` to generate a .jar

Test
----

- run `mvn test`

Author
------

* [Joe Miller](https://twitter.com/miller_joe) - http://joemiller.me / https://github.com/joemiller

License
-------

    Author:: Joe Miller (<joeym@joeym.net>)
    Copyright:: Copyright (c) 2012 Joe Miller
    License:: Apache License, Version 2.0

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
