package com.company.school.view.classroom;

import com.company.school.entity.Classroom;
import com.company.school.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "classrooms/:id", layout = MainView.class)
@ViewController(id = "Classroom.detail")
@ViewDescriptor(path = "classroom-detail-view.xml")
@EditedEntityContainer("classroomDc")
public class ClassroomDetailView extends StandardDetailView<Classroom> {
}