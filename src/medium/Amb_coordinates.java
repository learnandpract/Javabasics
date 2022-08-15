package medium;

import java.util.ArrayList;
import java.util.List;

public class Amb_coordinates {
	
public List<String> ambiguousCoordinates_trial(String s) {//816
//	Input: s = "(123)"
//    Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
	List ans = new ArrayList();
	List result = new ArrayList();
	result = checkforcoord(s,ans);
	
	return result;
        
    }
public List checkforcoord(String s,List ans) {
	
	List ans1 = new ArrayList();
	for(int i =0; i<s.length();i++) {
		
	}
	
	return ans1;
	
}

public List<String> ambiguousCoordinates(String S) { //816
    int n = S.length();
    List<String> res = new ArrayList();
    for (int i = 1; i < n - 2; ++i) {
        List<String> A = form(S.substring(1, i + 1));
        List<String> B = form(S.substring(i + 1, n - 1));
        for (String a : A) 
        	for (String b : B)
        		res.add("(" + a + ", " + b + ")");
    }
    return res;
}
public List<String> form(String S) {
    int n = S.length();
    List<String> res = new ArrayList();
    if (n == 0 || (n > 1 && S.charAt(0) == '0' && S.charAt(n - 1) == '0')) 
    	return res;
    if (n > 1 && S.charAt(0) == '0') {
        res.add("0." + S.substring(1));
        return res;
    }
    res.add(S);
    if (n == 1 || S.charAt(n - 1) == '0') 
    	return res;
    for (int i = 1; i < n; ++i)
    	res.add(S.substring(0, i) + '.' + S.substring(i));
    return res;
}


	public static void main(String[] args) {
		Amb_coordinates ac = new Amb_coordinates();
		System.out.println(ac.ambiguousCoordinates("(1234)"));
		// TODO Auto-generated method stub

	}

}
