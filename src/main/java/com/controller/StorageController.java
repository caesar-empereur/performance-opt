package com.controller;

import com.model.Storage;
import com.repository.StorageRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/4/28.
 */
@Api(value = "库存相关接口")
@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {

    @Resource
    private StorageRepository storageRepository;

    @GetMapping("/decrease")
    public String descrease(){
        Integer res = storageRepository.descreaseCount(1L);
        if (res > 0) {
            log.info("扣减成功");
            return "成功";
        } else {
            log.info("扣减失败");
            return "失败";
        }
    }

    @GetMapping("/save")
    public void save(){
        Storage storage = new Storage();
        storage.setCount(0);
        storage.setVersion(1);
        storage.setSkuCode(UUID.randomUUID().toString());
        storageRepository.save(storage);
    }
}
