/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Describing Service Components, The Game = Consumer
*/

package gamble.slots.game;

import gamble.slots.spi.PayOffService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The consumer -- this is the class that's going to call methods on a provider.
 * <p>
 * -It contains code that calls methods on service loader
 * to get the providers of a particular type.
 * <br>
 * -It executes the provider's code.
 * <br>
 * -It's module descriptor contains the user's directive,
 * which declares which service will be used,
 * <br>
 * -and its module descriptor contains a required directive of the module
 * where the service interface is declared is also necessary.
 */

// The application that will use the provider to provide
// 'winnings' for a player, whatever the winnings might be
public class CherrySlot {
    public static void main(String[] args) {
        // Mock playing the game.
        new CherrySlot().playGame();

    }

    // Method searches for providers, returns last one loaded if any
    // have been loaded.  forEach implicitly uses iterator on ServiceLoader
    private PayOffService getService() {
        List<PayOffService> providers = new ArrayList<>();
        ServiceLoader.load(PayOffService.class).forEach(providers::add);
        providers.forEach(System.out::println);
        if (providers.size() > 0) {
            return providers.get(providers.size() - 1);
        }
        return null;
    }

    // Method that plays the game and provides winnings
    private void playGame() {

        // PayOffService p = getService();
        // PayOffService p = getPreferredService(); // when there are 2 or more impl
        PayOffService p = getServiceInManyWays(0);
        if (p == null) System.out.println("Provider not found");
        else {
            System.out.println("Congratulations:  You're a winner!");
            p.threeInRow(PayOffService.SlotType.GOLDBAR_ONE);
        }

    }

    // Method that searches for providers and first one which is not
    // the default provider packaged with the application
    private PayOffService getPreferredService() {
        List<PayOffService> providers =
                ServiceLoader.load(PayOffService.class)
                        // stream of provider
                        .stream()
                        // map provider object to PayOffService object
                        .map(ServiceLoader.Provider::get)
                        .collect(Collectors.toList());


        System.out.println("--------");
        providers.forEach(s -> System.out.println(s.getClass().getName()));
        System.out.println("--------");

        // Give precedence to provider that is NOT the default provider
        Optional<PayOffService> service = providers.stream()
                .filter((s) ->
                        !s.getClass().getName()
                                .contains("gamble.slots.impl"))
                .findFirst();

        if (service.isEmpty()) {
            System.out.println("service empty");
            return providers.stream().findFirst().orElse(null);
        } else return service.get();
    }


    // Method will retrieve a service in multiple ways
    private PayOffService getServiceInManyWays(int whichWay) {
        System.out.println("whichWay = " + whichWay);

        // Call the static load() method on ServiceLoader which returns instance of ServiceLoader,
        // an Iterable whose iterator is made up of PayOffService objects
        ServiceLoader<PayOffService> loader = ServiceLoader.load(PayOffService.class);

        // Print out type of the result of load()
        System.out.println("Result of load method = " + loader.getClass());

        // Local variable will be returned from this method
        PayOffService payOffService = null;

        /*
        // You cannot directly instantiate a PayOffService, it's an interface
        payOffService = new PayOffService();

        // You cannot instantiate a ServiceLoader with a no args constructor
        payOffService = new ServiceLoader().load(PayOffService.class);

        // ServiceLoader.load does NOT return a PayOffService instance
        payOffService = ServiceLoader.load(PayOffService.class);

        // ServiceLoader.load returns an instance of ServiceLoader,
        // not a Provider or Optional that supports .get()
        payOffService = ServiceLoader.load(PayOffService.class).get();

        */

        switch (whichWay) {
            case (0):
                payOffService = loader.stream()
                        // map from a Provider<PayOffService> to a PayOffService
                        .map(ServiceLoader.Provider::get)
                        // now have a PayOffService so do not need .get() method
                        .filter(s -> s.getClass().getName().startsWith("gamble"))
                        // Now returned an Optional<PayOffService> and not Optional<Provider>
                        .findFirst()
                        .get();
                break;
            case (3):
                payOffService = loader.stream()
                        // In this instance I do not map to PayOffService, but instead
                        // use ServiceLoader.Provider.get() method in the filter
                        .filter(s -> s.get().getClass().getName().startsWith("gamble"))
                        // findFirst is the terminal operation and returns Optional<Provider>
                        .findFirst()
                        // get method on Optional returns a Provider
                        .get()
                        // need to call get again, this tim on Provider to get our PayOffService
                        .get();
                break;

            case (2):
                // Using iterator(), iterating through elements and
                // retrieving one based on class name.
                Iterator<PayOffService> iterator = loader.iterator();
                while (iterator.hasNext()) {
                    var iteratorItem = iterator.next();
                    System.out.println(iteratorItem.getClass());
                    if (iteratorItem.getClass().getName().startsWith("nj")) {
                        payOffService = iteratorItem;
                    }
                }
                break;
            case (1):
                payOffService = ServiceLoader.load(PayOffService.class)
                        // ServiceLoader.findFirst() returns an Optional
                        .findFirst()
                        // Need to use .get() on Optional to get a PayOffService
                        .get();
                break;
        }

        return payOffService;
    }
}