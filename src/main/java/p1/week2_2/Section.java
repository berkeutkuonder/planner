package p1.week2_2;

import java.util.List;
import java.util.ArrayList;

/**
 * Section stores different Task objects
 * 
 * Section objects are stored in Project and Section itself stores a list of
 * Tasks. 
 * 
 * @author Berke Utku Önder
 * @see Project
 * @see Task
 * @see CanGenerateXML
 * @version 2
 */

public class Section implements CanGenerateXML {
    
    public String Name;
    public List<Task> Tasks = new ArrayList<>();
    
    /**
     * Constructor
     *  
     * @param n name of the new section
     */
    Section(String n){
        this.Name = n;
        System.out.println("Section is created");
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
        String res = "\n\t\t<section ";
        res += String.format("id = \"%s\">", Name);
        for(Task p : Tasks) {
            res += p.getXML();
        }
        res += "\n\t\t</section>";
        return res;
    }

    /**
     * Creates a new task and appends it to the section
     * 
     * @param n name of the task
     * @param desc description of the task
     * @param str start of the task
     * @param dur duration of the task
     * @param dl deadline of the task
     * @param stat status of the task
     */
    public void newTask(String n, String desc, String str, String dur, String dl, String stat) {
        Task t = new Task(n, desc, str, dur, dl, stat);
        this.Tasks.add(t);
    }
}
