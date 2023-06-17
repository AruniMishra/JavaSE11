module variance.impl {
    requires variance.spi;
    provides variance.spi.MyService1 with variance.impl.MyServiceImpl;
    provides variance.spi.MyService2 with variance.impl.MyServiceImpl;
}
