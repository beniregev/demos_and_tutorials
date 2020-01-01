package com.beniregev.demos_and_tutorials.controller;

import com.beniregev.demos_and_tutorials.service.DemosAndTutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemosAndTutorialsController {
    @Autowired
    private DemosAndTutorialsService demosAndTutorialsService;
}
