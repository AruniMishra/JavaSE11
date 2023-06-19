module variance.impl {
    requires variance.spi;
    provides variance.spi.MyService1 with variance.impl.MyServiceImpl;
    provides variance.spi.MyService2 with variance.impl.MyServiceImpl;
}



/*
service provider provides service using below syntax:
module SERVICEPROVIDER {
    requires MODULENAME1(not package name);
    requires MODULENAME2;
    provides SERVICEINTERFACE with IMPLEMENTATION;
}
 */