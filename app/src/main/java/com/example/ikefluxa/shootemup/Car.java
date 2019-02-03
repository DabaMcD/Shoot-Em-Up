package com.example.ikefluxa.shootemup;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Car {
    private int lengthUpper;
    private int heightUpper;
    private int lengthLower;
    private int heightLower;
    private int wheelRad;
    float speed;
    private int colour;
    private float x; // Middle of car
    private float y; // Middle of wheels, bottom of lower rect
    private int timesPassed;
    int alive;
    Car(int lengthUpper, int heightUpper, int lengthLower, int heightLower, int wheelRad, int speed, int colour) {
        if(lengthUpper > lengthLower){
            lengthUpper = lengthLower;
        }
        this.lengthUpper = lengthUpper * 2; // Upper length
        this.heightUpper = heightUpper * 2; // Upper height
        this.lengthLower = lengthLower * 2; // Lower length
        this.heightLower = heightLower * 2; // Lower height
        this.wheelRad = wheelRad; // Wheel radius
        this.speed = speed * 2; // Speed
        this.colour = colour; // Color
        this.y = (float) (Math.random() * 490 - this.wheelRad + 10 + this.heightLower + this.heightUpper + 45); // Y-coordinate
        this.x = (float) (Math.random() * -600 - 200); // X-coordinate
        this.timesPassed = 0; // Number of times gone across canvas
        this.alive = 1; // Whether car has been shot or not
    }
    Boolean hit(float mouseX, float mouseY) {
        return (mouseX < x + lengthLower / 2 && mouseX > x - lengthLower / 2 && mouseY < y && mouseY > y - heightLower) || (mouseX < x + lengthUpper / 2 && mouseX > x - lengthUpper / 2 && mouseY < y - heightLower&&mouseY > y - heightLower - heightUpper);
    }
    Boolean pop(float mouseX, float mouseY) {
        return (Constants.getDist(x + (lengthLower / 4f), y, mouseX, mouseY) < wheelRad) || (Constants.getDist(x + (lengthLower / 4f), y, mouseX, mouseY) < wheelRad);
    }
    void move() {
        x += speed;
    }
    void reset() {
        if(x > Constants.SCREEN_WIDTH + Math.max(lengthLower / 2, (lengthLower / 4) + wheelRad / 2)) {
            x = -(Math.max(lengthLower / 2, (lengthLower / 4) + wheelRad / 2));
            y = (float) (Math.random() * 490 - this.wheelRad + 10 + this.heightLower + this.heightUpper + 45); // Y-coordinate
            timesPassed ++;
        }
    }
    void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(0);
        paint.setColor(colour);
        canvas.drawRect(x - (lengthUpper / 2f), y-heightLower, x + lengthUpper / 2f, y - heightUpper - heightUpper, paint);
        canvas.drawRect(x - (lengthLower / 2f), y, x + lengthLower / 2f, y - heightLower, paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x - (lengthLower / 4f), y, wheelRad*2, paint);
        canvas.drawCircle(x + (lengthLower / 4f), y, wheelRad*2, paint);
        paint.setColor(Color.rgb(0, 0, 255));
        paint.setTextSize(Constants.SCREEN_WIDTH / 20f);
        canvas.drawText(String.valueOf(timesPassed), x, y - heightLower - heightUpper-15, paint);
    }
}
