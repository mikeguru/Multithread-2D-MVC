package _08final.mvc.model;

import java.awt.*;
import java.util.ArrayList;


public class Shard extends Sprite {

    private final double FIRE_POWER = 20;
    private static final int FADE = 10;

    public Shard(Sprite sprite, int nOr){

        super();
        //friend will get a while loop, chain reaction
        setTeam(Team.DEBRIS);

        //defined the points on a cartesean grid
        ArrayList<Point> pnCs = new ArrayList<Point>();

        pnCs.add(new Point(1,0));
        pnCs.add(new Point(-1,0));

        assignPolarPoints(pnCs);

        setRadius(sprite.getRadius()/3);

        //a bullet expires after 20 frames
        setExpire(FADE);//originally 20


        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(nOr);

        //everything is relative to the falcon ship that fired the bullet
        setDeltaX( sprite.getDeltaX() +
                Math.cos( Math.toRadians(getOrientation() ) ) * FIRE_POWER );
        setDeltaY( sprite.getDeltaY() +
                Math.sin( Math.toRadians(getOrientation() ) ) * FIRE_POWER );
        setCenter( sprite.getCenter() );

        //System.out.println(sprite.getRadius()/3);

    }

    @Override
    public void move(){

        super.move();

        if (getExpire() == 0)
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        else
            setExpire(getExpire() - 1);

    }

}
