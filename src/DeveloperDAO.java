import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDAO {

    private List<Developer> developerBuffer;

    private final File developerFile = new File("src/developerFile.txt");

    private Integer nextId = 0;

    public DeveloperDAO(){this.getAllDevelopers();}

    public Developer getById(Integer id){
        Developer developer;
        for (int i = 0; i <developerBuffer.size(); i++) {
            developer = developerBuffer.get(i);
            if (developer.getId().equals(id)){return developer;}
        }
        return null;
    }

    public Collection<Developer> getAllDevelopers(){
        if (developerBuffer != null){return developerBuffer;}
        String buffer;
        developerBuffer = new ArrayList<>();
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
                this.developerBuffer.add(developer);
            }
        }catch (IOException|NumberFormatException|ArrayIndexOutOfBoundsException i){}
        return developerBuffer;
    }

    public void addDeveloper(Developer developer){
        developerBuffer.add(developer);
        nextId++;
    }

    public boolean saveChanges(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(developerFile));) {
            for (Developer developer: developerBuffer) {
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
        this.developerBuffer.set(developerBuffer.indexOf(getById(developer.getId())),developer);
    }

    public void deleteDeveloper(Integer id){
        developerBuffer.removeIf(developer -> developer.getId().equals(id));
    }


}
