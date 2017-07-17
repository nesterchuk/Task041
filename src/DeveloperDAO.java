import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDAO {

    private List<Developer> developerList;

    private final File developerFile = new File("src/developerFile.txt");

    private Integer nextId = 0;

    public DeveloperDAO(){
        String buffer;
        this.developerList = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(developerFile));) {
            while ((buffer = fileReader.readLine())!= null){
                String[] splitBuffer = buffer.split(",");
                int id = Integer.parseInt(splitBuffer[0]);
                this.nextId = (id > this.nextId ? id : nextId) + 1;
                Developer developer = new Developer();
                developer.setId(id);
                developer.setFirstName(splitBuffer[1]);
                developer.setLastName(splitBuffer[2]);
                developer.setSpeciality(splitBuffer[3]);
                developer.setExperience(Integer.parseInt(splitBuffer[4]));
                developer.setSalary(Integer.parseInt(splitBuffer[5]));
                this.developerList.add(developer);
            }
        }catch (IOException|NumberFormatException|ArrayIndexOutOfBoundsException i){}
    }

    public Developer getById(Integer id){
        for (Developer developer: developerList) {
            if (developer.getId().equals(id)){return  developer;};
        }
        return null;
    }

    public Collection<Developer> getAllDevelopers(){
        return developerList;
    }

    public void addDeveloper(Developer developer){
        developerList.add(developer);
        nextId++;
    }

    public boolean saveChanges(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(developerFile));) {
            for (Developer developer: developerList) {
                writer.write(developer.toString());
                writer.newLine();
            }
            return true;
        }catch (IOException e){};
        return false;
    }

    public Integer getNextId(){
        return this.nextId;
    }

    public void updateDeveloper(Developer developer){
        this.developerList.set(developerList.indexOf(getById(developer.getId())),developer);
    }

    public void deleteDeveloper(Integer id){
        developerList.removeIf(developer -> developer.getId().equals(id));
    }


}
