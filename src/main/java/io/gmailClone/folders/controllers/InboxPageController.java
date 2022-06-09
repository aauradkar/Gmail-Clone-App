package io.gmailClone.folders.controllers;

import io.gmailClone.folders.Folders;
import io.gmailClone.folders.FoldersRepository;
import io.gmailClone.folders.FoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InboxPageController {

    @Autowired
    private FoldersRepository folderRepository;

    @Autowired
    private FoldersService foldersService;

    @GetMapping(value = "/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model){

        if(principal != null && principal.getAttribute("login") != null){
            String userId = principal.getAttribute("login");
            List<Folders> userFolders = folderRepository.findAllById(userId);
            List<Folders> defaultFolders = foldersService.initFolders(userId);
            model.addAttribute("defaultFolders",defaultFolders);
            if(userFolders.size() > 0){
                //Added all folders to model
                //commit changes
                //changes 2
                model.addAttribute("userFolders",userFolders);
            }
            return "inbox-page";

        }
        return "index";
    }
}
