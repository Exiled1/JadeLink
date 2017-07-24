import java.util.ArrayList;

public class LearningTarget {
	String name, description;
	ArrayList<Assignment> assignments;
	double[] grades;
	public LearningTarget(int num) {
		grades = new double[num];
		assignments = new ArrayList<Assignment>();
	}
	public void average() {
		for(int i=0;i<assignments.size();i++) {
			for(int j=0;j<grades.length;j++) {
				grades[j]+=assignments.get(i).grades[j];
			}
		}
		for(int i=0;i<grades.length;i++) {
			grades[i]/=assignments.size();
		}
	}
}
