package com.shoot.em.up;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    static final int MAX_FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GameScreen gameScreen;
    private boolean running;
    static Canvas canvas;

    void setRunning(boolean running) {
        this.running = running;
    }

    MainThread(SurfaceHolder surfaceHolder, GameScreen gameScreen) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameScreen = gameScreen;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;
        while(running) {
            startTime = System.nanoTime();
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameScreen.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {e.printStackTrace();}
                }
            }
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;
            try {
                if(waitTime < 0) {
                    this.sleep(waitTime);
                }
            } catch (Exception e) {e.printStackTrace();}
            totalTime += System.nanoTime() - startTime;
            frameCount ++;
            if(frameCount == MAX_FPS) {
                averageFPS = (totalTime / frameCount) / 1000;
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }
}
