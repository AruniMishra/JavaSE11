# Module

## Plain java project

- Create all java file and run below commands

```shell
# sample.core.jar only works when available inside main src
jar -Mcf sample.core.jar -C out/production/ModularConversion sample/core

jar -Mcf sample.entity.jar -C out/production/ModularConversion sample/entity

jar -Mcf sample.service.jar -C out/production/ModularConversion sample/service

#jar -mcf META-INF/MANIFEST.MF sample.api.jar -C out/production/ModularConversion sample/api
```

### Run jar

```shell
java -jar .\sample.api.jar
```

## Bottom-up approach

- Create sample.core module (inside parent Modular conversion project)
- Move src/UtilityClass(../ModularConversion/src/sample/core/UtilityClass.java) inside 'sample.core/src/sample.core'
- the original is renamed as 'UtilityClassMoved' for demo
- create module-info.java
- this creates error "Cannot resolve symbol 'UtilityClass'" for main src's class
- to fix it add dependency to ModularConversion

```shell
jar -Mcf sample.core.jar -C out/production/sample.core/ .
```

```shell
#print content of the jar
jar tf sample.core.jar
```

```shell
java -p . --describe-module sample.core
```

```shell
#If your non-modular code depends on artifacts on the module path
#which is the scenario set up here,
#you'll need to add them manually with the --add-modules option.
java -p . --add-modules sample.core -jar sample.api.jar
```

## Top-down approach

- refer the other branch "top-down"
- Move back sample.core(package) to old src/sample
- remove sample.core module and then delete the same.

```shell
jar -Mcf sample.core.jar -C out/production/ModularConversion sample/core
```

```shell
# no more module.info.class file
jar tf sample.core.jar
```

- create new module sample.api, and create 'sample' package inside it.
- move sample.api from old src to sample.api/src/sample.
- create module-info.java
- open module settings, Dependencies and then add 3 jars(core, entity & service).
- run controller.java
- here the non modular jar are loaded as automatic modules
- sample.api.Controller is on named module, that is not an automatic module.

```shell
jar -mcf META-INF/MANIFEST.MF sample.api.jar -C out/production/sample.api .
```

```shell
java -p . -m sample.api/sample.api.Controller
```

## Jdeps

### with modularized jars

```shell
jdeps sample.core.jar
```

-- note: But when you're evaluating a modularized jar, you need to call the command with a different syntax, including
the module path
-- -p not allowed below.

```shell
jdeps --module-path . sample.api.jar
```

or,

```shell
jdeps --module-path . -m sample.api
```

### with non-modularized jars

```shell
jdeps --module-path . -m sample.core
```

## Additional

- jdeps summary

```shell
jdeps -s .\dom4j-1.6.1.jar
```

- jdeprscan

```shell
jdeprscan .\dom4j-1.6.1.jar
```

### duplicate dependency

```shell
jar -Mcf com.b.util.jar -C out/production/com.b.util .
jar -Mcf com.a.util.jar -C out/production/com.a.util . 
jdeps --module-path . com.a.util
```

