package spcc;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class firstandfollow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		
	int n = sc.nextInt();
	
	String str[] = new String[n];
	
	List<List<Character>> first = new ArrayList<>();
	
	for(int i = 0; i < n ; i++) {
		str[i] = sc.next();
	}
	
	List<List<Character>> list = new ArrayList<>();
	List<List<Character>> follow = new ArrayList<>();
	//System.out.println(str[1]);
	
	for(int i = 0; i < n ; i++) {
		
		list.add(new ArrayList<Character>());
		first.add(new ArrayList<Character>());
		
	}
	
	for(int  i = 0; i< n ; i++) {
		//List<Character> chars = str.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		list.get(i).addAll(str[i].chars().mapToObj(e->(char)e).collect(Collectors.toList()));
	}
	
	System.out.println(list);
	List<List<Character>> firstfinal = calcfirst(list,first,n);
	System.out.println("First "+firstfinal);
	for(int i = 0; i < n ; i++) {
		follow.add(new ArrayList<Character>());
	}
	List<List<Character>> followfinal = calcfollow(first,list,n,follow);
	System.out.println("Follow "+followfinal);
	
	//System.out.println(firstfinal);
	
	System.out.println(follow);
	
	}

	private static List<List<Character>> calcfollow(List<List<Character>> first, List<List<Character>> list, int n,
			List<List<Character>> follow) {
		// TODO Auto-generated method stub
		int next = 0,i = 0,temp = 0,point = 0;
		follow.get(0).add('$');
		for(int  k = 0 ;k < n; k++) {
			//System.out.println(firstfinal);
			System.out.println("kkkkkk "+k);
			for( next = 0 ; next < n ; next++) {
			
		for(  i = 3 ;i < list.get(next).size(); i++) {
						//search++;
							//next=search;
				System.out.println(next);
				System.out.println(list.get(k).get(0));
				System.out.println("k ka value "+k);
				System.out.println("i ka value "+i);
				//System.out.print(list.get(next).get(i));
				if((list.get(k).get(0).equals(list.get(next).get(i)))) {
					System.out.println("mila");
				//	System.out.println(firstfinal);
					temp = i+1 ;
					System.out.println("next ka val "+next);
					if(temp == list.get(next).size()) {
						follow.get(k).addAll(follow.get(next));
						System.out.println(follow);
					}
					
					//
					else {
				for(point  = 0;point < list.size() && temp < list.get(next).size();point++) {
					System.out.println("list pointer vala " +list.get(next).get(temp));
					if(list.get(next).get(temp).equals(list.get(point).get(0)) || (list.get(next).get(temp)>='a' && list.get(next).get(temp)<='z')) {
						//temp++;
						if(temp == list.get(next).size()-1) {
							if(list.get(next).get(temp)>='A' && list.get(next).get(temp)<='Z' && first.get(point).contains('e'))
									follow.get(k).addAll(follow.get(next));
							else if(list.get(next).get(temp)>='a' && list.get(next).get(temp)<='z'){
								follow.get(k).add(list.get(next).get(temp));
							}
							//break;
						}
					System.out.println(first.get(point));
					if(list.get(next).get(temp)>='A' && list.get(next).get(temp)<='Z')
						follow.get(k).addAll(first.get(point));
						
						if(follow.get(k).contains('e')) {
							follow.get(k).remove(follow.get(k).indexOf('e'));
							System.out.println("gaya");
							System.out.println(follow);
							temp++;
							//point++;
							
						}
						
						else {
							break;
						}
					}
				
					}
				//System.out.println("signal");
				System.out.println(follow);
				}
				}


			}
			}
			
		}

		//System.out.println(follow);


		return follow;
	}

	private static List<List<Character>> calcfirst(List<List<Character>> list, List<List<Character>> first, int n) {
		// TODO Auto-generated method stub
		int  i = 0,m = 0;
		for(int  k = 0 ; k < n ; k++) {
			System.out.println(k);
			boolean one = false;
		label:	for( i = 3,m = k + 1 ; i < list.get(k).size();i++,m++) {
				
				//System.out.println(list.get(k+1));
				System.out.println(i);
				
				System.out.println("kkkkkkkkkkkkkkkkkkk "+k);
				
				if((list.get(k).get(i) >= 'a' && list.get(k).get(i) <='z') && !list.get(k).contains('|')) {
					first.get(k).add(list.get(k).get(i));
					System.out.println("break ho nahh||||");
					break;
				}
				
				
				 if(m  < n && (list.get(k).get(i).equals(list.get(m).get(0)))) {
							System.out.println(list.get(m));
								System.out.println("hua");
							
								
								first.get(k).add((list.get(m).get(3)));
								
								if(list.get(m).contains('|')) {
							
						for(int  j = 4;j < list.get(m).size() ; j++) {
								
									
					
						if(list.get(m).get(j).equals('|')) {
							continue;
						}
						else {
							if((list.get(m).get(j)>='A' && list.get(m).get(j)<='Z') || (first.get(k).contains('e') && list.get(m).get(j).equals('e')) ) {
								continue;
							}
							else {
								
				first.get(k).add((list.get(m).get(j)));
								
				System.out.println(first);
							}
				//System.out.println(first);
						}
				//	}
					
				}
								}
								else if(list.get(m).size()==4) {
									if(first.get(k).contains('e')) {
										int ind = 	first.get(k).indexOf('e');
										first.get(k).remove(ind);
									}
									break label;
								}
			}
						else {
							
							System.out.println("else chalu");
							System.out.println("k ka val" + k);
							System.out.println(list.get(k));
							//for(int j = 3 ; j < list.get(k).size(); j++) {
								System.out.println(i);
							if(list.get(k).get(i).equals('|') || (list.get(k).get(i)>='A' && list.get(k).get(i)<='Z')) {
								System.out.println(first);
								if(list.get(k).get(i).equals('|')) {
									one = true;
								}
							continue;
							}
							
							else {
								System.out.println("gussa");
								
								if(first.get(k).contains(list.get(k).get(3)) || !one) {
									continue;
								}
								else {
								first.get(k).add(list.get(k).get(3));
								}
								System.out.println(first);
										if(one) {
											System.out.println("mein gaya");
											first.get(k).add(list.get(k).get(i));
											break label;
										}
								//continue;
							}
							//}
						}
						
				
						System.out.println("khatam");
		}
		}
		
		//System.out.println("First finally hua "+ first);
		return first;
	}

}
