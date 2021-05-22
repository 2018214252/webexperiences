package com.example.webexperiences.experience05;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webexperiences.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressMapper02 extends BaseMapper<Address> {
    List<AddressDTO> listAddressDTOs(@Param("detail") String detail);
}
