package edu.neu.csye6200;

public class ExplosionModel {
    public void blast(){
        Explosion ex = new Grenade();
        ex.explode();
        Explosion ey = new GunShot();
        ey.explode();
    }

}
