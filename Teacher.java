public class Teacher {
	String fname, lname;
	String password;
	Class [] classes;
	School school;
	public Teacher(String f, String l, School s, String pw) {
		classes = new Class[8];
		fname = f;
		lname = l;
		school = s;
		password = pw;
	}
	public void addGrade(int classid, String asname, int idid, int grade) {
		for(int i=0;i<8;i++) {
			if(classes[i].id == classid) {
				for(int j=0;j<classes[i].targets.size(); j++) {
					for(int k=0;k<classes[i].targets.get(j).assignments.size();k++) {
						if(classes[i].targets.get(j).assignments.get(k).name.equals(asname)) {
							for(int l=0;l<classes[i].num;l++) {
								if(classes[i].students[l].id == idid) {
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
