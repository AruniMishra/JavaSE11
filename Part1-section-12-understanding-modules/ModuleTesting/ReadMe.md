# Java Module

## Command

- Run below from root folder to run the program

```shell
java --module-path .\out\production\  -m MyFirstModule/modular.HelloWorld
java --module-path .\out\production\  -m MySecondModule/mod2.GoodbyeWorld 
```


or,

- telling the java virtual machine to look for a module jar file or exploded module directory using the --module-path 
or -p directory then pass the module name using the -m or --module option.
  - -p c:\modules, or
  - -p c:\modules\movies.jar

```shell
 java --module-path . --module MyFirstModule
```

---

- Run below to generate the .jar (-e or --main-class)

```shell
jar --create --file MySecondModule.jar -C .\out\production\MySecondModule\ .
jar --create --file MyFirstModule.jar --main-class modular.HelloWorld -C .\out\production\MyFirstModule\ .
```
-C DIR: Change to the specified directory and include the following file

---

- Run below to inspect

```shell
jar -f MyFirstModule.jar --list
```

---

- Run below to describe

```shell
jar -f MyFirstModule.jar -d
```

or,

```shell
java --module-path . --describe-module MyFirstModule
```

or,

```shell
java -p . -d MyFirstModule
```

---

- Run for jdeps
  - The jdeps tool is used to find out all dependencies of a class file or a jar file. It inspects the given class file
  (or all class files inside a jar files) and finds out all the required modules and packages that are referred to by this class or jar file.
- '--generate-module-info' option is available with jdeps command only,
  - It generates "mod-descriptors" directory containing module-info.java file

```shell
jdeps --module-path . .\MyFirstModule.jar
```

or,

- when MySecondModule.jar present(at root)
- 

```shell
jdeps --list-reduced-deps MyFirstModule.jar
```

- when MySecondModule.jar is not available(at root)
-

```shell
jdeps --module-path ".;.\out\production\" .\MyFirstModule.jar
```

# Advance

- With multiple modules

```shell
jar --create --file MyFirstModule.jar --main-class modular.HelloWorld -C out\production\MyFirstModule\ .
```

- To run

```shell
java -p "C:\resources\localdata\github\JavaSE11\part1-section-12-understanding-modules\ModuleTesting\out\production\MySecondModule;C:\resources\localdata\github\JavaSE11\section-12-understanding-modules\ModuleTesting\out\production\MyFirstModule" -m MyFirstModule/modular.HelloWorld
```

or,

```shell
java -p ".\out\production\;.\out\production\" -m MyFirstModule/modular.HelloWorld

java -p ".\out\;.\out\production\" -m MyFirstModule/modular.HelloWorld

java -p ".;.\out\production\" -m MyFirstModule/modular.HelloWorld

java -p ".;.\out\production\" -m MyFirstModule

java -p ".;./out/production/" -m MyFirstModule
```

---

- Run for Jdeps

```shell
jdeps --module-path  ".;.\out\production\" .\MyFirstModule.jar
```

or,

```shell
jdeps --module-path  ".;.\out\production\" -m MyFirstModule
```

or, run from out/production folder (_intellij markdown shell running in reverse order_)

```shell
jdeps --module-path . org.module.util

cd C:\resources\localdata\github\JavaSE11\part1-section-12-understanding-modules\ModuleTesting\out\production
```

## Misc

- Verbose

```shell
jdeps -v org.module.global

jdeps -v -m java.sql  
```

- Summary

```shell
jdeps -s org.module.global
jdeps -s org.module.global org.module.util

jdeps -summary -m java.sql

```
  
- Misc
  
```notes

Module options applicable for java as well as javac:
--module or -m : used to run or compile only the specified module.
--module-path or -p: used to specify the paths where java or javac will look for module definitions.

Module options applicable only for javac:
--module-source-path has no shortcut. Used by javac to look for source module definitions.
-d: used to specify output directory where the class files will be created after compilation.

Module options applicable only for java:
--list-modules has no shortcut. It lists observable modules and exits.
--show-module-resolution has no shortcut. It shows module resolution output during startup.
  
--describe-module or -d: It describes a module and exits(java).

--jmod describe: used to identify class and module dependencies


Note that -d works differently in java and javac. Further, -d is very different from -D, which is used while running a java program to specify name-value pairs of properties at the command line.
```

```notes
--show-module-resolution
This option shows all the dependencies of a module and how they are resolved while execution of a class. 
For example, lets say you have a moduleA that requires moduleB and moduleB requires moduleC. 
Now, if you run the following command:

java --module-path out --show-module-resolution --module moduleA/test.A

the following output is produced:

root moduleA file://C:/test/java/out/moduleA/
moduleA requires moduleB file://C:/test/java/out/moduleB/
moduleB requires moduleC file://C:/test/java/out/moduleC/
java.base binds java.xml.crypto jrt:/java.xml.crypto
...
...
java.rmi requires java.logging jrt:/java.logging
test.A

Observe the top three lines of the output. They show how moduleA, moduleB, and moduleC are resolved.


###########################################################################################
###########################################################################################


--describe-module
The --describe-module option shows the information given in the module-info of a particular module. 
It does not traverse the dependency graph. For example, if moduleA requires moduleB and moduleB requires moduleC, 
then the command java --describe-module moduleA will only show moduleB.
```
