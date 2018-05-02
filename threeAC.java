package spcc ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import java.util.regex.Pattern;
public Class Temp {

String temp="";
}

class threeAC{
	public static final List<Temp> passes = new ArrayList<Temp>();
	public static int point  = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String input = br.readLine();
	
	

	precedence(input);

		}
		

private static void precedence(String input) {
		// TODO Auto-generated method stub
char[] ip = input.toCharArray();
	String rep = (input);
	List<Temp> list = new ArrayList<Temp>();
	int prior = 0,j = 0,k=0,min = 0,pos = 0,listpointer = 0,brk = 0;
	int  i = 2;
	for( ;i < ip.length ; i++) {
		prior = 0;
		//temp = i;
	
		list.add(new Temp());
	
		if(isop(ip[i])) {
			k = i;
			  min = getprecedence(ip[k]);
			
			  //k++;
			while(k < ip.length) {
				if(!isop(ip[k])) {
					k++;
					continue;
				}
					prior = getprecedence(ip[k]);
					
					if(prior==1){
						pos=k;
						min = prior;
						break;
					}
					if(prior==min) {
						
						pos = k;
					
					}
					
					if(prior < min) {
							min = prior;
							pos = k;
					}
					
					k++;
		}
			prior = min;
		
			
			i=pos;
			
		}
		
		if(prior==1) {
			
			 j = i;
			while(ip[j]!=')') {
				list.get(listpointer).temp+= ip[j];
			
				ip[j]=' ';
				brk++;
				j++;
			}
			list.get(listpointer).temp+=")";
			ip[j]=' ';
			brk++;
			i=2;
		}
		else if(prior==2) {
	
			if(ip[i-1]==' ' && ip[i+1]==' '){
				ip[i]=' ';
				brk++;
				continue;
			
			}
			if(ip[i]==' ' || ip[i+1]==' ' || ip[i-1]==' ') {
	
				brk--;
			}

			if(!isop(ip[i-1]) && ip[i-1]!=' ') {
			
			list.get(listpointer).temp+=ip[i-1];
			ip[i-1]=' ';
			}
			else {
				ip[i-1] =' ';
			}
			if((!isop(ip[i]) && ip[i]!=' ')  || (isop(ip[i]) && (ip[i-1]==' ' && ip[i+1]!=' '))) {
			list.get(listpointer).temp+=ip[i];
			ip[i]=' ';
			}
			else {
				ip[i] =' ';
			}
			if((!isop(ip[i+1]) && ip[i+1]!=' ')) {
				
			list.get(listpointer).temp+=ip[i+1];
			ip[i+1]=' ';
			}
			else {
				ip[i+1] =' ';
			}
			
			brk+=3;
			
		
			i=2;
		}
		else if(prior==3) {
		
			if(ip[i-1]==' ' && ip[i+1]==' '){
				ip[i]=' ';
				brk++;
				continue;
	}
			if(ip[i]==' ' || ip[i+1]==' ' || ip[i-1]==' ') {
				
				brk--;
			}
			

			if(!isop(ip[i-1]) && ip[i-1]!=' ') {
				
			list.get(listpointer).temp+=ip[i-1];
			ip[i-1]=' ';
			}
			else {
				ip[i-1] =' ';
			}
			if((!isop(ip[i]) && ip[i]!=' ' ) || (isop(ip[i]) && (ip[i-1]==' ' && ip[i+1]!=' '))) {
			
			list.get(listpointer).temp+=ip[i];
			ip[i]=' ';
			}
			else {
				ip[i] = ' ';
			}
			if((!isop(ip[i+1]) && ip[i+1]!=' ')) {
			list.get(listpointer).temp+=ip[i+1];
			ip[i+1]=' ';
			}
			else {
				ip[i+1] =' ';
			}
	
			brk+=3;
			
			i=2;
		}
		

		listpointer++;
		
		if(brk==ip.length-2) {
			
			break;
		}
		
		
		if(ip[i]==' '){

		continue;
		}
	

	}

	Iterator<Temp> il = list.iterator();
	while (il.hasNext())
	{
	    String s = il.next().temp;
	    if (s == null || s.isEmpty())
	    {
	        il.remove();
	    }
	}


	List<Temp> resul  = compute(list,rep);

	 }

	private static List<Temp> compute(List<Temp> list, String rep) {
		// TODO Auto-generated method stub
		
		int  i = 0;
		
		while(i < list.size()) {
		
				if(rep.contains(list.get(i).temp)) {
				
					passes.add(new Temp());
				
					passes.get(point).temp = (rep.replace(list.get(i).temp,String.valueOf(point)));

					System.out.println(point+": "+list.get(i).temp);
					rep = passes.get(point).temp;
					point++;
				}

			i++;
		}
		if(passes.get(passes.size()-1).temp.length()==3) {
			System.out.println("x="+(point-1));
			return passes;
		}
		else {
			precedence(passes.get(passes.size()-1).temp);
		}

		return null;
	}

	private static int getprecedence(char c) {
		// TODO Auto-generated method stub
		if(c=='(')
			return 1;
		else if(c=='*' ||  c=='/')
			return 2;
		else if(c=='+' || c=='-')
			return 3;
		return 0;
	}

	private static boolean isop(char c) {
		// TODO Auto-generated method stub
		
			if(c=='('|| c=='+' || c=='*' || c=='-' || c=='/')
				return true;
		
		return false;
	}

}

/* 
Input:
a=b+c*d
Any input of three AC
*/
