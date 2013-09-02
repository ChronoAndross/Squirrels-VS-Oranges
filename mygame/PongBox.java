/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
/**
 *
 * @author chewbacca
 */
public class PongBox extends Box
{
    Box pongBox;
    Geometry pongGeo;
    public PongBox(Vector3f newVector, int xCoord, int yCoord, int zCoord) 
    {
         pongBox = new Box(newVector, xCoord, yCoord, zCoord);
         pongGeo = new Geometry("Box", pongBox);
    }
    public Geometry getPongBox()
            {
                return pongGeo;
            }
}

