package com.example.ikefluxa.sobrietytest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Ike&Fluxa on 1/5/2018.
 */

public class Car {
    private int lengthUpper;
    private int heightUpper;
    private int lengthLower;
    private int heightLower;
    private int wheelRad;
    public float speed;
    private int colour;
    private float x; // Middle of car
    private float y; // Middle of wheels, bottom of lower rect
    public int timesPassed;
    public int alive;
    public Car(int lengthUpper, int heightUpper, int lengthLower, int heightLower, int wheelRad, int speed, int colour) {
        if(lengthUpper > lengthLower){
            lengthUpper = lengthLower;
        }
        this.lengthUpper = lengthUpper * 2; // Upper length
        this.heightUpper = heightUpper * 2; // Upper height
        this.lengthLower = lengthLower * 2; // Lower length
        this.heightLower = heightLower * 2; // Lower height
        this.wheelRad = wheelRad * 2; // Wheel radius
        this.speed = speed * 2; // Speed
        this.colour = colour; // Color
        this.y = (float) (Math.random() * 490 - this.wheelRad + 10 + this.heightLower + this.heightUpper + 45); // Y-coordinate
        this.x = (float) (Math.random() * -600 - 200); // X-coordinate
        this.timesPassed = 0; // Number of times gone across canvas
        this.alive = 1; // Whether car has been shot or not
    }
    public Boolean hit(int mouseX, int mouseY) {
        if((mouseX < x + lengthLower / 2 && mouseX > x - lengthLower / 2 && mouseY < y && mouseY > y - heightLower) || (mouseX < x + lengthUpper / 2 && mouseX > x - lengthUpper / 2 && mouseY < y - heightLower&&mouseY > y - heightLower - heightUpper)){
            return true;
        }
        return false;
    }
    public Boolean pop(int mouseX, int mouseY) {
        if((Constants.getDist(x + (lengthLower / 4), y, mouseX, mouseY) < wheelRad) || (Constants.getDist(x + (lengthLower / 4), y, mouseX, mouseY) < wheelRad)){
            return true;
        }
        return false;
    }
    public void move() {
        x += speed;
    }
    public void reset() {
        if(x > Constants.SCREEN_WIDTH + Math.max(lengthLower / 2, (lengthLower / 4) + wheelRad / 2)) {
            x = -(Math.max(lengthLower / 2, (lengthLower / 4) + wheelRad / 2));
            this.y = (float) (Math.random() * 490 - this.wheelRad + 10 + this.heightLower + this.heightUpper + 45); // Y-coordinate
        }
    }
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(0);
        paint.setColor(colour);
        canvas.drawRect(x - (lengthUpper/2), y-heightLower, x + lengthUpper / 2, y - heightUpper - heightUpper, paint);
        canvas.drawRect(x - (lengthLower/2), y, x + lengthLower / 2, y - heightLower, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x - (lengthLower/4), y, wheelRad*2, paint);
        canvas.drawCircle(x + (lengthLower/4), y, wheelRad*2, paint);
        paint.setColor(Color.rgb(0, 0, 255));
    }
}
