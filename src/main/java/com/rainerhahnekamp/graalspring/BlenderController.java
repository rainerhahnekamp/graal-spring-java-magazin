package com.rainerhahnekamp.graalspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blender")
public class BlenderController {
    private final Blender blender;

    BlenderController(Blender blender) {
        this.blender = blender;
    }

    @GetMapping("")
    public String blend() {
        blender.run();
        return "blended";
    }
}
