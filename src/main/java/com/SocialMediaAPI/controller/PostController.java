package com.SocialMediaAPI.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/post")

@Tag(name = "Посты",
        description = "Класс-контроллер для взаимодействия с постами ")
public class PostController {


    @Operation(summary = "Получить пост по id")
    @GetMapping("/{id}")
    public Object findById(@PathVariable int id) {
//        return this.mapstructMapper.userEducationToUserEducationResponse(usersEducation.getEducationById(id));
        return null;
    }


}
