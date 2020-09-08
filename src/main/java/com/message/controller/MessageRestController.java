package com.message.controller;

import com.message.dto.MessageDto;
import com.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/message")
@Slf4j 
@RestController
class MessageRestController {
	@Autowired
	private MessageService messageService; 

	@PostMapping("/save")
	public @ResponseBody ResponseEntity<List<MessageDto>> sendMessage(@RequestBody List<MessageDto> messageDtos ) throws Exception {
		for (MessageDto messageDto:messageDtos) {
			messageService.save(messageDto);
		}
		return new ResponseEntity<List<MessageDto>>(messageDtos, HttpStatus.OK);
	}


	@PostMapping
	public @ResponseBody ResponseEntity<List<MessageDto>> sendMessageList(@RequestBody List<MessageDto> messageDtos ) throws Exception {
		for (MessageDto messageDto:messageDtos) {
			messageService.save(messageDto);
		}
		return new ResponseEntity<List<MessageDto>>(messageDtos, HttpStatus.OK);
	}
}
