package com.example.demo.dto;

import java.io.Serializable;
import java.util.Objects;

public class TeacherDto implements Serializable {
    private final Integer teacherId;
    private final String name;
    private final String email;
    private final String phone;

    public TeacherDto(Integer teacherId, String name, String email, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDto entity = (TeacherDto) o;
        return Objects.equals(this.teacherId, entity.teacherId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phone, entity.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, name, email, phone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "teacherId = " + teacherId + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "phone = " + phone + ")";
    }
}
