package com.amber.data.convert;

import com.amber.data.User;
import com.amber.data.vo.UserVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserVOConvertToUser {

    public List<User> userVOConvertToUser(List<UserVO> userVOS) {
        return userVOS.stream().map(userVO -> {
            User user = new User();
            user.setFirstName(userVO.getFirstName());
            user.setLastName(userVO.getLastName());
            user.setEmailAddress(userVO.getEmailAddress());
            return user;
        }).collect(Collectors.toList());

    }
}
