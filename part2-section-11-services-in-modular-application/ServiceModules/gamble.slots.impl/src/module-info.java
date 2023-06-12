module gamble.slots.impl {
    requires gamble.slots.spi;
    provides gamble.slots.spi.PayOffService
            with gamble.slots.impl.PayOffServiceImpl;
}