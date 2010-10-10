import javax.vecmath.*;

public class Sphere extends Object3D {
	private Point3d center = null;
	private double radius = 1d;
	private Color3f color = null;
	boolean DEBUG = false;

	public Sphere() {
		this.center = new Point3d();
		this.radius = 1d;
		this.color = new Color3f(1f, 1f, 1f);
	}
	
	public Sphere(Point3d center, double radius, Color3f color) {
		super();
		this.center = center;
		this.radius = radius;
		this.color  = color;
	}

	boolean intersect(Ray r, Hit h, TValue tMin) {
		// ToDo:
		// Compute the intersection of the ray with the
		// Sphere and update what needs to be updated
		//método algebraico para intersección - http://devmaster.net/wiki/Ray-sphere_intersection -
		boolean retVal = false;
		// ... se toma el rayo y se evalúa si llega a tocar la esfera
		Vector3d ray= new Vector3d(r.getOrigin().x,r.getOrigin().y,r.getOrigin().z); ray.sub(center);
		double A = r.getDirection().dot(r.getDirection());
		double B = 2*ray.dot(r.getDirection());
		double C = ray.dot(ray)-(radius*radius);
		if( B*B-4*A*C >= 0.0 ){//raiz real
			double bach = ( -B + Math.sqrt( B*B-4*A*C ))/(2*A) ; 
			if( bach > 0  &&  bach < tMin.getT() ){
				tMin.setT(bach);// la nueva 't' es donde pega
                h.setT(bach); // nueva t del hit
                h.setColor(color);//color de la esfera
			}
			retVal =true;
		}
		
		
		return retVal;
	}
}
