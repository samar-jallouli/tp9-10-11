package com.samar.makeup.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.samar.makeup.entities.*;
import com.samar.makeup.service.*;
@Controller
public class MakeupController {
@Autowired
MakeupService makeupService;
 @RequestMapping("/ListeMakeup")
public String listeMakeup(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
{
	Page<Makeup> mak = makeupService.getAllMakeupParPage(page, size);
	modelMap.addAttribute("makeup", mak);
	modelMap.addAttribute("pages", new int[mak.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	
	return "listeMakeup";
}
 @RequestMapping("/showCreate")
public String showCreate()
{
return "createMakeup";
}
@RequestMapping("/saveMakeup")
public String saveMakeup(@ModelAttribute("makeup") Makeup makeup,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 makeup.setDateCreation(dateCreation);

Makeup saveMakeup = makeupService.saveMakeup(makeup);
String msg ="makeup enregistré avec Id "+saveMakeup.getIdMakeup();
modelMap.addAttribute("msg", msg);
return "createMakeup";
}
@RequestMapping("/supprimerMakeup")
public String supprimerMakeup(@RequestParam("id") Long id,ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
 
{
makeupService.deleteMakeupById(id);
Page<Makeup> mak = makeupService.getAllMakeupParPage(page,size);
		modelMap.addAttribute("makeup", mak);
		modelMap.addAttribute("pages", new int[mak.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMakeup";

}

 @RequestMapping("/modifierMakeup")
public String editerMakeup(@RequestParam("id") Long id,
 ModelMap modelMap)
{
Makeup M= makeupService.getMakeup(id);
modelMap.addAttribute("makeup", M);
return "editerMakeup";
}
@RequestMapping("/updateMakeup")
public String updateMakeup(@ModelAttribute("makeup") Makeup
makeup, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 makeup.setDateCreation(dateCreation);

 makeupService.updateMakeup(makeup);
 List<Makeup> mak = makeupService.getAllMakeup();
 modelMap.addAttribute("makeup", mak);
return "listeMakeup";
}
}