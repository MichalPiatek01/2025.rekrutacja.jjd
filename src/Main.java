import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Folder f1 = new FolderEntity("Photos", "LARGE");
        Folder f2 = new FolderEntity("Docs", "SMALL");
        Folder f3 = new FolderEntity("Videos", "LARGE");

        MultiFolder mf1 = new MultiFolderEntity("Projects", "MEDIUM", Arrays.asList(f2, f3));
        MultiFolder mf2 = new MultiFolderEntity("Archive", "SMALL", Arrays.asList(mf1, f1));

        FileCabinet cabinet = new FileCabinet(List.of(mf2));

        System.out.println("Find 'Docs': " + cabinet.findFolderByName("Docs").orElse(null));
        System.out.println("Find 'Music': " + cabinet.findFolderByName("Music").orElse(null));

        for (Folder f : cabinet.findFoldersBySize("LARGE")) {
            System.out.println(" - " + f.getName());
        }
        for (Folder f : cabinet.findFoldersBySize("SMALL")) {
            System.out.println(" - " + f.getName());
        }
        for (Folder f : cabinet.findFoldersBySize("MEDIUM")) {
            System.out.println(" - " + f.getName());
        }

        System.out.println("Total folder count: " + cabinet.count());
    }
}