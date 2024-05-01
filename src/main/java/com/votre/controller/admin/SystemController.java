package com.votre.controller.admin;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.votre.entity.LogInfo;
import com.votre.entity.User;
import com.votre.service.LogInfoService;
import com.votre.service.UserService;
import com.votre.utils.MsgResult;
import com.votre.utils.NetworkUtil;
import com.votre.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class SystemController {

    @Autowired
    UserService userService;

    @Autowired
    LogInfoService logInfoService;

    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/admin/loginAct", method = RequestMethod.POST)
    @ResponseBody
    public MsgResult loginAct(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session, String captcha, HttpServletRequest request) {

        String code = session.getAttribute("code").toString();
          String ipAddress = NetworkUtil.getIpAddress(request);

        if (captcha == null || !code.equals(captcha)) {
              LogInfo logInfo = new LogInfo(username,ipAddress,1,"后台登入失败，验证码错误",new Date());
             logInfoService.addLogInfo(logInfo);
            return MsgResult.build(0, "验证码错误");
        } else {
            User user = userService.checkUser(username, password);
            if (user != null) {
                session.setAttribute("loginUser", user);
                   LogInfo logInfo = new LogInfo(username,ipAddress,0,"后台登入成功",new Date());
                 logInfoService.addLogInfo(logInfo);
                return MsgResult.build(1, "登入成功");
            } else {
                  LogInfo logInfo = new LogInfo(username,ipAddress,1,"后台登入失败，账号不存在或密码错误",new Date());
                logInfoService.addLogInfo(logInfo);
                return MsgResult.build(0, "账号不存在或密码错误");
            }
        }
    }
    @RequestMapping({"/admin/index","/admin"})
    public String index(Model model, HttpSession session){
        User user = UserUtils.getSubjectUser(session);
        model.addAttribute("user", user);
        return "admin/index";
    }

    @RequestMapping("/admin/welcome")
    public String welcome(Model model, HttpSession session) {
        User user = UserUtils.getSubjectUser(session);
        model.addAttribute("user", user);
        return "admin/welcome";
    }
    @RequestMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "/admin/login";
    }
    @GetMapping("/admin/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 3);
        session.setAttribute("code", lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(), "JPEG", outputStream);

    }

}
