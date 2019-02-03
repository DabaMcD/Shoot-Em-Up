package com.shoot.em.up;

class Constants {
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    static Boolean mousePressed;
    static float mouseX;
    static float mouseY;
    static double getDist(float x1, float y1, float x2, float y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
