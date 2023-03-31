module org.module.util {
    // exports org.pkg.util;

    /*
    limit org.pkg.util to be read only by friend(org.module.base)
     */
    exports org.pkg.util to org.module.base, org.module.concrete;

    /*
    transitive requires is added, so that any module which reads org.module.util,
    can also read org.module.global
     */
    requires transitive org.module.global;
}