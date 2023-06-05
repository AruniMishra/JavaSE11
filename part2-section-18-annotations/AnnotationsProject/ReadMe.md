# Annotations

## Test annotations

- open in terminal: ..\AnnotationsProject\out\production\AnnotationsProject

- we can see Class and Runtime annotations in the verbose listing of javap
    ```shell
    javap -verbose TestingAnnotatedClasses.class > TestingAnnotatedClasses.disassembled
    ```

```shell
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java 
```

## JavaDocs

- select "TestingAnnotatedClasses.java"
- Tools > Generate JavaDoc...