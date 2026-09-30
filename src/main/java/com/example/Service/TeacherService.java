package com.example.Service;

import com.example.Api.ApiException;
import com.example.Model.Teacher;
import com.example.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        if (teacherRepository.existsById(teacher.getId()))
            throw new ApiException("A teacher with this ID already existed");
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher old = teacherRepository.findTeacherById(id);
        if (old == null)
            throw new ApiException("not found");
        old.setName(teacher.getName());
        old.setAge(teacher.getAge());
        old.setEmail(teacher.getEmail());
        old.setSalary(teacher.getSalary());
        teacherRepository.save(old);
    }

//he4e4
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("not found");
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("not found");
        return teacher;
    }
}
