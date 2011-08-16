# sbt-prototype is the starting point for all my projects #

## Features ##
- **ScalaTest**. Some sample tests are in `src/test/scala`. Run them with `sbt test`.
- **ENSIME**. The `sbt-prototype/.ensime` file is configured so you can start up ENSIME in emacs with `M-x ensime` and just hit enter.
- **ProGuard**. This is just so you can make an executable jar out of your project. Run `sbt proguard` and there will be an executable jar `sbt-prototype/target/scala_*/myproj-alpha.min.jar` that you can run `java -jar` on.
- **sbt tweaks**. Logging and stack traces are turned down to be less distracting; `javac` and `scalac` options are added for greater error checking; more customized scaladocs are created; your project's `README.md` and `LICENSE` files will be included in the resulting jars.
- **git**. The `.gitignore` file is ready to go.

## Customize for your project ##
* `cd` into the `sbt-prototype` directory.
* Run `grep -ri myproj . | grep -v target`. Replace every instance of `myproj` with your project's name.
* Run `grep -ri yuvimasory . | grep -v target` and replace every instance of `com.yuvimasory` with your package name.
* Fill in the `LICENSE` file with the text of your program's license.
* If you change your program entry point from the provided one, remember to update the `mainClass` definition in `project/build/Project.scala`.
* If you want to change your program's version number from `alpha` to something more descriptive, like `1.0`, update the `project.version` definition in `project/build.properties`.