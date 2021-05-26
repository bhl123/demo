package com.bhl.demo.BLL.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bhl.demo.BLL.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public interface LoginMapper extends BaseMapper<User> {

    void loginUser(User user);
    
    IPage<User> selectUserList(Page<User> page);
}
