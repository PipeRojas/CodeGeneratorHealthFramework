package evaluators;

import java.util.ArrayList;

import edu.eci.prot.dsl2.dsl2.Entity;
import edu.eci.prot.dsl2.dsl2.Feature;
import edu.eci.prot.dsl2.dsl2.Type;

public class GeneralEvaluator {
	public static Boolean typeIsPrimitive(Type t) {
		Boolean ans=false;
		if((t.getName().equals("Byte")||t.getName().equals("Short")||t.getName().equals("Integer")||t.getName().equals("Long")||t.getName().equals("Float")||t.getName().equals("Double")||t.getName().equals("Char")||t.getName().equals("String")||t.getName().equals("Boolean")||t.getName().equals("Date"))){
			ans=true;
		}
		return ans;
	}
	public static Boolean entityIsEmbeddable(Entity e, ArrayList<Feature> pFeatures){
		Boolean ans=false;
		for (Feature feature : pFeatures) {
			if(e.getName().equals(feature.getType().getName())){
				ans=true;
				break;
			}
		}
		return ans;
	}
}
