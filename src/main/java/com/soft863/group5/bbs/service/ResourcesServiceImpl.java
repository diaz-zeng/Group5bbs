package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.dao.ResourcesMapper;
import com.soft863.group5.bbs.dao.UserMapper;
import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.entity.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * author zhaosl
 * date 2019/1/15 20:54
 *
 * @version 1.0
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    public ResourcesServiceImpl() {
    }

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Resources queryResourcesById(Long id) {

        return resourcesMapper.queryResourcesById(id);
    }

    @Override
    public Resources queryResourcesByName(String name) {

        return resourcesMapper.queryResourcesByName(name);
    }

    @Override
    public List<Resources> queryResourcesByNameLike(String name) {
        StringBuilder sb = new StringBuilder("%");
        name = sb.append(name).append("%").toString();
        return resourcesMapper.queryResourcesByNameLike(name);
    }

    @Override
    public List<Resources> queryAllResources() {

        return resourcesMapper.queryAllResources();
    }

    @Override
    public List<Resources> queryAllResourcesByPage(Map<String, Object> map) {
        return resourcesMapper.queryAllResourcesByPage(map);
    }

    @Override
    public Map<String, String> downloadVerify(Long rid, Long uid) {
        Map<String, String> map = new HashMap();
        User user = userMapper.queryById(uid);
        map.put("status", "failed");
        if (user != null) {
            Resources resources = resourcesMapper.queryResourcesById(rid);
            if (resources != null) {
                map.put("userScore", String.valueOf(user.getScores()));
                map.put("status", "success");
                map.put("url", String.format("/resources/downloadResources.action?id=%d&userid=%d", resources.getId(), user.getId()));
            } else {
                map.put("msg", "资源不存在，可能已被删除!");
            }
        } else {
            map.put("msg", "登录状态异常，请重新登录!");
        }
        return map;
    }

    @Transactional
    @Override
    public ResponseEntity<byte[]> downloadFileEntity(Long id) throws Exception{
        ResponseEntity<byte[]> responseEntity = null;
        Resources resources = resourcesMapper.queryResourcesById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", resources.getTruename());
        resourcesMapper.plusCount(resources);
        File file = new File(ResourceBundle.getBundle("config").getString("resource-path") + resources.getFilepath());
        responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);

        return responseEntity;
    }

    @Override
    public Integer addResources(Resources resources) {

        return resourcesMapper.addResources(resources);
    }

    @Override
    public Integer deleteResources(Long id) {
        Resources resources = queryResourcesById(id);
        if (resources != null) {
            return resourcesMapper.deleteResources(id);
        }
        return null;
    }

    @Override
    public Integer updateResources(Resources resources) {
        return resourcesMapper.updateResources(resources);
    }

    @Override
    public Integer plusCount(Resources resources) {
        return resourcesMapper.plusCount(resources);
    }

    @Override
    public Integer queryResourcesCount(Integer pass) {

        return resourcesMapper.queryResourcesCount(pass);
    }

    @Override
    public boolean uploadFile(User user, Resources resources, MultipartFile uploadFile) {
        try {
            if (uploadFile != null) {
                String truename = uploadFile.getOriginalFilename();
                String filepath = UUID.randomUUID().toString() + truename;
                File file = new File("d:/resources", filepath);
                Double size = Double.valueOf(uploadFile.getSize());
                resources.setTruename(truename);
                resources.setFilepath(filepath);
                resources.setFilesize(size);
                uploadFile.transferTo(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resources.setUser(user);
        resources.setDate(new Date());
        resources.setTimes(0);
        resources.setCheck(0);
        Integer count = addResources(resources);
        boolean flag = count == 1 ? true : false;
        return flag;
    }

    @Override
    public String setSize(Double filesize) {
        String size = null;
        if (filesize == null || filesize==0) {
            size = 0 + "B";
        } else if (0 <= filesize && filesize <= 1024) {
            String format = String.format("%.2f", filesize / 1024);
            size = format + "B";
        } else if (1024 < filesize && filesize <= 1048576) {
            String format = String.format("%.2f", filesize / 1024);
            size = format + "KB";
        } else if (1048576 < filesize && filesize <= 1073741824) {
            String format = String.format("%.2f", filesize / 1024);
            size = format + "MB";
        }else {
            String format = String.format("%.2f", filesize / 1024);
            size = format + "GB";
        }
        return size;
    }
}