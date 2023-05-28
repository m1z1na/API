package com.SocialMediaAPI.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/user")

@Tag(name = "Пользователь",
        description = "Класс-контроллер для получения и обновления пользовательской информации")
public class UserController {


        @Operation(summary = "Получить всех друзей")
        @GetMapping("/getFriend")
//        @GetMapping("/{id}")
//        public String findById(@PathVariable int id) {
        public String findById( ) {
//        return this.mapstructMapper.userEducationToUserEducationResponse(usersEducation.getEducationById(id));
            return "123";
        }

//    @Operation(summary = "Получить страницу/Найти сотрудника по маске ФИО")
//    @GetMapping("/page")
//    Page<UsersData> getAll(
//            @RequestParam(value = "fio") Optional<String> fio,
//            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
//            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
//            @RequestParam(value = "sort", defaultValue = "id") String sortField,
//            @RequestParam(value = "sortBy", defaultValue = "ASC" ) Sort.Direction sort
//    ) {
//        String searchValue;
//        if (!fio.isPresent()) {
//            searchValue = "%";
//        } else {
//            searchValue = "%" + fio.get() + "%";
//        }
////        return userData.findByFio(PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, sortField)), searchValue.toLowerCase());
//        return userData.findByFio(PageRequest.of(offset, limit, Sort.by(sort, sortField)), searchValue.toLowerCase());
////        return userData.findByFio(PageRequest.of(offset, limit, UserDataSort.ID_ASC.getSortValue()), searchValue.toLowerCase());
//    }
    }
