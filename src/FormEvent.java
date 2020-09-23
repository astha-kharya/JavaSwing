import java.util.EventObject;

public class FormEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null

     */
    private int ageCategory;
    private String empCat;
    private  String gender;

    public boolean isIndian() {
        return Indian;
    }

    public String getTaxID() {
        return taxID;
    }

    private String taxID;
    private boolean Indian;

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String occupation;
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public FormEvent(Object source) {
        super(source);
    }
    public FormEvent(Object source,String name,String occupation,int ageCategory,String empCat,String taxID,boolean Indian,String gender) {
        super(source);
        this.name=name;
        this.occupation=occupation;
        this.ageCategory=ageCategory;
        this.empCat=empCat;
        this.taxID=taxID;
        this.Indian=Indian;
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

    public int getAgeCategory(){
        return ageCategory;
    }

    public String getEmpCat() {
        return empCat;
    }
}
