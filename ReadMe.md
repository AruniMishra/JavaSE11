# Java

Implicit narrowing(for final constant) occurs only for byte, char, short, and int. 
Remember that it does not occur for long, float, or double.







## Inner class

Method-local inner classes cannot be defined using explicit access modifiers (public, protected and private) but non-access modifiers: final and abstract can be used with method-local inner class.
Static also not allowed.

a method local inner class can access local variables and parameters of the enclosing block that are final or effectively final.


# Collection

- The of and copyOf methods do not support null elements.


# Exception

- The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions. Checked exceptions need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.

- java.lang.Exception is a checked Exception


# Interface
- Though an interface is allowed to have overriding abstract methods [equals(Object) method, toString() method etc.] from Object class but default methods of an interface cannot override the methods of the Object class.
- Interfaces in java are allowed to override default method with abstract method.
- An Interface can extend an interface and override the abstract method with default interface.