package com.hmc.zntc.admin.modules.sys.service.impl;

import com.hmc.zntc.admin.mapper.SysMenuMapper;
import com.hmc.zntc.admin.mapper.SysUserMapper;
import com.hmc.zntc.admin.mapper.SysUserTokenMapper;
import com.hmc.zntc.admin.modules.sys.entity.SysMenuEntity;
import com.hmc.zntc.admin.modules.sys.entity.SysUserEntity;
import com.hmc.zntc.admin.modules.sys.entity.SysUserTokenEntity;
import com.hmc.zntc.admin.modules.sys.service.ShiroService;
import com.hmc.zntc.admin.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuMapper sysMenuDao;
    @Autowired
    private SysUserMapper sysUserDao;
    @Autowired
    private SysUserTokenMapper sysUserTokenDao;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
