package com.paypal.newsreader.service;

import com.paypal.newsreader.model.FeedDetails;
import com.sun.deploy.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NewsReaderService {

    private static final Logger logger = LogManager.getLogger(NewsReaderService.class);

    @Value("${twitter.link}")
    private String TWITTER_LINK;

    public String prepareHtmlTemplateString(FeedDetails feedDetails) {

        String content = feedDetails.getCrawledFeed();
        String patternString = "\\b(" + StringUtils.join(feedDetails.getEntities(), "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(feedDetails.getCrawledFeed());
        while (matcher.find()) {
            logger.info(matcher.group(1));
            content = content.replace(matcher.group(1), "<strong>" + matcher.group(1) + "</strong>");
        }

        if (!feedDetails.getLink().isEmpty() && !feedDetails.getLink().equals(null)) {
            content = content.replaceAll(feedDetails.getLink(), "<a href=\"" + feedDetails.getLink() + "\">" + feedDetails.getLink() + "</a>");
        }

        if (!feedDetails.getTwitter_handle().isEmpty() && !feedDetails.getTwitter_handle().equals(null)) {
            content = content.replaceAll(feedDetails.getTwitter_handle(), "<a href =\"" + TWITTER_LINK + feedDetails.getTwitter_handle() + "\">"
                    + feedDetails.getTwitter_handle() + "</a>");
        }
        logger.info("======================== Content " + content);
        return content;
    }
}
