public interface IWorkShop<T extends Vehicle> {

    void changeTires(T vehicle);
    void changeOilFilter(T vehicle);
    void repairWindShield(T vehicle);
    void loosenBolts(T vehicle);
}
