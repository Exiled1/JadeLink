import java.util.ArrayList;
import java.util.Arrays;

public class LearningTarget {
	//learning target information
	Class class1;
	String name, description;
	ArrayList<Assignment> assignments;
	double[] grades;
	
	public LearningTarget(String n, int num) {
		name = n;
		grades = new double[num];
		assignments = new ArrayList<Assignment>();
	}
	
	//computing students grade for the learning target
	public void average() {
		int sumOfWeights = 0;
		Arrays.fill(grades, 0);
		for(int i=0;i<assignments.size();i++) {
			for(int j=0;j<grades.length;j++) {
				grades[j]+=assignments.get(i).grades[j] * assignments.get(i).weight;
			}
			sumOfWeights += assignments.get(i).weight;
		}
		for(int i=0;i<grades.length;i++) {
			grades[i]/=sumOfWeights;
		}
	}
}
