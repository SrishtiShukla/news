package com.paypal.newsreader.controller;

import com.paypal.newsreader.model.FeedDetails;
import com.paypal.newsreader.service.NewsReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/newsreader/module3")
public class NewsReaderController {

    NewsReaderService newsReaderService;

    @Autowired
    public NewsReaderController(NewsReaderService newsReaderService) {
        this.newsReaderService = newsReaderService;
    }

    @GetMapping(name = "Html Template String", value = "/")
    public String getHtmlTemplateString(@RequestBody @Valid FeedDetails feedDetails) {
        return newsReaderService.prepareHtmlTemplateString(feedDetails);
    }
}
