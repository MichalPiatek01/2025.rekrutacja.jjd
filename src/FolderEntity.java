public class FolderEntity implements Folder {
    private final String name;
    private final String size;

    public FolderEntity(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        return name + " " + size;
    }
}
