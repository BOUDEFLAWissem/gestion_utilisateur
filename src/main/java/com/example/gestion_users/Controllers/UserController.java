package com.example.gestion_users.Controllers;

import com.example.gestion_users.Repositories.RoleRepository;
import com.example.gestion_users.Repositories.UserRepository;

import com.example.gestion_users.model.Role;
import com.example.gestion_users.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller


public class UserController {
    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;




    @GetMapping("/")
    public String viewHomePage(Model model,String nom) {



        model.addAttribute("nom", nom);

        if (nom!=null){
            model.addAttribute("list",userRepository.findByNom(nom));


        }
        else model.addAttribute("list",userRepository.findAll());
        return "index";
    }


    @RequestMapping("/user/{id}")
    public String showuser(@PathVariable Long id, Model model){
        model.addAttribute("user", userRepository.findById(id).get());
       List ttt=roleRepository.findAll();
        model.addAttribute("lll",ttt);
        return "details";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        User user=new User();

       // roleRepository.saveAll( Arrays.asList(new Role(1L,"ROLE_USER"),new Role(2L,"ROLE_SUPERUSER") , new Role(3L,"ROLE_ADMIN"),new Role(4L,"ROLE_NEW")));
      //  List tt=roleRepository.findAll();
        List r=Arrays.asList(new Role(1L,"ROLE_USER"),new Role(2L,"ROLE_SUPERUSER") , new Role(3L,"ROLE_ADMIN"),new Role(4L,"ROLE_NEW"));
       roleRepository.saveAll(r);
         model.addAttribute("ll",r);

        model.addAttribute("user", user);
        return "new_user";
    }



    @PostMapping("/save")
    public String save( @ModelAttribute("user")@Valid User user,BindingResult b,Model model) {
        if(b.hasErrors()) {
            List r=Arrays.asList(new Role(1L,"ROLE_USER"),new Role(2L,"ROLE_SUPERUSER") , new Role(3L,"ROLE_ADMIN"),new Role(4L,"ROLE_NEW"));
            roleRepository.saveAll(r);
            model.addAttribute("ll",r);
           // model.addAttribute("property",);
            return "new_user";
        }

        userRepository.save(user);

        return "redirect:/";
    }


    @GetMapping("/Update/{id}")
    public String Update(@PathVariable(value = "id") long id, Model model) {


       User user = userRepository.findById(id).get();


        List ttt=roleRepository.findAll();
        model.addAttribute("lll",ttt);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {


        this.userRepository.deleteById(id);
        return "redirect:/";
    }



/******/


}