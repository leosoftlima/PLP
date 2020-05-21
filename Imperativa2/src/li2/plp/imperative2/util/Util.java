package li2.plp.imperative2.util;

import java.util.regex.Pattern;

public class Util {
	
	
	public static String convertTernarioForIFThenElse(String id,String strTernario, boolean flag , boolean thenflag) {
		StringBuilder msg= new StringBuilder();

		msg.append("\n if ");
		if(strTernario !=null) {
			String aux = strTernario.split(Pattern.quote ("?"),2)[0];		
			msg.append(aux);
			aux = strTernario.toString().split("[?]")[1];
			
			if(strTernario.split(Pattern.quote ("?")).length > 2) {
				
				aux = strTernario.substring(strTernario.indexOf("?") + 1,strTernario.indexOf(strTernario.split("[:]",3)[2])- 1);
				msg.append(" then " + id + extracaoElse(aux));
				System.out.println(msg);
				msg.append(convertTernarioForIFThenElse(id,aux,true,false));
				System.out.println(msg);
				flag = false;
				thenflag = false;
			}
			if(!flag && !thenflag) {
				aux = strTernario.split("[:]")[0].split("[?]")[1];
				msg.append(" then " + id + aux);
				System.out.println(msg);
			}
			if(!flag || thenflag) {
				msg.append("\n else " + id + extracaoElse(strTernario));
			}
			System.out.println(msg);
		}
		return msg.toString();
	}
	private static String extracaoElse(String str) {
		if(str.contains(":") && str.split("[:]").length > 2 ) {
			return str.split("[:]",3)[2];
		}
		return str.split("[:]",2)[1];
	}
	public static void main(String[] args) {
//		String str = " y==2 ? \"SSS\" : \"CCC\"";
//		String str2 = "y==2 ? x == \"vvv\" ? \"SSS\" : \"CCC\" : \"ZZZ\"";
//		String str3 = "y==2 ? \"ZZZ\" : x == \"vvv\" ? \"SSS\" : \"CCC\"";
//		String id = "x:=";
////		System.out.println(extracaoElse(str));
//			System.out.printf(convertTernarioForIFThenElse(id,str2,false,false));
		Integer x=4;
		Integer y=2;
		x = ++y;
		System.out.println(y);
	}
	


	
}
