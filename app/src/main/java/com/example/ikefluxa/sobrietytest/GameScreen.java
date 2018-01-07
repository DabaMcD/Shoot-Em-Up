package com.example.ikefluxa.sobrietytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by Ike&Fluxa on 1/5/2018.
 */

public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private String page = "main page";
    private int mouseIsClicked;
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
    private Car test;
    public GameScreen(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        mouseIsClicked = 0;
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
        test = new Car(60, 20, 100, 30, 15, 10, Color.RED);
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

        }
        return true;
    }
    public void update() {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        test.move();
        test.reset();
        test.draw(canvas);
    }
}
