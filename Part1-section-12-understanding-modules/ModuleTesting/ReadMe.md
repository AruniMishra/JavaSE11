# Java Module

## Command

- Run below from root folder to run the program

```shell
java --module-path .\out\production\  -m MyFirstModule/modular.HelloWorld
java --module-path .\out\production\  -m MySecondModule/mod2.GoodbyeWorld 
```


or,

```shell
 java --module-path . --module MyFirstModule
```

---

- Run below to generate the .jar (-e or --main-class)

```shell
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

```shell
jdeps MyFirstModule.jar
```

or,

```shell
jdeps --list-reduced-deps MyFirstModule.jar
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
  