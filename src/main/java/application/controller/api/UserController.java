package application.controller.api;

import application.data.model.User;
import application.data.service.UserService;
import application.model.api.DataApiResult;
import application.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public DataApiResult getDetail(@PathVariable int id){

        DataApiResult result=new DataApiResult();

        UserDTO userDTO=new UserDTO();

        String username= SecurityContextHolder.getContext().getAuthentication().getName();

        User userEntity =userService.findUserByUsername(username);

        if (userEntity != null) {
            userDTO.setAddress(userEntity.getAddress());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setAvatar(userEntity.getAvatar());
            userDTO.setGender(userEntity.getGender());
            userDTO.setName(userEntity.getName());
            userDTO.setUserName(userEntity.getUserName());
        }

        result.setData(userDTO);
        result.setMessage("done");
        return result;

    }

    @PutMapping("/{id}")
    public DataApiResult updateUser(@PathVariable int id,@RequestBody UserDTO userDTO){

        DataApiResult result=new DataApiResult();

        try{

            User userEntity=userService.findById(id);

            userEntity.setAddress(userDTO.getAddress());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setAvatar(userDTO.getAvatar());
            userEntity.setGender(userDTO.getGender());
            userEntity.setName(userDTO.getName());
            userEntity.setUserName(userDTO.getUserName());

            if(userDTO.getPassword() != null ||
                    ! passwordEncoder.matches(userDTO.getPassword(),userEntity.getPasswordHash())){
                    userEntity.setPassword(userDTO.getPassword());
                    userEntity.setPasswordHash(passwordEncoder.encode(userEntity.getPassword()));
                    userService.updateUser(userEntity);
            }

            result.setData(userEntity);
            result.setMessage("done");

        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("some error");

        }
        return result;
    }


}
