package creational;

public class Builder {


    public static void main(String[] args) {
        Student s = new Student.StudentBuilder()
                .setId(1l).
                setName("shubam")
                .setEmail("abc@gmail.com")
                .build();

        System.out.println(s);
    }

}

class Student {
    private Long id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private Student() {
    }

    public Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
    }

    static class StudentBuilder {
        private Long id;
        private String name;
        private String email;

        public StudentBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
