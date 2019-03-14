package com.soft863.group5.bbs.service;

import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/15 20:54
 *
 * @version 1.0
 */
public interface ResourcesService {

    Resources queryResourcesById(Long id);

    /**
     * 按资源的名字查询资源
     *
     * @param name
     * @return
     */
    Resources queryResourcesByName(String name);

    /**
     * 按照资源的名字做模糊查询
     *
     * @param name
     * @return
     */
    List<Resources> queryResourcesByNameLike(String name);

    List<Resources> queryAllResources();

    List<Resources> queryAllResourcesByPage(Map<String, Object> map);

    Map<String, String> downloadVerify(Long rid, Long uid);


    ResponseEntity<byte[]> downloadFileEntity(Long id) throws Exception;

    /**
     * 添加用户
     *
     * @param resources
     */
    Integer addResources(Resources resources);

    /**
     * 按照资源id删除
     *
     * @param id
     * @return Integer
     */
    Integer deleteResources(Long id);

    /**
     * 修改资源
     *
     * @param resources
     * @return
     */
    Integer updateResources(Resources resources);

    /**
     * 查询记录的条数
     *
     * @return Integer
     */
    Integer queryResourcesCount(Integer pass);

    Integer plusCount(Resources resources);

    boolean uploadFile(User user, Resources resources, MultipartFile uploadFile);

    String setSize(Double filesize);
}
