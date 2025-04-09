import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders(folders).stream()
                .filter(folder -> folder.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return getAllFolders(folders).stream()
                .filter(folder -> folder.getSize().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return getAllFolders(folders).size();
    }

    private List<Folder> getAllFolders(List<Folder> Folders) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : Folders) {
            result.add(folder);
            if (folder instanceof MultiFolder multi) {
                result.addAll(getAllFolders(multi.getFolders()));
            }
        }
        return result;
    }
}