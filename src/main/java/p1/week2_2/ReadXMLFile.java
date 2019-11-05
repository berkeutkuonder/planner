package p1.week2_2;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static Planner readxml(String n) {
      Planner myplanner = new Planner("fromxml");

      try {
          File fXmlFile = new File(n);
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(fXmlFile);
	  doc.getDocumentElement().normalize();
			
	  NodeList projects = doc.getElementsByTagName("project");
			
	  for (int i = 0; i < projects.getLength(); i++) {
              Node project = projects.item(i);
              Element p = (Element) project;
              
              String name = p.getAttribute("id");
              myplanner.newProject(name);

              NodeList sections = p.getElementsByTagName("section");
              for (int j = 0; j < sections.getLength(); j++) {
                  Node section = sections.item(j);
                  Element s = (Element) section;
                  
                  String sname = s.getAttribute("id");
                  myplanner.projects.get(i).newSection(sname);
                  
                  NodeList tasks = s.getElementsByTagName("task");
                  for(int k = 0; k < tasks.getLength(); k++) {
                      Node task = tasks.item(k);
                      Element eElement = (Element) task;

                      String tname = eElement.getAttribute("id");
                      myplanner.projects.get(i).SectionNames.get(j).newTask(tname, "1","2","3","3","4");
                  }
              }
          }
      } 
      catch (Exception e) {
          e.printStackTrace();
      }
      
      return myplanner;
  }
}
