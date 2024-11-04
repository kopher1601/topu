package jp.co.kopher1601.topu.recruitment.controller

import jp.co.kopher1601.topu.recruitment.request.PostRecruitmentRequest
import jp.co.kopher1601.topu.recruitment.service.PostRecruitment
import jp.co.kopher1601.topu.recruitment.service.RecruitmentService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class RecruitmentController @Autowired constructor(
    private val recruitmentService: RecruitmentService,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/recruitments")
    fun post(request: PostRecruitmentRequest) {
        recruitmentService.post(PostRecruitment.from(request))
    }
}