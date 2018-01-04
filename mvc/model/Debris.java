package _08final.mvc.model;

//EXTRA ADD
import _08final.mvc.controller.Game;

import java.awt.*;

/**
 * Created by Wen on 11/21/16.
 */

public class Debris extends MovableAdapter {

    private int mExpiry;
    private Point mPoint;

    public Debris(int mEmpiry, Point mPoint) {
        this.mExpiry = mEmpiry;
        this.mPoint = mPoint;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(

                Game.R.nextInt(256),
                Game.R.nextInt(256),
                Game.R.nextInt(256)
        ));
        g.fillOval(mPoint.x, mPoint.y, mExpiry, mExpiry);

    }

    @Override
    public void move() {
        if (mExpiry == 0){
            CommandCenter.getInstance().getOpsList()
                    .enqueue(this, CollisionOp.Operation.REMOVE);
        } else {
            mExpiry--;
        }
    }

    //collission detection.

    @Override
    public Team getTeam() {
        return Team.DEBRIS;
    }
}