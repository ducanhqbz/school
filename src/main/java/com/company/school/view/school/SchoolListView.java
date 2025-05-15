package com.company.school.view.school;

import com.company.school.entity.School;
import com.company.school.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "schools", layout = MainView.class)
@ViewController(id = "School.list")
@ViewDescriptor(path = "school-list-view.xml")
@LookupComponent("schoolsDataGrid")
@DialogMode(width = "64em")
public class SchoolListView extends StandardListView<School> {
}