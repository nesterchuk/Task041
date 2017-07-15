import java.io.IOException;
import java.util.Collection;

public class DeveloperController {

    private DeveloperDAO developerDAO = new DeveloperDAO();

    public Collection<Developer> getAllDevelopers() {
        return developerDAO.getAllDevelopers();
    }

    public Developer getById(Integer id) {
        return developerDAO.getById(id);
    }

    public void addDeveloper(Developer developer) {
         developerDAO.addDeveloper(developer);
    }

    public void updateDeveloper(Developer developer) {
        developerDAO.updateDeveloper(developer);
    }

    public void deleteDeveloper(Integer id) {
        developerDAO.deleteDeveloper(id);
    }

    public Integer getId(){return developerDAO.getNextId();}

    public boolean saveChanges() {
        return developerDAO.saveChanges();
    }
}
