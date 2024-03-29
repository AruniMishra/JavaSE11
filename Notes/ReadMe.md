- [JavaSE11](#javase11)
  - [Inheritance](#inheritance)
  - [Abstract Class](#abstract-class)
  - [Interface](#interface)


# JavaSE11


## Inheritance

A method signature is made up of its name and ordered list of parameter types

An overridden method must match parameter types exactly

An overridden method must match a return type exactly or be a covariant of the return type

An overloaded method ignores parameter names

An overloaded method ignores return types

you can override a method with a throws' clause, and not declare one yourself in base case.  
you do not have to specify a throws clause in the overridden method

You can overload overridden methods.

Modifier 'static' is redundant for inner interfaces

### Overriding

There are 2 rules related to return types of overriding method:

1. If return type of overridden method is of primitive type, then overriding method should use same primitive type.

2. If return type of overridden method is of reference type, then overriding method can use same reference type or its sub-type (also known as covariant return type).

## Abstract Class
 - An abstract class(either abstract method or concrete method) can override a method in an interface though it should be public.


## Interface

- Concrete methods are supported on an interface but limited to private methods, private static methods, default methods, and public static methods.

