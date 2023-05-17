# Module

## Run

```shell
jar -Mcf sample.core.jar -C out/production/ModularConversion sample/core
```

```shell
jar -Mcf sample.entity.jar -C out/production/ModularConversion sample/entity
```

```shell
jar -Mcf sample.service.jar -C out/production/ModularConversion sample/service
```

```shell
jar -mcf META-INF/MANIFEST.MF sample.api.jar -C out/production/ModularConversion sample/api
```


## Run jar

```shell
java -jar .\sample.api.jar
```