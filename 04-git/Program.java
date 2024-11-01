public class Program {
    // Class variables
    private String name;
    private int version;

    // Constructor
    public Program(String name, int version) {
        this.name = name;
        this.version = version;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for version
    public int getVersion() {
        return version;
    }

    // Setter for version
    public void setVersion(int version) {
        this.version = version;
    }

    // Main method
    public static void main(String[] args) {
        Program program = new Program("Example", 1);
        System.out.println("Program Name: " + program.getName());
        System.out.println("Program Version: " + program.getVersion());
    }

    //#3 Change 3
}
