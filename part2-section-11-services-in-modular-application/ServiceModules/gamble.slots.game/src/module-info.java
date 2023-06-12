module gamble.slots.game {
    // consumer:
    // its module descriptor contains a required directive of the module
    // where the service interface is declared is also necessary.
    requires gamble.slots.spi;
    uses gamble.slots.spi.PayOffService;
}