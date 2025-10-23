package org.example

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.dsl.builder.forwardTo
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.prompt.executor.clients.google.GoogleModels
import ai.koog.prompt.executor.llms.all.simpleGoogleAIExecutor
import kotlinx.coroutines.runBlocking


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking {
    val apiKey = System.getenv("GoogleApiKey") ?: error("OPENAI_API_KEY is not set")

    val strategy = strategy<String, EmojiEmotions>("my-strategy"){
        val translateToEmoji by node<String, EmojiEmotions>{
            EmojiEmotions.Good
        }
        edge(nodeStart forwardTo translateToEmoji)
        edge(translateToEmoji forwardTo nodeFinish)
    }

    val agent = AIAgent(
        promptExecutor = simpleGoogleAIExecutor(apiKey),
        strategy = strategy,
        llmModel = GoogleModels.Gemini2_0FlashLite
    )
    val result: EmojiEmotions = agent.run("オブジェクト指向とは何ですか")
    println(result)
}