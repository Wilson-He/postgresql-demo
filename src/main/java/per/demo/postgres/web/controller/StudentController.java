package per.demo.postgres.web.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StudentController
 *
 * @author Wilson
 * @since 2018-04-17
 */
@Api(value = "StudentController", tags = {"StudentController"}, description = "StudentController")
@RequestMapping("/student")
public interface StudentController {
    @ApiOperation(value = "[Doc]查看详情", notes = "查看详情")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "访问成功", response = Object.class)})
    @GetMapping("/get")
    Object get(@ApiParam(name = "id", value = "") @RequestParam String id);

    @ApiOperation(value = "[Doc]分页查询", notes = "分页查询")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "访问成功", response = Object.class)})
    @GetMapping("/page")
    Object page(@ApiParam(name = "page", value = "页码", defaultValue = "1") @RequestParam(defaultValue = "1") Integer page,
                @ApiParam(name = "size", value = "每页返回数", defaultValue = "15") @RequestParam(defaultValue = "15") Integer size);

    @ApiOperation(value = "[Doc]更新", notes = "更新")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "访问成功", response = Object.class)})
    @PostMapping("/update")
    Object update();

    @ApiOperation(value = "[Doc]删除", notes = "删除")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "访问成功", response = Object.class)})
    @PostMapping("/delete")
    Object delete(@ApiParam(name = "id", value = "") @RequestParam String id);

}
