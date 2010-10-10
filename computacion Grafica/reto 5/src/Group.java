import java.util.Vector;

public class Group extends Object3D {
	Vector<Object3D> vector = null;
	
	public Group() {
		vector = new Vector<Object3D>();
	}
	
	public void add(Object3D o3D) {
		vector.add(o3D);
	}
	
	boolean intersect(Ray r, Hit h, TValue tMin) {
		//DONE!!!
		// ToDo:
		// Iterate over the array of objects,
		// finding the intersections
		boolean retVal = false;
		for(Object3D i : vector)
			if(i.intersect(r,h,tMin))
				retVal=true;
		
		// ...
		return retVal;
	}

}
