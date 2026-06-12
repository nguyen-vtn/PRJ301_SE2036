/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author VuongNguyen
 */
public class Student {

    private int id;
    private String name;
    private double gpa;

    // 1. Constructor không tham số
    public Student() {
        this.id = 0;
        this.name = "";
        this.gpa = 0.0;
    }

    // 2. Constructor có tham số (Lọc dữ liệu chuẩn tại đây)
    public Student(int id, String name, double gpa) {
        // Check ID: Nếu âm thì gán bằng 0
        if (id < 0) {
            this.id = 0;
        } else {
            this.id = id;
        }

        this.name = name;

        // Check GPA: Nếu ngoài khoảng 0-10 thì gán bằng 0
        if (gpa < 0 || gpa > 10) {
            this.gpa = 0;
        } else {
            this.gpa = gpa;
        }
    }

    // 3. Các hàm Getter: Chỉ nhiệm vụ return, không xử lý logic
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // 4. Các hàm Setter: Check dữ liệu trước khi cho phép thay đổi
    public void setId(int id) {
        if (id < 0) {
            this.id = 0;
        } else {
            this.id = id;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 10) {
            this.gpa = 0;
        } else {
            this.gpa = gpa;
        }
    }

    // 5. Hàm toString hiển thị theo định dạng của bạn
    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + gpa + ")";
    }
}
