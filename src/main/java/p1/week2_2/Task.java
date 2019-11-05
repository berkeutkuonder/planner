package p1.week2_2;

/**
 * Section stores different Task objects
 * 
 * Section objects are stored in Project and Section itself stores a list of
 * Tasks. 
 * 
 * @author Berke Utku Önder
 * @see Section
 * @see CanGenerateXML
 * @version 2
 */

public class Task implements CanGenerateXML {
    
    private final String name;
    private final String description;
    private final String start;
    private final String duration;
    private final String deadline;
    private final String status;
    
    /**
     * Constructor
     * 
     * @param n name of the task
     * @param desc description of the task
     * @param str start of the task
     * @param dur duration of the task
     * @param dl deadline of the task
     * @param stat status of the task
     */
    Task(String n, String desc, String str, String dur, String dl, String stat){
        this.name = n;
        this.description = desc;
        this.start = str;
        this.duration = dur;
        this.deadline = dl;
        this.status = stat;
        System.out.println("Task is created");
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
        String res = "\n\t\t\t<task ";
        res += String.format("id = \"%s\">", name);
        res += String.format("\n\t\t\t\t<status>%s</status>", status);
        res += "\n\t\t\t</task>";
        return res;
    }
}
