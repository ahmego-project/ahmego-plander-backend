package com.bangshinchul.backend.sample;

import com.bangshinchul.backend.sample.model.TestMessageView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public TestMessageView test() {
        TestMessageView view = new TestMessageView();
        view.setStatusCode("200");
        view.setMessage("Hello world! this is test message@");
        return view;
    }

}
