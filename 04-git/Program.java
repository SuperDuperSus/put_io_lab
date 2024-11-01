// n6
public class Program {
    // Class variables
    private String name;
    private int version;

    // Change 1

    // Constructor
    public Program(String name, int version) {
        this.name = name;
        this.version = version;
    }

    // Change 1 True n5

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        // n7 Change 3
        this.name = name;
    }

    // Change 2 True n5

    // Getter for version
    public int getVersion() {
        // n7 Change 2
        return version;
    }

    // Setter for version
    public void setVersion(int version) {
        this.version = version;
    }
    // Change 3 True n5

    // Main method
    public static void main(String[] args) {
        Program program = new Program("Example", 1);
        System.out.println("Program Name: " + program.getName());
        System.out.println("Program Version: " + program.getVersion());
    }

    //#3 Change 3
}
