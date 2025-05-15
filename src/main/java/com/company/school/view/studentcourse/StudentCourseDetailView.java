package com.company.school.view.studentcourse;

import com.company.school.entity.StudentCourse;
import com.company.school.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "student-courses/:id", layout = MainView.class)
@ViewController(id = "StudentCourse.detail")
@ViewDescriptor(path = "student-course-detail-view.xml")
@EditedEntityContainer("studentCourseDc")
public class StudentCourseDetailView extends StandardDetailView<StudentCourse> {
}