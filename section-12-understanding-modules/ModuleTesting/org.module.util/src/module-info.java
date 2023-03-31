module org.module.util {
    exports org.pkg.util;

    requires transitive org.module.global;
}