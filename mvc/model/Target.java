package _08final.mvc.model;

import java.awt.*;

/**
 * Created by Wen on 11/21/16.
 */
public class Target extends MovableAdapter{


    private static int RAD = 80;

   private int mExpiry;
   private Point mPoint;

    public Target(Point mPoint) {
//        this.mExpiry = mExpiry;
        this.mPoint = mPoint;

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.blue);

        //correct
        g.drawOval(mPoint.x - RAD, mPoint.y + RAD, RAD*2, RAD*2);
        g.drawLine(-RAD, mPoint.y, RAD, mPoint.y);
        g.drawLine(mPoint.x, RAD, mPoint.x, -RAD);

        CommandCenter.getInstance().getOpsList().enqueue(
               this, CollisionOp.Operation.REMOVE);


    }

//    @Override
//    public void move() {
//        if (mExpiry == 0){
//
//        }
//
//
//    }

    @Override
    public Team getTeam() {
        return Team.DEBRIS;
    }
}
