# Annotations

## create annotations
- open in terminal: ..\AnnotationsProject\out\production\AnnotationsProject

```shell
javap -verbose TestingAnnotatedClasses.class > TestingAnnotatedClasses.disassembled
```

```shell
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java 
```

## JavaDocs
- select "TestingAnnotatedClasses.java"
- Tools > Generate JavaDoc...