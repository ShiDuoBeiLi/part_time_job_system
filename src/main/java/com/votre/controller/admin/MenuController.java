package com.votre.controller.admin;

import com.votre.entity.Menu;
import com.votre.entity.User;
import com.votre.service.MenuService;
import com.votre.utils.MenuTree;
import com.votre.utils.MsgResult;
import com.votre.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    /*加载左侧菜单*/
    @RequestMapping("/indexLeftMenuJson")
    @ResponseBody
    public Map<String, Object> indexLeftMenuJson(HttpSession session) {
        Map<String, Object> retMap = new HashMap<>();
        User user = UserUtils.getSubjectUser(session);
        List<Menu> menus = menuService.getALLMenuListByUserId(user.getId(), true);
        // homeInfo
        retMap.put("homeInfo", new Menu("首页", "/admin/welcome"));

        retMap.put("menuInfo", menus);
        return retMap;
    }

    /*转至菜单管理页面*/
    @RequestMapping("/toMenuManager")
    public String toMenuManager() {
        return "admin/menuManager";
    }

    /*菜单列表*/
    @ResponseBody
    @RequestMapping("/listMenuAct")
    public Map<String, Object> listMenuAct() {
        Map<String, Object> retMap = new HashMap<>();
        List<Menu> menus = menuService.getALLMenuList();
        retMap.put("code", 200);
        retMap.put("data", menus);
        return retMap;
    }

    /*树状菜单*/
    @ResponseBody
    @RequestMapping("/listTreeMenuAct")
    public MsgResult listTreeMenuAct() {
        List<MenuTree> menuTrees = menuService.getListALLMenuList();
        return new MsgResult(0,"操作成功",menuTrees);
    }

    /*转至增加子菜单页面*/
    @RequestMapping(value = "/addMenu", method = RequestMethod.GET)
    public String addChildMenu() {
        return "admin/addMenu";
    }

    @ResponseBody
    @RequestMapping(value = "/addMenuAct",method = RequestMethod.POST)
    public MsgResult addMenuAct(Menu menu) {
        int retNum = menuService.addMenu(menu);
        if (retNum == 1) {
            return MsgResult.build(1, "增加成功");
        } else {
            return MsgResult.build(0,"增加失败,请重新添加");
        }
    }

    /*转至修改页面*/
    @RequestMapping(value = "/editMenu/{id}")
    public String editMenu(@PathVariable("id") int id, Model model){
        Menu menu = menuService.getMenuById(id);
        model.addAttribute("menu",menu);
        return "admin/editMenu";
    }

    @ResponseBody
    @RequestMapping(value = "/editMenuAct",method = RequestMethod.POST)
    public MsgResult editMenuAct(Menu menu){
        int retNum = menuService.editMenu(menu);
        if (retNum == 1) {
            return MsgResult.build(1, "修改成功");
        } else {
            return MsgResult.build(0, "修改失败，请重新提交");
        }
    }

    /*删除菜单*/
    @RequestMapping(value = "/deleteMenuAct", method = RequestMethod.POST)
    @ResponseBody
    public MsgResult deleteMenuAct(@RequestParam(name = "id") int id) {
        int retNum = menuService.deleteMenu(id);
        if (retNum == 1) {
            return MsgResult.build(1, "删除成功");
        } else {
            return MsgResult.build(0, "删除失败，请重新提交");
        }
    }
}
