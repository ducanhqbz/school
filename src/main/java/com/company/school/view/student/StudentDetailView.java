package com.company.school.view.student;

import com.company.school.entity.Course;
import com.company.school.entity.Student;
import com.company.school.entity.StudentCourse;
import com.company.school.view.main.MainView;
import com.company.school.view.studentcourse.StudentCourseDetailView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.Dialogs;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.app.inputdialog.DialogActions;
import io.jmix.flowui.app.inputdialog.DialogOutcome;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.kit.component.button.JmixButton;

import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.jmix.flowui.app.inputdialog.InputParameter.entityParameter;
import static io.jmix.flowui.app.inputdialog.InputParameter.intParameter;

@Route(value = "students/:id", layout = MainView.class)
@ViewController(id = "Student.detail")
@ViewDescriptor(path = "student-detail-view.xml")
@EditedEntityContainer("studentDc")
public class StudentDetailView extends StandardDetailView<Student> {


    @Autowired
    private Dialogs dialogs;

    @Autowired
    private DataManager dataManager;

    @Autowired
    private EntityStates entityStates;


    private InstanceContainer<StudentCourse> stepsDc; // Corrected to stepsDc




    @Subscribe(id = "createbutton", subject = "clickListener")
    public void onCreatebuttonClick( ClickEvent<Button> event) {
        dialogs.createInputDialog(this)
                .withHeader("Enter values")
                .withParameters(
                        entityParameter("Student", Student.class).withLabel("Student"),
                        entityParameter("Course", Course.class).withLabel("Course"),
                        intParameter("Grade").withLabel("Grade").withDefaultValue(1))
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        Student student = (Student) closeEvent.getValue("Student");
                        Course course = (Course) closeEvent.getValue("Course");
                        Integer grade = (Integer) closeEvent.getValue("Grade");

                        if (student != null && course != null && grade != null) {
                            StudentCourse studentCourse = dataManager.create(StudentCourse.class);
                            studentCourse.setStudent(student);
                            studentCourse.setCourse(course);
                            studentCourse.setGrade(grade);

                            //  Save the StudentCourse to the database
                            try {
                                dataManager.save(studentCourse);
                            } catch (Exception e) {
                                //  Handle the exception (e.g., show an error message to the user)
                                e.printStackTrace(); // Log the error for debugging
                                return; //  Important:  Exit if saving fails
                            }
//                            stepsDc.getMutableItems().add(studentCourse);

                            // if the student is new, merge it.
                            if (entityStates.isNew(student)) {
                                dataManager.save(student);
                            }
                            if (entityStates.isNew(course)) {
                                dataManager.save(course);
                            }
                        }
                    }
                })
                .open();
    }


}

