package com.jkdk.coursemanager.config;

import com.jkdk.coursemanager.model.*;
import com.jkdk.coursemanager.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final ConfigurableApplicationContext context;

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final LessonBlockRepository lessonBlockRepository;
    private final CourseEnrollmentRepository courseEnrollmentRepository;



    @Override
    public void run(String... args) throws Exception {
        initUsers();

        if (lessonRepository.count() == 0) {

            initCourse("Java Advanced");
            Course javaCourse = initCourse("Java Basics");

            User userAdam = new User();
            userAdam.setFirstName("Adam");
            userAdam.setLastName("Johnson");
            userAdam.setLogin("AdamJ");
            userAdam.setPassword(passwordEncoder.encode("pass"));
            userAdam.setType(Role.PARTICIPANT);
            userAdam.setActive(true);
            userRepository.save(userAdam);
            CourseEnrollment enrollment = new CourseEnrollment();
            enrollment.setDate(LocalDate.now());
            enrollment.setParticipant(userAdam);
            enrollment.setCourse(javaCourse);
            courseEnrollmentRepository.save(enrollment);
        }

//        context.close();
    }



    private void initUsers() {
        if (userRepository.count() == 0) {
            User userPeter = new User();
            User userAdrian = new User();
            User teacherSophie = new User();
            User teacherWayne = new User();
            User adminConnor = new User();
            userPeter.setFirstName("Peter");
            userPeter.setLastName("Brown");
            userPeter.setLogin("PeterB");
            userPeter.setPassword(passwordEncoder.encode("pass"));
            userPeter.setType(Role.PARTICIPANT);
            userPeter.setActive(true);

            userAdrian.setFirstName("Adrian");
            userAdrian.setLastName("Smith");
            userAdrian.setLogin("AdrianS");
            userAdrian.setPassword(passwordEncoder.encode("pass"));
            userAdrian.setType(Role.PARTICIPANT);
            userAdrian.setActive(true);

            teacherSophie.setFirstName("Sophie");
            teacherSophie.setLastName("Hamilton");
            teacherSophie.setLogin("SophieS");
            teacherSophie.setPassword(passwordEncoder.encode("pass"));
            teacherSophie.setType(Role.TEACHER);
            teacherSophie.setActive(true);

            teacherWayne.setFirstName("Wayne");
            teacherWayne.setLastName("Peterson");
            teacherWayne.setLogin("WayneP");
            teacherWayne.setPassword(passwordEncoder.encode("pass"));
            teacherWayne.setType(Role.TEACHER);
            teacherWayne.setActive(true);

            adminConnor.setFirstName("Connor");
            adminConnor.setLastName("Ferguson");
            adminConnor.setLogin("ConorF");
            adminConnor.setPassword(passwordEncoder.encode("admin"));
            adminConnor.setType(Role.ADMIN);
            adminConnor.setActive(true);

            userRepository.save(userPeter);
            userRepository.save(userAdrian);
            userRepository.save(teacherSophie);
            userRepository.save(adminConnor);
            userRepository.save(teacherWayne);

        }
    }

    private Course initCourse(String name) {
        Course course = new Course();
        course.setName(name);
        course.setLessonBlocks(initBlocks(name));
        courseRepository.save(course);
        return course;
    }

    private List<LessonBlock> initBlocks(String coursePrefix) {
        LessonBlock block_test = new LessonBlock();
        LessonBlock block_db = new LessonBlock();
        LessonBlock block_java = new LessonBlock();

        block_test.setSubject(coursePrefix + " testing");
        block_test.setLessons(initLessons("Testing", 2));
        lessonBlockRepository.save(block_test);

        block_db.setSubject(coursePrefix + " Databases");
        block_db.setLessons(initLessons("Databases", 4));
        lessonBlockRepository.save(block_db);

        block_java.setSubject(coursePrefix + "Java");
        block_java.setLessons(initLessons("Java", 12));
        lessonBlockRepository.save(block_java);

        return List.of(block_db, block_java, block_test);
    }

    private List<Lesson> initLessons(String subject, int count) {
        return IntStream.range(0, count).mapToObj(i -> {
            Lesson lesson = new Lesson();
            lesson.setSubject(subject + " " + i);
            lesson.setDate(LocalDate.now().minusDays(31 - i));
            lessonRepository.save(lesson);
            return lesson;
        }).collect(Collectors.toList());
    }


}
