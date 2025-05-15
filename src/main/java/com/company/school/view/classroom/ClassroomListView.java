package com.company.school.view.classroom;

import com.company.school.entity.Classroom;
import com.company.school.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "classrooms", layout = MainView.class)
@ViewController(id = "Classroom.list")
@ViewDescriptor(path = "classroom-list-view.xml")
@LookupComponent("classroomsDataGrid")
@DialogMode(width = "64em")
public class ClassroomListView extends StandardListView<Classroom> {
}