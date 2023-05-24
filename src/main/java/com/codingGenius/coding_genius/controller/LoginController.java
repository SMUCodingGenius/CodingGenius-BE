package com.codingGenius.coding_genius.controller;

import com.codingGenius.coding_genius.dto.BaseResponse;
import com.codingGenius.coding_genius.service.LoginService;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    LoginService loginService;

    @PostMapping("/email")
    @ApiOperation(value = "이메일 유효성 요청", notes = "Request Body에 email을 담아서 보내면 해당 이메일로 전송 메세지가 전송됨")
    public BaseResponse<Void> requestEmailValidation(@RequestBody String email) {
        try {
            loginService.requestEmailValidation(email);
            return new BaseResponse<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/email")
    @ApiOperation(value = "이메일 유효성 확인")
    public BaseResponse<Void> checkEmailValidation(@RequestParam("code") String code, @RequestParam("email") String email) {
        try {
            loginService.checkEmailValidation(email, code);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
