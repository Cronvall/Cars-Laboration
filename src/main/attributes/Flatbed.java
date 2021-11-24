package attributes;

import vehicle.Car;

public class Flatbed {

    private Car[] carLoad;
    private final LoadingMethod loadingMethod;
    private int currentIndex;
    private int currentLoadOffIndex;

    public Flatbed(int loadingCapacity, LoadingMethod loadingMethod){
        if(loadingCapacity > 0)
            carLoad = new Car[loadingCapacity];
        else
            System.out.println("Input a valid Capacity for your attributes.Flatbed");

        this.loadingMethod = loadingMethod;
        this.currentIndex = 0;

        if(loadingMethod == LoadingMethod.FirstOnFirstOff)
            currentLoadOffIndex = 0;
        else currentLoadOffIndex = loadingCapacity - 1;
    }

    public Car[] getCarLoad(){
        return carLoad;
    }

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

    public void removeCar(){
        if(loadingMethod == LoadingMethod.FirstOnLastOff)
            removalFirstOnLastOff();
        else removalFirstOnFirstOff();
    }

    private void removalFirstOnFirstOff(){
        if(carLoad[currentLoadOffIndex] != null){
            carLoad[currentLoadOffIndex] = null;
            if(currentLoadOffIndex < carLoad.length - 1)
                currentLoadOffIndex++;
        }
    }
    private void removalFirstOnLastOff(){
        carLoad[currentIndex -1] = null;

    }


    public enum LoadingMethod{
        FirstOnFirstOff, //Ex. This would apply to ferries and a like where you can open the "flatbed" from two sides.
        FirstOnLastOff  //Ex. This would apply to trucks since they only can unload from behind.
    }
}


