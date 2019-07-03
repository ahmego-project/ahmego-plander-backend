package com.bangshinchul.backend.SalesManagement;

import com.bangshinchul.backend.auth.Auth;
import com.bangshinchul.backend.common.utils.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/salesManage")
public class ManagementController {

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DESIGNER')")
    @GetMapping("/find")
    public Object findSalesInfoByDate(
            @RequestHeader HttpHeaders header,
            @RequestParam("startAt") String startAt, @RequestParam("endAt") String endAt) {
        log.info("]---->[Controller] ManagementController :: findSalesInfoByDate CALL :: params -> startAt:{} , endAt:{}", startAt, endAt);

        String authorization = header.get("Authorization").get(0);
        Auth decodeAuth = HashUtil.basicToken(authorization);
        Long userId = decodeAuth.getId();
        log.info("]---->[Controller] ManagementController :: findSalesInfoByDate Request User's ID : {}", userId);
        return null;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DESIGNER')")
    @GetMapping("/insert")
    public String SalesInfoInsert() {

        return "InsertComplete!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DESIGNER')")
    @GetMapping("/update")
    public String SalesInfoUpdate() {
        return "Hello world!";
    }

}
