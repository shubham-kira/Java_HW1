import java.util.*;
import java.io.*;

public class CSX_358_HW1_16103080 {
	public static void main(String args[]) throws IOException, FileNotFoundException {

		File filei = new File("input.txt");
		File fileo = new File("output.txt");

		Scanner sc = new Scanner(filei);
		Writer wr = new FileWriter(fileo);

		wr.write("StdentID  EX  ----------Assignments--------  TOT  MI  Fin  CL  PTS  PCT  GR\n");
		wr.write("--------  50  20 20 20 20 20 20 20 20 20 20  200  70  100  10  420  ---  --\r\n\r\n");

		String s = "";
		int pmax = 0, st = 0, avgper = 0;
		int g[] = new int[5];

		while (sc.hasNextLine()) {
			Student obj = new Student();
			s = sc.nextLine();
			String[] tokens = s.split("\\s+");
			int c = 0;

			obj.id = tokens[c++];
			obj.ex = Integer.parseInt(tokens[c++]);
			for (int i = 0; c < 12; c++, i++)
				obj.as[i] = Integer.parseInt(tokens[c]);
			obj.mi = Integer.parseInt(tokens[c++]);
			obj.fin = Integer.parseInt(tokens[c++]);
			obj.cl = Integer.parseInt(tokens[c++]);

			int asum = obj.assignmentSum();
			int tsum = obj.totalSum();
			if (pmax < tsum)
				pmax = tsum;
			float p = (float) tsum / (float) (4.2);
			int per = Math.round(p);
			avgper += per;
			char gr = obj.grade(per);
			g[gr - 'A']++;
			st++;

			wr.write(obj.id + "  " + String.format("%2d", per) + "  ");
			for (int i = 0; i < 10; i++)
				wr.write(String.format("%2d", new Integer(obj.as[i])) + " ");
			wr.write(" " + String.format("%3d", asum) + "  ");
			wr.write(String.format("%2d", obj.mi) + "  " + String.format("%3d", obj.fin) + "  ");
			wr.write(String.format("%2d", obj.cl) + "  " + String.format("%3d", tsum) + "  ");
			wr.write(String.format("%3d", per) + "  " + String.format("%2c", gr));
			wr.write("\r\n");
		}
		
		wr.write("\n\n");
		wr.write("Total Number of Students: " + st + "\n");
		wr.write("Average Total Point Percentage: " + avgper / st + "\n\n");
		wr.write("Number of A's: " + g[0] + "\r\n");
		wr.write("Number of B's: " + g[1] + "\r\n");
		wr.write("Number of C's: " + g[2] + "\r\n");
		wr.write("Number of D's: " + g[3] + "\r\n");
		wr.write("Number of F's: " + g[4] + "\r\n\r\n");
		wr.write("Maximum Points: " + pmax + "\r\n");
		sc.close();
		wr.close();
	}

}