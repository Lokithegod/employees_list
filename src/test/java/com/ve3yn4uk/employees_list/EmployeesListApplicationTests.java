package com.ve3yn4uk.employees_list;

import com.ve3yn4uk.employees_list.controller.EmployeeController;
import com.ve3yn4uk.employees_list.controller.ProjectController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesListApplicationTests {

    @Autowired
    private MockMvc  mockMvc;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private ProjectController projectController;


    @Test
    public void contextLoads() throws Exception {

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
