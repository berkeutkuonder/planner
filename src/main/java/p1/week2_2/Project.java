package p1.week2_2;

import java.util.List;
import java.util.ArrayList;
/**
 * Project stores different Section objects
 * 
 * Project objects are stored in Planner and Project itself stores a list of
 * sections. 
 * 
 * @author Berke Utku Önder
 * @see Planner
 * @see Section
 * @see CanGenerateXML
 * @version 2
 */
public class Project implements CanGenerateXML {
    
    public String Name;
    public List<Section> SectionNames = new ArrayList<>();
    
    /**
     * Constructor
     *  
     * @param n name of the new Project
     */
    Project(String n){
        this.Name = n;
        System.out.println("Project is created");
    }
    
    /**
     * Converts Project to XML (as a string)
     * 
     * This methods does not get any arguments, and it creates XML version of the project.
     * Similar methods can be found in other classes as well
     * 
     * @return A string of XML
     */
    @Override
    public String getXML(){
        String res = "\n\t<project ";
        res += String.format("id = \"%s\">", Name);
        for(Section p : SectionNames) {
            res += p.getXML();
        } 
        res += "\n\t</project>";
        return res;
    }
    
    /**
     * Creates a new section and appends it to the project
     *  
     * @param n name of the new section
     */
    public void newSection(String n) {
        Section s = new Section(n);
        this.SectionNames.add(s);
    }
}
