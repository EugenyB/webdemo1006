package ua.mk.berkut.webdemo1006.service;

import org.springframework.stereotype.Service;
import ua.mk.berkut.webdemo1006.model.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }
}
