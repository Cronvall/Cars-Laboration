import org.junit.jupiter.api.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class testCar {

    @Test
    void test_getters(){
        int saab_horse_p = 100;
        int saab_doors = 2;
        Color saab_color = Color.green;

        Saab95 saab = new Saab95(saab_doors, saab_horse_p, saab_color);

        Point initial_position = new Point(0, 0);

        should_return_direction(saab);
        should_return_current_speed(saab);
        should_return_engine_pow(saab_horse_p,saab);
        should_return_start_position(saab, initial_position);
    }

    @Test
    static void should_return_engine_pow(int engine_pow, Saab95 saab){
        assertEquals(engine_pow, saab.getEnginePower(), "Saab engine power incorrect!");
    }
    @Test
    static void should_return_current_speed(Saab95 saab){
        assertEquals(saab.getCurrentSpeed(), 0, "Saab speed not zero!");
    }
    @Test
    static void should_return_direction(Saab95 saab){
        assertEquals(saab.getDirection(), 1, "Saab starts in wrong direction!");
    }
    @Test
    static void should_return_start_position(Saab95 saab, Point position){
        assertEquals(position, saab.getPosition(), "Saab starts at wrong position!");
    }






}
