package edu.logos.controller;

import edu.logos.dto.StudentDTO;
import edu.logos.dto.filter.SimpleFilter;
import edu.logos.entity.Country;
import edu.logos.entity.Student;
import edu.logos.entity.User;

import edu.logos.mapper.StudentMapper;

import edu.logos.service.CountryService;
import edu.logos.service.StudentService;
import edu.logos.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"countries","saveUser"})
public class HomeController {

    private CountryService countryService;
    private StudentService studentService;
    private UserService userService;

    public HomeController(CountryService countryService, StudentService studentService, UserService userService) {
        this.countryService = countryService;
        this.studentService = studentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/add/country")
    public String showAddCountryForm(Model model) {
        model.addAttribute("countryModel", new Country());
        return "c";

    }
    @GetMapping("/add/student")
    public String showAddCStudentForm(Model model) {
        model.addAttribute("studentModel", new Student());
        model.addAttribute("countries", countryService.findAllCountrys());
        return "add-student";
    }

    @PostMapping("/add/country")
    public String saveCountry(@Valid @ModelAttribute("countryModel") Country country,
                              BindingResult br){
        if (br.hasErrors()) {
            return "add-country";
        }
        countryService.saveCountry(country);
        return "redirect:/";
    }

    @PostMapping("/add/student")
    public String saveStudent(@Valid @ModelAttribute("studentModel") Student student, BindingResult br) {
        if (br.hasErrors()) {
            return "add-student";
        }
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/add/user")
    public String showAddUserForm(Model model) {
    model.addAttribute("saveUser", new User());
        return "add-user";
    }

    @PostMapping("/add/user")
    public String saveUser(@Valid @ModelAttribute("saveUser") User user, BindingResult br) {
        if (br.hasErrors()) {
            return "add-user";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    // DTO
    @GetMapping("/add/student-dto")
    public String showAddStudentDTOFrom(Model model) {
        model.addAttribute("studentDTOModel", new StudentDTO());
        return "add-student-dto";
    }

    @PostMapping("/add/student-dto")
    public String saveStudentDTO(
            @Valid @ModelAttribute("studentDTOModel") StudentDTO studentDTO,
            BindingResult br
    ) {
        if( br.hasErrors()) { return "add-student-dto"; }
        Student student = StudentMapper.studentDTOtoStudent(studentDTO);
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("simpleModel", new SimpleFilter());
        List<Student> s = studentService.findAllStudents();
        System.out.println(s.size());
        model.addAttribute("studentsList", s);
        return "student-list";
    }

    @GetMapping("/students/search")
    public String showStudentsByFilter(
            @ModelAttribute("simpleModel") SimpleFilter filter,
            Model model
    ) {
        model.addAttribute("studentsList", studentService.findAllStudentsByFilter(filter));
        return "student-list";
    }

    @GetMapping("/students/pages")
    public String showStudentsByPage(
            Model model,
            @PageableDefault Pageable pageable
            ) {
        Page<Student> page = studentService.findAllStudentsByPage(pageable);


//        model.addAttribute("stlist", page.getContent());
        int currentPage = page.getNumber();
        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", currentPage);
        model.addAttribute("studentsList", page);
        model.addAttribute("studentPageListByPageSize", page.getContent());
        page.getContent().forEach(c -> System.out.println(c));
        return "students-by-page";
    }

}
