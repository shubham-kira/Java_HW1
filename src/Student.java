class Student {
	String id;
	int ex;
	int as[] = new int[10];
	int mi;
	int fin;
	int cl;

	public int assignmentSum() {
		int s, i;
		for (s = 0, i = 0; i < 10; i++)
			s += as[i];
		return s;
	}

	public int totalSum() {
		int s = assignmentSum(), ts = 0;
		ts += s + ex + mi + fin + cl;
		return ts;
	}

	public char grade(int p) {
		if (p >= 90)
			return 'A';
		else if (p >= 78)
			return 'B';
		else if (p >= 62)
			return 'C';
		else if (p >= 46)
			return 'D';
		else
			return 'F';
	}
}