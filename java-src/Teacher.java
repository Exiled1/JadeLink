public class Teacher {
	//teacher's information
	String fname, lname;
	String password;
	StudentClass [] classes;
	School school;
	public Teacher(String f, String l, School s, String pw) {
		classes = new StudentClass[8];
		fname = f;
		lname = l;
		school = s;
		password = pw;
	}
	//adding a grade to a student
	public void addGrade(int classid, String asname, int idid, int grade) {
		//goes through all the periods
		for(int i=0;i<8;i++) {
			if(classes[i].id == classid) {
				//goes through all the periods
				for(int j=0;j<classes[i].targets.size();j++) {
					//going through all the assignments
					for(int k=0;k<classes[i].targets.get(j).assignments.size();k++) {
						if(classes[i].targets.get(j).assignments.get(k).name.equals(asname)) {
							//going through all the students
							for(int l=0;l<classes[i].num;l++) {
								if(classes[i].students[l].id == idid) {
									//change grade
									classes[i].targets.get(j).assignments.get(k).grades[l] = grade;
									break;
								}
							}
							break;
						}
					}
				}
				break;
			}
		}
	}
}
