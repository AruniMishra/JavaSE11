module test.impl {
    requires test.spi;
    provides test.spi.TestService with test.impl.TestProvider
            // ; // valid, 1 provider
            , test.impl.TestProviderTwo
            // ; // valid, 2 provider
            , test.impl.TestProviderFactory;

    // invalid, Duplicate 'provides': test.spi.TestService
    // provides test.spi.TestService with test.impl.TestProviderTwo;
}