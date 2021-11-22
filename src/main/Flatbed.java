public class Flatbed {

    private Car[] carLoad;
    private final LoadingMethod loadingMethod;
    private int currentIndex;

    public Flatbed(int loadingCapacity, LoadingMethod loadingMethod){
        if(loadingCapacity > 0)
            carLoad = new Car[loadingCapacity];
        else
            System.out.println("Input a valid Capacity for your Flatbed");

        this.loadingMethod = loadingMethod;

        if(loadingMethod == LoadingMethod.FirstOnFirstOff)
            currentIndex = 0;
        else if(loadingMethod == LoadingMethod.FirstOnLastOff)
            currentIndex = loadingCapacity - 1;
    }

    public Car[] getCarLoad(){
        return carLoad;
    }

    protected void loadCar(Car car){
        if(currentIndex < carLoad.length && currentIndex >= 0){
            if(carLoad[currentIndex] == null){
                carLoad[currentIndex] = car;

                //SET NEW INDEX
                if(currentIndex != 0 && currentIndex != carLoad.length - 1){
                    if(loadingMethod == LoadingMethod.FirstOnFirstOff)
                        currentIndex += 1;
                    else currentIndex -= 1;
                }
            }
            else System.out.println("There is already a car in this place.");
        }
        else System.out.println("The flatbed is already full, you'll need to load off a car first to fit another one.");
    }

    protected void removeCar(){
        Car[] newArray = carLoad;
        newArray[currentIndex] = null;
        carLoad = newArray;

        //SET NEW INDEX
        if(currentIndex != 0 && currentIndex != carLoad.length - 1){
            if(loadingMethod == LoadingMethod.FirstOnFirstOff)
                currentIndex -= 1;
            else currentIndex += 1;
        }
    }


    public enum LoadingMethod{
        FirstOnFirstOff, //Ex. This would apply to ferries and a like where you can open the "flatbed" from two sides.
        FirstOnLastOff  //Ex. This would apply to trucks since they only can unload from behind.
    }
}


