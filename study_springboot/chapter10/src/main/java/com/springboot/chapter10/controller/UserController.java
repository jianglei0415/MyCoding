package com.springboot.chapter10.controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.springboot.chapter10.pojo.User;
import com.springboot.chapter10.service.UserService;
import com.springboot.chapter10.validator.UserValidator;
import com.springboot.chapter10.view.PdfExportService;
import com.springboot.chapter10.view.PdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/30 0:28
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/converter")
    @ResponseBody
    public User getUserByConverter(User user) {
        return user;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(List<User> userList) {
        return userList;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @GetMapping("/validator")
    @ResponseBody
    public Map<String, Object> validator(@Valid User user, Errors errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        if (errors.hasErrors()) {
            List<ObjectError> oes = errors.getAllErrors();
            for (ObjectError oe : oes) {
                if (oe instanceof FieldError) {
                    FieldError fe = (FieldError) oe;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    map.put(oe.getObjectName(), oe.getDefaultMessage());
                }
            }
        }
        return map;
    }

    @GetMapping("/export/pdf")
    public ModelAndView exportPdf(String userName, String note) {
        List<User> userList = userService.findUsers(userName, note);
        View view = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("userList", userList);
        return mv;
    }

    @SuppressWarnings("unchecked")
    private PdfExportService exportService() {
        return ((model, document, writer, request, response) -> {
            try {
                document.setPageSize(PageSize.A4);
                document.addTitle("用户信息");
                document.add(new Chunk("\n"));
                PdfPTable table = new PdfPTable(3);
                PdfPCell cell = null;
                Font f8 = new Font();
                f8.setColor(Color.BLUE);
                f8.setStyle(Font.BOLD);
                cell = new PdfPCell(new Paragraph("id", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph("user_name", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph("note", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);
                List<User> userList = (List<User>) model.get("userList");
                for (User user : userList) {
                    document.add(new Chunk("\n"));
                    cell = new PdfPCell(new Paragraph(user.getId() + ""));
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(user.getUserName()));
                    table.addCell(cell);
                    String note = user.getNote() == null ? "" : user.getNote();
                    cell = new PdfPCell(new Paragraph(note));
                    table.addCell(cell);
                }
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/show")
    public String showUser(Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "data/user";
    }

//    @GetMapping("/redirect1")
//    public String redirect1(String userName, String note) {
//        User user = new User();
//        user.setNote(note);
//        user.setUserName(userName);
//        userService.insertUser(user);
//        return "redirect:/user/show?id=" + user.getId();
//    }

//    @GetMapping("/redirect2")
//    public ModelAndView redirect2(String userName, String note) {
//        User user = new User();
//        user.setNote(note);
//        user.setUserName(userName);
//        userService.insertUser(user);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("redirect:/user/show?id=" + user.getId());
//        return mv;
//    }

    @RequestMapping("/showUser")
    public String showUser(User user, Model model) {
        System.out.println(user.getId());
        return "data/user";
    }

    @GetMapping("/redirect1")
    public String redirect1(String userName, String note, RedirectAttributes ra) {
        User user = new User();
        user.setNote(note);
        user.setUserName(userName);
        userService.insertUser(user);
        ra.addFlashAttribute("user", user);
        return "redirect:/user/showUser";
    }

    @GetMapping("/redirect2")
    public ModelAndView redirect2(String userName, String note, RedirectAttributes ra) {
        User user = new User();
        user.setNote(note);
        user.setUserName(userName);
        userService.insertUser(user);
        ra.addFlashAttribute("user", user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/user/showUser");
        return mv;
    }

    @GetMapping("/header/page")
    public String headerPage() {
        return "header";
    }

    @PostMapping("/header/user")
    @ResponseBody
    public User headerUser(@RequestHeader("id") Long id) {
        User user = userService.getUser(id);
        return user;
    }
}
