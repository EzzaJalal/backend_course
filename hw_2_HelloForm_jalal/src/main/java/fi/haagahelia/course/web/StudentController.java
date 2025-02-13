package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Student;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String listStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        model.addAttribute("students", students);
        return "studentlist";
    }
}

