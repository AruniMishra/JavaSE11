# Java

## Command

- Run below from root folder to run the program

```shell
java --module-path .\out\production\  -m MyFirstModule/modular.HelloWorld
```

- Run below to generate the .jar

```shell
jar --create --file MyFirstModule.jar --main-class modular.HelloWorld -C .\out\production\MyFirstModule\ .
```

- Run below to inspect

```shell
jar -f .\MyFirstModule.jar --list
```

- Run below to describe

```shell
jar -f .\MyFirstModule.jar -d
```

or,

```shell
java --module-path . --describe-module MyFirstModule
```

or,

```shell
java -p . -d MyFirstModule
```