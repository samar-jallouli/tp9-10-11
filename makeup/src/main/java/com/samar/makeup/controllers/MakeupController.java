package com.samar.makeup.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.samar.makeup.entities.Brand;
import com.samar.makeup.entities.Makeup;
import com.samar.makeup.service.MakeupService;
import jakarta.validation.Valid;

@Controller
public class MakeupController {

    @Autowired
    MakeupService makeupService;

    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/ListeMakeup")
    public String listeMakeup(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Makeup> mak = makeupService.getAllMakeupParPage(page, size);
        modelMap.addAttribute("makeup", mak);
        modelMap.addAttribute("pages", new int[mak.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMakeup";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("makeup", new Makeup());
        modelMap.addAttribute("mode", "new");
        List<Brand> brands = makeupService.getAllBrands();
        modelMap.addAttribute("brands", brands);
        return "formMakeup";
    }

    @RequestMapping("/saveMakeup")
    public String saveMakeup(@Valid Makeup makeup, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) return "formMakeup";
        if (makeup.getIdMakeup() == null)
            isNew = true;
        makeupService.saveMakeup(makeup);
        if (isNew) {
            Page<Makeup> mak = makeupService.getAllMakeupParPage(page, size);
            currentPage = mak.getTotalPages() - 1;
        } else {
            currentPage = page;
        }
        return "redirect:/ListeMakeup?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerMakeup")
    public String supprimerMakeup(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        makeupService.deleteMakeupById(id);
        Page<Makeup> mak = makeupService.getAllMakeupParPage(page, size);
        modelMap.addAttribute("makeup", mak);
        modelMap.addAttribute("pages", new int[mak.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMakeup";
    }

    @RequestMapping("/modifierMakeup")
    public String editerMakeup(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Makeup m = makeupService.getMakeup(id);
        List<Brand> brands = makeupService.getAllBrands();
        modelMap.addAttribute("makeup", m);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("brands", brands);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formMakeup";
    }
}