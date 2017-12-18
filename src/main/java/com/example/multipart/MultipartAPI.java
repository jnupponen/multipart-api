package com.example.multipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MultipartAPI {

    private static final Logger LOG = LoggerFactory.getLogger(MultipartAPI.class);
    @RequestMapping(value = "/multipart", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file) {
        LOG.info("Received file {}", file.getOriginalFilename());
        return new ResponseEntity<String>("received "+file.getOriginalFilename(), HttpStatus.OK);
        
    }
}
