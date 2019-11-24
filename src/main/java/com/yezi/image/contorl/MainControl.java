package com.yezi.image.contorl;

import com.yezi.image.info.User;
import com.yezi.image.mysql.MySqlEntity;
import com.yezi.image.mysql.PersonExecutor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@Controller
public class MainControl {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "register.action",method = RequestMethod.POST)
    public void register(User user,HttpServletResponse response){
        PersonExecutor personExecutor = MySqlEntity.getMySqlEntity().getPersonExecutorImple();
        try {
            PrintWriter printWriter = response.getWriter();
            if (!personExecutor.checkUser(user.getAccount(), user.getPass())) {
                personExecutor.writerUser(user);
                printWriter.print("success");
            }
            else
                printWriter.print("failed");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
