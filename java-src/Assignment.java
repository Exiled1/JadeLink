public class Assignment {
	//assignment information
	String name;
	LearningTarget target;
	double[] grades;
	int num;
	boolean isBehavior; //1 is test, 2 is homework, 3 is behavior
	int weight;
	public Assignment(String na, int n, boolean t, int w) {//, LearningTarget t) {
		name = na;
		num = n;
		grades = new double[num];
		isBehavior = t;
		weight = w;
		
		//target = t;
	}
	//adding or changing a students grade on assigment
	//goes through every single student, search for name, and then change
	public void addGrade(int id, double grade) {
		for(int i=0;i<num;i++) {
			if(id == target.class1.students[i].id) {
				grades[i] = grade;
				target.class1.students[i].classgrade(target.class1.period-1);
				//target.class1.students[i].update();
				break;
			}
		}
	}
}