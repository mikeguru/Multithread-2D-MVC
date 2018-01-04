package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;

public class Ufobullet extends Sprite {

    private final double FIRE_POWER = 30;

    private int nSpin;

    public  Ufobullet (Ufo ufo) {

        super();
        setTeam(Team.FOE);
        ArrayList<Point> pntCs = new ArrayList<Point>();
        // top of ship
        pntCs.add(new Point(0, 3));
        pntCs.add(new Point(1,-1));
        pntCs.add(new Point(0,-2));
        pntCs.add(new Point(-1,-1));

        assignPolarPoints(pntCs);

        setExpire(20);
        setRadius(6);
        setColor(ufo.getColor());

        int nOrRandom= Game.R.nextInt(360);

        //everything is relative to the falcon ship that fired the bullet
        setDeltaX( ufo.getDeltaX() +
                Math.cos( Math.toRadians(nOrRandom ) ) * FIRE_POWER );
        setDeltaY( ufo.getDeltaY() +
                Math.sin( Math.toRadians(nOrRandom) ) * FIRE_POWER );
        setCenter( ufo.getCenter() );

    }

    @Override
    public void move() {
        super.move();
        //adding expire functionality
        if (getExpire() == 0)
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);

        else {
            setExpire(getExpire()-1);

        }
    }

}
