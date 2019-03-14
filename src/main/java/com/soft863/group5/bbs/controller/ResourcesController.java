package com.soft863.group5.bbs.controller;

import com.alibaba.fastjson.JSON;
import com.soft863.group5.bbs.entity.PointRecord;
import com.soft863.group5.bbs.entity.ResourceComments;
import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.entity.User;
import com.soft863.group5.bbs.service.ResourceCommentsService;
import com.soft863.group5.bbs.service.ResourcesService;
import com.soft863.group5.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author zhaosl
 * date 2019/1/16 14:30
 *
 * @version 1.0
 */
@Controller
@RequestMapping("resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private UserService userService;

    @Autowired
    private ResourceCommentsService resourceCommentsService;

    /**
     * 展示所有的资源
     * @return
     */
//    @RequestMapping("listResources")
//    public ModelAndView listResources() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Resources> resources = resourcesService.queryAllResources();
//        modelAndView.addObject("resources", resources);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }

    /**
     * 采用分页来展示资源
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("listResourcesByPage")
    public ModelAndView listResourcesByPage(Integer currentPage) {
        ModelAndView modelAndView = new ModelAndView();
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = 1;
        }
        Integer totalPage = null;
        Integer total = resourcesService.queryResourcesCount(1);
        if (total % 8 != 0) {
            totalPage = total / 8 + 1;
        } else {
            totalPage = total / 8 + 0;
        }
//        Pagination page = new Pagination(currentPage, 8, total);
        Map<String, Object> map = new HashMap<>();
//        map.put("position", page.getPosition());
//        map.put("size", page.getSize());
        map.put("position", (currentPage - 1) * 8);
        List<Resources> resources = resourcesService.queryAllResourcesByPage(map);
        modelAndView.addObject("resources", resources);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.setViewName("index");
        return modelAndView;
    }

//    @RequestMapping("export")
//    public ResponseEntity<byte[]> export() throws Exception {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        httpHeaders.setContentDispositionFormData("attachment", "file.xml");
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(ResourceBundle.getBundle("config").getString("resource-path") + "/file.txt")), httpHeaders, HttpStatus.CREATED);
//    }

    /**
     * 判断前台传过来的user是否为空
     *
     * @param id
     * @param uid
     * @return String
     */
    @RequestMapping(value = "/elementIsNull", produces = "text/javascript;charset=UTF-8")
    @ResponseBody
    public String elementIsNull(Long id, Long uid) {//        ModelAndView modelAndView=new ModelAndView();
//        User user = userService.queryById(userid);
//        if (user!=null){
//            modelAndView.setViewName("forward:downloadResources.action");
//            return modelAndView;
//        }
//        modelAndView.addObject("errorMsg","您未登录，请先登录！");
//        return modelAndView;
        String jsonString = JSON.toJSONString(resourcesService.downloadVerify(id, uid));
        return jsonString;
    }

    /**
     * @param id
     * @param userid
     * @return ResponseEntity
     * @throws Exception
     */
    @RequestMapping(value = "/downloadResources")
    @ResponseBody
    public ResponseEntity<byte[]> downloadResources(Long id, Long userid) throws Exception {
        User user = userService.queryById(userid);
        Resources resources = resourcesService.queryResourcesById(id);
        Integer score = resources.getScore();
        PointRecord pointRecord = new PointRecord(0 - score, new Date(), "资源下载", user);
        Integer count = userService.addPointRecord(pointRecord);
        if (count == 1) {
            Integer newScore = user.getScores() + pointRecord.getIntegral();
            user.setScores(newScore);
            userService.userUpadeScore(user);
        }
        ResponseEntity<byte[]> entity = resourcesService.downloadFileEntity(id);
        return entity;
    }

    /**
     * 上传资源
     *
     * @param userid
     * @param resources
     * @param uploadFile
     * @return ModelAndView
     */
    @RequestMapping("saveResources")
    public ModelAndView saveResources(Long userid, Resources resources, MultipartFile uploadFile) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.queryById(userid);
        boolean flag = resourcesService.uploadFile(user, resources, uploadFile);
        if (flag) {
            modelAndView.setViewName("forward:listResourcesByPage.action");
            return modelAndView;
        } else {
            modelAndView.addObject("error", "添加失败");
        }
        modelAndView.setViewName("forward:upload.action");
        return modelAndView;
    }

    @RequestMapping("toUpload")
    public ModelAndView toUpload() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload");
        return modelAndView;
    }

    /**
     * 下载资源，并修改下载次数
     *
     * @param resources,times
     * @return ModelAndView
     */
    @RequestMapping("downloadCount")
    public ModelAndView downloadCount(Resources resources, Integer times) {
        ModelAndView modelAndView = new ModelAndView();
        resources.setTimes(times);
        resourcesService.plusCount(resources);
        modelAndView.setViewName("forward:listResourcesByPage.action");
        return modelAndView;
    }

//     /*@RequestMapping("downloadResources")
//     public ModelAndView downloadResources(String name, HttpServletResponse response) throws Exception {
//         ModelAndView modelAndView = new ModelAndView();
//         File dest = new File(ResourceBundle.getBundle("config").getString("resource-path"));
//         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "utf-8"));
//         response.setHeader("Content-Length", String.valueOf(dest.length()));
//         byte[] arr = FileUtils.readFileToByteArray(dest);
//         ServletOutputStream out = response.getOutputStream();
//         out.write(arr);
//         out.flush();
//         modelAndView.setViewName("forward:downloadCount.action");
//         return modelAndView;
//     }*/

    /**
     * 按资源id获取资源信息，资源详情展示
     *
     * @param id
     * @return ModelAndView
     */
    @RequestMapping("queryResourcesById")
    public ModelAndView queryResourcesById(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Resources resources = resourcesService.queryResourcesById(id);
        Double filesize = resources.getFilesize();
        String size = resourcesService.setSize(filesize);
        List<ResourceComments> resourceComments = resourceCommentsService.queryResourceComments(id);
        modelAndView.addObject("size", size);
        modelAndView.addObject("resource", resources);
        modelAndView.addObject("comments", resourceComments);
        modelAndView.setViewName("detai");
        return modelAndView;
    }

    /**
     * 删除资源
     *
     * @param id
     * @return ModelAndView
     */
    @RequestMapping("deleteResources")
    public ModelAndView deleteResources(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Integer count = resourcesService.deleteResources(id);
        boolean flag = count > 0 ? true : false;
        if (flag != true) {
            modelAndView.addObject("error", "删除失败");
            modelAndView.setViewName("forward:listResourcesByPage.action");
        }
        return modelAndView;
    }

    /**
     * 修改资源信息
     *
     * @param resources
     * @return ModelAndView
     */
    @RequestMapping("updateResources")
    public ModelAndView updateResources(Resources resources) {
        ModelAndView modelAndView = new ModelAndView();
        Integer count = resourcesService.updateResources(resources);
        boolean flag = count > 0 ? true : false;
        if (flag == true) {
            modelAndView.setViewName("forward:listResourcesByPage.action");
        }
        return modelAndView;
    }

    /**
     * 模糊查询
     *
     * @param name
     * @return ModelAndView
     */
    @RequestMapping("queryResourcesNameLike")
    public ModelAndView queryResourcesNameLike(String name) {
        ModelAndView modelAndView = new ModelAndView();
        List<Resources> resources = resourcesService.queryResourcesByNameLike(name);
        modelAndView.addObject("resources", resources);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
