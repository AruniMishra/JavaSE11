module test.impl {

    requires test.spi;


    provides test.spi.TestService with
            // test.impl.TestProvider
            // ; // valid, 1 provider
            // ,
            test.impl.TestProviderTwo
            // ; // valid, 2 provider
            ,
            test.impl.TestProviderFactory;

    // invalid, Duplicate 'provides': test.spi.TestService (should be separated by ,)
    // provides test.spi.TestService with test.impl.TestProviderTwo;


    // but this is valid!
    // the consumer doesn't know anything about an EnhancedTestService.
    exports test.impl;
    provides test.impl.EnhancedTestService with test.impl.TestProviderTwo;

}