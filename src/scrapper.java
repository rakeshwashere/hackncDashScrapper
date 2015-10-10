import com.jaunt.*;
public class scrapper {

	public static void main(String[] args)throws JauntException 
	{
		// TODO Auto-generated method stub
		    
		    UserAgent userAgent = new UserAgent();      //create new userAgent (headless browser)
		    userAgent.settings.autoSaveAsHTML = true;
		    userAgent.visit("https://www.linkedin.com/in/dhvanivora");       //visit google
		    //userAgent.doc.apply("butterflies");         //apply form input (starting at first editable field)
		    //userAgent.doc.submit("Google Search");      //click submit button labelled "Google Search"
		    //System.out.println("hello");
		    //<a href="https://www.linkedin.com/topic/web-services?trk=pprofile_topic" title="Learn more about this skill" class="endorse-item-name-text">Web Services</a>
		    //Elements links = userAgent.doc.findEvery("<span class=endorse-item-name>").findEvery("<a>");   //find search result links 
		    Elements links = userAgent.doc.findEvery("<div id=skills-item>").findEach("<a>");   //find search result links
		    Elements links1 = userAgent.doc.findEvery("<div id=courses-view>").findEach("<li>");
		    Elements links2 = userAgent.doc.findEvery("<div id=background-education>").findEach("<li>"); 
		    for(Element link : links) System.out.println(link.getText());     //print results
		    for(Element link : links1) System.out.println(link.getText());     //print results
		    

}}
