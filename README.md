# parser-playground
[Parser playground app](https://iamsmkr.github.io/parser-playground/) to demo usage of Scala library in javascript ecosystem using Scala.js

## Dev
1. To generate a fast optimized compiled version of the javascript file execute following command from Scala.js sbt plugin. The javascript file is generated as `js/target/scala-2.12/simple-arithmetic-parser-fastopt.js`

  ```
  $ sbt> fastOptJS
  ```

2. Access `index-dev.html` on your browser to launch the app

## Deploy
1. To generate fully optimized version of the javascript file execute the following command from Scala.js sbt plugin. The javascript file is generated as `js/target/scala-2.12/simple-arithmetic-parser-opt.js`. Note that this can take a while on a larger project, which is why we typically use `fastOptJS` during development. 

  ```
  $ sbt> fullOptJS
  ```

2. Access `index.html` on your browser to launch the app

## Refer

1. [Scala.js Basic tutorial](https://www.scala-js.org/doc/tutorial/basic/)
2. [Scala.js Cross Building](https://www.scala-js.org/doc/project/cross-build.html)
