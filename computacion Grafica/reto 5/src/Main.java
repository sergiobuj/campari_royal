/**
 * mioooooooooooooooo
 */
import javax.vecmath.*;

/**
 * @author htrefftz
 *
 */
public class Main {
	int		size = 300;
	Group group = null;
	Image	image = null;
	Camera	camera = null;
	
	/**
	 * The objects of the scene are created here
	 */
	public void createScene() {
		// Create a red sphere
		Sphere s1 = new Sphere(new Point3d(0.5d, 0.5d, -0.5d), 0.3d, 
							   new Color3f(1f, 0f, 0f));	
		// Create a blue sphere
		Sphere s2 = new Sphere(new Point3d(0.1d, 0.5d, -1.5d), 0.3d, 
							   new Color3f(0f, 0f, 1f));	
		// Now create a group
		group = new Group();
		group.add(s1);
		group.add(s2);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.createScene();
		
		m.image = new Image(m.size, m.size);
		m.camera = new OrtographicCamera(1d);
		//DONE!!!
		// ToDo: For each pixel in the image,
		// ask the camera to cast a ray
		// then find if there are intersections of89 the
		// ray with all objects in the scene
		// Set the color of the image when necessary
		
		double dx = 1d/(m.size-1);/*incrementos*/
		double dy = 1d/(m.size-1);
		for (int x = 0; x < m.size; x++) {
			for (int y = 0; y < m.size; y++) {
				//...
				Ray ray=m.camera.generateRay(new Point2d(x*dx,y*dy)); // generar el rayo en cada punto de la imágen
				Hit hit=new Hit();// tiro el rayo a pegar
				if( m.group.intersect(ray,hit,new TValue())){
					m.image.setColor(x,y, hit.getColor() ); //si pega con algo, tome el color donde cayó	
				} 				// y péguelo  en la imágen...
				
			}
		}
		
		
		//DONE!!!!!!
		// ToDo: Write the image at the end
		// ...
		m.image.writeImage();
	}
	
}
