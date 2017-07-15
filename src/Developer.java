
public class Developer {

    private Integer id;

    private String firstName;

    private String lastName;

    private String speciality;

    private Integer experience;

    private Integer salary;

    public Developer(){

    }
    public Developer(Integer id, String firstName, String lastName, String speciality, Integer experience, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.experience = experience;
        this.salary = salary;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public Integer getExperience() {
        return this.experience;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return  id+","+firstName+","+lastName+","+ speciality+","+ experience+","+ salary;
    };
}
