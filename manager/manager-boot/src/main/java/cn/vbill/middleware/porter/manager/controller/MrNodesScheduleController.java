/*
 * Copyright ©2018 vbill.cn.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package cn.vbill.middleware.porter.manager.controller;

import cn.vbill.middleware.porter.manager.core.entity.MrNodesSchedule;
import cn.vbill.middleware.porter.manager.service.MrNodesScheduleService;
import cn.vbill.middleware.porter.manager.web.message.ResponseMessage;
import cn.vbill.middleware.porter.manager.web.page.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.vbill.middleware.porter.manager.web.message.ResponseMessage.ok;

/**
 * 节点任务监控表 controller控制器
 *
 * @author: FairyHood
 * @date: 2018-03-07 17:26:55
 * @version: V1.0-auto
 * @review: FairyHood/2018-03-07 17:26:55
 */
@Api(description = "节点任务监控表管理")
@RestController
@RequestMapping("/manager/mrnodesschedule")
public class MrNodesScheduleController {

    @Autowired
    protected MrNodesScheduleService mrNodesScheduleService;

    /**
     * 查询分页
     *
     * @author FuZizheng
     * @date 2018/3/20 上午9:35
     * @param: [pageNo]
     * @return: ResponseMessage
     */
    @GetMapping
    @ApiOperation(value = "查询分页", notes = "查询分页")
    public ResponseMessage list(@RequestParam(value = "pageNo", required = true) Integer pageNo,
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "ipAddress", required = false) String ipAddress,
            @RequestParam(value = "computerName", required = false) String computerName) {
        Page<MrNodesSchedule> page = mrNodesScheduleService.page(new Page<MrNodesSchedule>(pageNo, pageSize), ipAddress,
                computerName);
        return ok(page);
    }

}