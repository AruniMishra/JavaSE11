import annotations.ModuleAnnotation;

/*
A module being deprecated doesn't cause
warnings to be issued for uses of types within the module.
 */
@Deprecated
@ModuleAnnotation
module TestModuleAnnotations {
    exports test;
}