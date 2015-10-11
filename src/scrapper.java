import com.jaunt.*;
public class scrapper {

	public static void serial_scrappist(String url) throws JauntException
	{
		String data = "",skills="",courses="";
    	UserAgent userAgent = new UserAgent();      //create new userAgent (headless browser)
	    userAgent.settings.autoSaveAsHTML = true;
	    //userAgent.visit("https://www.linkedin.com/in/dhvanivora");       //visit google
	    
	    //System.out.println(url);
	    
	    userAgent.visit(url);       
	    //userAgent.doc.apply("butterflies");         //apply form input (starting at first editable field)
	    //userAgent.doc.submit("Google Search");      //click submit button labelled "Google Search"
	    //System.out.println("hello");
	    //<a href="https://www.linkedin.com/topic/web-services?trk=pprofile_topic" title="Learn more about this skill" class="endorse-item-name-text">Web Services</a>
	    //Elements links = userAgent.doc.findEvery("<span class=endorse-item-name>").findEvery("<a>");   //find search result links 
	    Elements links = userAgent.doc.findEvery("<div id=skills-item>").findEach("<a>");   //find search result links
	    Elements links1 = userAgent.doc.findEvery("<div id=courses-view>").findEach("<li>");
	    Elements links2 = userAgent.doc.findEvery("<div id=background-education>").findEach("<li>"); 
        //System.out.println("{");
        data += "{\n";
	    
	   // System.out.println("\"name\":\""+ userAgent.doc.findFirst("<span class=full-name>").getText()+"\","+"\n");
	    data += "\"name\":\""+ userAgent.doc.findFirst("<span class=full-name>").getText()+"\","+"\n";
	   //System.out.print("\"skills\": [");
	    data+="\"skills\": [";
	    for(Element link : links) 
	    {
	    	if(!link.getText().trim().equals(""))
	    	{
	    	skills +="\""+link.getText().trim()+"\",";
	    	}
	    	
	    	
	    }  
	    //System.out.print(skills.substring(0, skills.length()-1)); 
	    data += skills.substring(0, skills.length()-1);
	    //print results
	    //System.out.println("],");
	    data +="],\n";
	    //System.out.print("\"courses\": [");
	    data +="\"courses\": [";
	    courses+=" ";
	   for(Element link : links1)
		   {
		   if(!link.getText().trim().equals(""))
	    	{
		   courses +="\""+link.getText().trim()+"\",";
	    	}
		   //System.out.println(link.getText());    
		   }//print results
	   //System.out.print(courses.substring(0, courses.length()-1)); 
	   data +=courses.substring(0, courses.length()-1);
	   //System.out.println("]");
	   data+="]\n";
	   //System.out.println("}\n\n");
	   data+="}\n\n";
	    System.out.println(data );
	}
	public static void main(String[] args)throws JauntException 
	{
		// TODO Auto-generated method stub
		
		String [] urls = {"https://www.linkedin.com/in/gautamjeyaraman","https://in.linkedin.com/pub/shivani-sharma/42/69b/478","https://in.linkedin.com/pub/rakesh-kumar-sukumar/8a/b6/4a8","https://in.linkedin.com/in/bharathimit","https://www.linkedin.com/in/venkythewolf","https://www.linkedin.com/pub/diksha-gohlyan/a5/b81/697",
				"https://www.linkedin.com/pub/anish-thomas/22/907/b15","https://in.linkedin.com/in/sandeepsamdaria","https://in.linkedin.com/in/nasruddin","https://in.linkedin.com/in/yogesh21","https://www.linkedin.com/pub/abhinandan-kelgere-ramesh/62/3b0/505?trk=seokp-title_posts_secondary_cluster_res_author_name","https://www.linkedin.com/in/karanhegde","https://www.linkedin.com/pub/mathioli-ramalingam/34/650/1b2","https://in.linkedin.com/pub/anbarasi-manoharan/56/5a4/ba6"};
		
		int  c =0;
	for(String s : urls)
	{
		serial_scrappist(s);
	c++;
	}
	System.out.println(c);
	}
}
	
