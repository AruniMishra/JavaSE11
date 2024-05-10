module gamble.slots.impl {
    requires gamble.slots.spi;
    // PayOffService should be an interface or an abstract class but there is no such technical restriction.
    // The service must be a class type, an interface type, or an annotation type.
    // It is a compile-time error if a provides directive specifies an enum type as the service.
    provides gamble.slots.spi.PayOffService
            with gamble.slots.impl.PayOffServiceImpl;
}