import java.util.List;

public class MultiFolderEntity implements MultiFolder {
    private String name;
    private String size;
    private List<Folder> folders;

    public MultiFolderEntity(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = folders;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
