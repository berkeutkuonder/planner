package p1.week2_2;

import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 * Planner stores different Project objects 
 * 
 * Planner is the main object stores the all information about the the applications.
 * It implements CanGenerateXML interface. It also has a demo() method which
 * starts an example planner. This can be used to explore the object more
 * 
 * @author Berke Utku Önder
 * @see Project
 * @see CanGenerateXML
 * @version 2
 */
public class Planner implements CanGenerateXML {
    
    public final List<Project> projects;
    private final String name;
    
    /**
     * Constructor
     *  
     * @param name name of the new Planner
     */
    Planner(String name) {
        //System.out.println("Planner is created"); 
        this.name = name;
        this.projects = new ArrayList<>();
    }
    
    /**
     * Converts Planner to XML (as a string)
     * 
     * This methods does not get any arguments, and it creates XML version of the planner
     * so that we can store the planner and reload it when we need it. This method
     * comes from CanGenerateXML.
     * 
     * @return A string of XML
     */
    @Override
    public String getXML() {
        String res = "<?xml version=\"1.0\"?>\n<planner>";
        for(Project p : projects) {
            res += p.getXML();
        } 
        res += "\n</planner>";
        return res;
    }
    
    /**
     * Creates a new project and appends it to the planner
     *  
     * @param n name of the new Project
     */
    public void newProject(String n) {
        Project p = new Project(n);
        this.projects.add(p);
    }
    
    /**
     * Saves the Planner to a file
     * 
     * The method first converts the planner to XML, and the then stores this 
     * String into a file. Then, we can reload this to initiate the Planner
     * 
     * @see ReadXMLFile
     * @see Planner.getXML()
     * @param n name of the file that we want to use to save our XML
     * @throws Exception 
     */
    public void saveXML(String n) throws Exception {
        FileWriter fw =  new FileWriter(n);
        String res = getXML();
        fw.write(res);
        fw.close();
    }
    
    /**
     * Creates an example planner object
     * 
     * @return A planner object
     */
    public static Planner Demo() {
        Planner myplanner = new Planner("demo");
        myplanner.newProject("p1");
        myplanner.projects.get(0).newSection("s1");
        myplanner.projects.get(0).newSection("s2");
        myplanner.projects.get(0).SectionNames.get(0).newTask("t1","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(0).SectionNames.get(0).newTask("t2","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(0).SectionNames.get(1).newTask("t1","desc","start","dur","deadline","NotDone");
        myplanner.newProject("p2");
        myplanner.projects.get(1).newSection("s1");
        myplanner.projects.get(1).newSection("s2");
        myplanner.projects.get(1).SectionNames.get(0).newTask("t1","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(1).SectionNames.get(0).newTask("t2","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(1).SectionNames.get(1).newTask("t1","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(1).SectionNames.get(1).newTask("t2","desc","start","dur","deadline","NotDone");
        myplanner.projects.get(1).SectionNames.get(1).newTask("t3","desc","start","dur","deadline","NotDone");
        return(myplanner);
    }
    
}
