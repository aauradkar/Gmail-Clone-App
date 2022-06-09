package io.gmailClone.folders;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoldersService {

    public List<Folders> initFolders(String userId){
        var defaultFolders = Arrays.asList(
                new Folders(userId,"Inbox","blue"),
                new Folders(userId,"Sent","green"),
                new Folders(userId,"Important","yellow")
        );
        return defaultFolders;
    }
}
