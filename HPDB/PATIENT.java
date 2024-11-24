package HPDB;

public class PATIENT{

    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    private String age,ph,report;
    public PATIENT(String name, String age, String ph){
        this.name = name;
        this.age = age;
        this.ph = ph;
        
    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPh() {
        return ph;
    }
    
    public void writeReport(String report){
        this.report = report;
    }

    public String getReport(){
        return report;
    }
    
    public String toCSV(){
        return name + "," + age + ", phone " + ph + "," + report;
    }

}
