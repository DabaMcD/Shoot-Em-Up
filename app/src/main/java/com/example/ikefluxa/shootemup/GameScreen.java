package com.example.ikefluxa.shootemup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ike&Fluxa on 1/5/2018.
 */

public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private String page = "main page";
    private int money;
    private ArrayList<Smoke> smoke;
    private int lotsOfSmoke;
    private int smokeNo;
    private int exploded;
    private int explodeX;
    private int explodeY;
    private int frozen;
    private int freezeX;
    private int freezeY;
    private int carsFreeze;
    private int carsFreezeNum;
    private int moneyBonused;
    private int moneyBonusX;
    private int moneyBonusY;
    private int level;
    private int carCount;
    private int timesPassToLose;
    private int moreCarLapsPrice;
    private String storeBack;
    private int carsGoSlower;
    private int carsGoSlowerPrice;
    private int bonusesComeMoreOften;
    private String levelSelectBack;
    private ArrayList<Level> levels;
    private ArrayList<Car> showCars;
    public GameScreen(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        money = 0;
        smoke = new ArrayList<>();
        lotsOfSmoke = 0;
        smokeNo = 1;
        exploded = 0;
        explodeX = -200;
        explodeY = (int) (Math.random() * 400 + 50);
        frozen = 0;
        freezeX = -200;
        freezeY = (int) (Math.random() * 400 + 50);
        carsFreeze = 0;
        carsFreezeNum = 0;
        moneyBonused = 0;
        moneyBonusX = -200;
        moneyBonusY = (int) (Math.random() * 400 + 50);
        level = 1;
        carCount = 0;
        timesPassToLose = 16;
        moreCarLapsPrice = 300;
        storeBack = "play";
        carsGoSlower = 0;
        carsGoSlowerPrice = 230;
        bonusesComeMoreOften = 1;
        levelSelectBack = "main page";
        levels = new ArrayList<Level>() {
            {
                add(new Level(new ArrayList<>(Arrays.asList(new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 0)),
                        new Car(50, 30, 71, 40, 8, 5, Color.rgb(255, 0, 255)),
                        new Car(50, 56, 136, 27, 21, 2, Color.rgb(43, 255, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(60, 20, 100, 30, 15, 10, Color.rgb(133, 66, 66)),
                        new Car(50, 30, 71, 40, 8, 5, Color.rgb(138, 68, 138)),
                        new Car(50, 56, 136, 27, 21, 2, Color.rgb(61, 125, 133))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(80, 5, 150, 5, 30, 10, Color.rgb(255, 0, 0)),
                        new Car(80, 5, 200, 5, 20, 10, Color.rgb(0, 255, 0)),
                        new Car(80, 5, 200, 5, 30, 10, Color.rgb(0, 0, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(30, 10, 50, 20, 10, 5, Color.rgb(255, 255, 255)),
                        new Car(30, 20, 50, 30, 10, 10, Color.rgb(0, 0, 255)),
                        new Car(10, 50, 150, 10, 20, 15, Color.rgb(255, 255, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 255, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 255, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 0, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(20, 100, 40, 30, 30, 10, Color.rgb(0, 255, 255)),
                        new Car(20, 100, 40, 30, 30, 10, Color.rgb(255, 0, 255)),
                        new Car(20, 100, 40, 30, 30, 10, Color.rgb(255, 255, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(40, 3, 250, 5, 50, 20, Color.rgb(255, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(30, 10, 50, 20, 10, 5, Color.rgb(255, 0, 0)),
                        new Car(30, 10, 50, 20, 10, 5, Color.rgb(0, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 5, Color.rgb(255, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 5, Color.rgb(255, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 5, Color.rgb(0, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 5, Color.rgb(0, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(30, 10, 50, 20, 10, 10, Color.rgb(255, 0, 0)),
                        new Car(30, 10, 50, 20, 10, 10, Color.rgb(0, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 10, Color.rgb(255, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 10, Color.rgb(255, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 10, Color.rgb(0, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 10, Color.rgb(0, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(30, 10, 50, 20, 10, 15, Color.rgb(255, 0, 0)),
                        new Car(30, 10, 50, 20, 10, 15, Color.rgb(0, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 15, Color.rgb(255, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 15, Color.rgb(255, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 15, Color.rgb(0, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 15, Color.rgb(0, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(10, 50, 150, 10, 20, 8, Color.rgb(255, 0, 0)),
                        new Car(10, 50, 150, 10, 20, 8, Color.rgb(0, 255, 0)),
                        new Car(10, 50, 150, 10, 20, 8, Color.rgb(0, 0, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(10, 50, 150, 10, 20, 10, Color.rgb(255, 0, 0)),
                        new Car(10, 50, 150, 10, 20, 10, Color.rgb(0, 255, 0)),
                        new Car(10, 50, 150, 10, 20, 10, Color.rgb(0, 0, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(10, 50, 150, 10, 20, 12, Color.rgb(255, 0, 0)),
                        new Car(10, 50, 150, 10, 20, 12, Color.rgb(0, 255, 0)),
                        new Car(10, 50, 150, 10, 20, 12, Color.rgb(0, 0, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(10, 50, 150, 10, 0, 12, Color.rgb(255, 0, 0)),
                        new Car(10, 50, 150, 10, 0, 12, Color.rgb(0, 255, 0)),
                        new Car(10, 50, 150, 10, 0, 12, Color.rgb(0, 0, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(30, 10, 50, 20, 10, 3, Color.rgb(106, 0, 255)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(179, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 77, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 238, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(0, 255, 26)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(0, 255, 255)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 0, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 106, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 255, 255)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(0, 0, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(17, 255, 0)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(0, 9, 255)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(255, 0, 111)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(0, 119, 255)),
                        new Car(30, 10, 50, 20, 10, 3, Color.rgb(128, 255, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 0, 0)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 255, 0)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 0, 255)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(0, 255, 0)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(0, 255, 255)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(0, 0, 255)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 119, 0)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 0, 123)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(255, 255, 255)),
                        new Car(10, 50, 150, 10, 20, 3, Color.rgb(0, 0, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(20, 10, 20, 10, 5, 3, Color.rgb(0, 255, 0)),
                        new Car(20, 10, 20, 10, 5, 3, Color.rgb(0, 255, 0)),
                        new Car(20, 10, 20, 10, 5, 3, Color.rgb(0, 255, 0)),
                        new Car(20, 10, 20, 10, 5, 3, Color.rgb(0, 255, 0)),
                        new Car(20, 10, 20, 10, 5, 3, Color.rgb(0, 255, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(20, 10, 20, 10, 5, 5, Color.rgb(255, 255, 255)),
                        new Car(20, 10, 20, 10, 5, 5, Color.rgb(255, 255, 255)),
                        new Car(20, 10, 20, 10, 5, 5, Color.rgb(255, 255, 255)),
                        new Car(20, 10, 20, 10, 5, 5, Color.rgb(255, 255, 255)),
                        new Car(20, 10, 20, 10, 5, 5, Color.rgb(255, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(20, 10, 20, 10, 5, 7, Color.rgb(255, 0, 0)),
                        new Car(20, 10, 20, 10, 5, 7, Color.rgb(255, 0, 0)),
                        new Car(20, 10, 20, 10, 5, 7, Color.rgb(255, 0, 0)),
                        new Car(20, 10, 20, 10, 5, 7, Color.rgb(255, 0, 0)),
                        new Car(20, 10, 20, 10, 5, 7, Color.rgb(255, 0, 0))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 255, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 255, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 0, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 255, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 0, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 255, 255)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(255, 255, 0)),
                        new Car(60, 20, 100, 30, 15, 10, Color.rgb(0, 255, 255))))));
                add(new Level(new ArrayList<>(Arrays.asList(new Car(2, 1, 2, 1, 2, 1, Color.rgb(255, 0, 0)),
                        new Car(2, 1, 2, 1, 2, 1, Color.rgb(255, 0, 0)),
                        new Car(2, 1, 2, 1, 2, 1, Color.rgb(255, 0, 0))))));
            }};
        showCars = new ArrayList<Car>() {{
            add(new Car(50, 20, 80, 30, 15, 0, Color.rgb(17, 255, 0)));
            add(new Car(50, 20, 80, 30, 15, 0, Color.rgb(255, 94, 0)));
            add(new Car(50, 20, 80, 30, 15, 0, Color.rgb(204, 0, 255)));
            add(new Car(50, 20, 80, 30, 15, 0, Color.rgb(247, 255, 0)));
        }};
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {e.printStackTrace();}
            retry = false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Constants.mousePressed = true;
                Constants.mouseX = event.getX();
                Constants.mouseY = event.getY();
        }
        return true;
    }
    public void update() {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(-1, -1, Constants.SCREEN_WIDTH + 1, Constants.SCREEN_HEIGHT + 1, paint);
        if(levels.get(level - 1).run(canvas) == 2) {
            level ++;
        } else if(levels.get(level - 1).run(canvas) == 1) {
            // Game over
        }
        Constants.mousePressed = false;
    }
}
