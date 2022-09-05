package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.model.ClassCG;
import com.codegym.model.Student;
import com.codegym.service.IClassService;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SessionAttributes(value = {"talkList", "studentList"})
@RequestMapping(value = "/student")
@Controller
public class StudentController {

    @ModelAttribute(value = "talkList")
    public List<Student> createTalkList() {
        return new ArrayList<>();
    }

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassService iClassService;

    @GetMapping(value = "/list")
    public String goStudentList(Model model,
                                @PageableDefault(size = 5) Pageable pageable,
                                @RequestParam Optional<String> keyword) {

        String keywordVal = keyword.orElse("");
///
        model.addAttribute("studentList",
                this.iStudentService.findAllSearchAndPaging(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);

        return "list_student";
    }

//    @GetMapping(value = "/list")
//    public String goStudentList(ModelMap modelMap) {
//
//        modelMap.addAttribute("studentList",
//                this.iStudentService.findAll());
//
//        return "list_student";
//    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @GetMapping(value = {"/list", ""})
//    public ModelAndView goStudentList() {
//
//        ModelAndView modelAndView = new ModelAndView("list_student");
//
//        modelAndView.addObject("studentList",
//                this.iStudentService.findAll());
//
//        return modelAndView;
//    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam int id,
                                  Model model) throws Exception {

        Student studentObj = this.iStudentService.findById(id);

        if (studentObj == null) {
            throw new Exception();
        }

        model.addAttribute("studentObj",
                studentObj);

        return "detail_student";
    }

    @GetMapping(value = "/detail/{idStudent}")
    public String goDetailStudentPV(@PathVariable int idStudent,
                                  Model model) {

        model.addAttribute("studentObj",
                this.iStudentService.findById(idStudent));

        return "detail_student";
    }

    @GetMapping(value = "/create")
    public String goCreateStudent(Model model,
                                  @CookieValue(defaultValue = "0") String countStudentRegister) {

        model.addAttribute("studentDto",
                new StudentDto());
        model.addAttribute("classList",
                this.iClassService.findAll());
        model.addAttribute("countStudentCookie",
                countStudentRegister);

        return "create_student";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute @Valid StudentDto studentDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model,
                                HttpServletResponse response,
                                @CookieValue(defaultValue = "0") String countStudentRegister) {
//        model.addAttribute("student", new Student());

        new StudentDto().validate(studentDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("classList",
                    this.iClassService.findAll());
            return "create_student";
        }

        // Create cookie
        int tmp = Integer.parseInt(countStudentRegister);

        Cookie cookie = new Cookie("countStudentRegister", String.valueOf(++tmp));
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);

        ClassCG classCG = new ClassCG();
        classCG.setId(studentDto.getClassCG().getId());
        student.setClassCG(classCG);

        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");

        return "redirect:/student/list";
    }

    @GetMapping(value = "/addToTalk/{id}")
    public String addToTalk(@PathVariable Integer id,
                            @SessionAttribute List<Student> talkList,
                            RedirectAttributes redirectAttributes) {

        Student studentObj = this.iStudentService.findById(id);
        talkList.add(studentObj);

        redirectAttributes.addFlashAttribute("msg",
                "Add to talk successfully!");

        return "redirect:/student/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String goStudentError() {
        return "error_student";
    }
}
