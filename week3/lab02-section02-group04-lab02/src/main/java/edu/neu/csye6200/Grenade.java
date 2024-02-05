package edu.neu.csye6200;

public class Grenade extends Explosion {
    //explode method for concrete class Explosion
    @Override
    public void explode(){
        System.out.println("Grenade is ongoing -----> ###KABOOOM###");
    }
}