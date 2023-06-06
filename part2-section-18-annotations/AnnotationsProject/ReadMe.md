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

## Miscellaneous

https://www.oracle.com/technical-resources/articles/hunter-meta1.html

https://reflectoring.io/java-annotation-processing/#:~:text=SOURCE%20%2D%20The%20annotation%20is%20used,annotation%20is%20retained%20at%20runtime.