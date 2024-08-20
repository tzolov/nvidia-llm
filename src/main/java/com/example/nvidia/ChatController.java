/*
* Copyright 2024 - 2024 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.nvidia;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

/**
 * @author Christian Tzolov
 */
@RestController
public class ChatController {

	private final ChatClient chatClient;

	@Autowired
	public ChatController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/ai/generate")
	public String generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
		String response =   chatClient.prompt().user(message).call().content();
		return response;
	}

	@GetMapping("/ai/generateStream")
	public Flux<String> generateStream(
			@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
		return chatClient.prompt().user(message).stream().content();
	}

}
