package abstractpkg;
// This abstract class extends the abstract Vehicle
// It is not required that an abstract class implements any or all
// of Vehicle's abstract methods.   In this example, we implement 2 of
// Vehicle's abstract methods, but do not implement makeNoise method

public abstract class AutomatedVehicle extends Vehicle {

    // Constructor is pass through to Vehicle constructor
    public AutomatedVehicle(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }

    // This class implements park(), but calls an abstract method defined
    // on this class. Any class that extends the AutomatedVehicle no
    // longer has to implement park(), but has to implement autoPark.
    public void park() {
        autoPark();
    }

    // This class implements drive(), but calls an abstract method defined
    // on this drive
    public void drive() {
        autoDrive();
    }

    // Any concrete class that extends the AutomatedVehicle has to
    // implement autoPark
    abstract void autoPark();

    // Any concrete class that extends the AutomatedVehicle has to
    // implement autoDrive
    abstract void autoDrive();
}