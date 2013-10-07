package fr.renater.idegest.util;

public class UtilHtml {
	
	
	
	public String toHtmlTab(Object[] tab, int maxRows) {
		int n= maxRows;
			
		if (n>0) {
			String table = "<table>";
			for(int i=0; i<=n ; i++){
				//String rep ="<tr> <td> "+tab[i]+" </td></tr>";
				return "<tr> <td> "+tab[i]+"</td></tr> ";
				
			}
			String tableferme = "</table>";	
		}
		
		return "(vide)";	
	}

}
