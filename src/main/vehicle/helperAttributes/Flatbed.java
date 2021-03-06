package vehicle.helperAttributes;
import vehicle.Car;
import vehicle.ILoadCar;
import vehicle.LoaderHelper;
import vehicle.MotorVehicle;

/**
 * A Flatbed is what vehicles that transport cars use to carry cars on top of
 */
public class Flatbed{

    private LoaderHelper loaderHelper;
    private Car[] carLoad;
    private final LoadingMethod loadingMethod;
    private int currentIndex;
    private int currentLoadOffIndex;

    /**
     * Initiates a new object of the class Flatbed
     * @param loadingCapacity Describes how many cars can be carried
     * @param loadingMethod Describes by which order the flatbed loads off cars
     */
    public Flatbed(int loadingCapacity, LoadingMethod loadingMethod){
        this.loaderHelper = new LoaderHelper();
        if(loadingCapacity > 0)
            carLoad = new Car[loadingCapacity];
        else
            System.out.println("Input a valid Capacity for your vehicle.helperAttributes.Flatbed");

        this.loadingMethod = loadingMethod;
        this.currentIndex = 0;

        if(loadingMethod == LoadingMethod.FirstOnFirstOff)
            currentLoadOffIndex = 0;
        else currentLoadOffIndex = loadingCapacity - 1;
    }

    public boolean isEmpty(){
        return this.loaderHelper.isEmpty(carLoad);
    }

    public Flatbed getFlatBed(){
        return this;
    }

    public LoaderHelper getLoaderHelper(){
        return this.loaderHelper;
    }
    public void moveCargo(MotorVehicle vehicle){
        this.loaderHelper.moveLoad(carLoad, vehicle);
    }

    /**
     * Returns an array displaying what cars are being carried
     * @return
     */
    public Car[] getCarLoad(){
        return carLoad;
    }

    /**
     * Laods a car onto the flatbed
     * @param car Refers to the car being loaded
     */
    public void loadCar(Car car){

        if(currentIndex < carLoad.length && currentIndex >= 0){
            if(carLoad[currentIndex] == null){
                carLoad[currentIndex] = car;

                //SET NEW INDEX
                if(currentIndex != carLoad.length - 1){
                        currentIndex += 1;
                }
            }
            else System.out.println("There is already a car in this place.");
        }
        else System.out.println("The flatbed is already full, you'll need to load off a car first to fit another one.");
    }

    /**
     * Removes a car from the flatbed
     */
    public void removeCar(){
        if(loadingMethod == LoadingMethod.FirstOnLastOff)
            removalFirstOnLastOff();
        else removalFirstOnFirstOff();
    }

    /**
     * Tells the Flatbed which car to offload next when loadingMethod = FirstOnFirstOff
     */
    private void removalFirstOnFirstOff(){
        if(carLoad[currentLoadOffIndex] != null){
            carLoad[currentLoadOffIndex].setLoadedOnTransporter(false);
            carLoad[currentLoadOffIndex] = null;
            if(currentLoadOffIndex < carLoad.length - 1)
                currentLoadOffIndex++;
        }
    }

    /**
     * Tells the Flatbed which car to offload next when loadingMethod = FirstOnLastOff
     */
    private void removalFirstOnLastOff(){
        carLoad[currentIndex -1].setLoadedOnTransporter(false);
        carLoad[currentIndex -1] = null;
    }

    /**
     * Enum that describes the two sorts of loading-methods that can be used
     */
    public enum LoadingMethod{
        FirstOnFirstOff, //Ex. This would apply to ferries and a like where you can open the "flatbed" from two sides.
        FirstOnLastOff  //Ex. This would apply to trucks since they only can unload from behind.
    }
}


