package p1.week2_2;

public class NewMain {

    public static void main(String[] args) throws Exception {
        Planner myplanner = Planner.Demo();
        String res = myplanner.getXML();
        System.out.println(res);
        //myplanner.saveXML("testweek2.xml");
        //Planner myplanner2 = ReadXMLFile.readxml("testweek2.xml");
    }
    
}
