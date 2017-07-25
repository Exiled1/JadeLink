public class Assignment {
	String name;
	LearningTarget target;
	double[] grades;
	int num;
	public Assignment(String na,int n) {
		name = na;
		num = n;
		grades = new double[num];
	}
	public void addGrade(int id, double grade) {
		for(int i=0;i<num;i++) {
			if(id == target.class1.students[i].id) {
				grades[i] = grade;
				target.class1.students[i].classgrade(target.class1.period-1);
				target.class1.students[i].update();
			}
		}
	}
}