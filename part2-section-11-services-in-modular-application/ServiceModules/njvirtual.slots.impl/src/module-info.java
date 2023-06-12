module njvirtual.slots.impl {
    requires gamble.slots.spi;

    // The declaration provides a service with a service provider implementation.
    provides gamble.slots.spi.PayOffService with njvirtual.slots.impl.ACPayOffService;
}
