# Playground scala

## How to Use

```bash
# first: setup ensime for lsp
sbt ensimeConfig
# run Main
sbt run
# compile
sbt compile
# test
sbt test
sbt testOnly
sbt testQuick
# get testCoverage
sbt clean coverage test coverageReport
# with watch
sbt ~run
sbt ~compile
sbt ~test
sbt ~testOnly
sbt ~testQuick
```
