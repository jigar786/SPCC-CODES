package spcc;

import java.util.*;
import java.io.*;

//import org.apache.commons.lang.StringUtils;
public class macro {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\jigar\\Desktop\\a.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String s;

		String str = "";
		String ss = "";
		int cnt = 0;
		while ((s = br.readLine()) != null) {
			if(s.contains("macro")) {
				cnt++;
			}
			str += s;
			str += " ";
			
		}
		
		
	
		StringBuilder sb1 = new StringBuilder(str);
		for(int  k = 0 ; k < cnt ; k++) {

		String words[] = str.split("mend");
		
		String start[] = words[0].split("macro");
		
		String mnemonics = start[1];
		String ais = "";
		String ip[] = mnemonics.split(" ");
		
		for (int i = 0; i < ip.length; i++) {
			if (ip[i].equals("load") || ip[i].equals("store")) {
				
				i--;

				System.out.println("mila");
				try {
					while (ip[i++] != null) {
						ais += ip[i];
						System.out.println(ais);
						
					}
				} catch (Exception e) {
					
				}
			
				break;
				
			}
			else {
				ss+=ip[i];
			}
		}
		String ip2[] = ais.split("[0-9]");
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < ip2.length; i++) {
			list.add(new ArrayList<String>());
			if (ip2[i].contains("load")) {
				list.get(i).add(ip2[i].substring(0, 4) + " " + ip2[i].substring(4) + (i + 1));
				
				
			}
			if (ip2[i].contains("add")) {
				list.get(i).add(ip2[i].substring(0, 3) + " " + ip2[i].substring(3) + (i + 1));
				
				
			}
			if (ip2[i].contains("store")) {
				list.get(i).add(ip2[i].substring(0, 5) + " " + ip2[i].substring(5) + (i + 1));
				
				
			}
			if (ip2[i].contains("sub")) {
				list.get(i).add(ip2[i].substring(0, 3) + " " + ip2[i].substring(3) + (i + 1));
				
				
			}

		}
		
		StringBuilder sb = new StringBuilder(ss);
		
		sb.insert(2, ' ');
		
		
		File op = new File("C:\\\\Users\\\\jigar\\\\Desktop\\\\op.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(op, true));
		writer.write(k+"\t"+String.valueOf(sb) + System.lineSeparator());
		for (int i = 0; i < list.size(); i++) {
			writer.write("\t"+list.get(i).get(0) + System.lineSeparator());
			
		}
		writer.write("\t"+"mend"+"\n");
		writer.close();
		
		
		
		sb1.delete(0, str.indexOf("mend")+6);


		//2nd MNT   
		File op1 = new File("C:\\\\Users\\\\jigar\\\\Desktop\\\\op1.txt");
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(op1, true));
		
			writer1.write((k+1)+"\t"+str.substring(6, 8)+"\t"+(k+1) + System.lineSeparator());
			
		writer1.write("\n");
		writer1.close();
		
		//3rd prev ALA
		File op2 = new File("C:\\\\Users\\\\jigar\\\\Desktop\\\\op2.txt");
		BufferedWriter writer2 = new BufferedWriter(new FileWriter(op2, true));

			writer2.write((k+1)+"\t"+ss.substring(2)+System.lineSeparator());
		
		writer2.write("\n");
		writer2.close();

		str = sb1.toString(); //Remind me
		ss="";  //Remind me

		}
		
		File op3 = new File("C:\\\\Users\\\\jigar\\\\Desktop\\\\op3.txt");
		BufferedWriter writer3 = new BufferedWriter(new FileWriter(op3, true));

		int ml = 0;
		while(str.contains("  ")) {
			
		String ipl[] = str.split("  ");
		str = ipl[1];
		
	
			writer3.write((ml+1)+"\t"+ipl[0] + System.lineSeparator());
			ml++;
			
		}
		writer3.write((ml+1)+"\t"+str+System.lineSeparator());
		writer3.write("\n");
		writer3.close();
		
	}

}


/* 
Input:
macro m1 &arg1, &arg2, &arg3
load A,&arg1
add B,&arg2
store C,&arg3
mend

macro m2 &arg1, &arg2, &arg3
store A,&arg1
add B,&arg2
sub C,&arg3
mend

m1 2,3,4

m2 A1,A2,A3
 */
