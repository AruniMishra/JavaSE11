A method signature is made up of its name and ordered list of parameter types

An overridden method must match parameter types exactly

An overridden method must match a return type exactly or be a covariant of the return type

An overloaded method ignores parameter names

An overloaded method ignores return types

you can override a method with a throws' clause, and not declare one yourself in base case.  
you do not have to specify a throws clause in the overridden method

You can overload overridden methods.