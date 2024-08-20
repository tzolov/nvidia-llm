# Demo App: SpringAI - NVIDIA LLM API integration

[NVIDIA LLM API](https://docs.api.nvidia.com/nim/reference/llm-apis) is a proxy AI Inference Engine offering a wide range of models from [various providers](https://docs.api.nvidia.com/nim/reference/llm-apis#models).

Spring AI integrates with the NVIDIA LLM API by reusing the existing Spring AI [OpenAI](https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html) client. 

For this you need to set the base-url to `https://integrate.api.nvidia.com`, select one of the provided https://docs.api.nvidia.com/nim/reference/llm-apis#model[LLM models] and get an `api-key` for it.

![SpringAI - NVIDIA LLM API integration](/doc/SpringAI-NVIDIA-API.jpg)

NOTE: NVIDIA LLM API requires the `max-token` parameter to be explicitly set or server error will be thrown.

Find more in the SpringAI/NVIDIA Reference documentation: https://docs.spring.io/spring-ai/reference/api/chat/nvidia-chat.html