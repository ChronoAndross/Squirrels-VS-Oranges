package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.*;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.math.Quaternion;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.Camera;
import com.jme3.math.ColorRGBA;


/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    PongSphere enemy1;
    PongSphere enemy2;
    int orangeCount;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        
        PongBox platform = new PongBox(Vector3f.ZERO, 5, 5, 5);
       
        enemy1 = new PongSphere("orange1", 8, 16, (float)1.5);
        enemy2 = new PongSphere("orange2", 8, 16, (float)1.5);
        orangeCount = 2;
        
        // set brick texture
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setTexture("ColorMap", assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        
        // create orange color
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Orange);
        
        Quaternion roll90 = new Quaternion(); 
        roll90.fromAngleAxis( (float)Math.PI / 4 , new Vector3f(0,1,0) ); 

        // set texture to the platform object and tilt it
        platform.getPongBox().setMaterial(mat1);
        platform.getPongBox().move(-8.0f, 0f, -20f);
        platform.getPongBox().setLocalRotation(roll90);
        
        // set orange color to first enemy
        enemy1.getPongSphere().setMaterial(mat2);
        enemy1.getPongSphere().move(-8.0f, 6f, -20f);
        
        // set orange color to second enemy
        enemy2.getPongSphere().setMaterial(mat2);
        enemy2.getPongSphere().move(-4.0f, 6f, -15f);
        
        // instantiate camera
        Camera cam = new Camera(10,10);
        cam.setFrustumTop(5f);
        cam.update();
        
        // attach all parts
        rootNode.attachChild(platform.getPongBox());
        rootNode.attachChild(enemy1.getPongSphere());
        rootNode.attachChild(enemy2.getPongSphere());
        
        AmbientLight sun = new AmbientLight();
        rootNode.addLight(sun);
        
    }

    @Override
    // moves the oranges; cannot see why they cannot move; we have to work on this
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        // negative movement
       enemy1.getPongSphere().move(-0.01f, 0, -0.02f);
       enemy2.getPongSphere().move(-0.02f, 0, -0.01f);
       // positive movement
       enemy1.getPongSphere().move(0.01f, 0, 0.02f);
       enemy2.getPongSphere().move(0.02f, 0, 0.01f);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
