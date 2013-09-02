/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author chewbacca
 * abstracts the geometries and sphere classes into one class
 */
public class PongSphere extends Sphere
{
    Sphere pongSphere;
    Geometry ballGeo;
    private int lives = 3;
    private int steps = 0;
    
    // constructor for sphere being used
    // inputs: s - string used for indicating the name of the sphere
    //         z - the amount of depth for sphere (check doc for that) (must be obtained through 2^x)
    //         samples - the amount of vertices used for the sphere (must be obtained through 2^x)
    //         radius - radius of sphere
    public PongSphere(String s, int z, int samples, float radius) 
    {
         pongSphere = new Sphere(z, samples, (float)radius,false, false);
         ballGeo = new Geometry("Sphere", pongSphere);
    }
   
    // returns the geometry of the sphere; use to obtain the shape used in the game
    // output: ballGeo - geometry of sphere created
    public Geometry getPongSphere()
            {
                return ballGeo;
            }    
    // adds a life for the oranges; used for creating moer difficult enemies
    public void addLife()
    {
        lives++;
    }
    // subtracts a life from an orange
    public void loseLife()
    {
        lives--;
    }
    // gets the amount of lives left for the orange
    public int getLife()
    {
        return lives;
    }
}