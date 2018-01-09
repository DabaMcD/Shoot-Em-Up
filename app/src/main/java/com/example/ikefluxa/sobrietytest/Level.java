package com.example.ikefluxa.sobrietytest;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Ike&Fluxa on 1/6/2018.
 */

public class Level {
    ArrayList<Car> cars;

    public Level(ArrayList<Car> cars) {
        this.cars = cars;
    }
    public int run(Canvas canvas) { // return values: 2 = win, 1 = lose, 0 = still playing
        int numCars = 0;
        for(Car car : cars) {
            if(car.alive == 1) {
                car.draw(canvas);
                car.move();
                car.reset();
                if(car.pop(Constants.mouseX, Constants.mouseY) && Constants.mousePressed) {
                    car.speed = Math.max(car.speed / 2, 1);
                }
                if(car.hit(Constants.mouseX, Constants.mouseY) && Constants.mousePressed) {
                    car.alive = 0;
                }
                numCars ++;
            }
        }
        if(numCars <= 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
