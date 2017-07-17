public class DeveloperController {
    ConsoleReader reader = new ConsoleReader();

    private DeveloperService developerService = new DeveloperService();

    public boolean startMenu(){
        System.out.println( "0)Exit\n"+
                            "1) Show all developers \n"+
                            "2) Search the developer by id \n"  +
                            "3) Add a new developer \n"+
                            "4) Edit developer\n"+
                            "5) Remove developer \n"+
                            "6) Save changes \n"
        );

        switch (reader.readString()){
            case "0":
                return false;
            case "1":
                this.getAllDevelopers();
                break;
            case "2":
                this.getDeveloper();
                break;
            case "3":
                this.addDeveloper();
                break;
            case "4":
                this.updateDeveloper();
                break;
            case "5":
                this.deleteDeveloper();
                break;
            case "6":
                this.saveChanges();
                break;
        }
        return true;
    }

    public void getAllDevelopers(){
        for (Developer developer: developerService.getAllDevelopers()) {
            System.out.println(developer);
        }
    }

    public void addDeveloper(){
        Developer developer = new Developer();
        readDeveloperFields(developer);
        developer.setId(developerService.getId());
        developerService.addDeveloper(developer);
    }

    public void getDeveloper(){
        ConsoleReader consoleReader = new ConsoleReader();
        System.out.print("Enter the Id of the developer:");
        Developer developer = developerService.getById(consoleReader.readInteger());
        if (developer == null){
            System.out.println("Id not found");
        } else {
            System.out.println(developer);
        }

    }

    public void updateDeveloper(){
        System.out.print("Enter the developer ID you want to change: ");
        Integer id = reader.readInteger();
        Developer developer = developerService.getById(id);
        if (developer == null){
            System.out.println("Id not found");
        } else {
            readDeveloperFields(developer);
            developerService.updateDeveloper(developer);
        }

    }

    private void readDeveloperFields(Developer developer){

        System.out.print("Enter a first name: ");
        developer.setFirstName(reader.readString());

        System.out.print("Enter a last name: ");
        developer.setLastName(reader.readString());

        System.out.print("Enter speciality: ");
        developer.setSpeciality(reader.readString());

        System.out.print("Enter experience: ");
        developer.setExperience(reader.readInteger());

        System.out.print("Enter salary: ");
        developer.setSalary(reader.readInteger());
    }


    public void deleteDeveloper(){

        System.out.print("Enter Developer Id: ");
        developerService.deleteDeveloper(reader.readInteger());
        System.out.println("Deleted successfully");
    }

    public void saveChanges(){
        developerService.saveChanges();
        System.out.println("Saved successfully");
    }


 }
