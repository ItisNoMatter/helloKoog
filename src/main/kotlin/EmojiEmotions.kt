package org.example

sealed interface EmojiEmotions {
    val emoji: String
    data object Good : EmojiEmotions{
        override val emoji: String = "☺️"
    }
    data object Bad : EmojiEmotions{
        override val emoji: String = "😫"
    }
    data object Ok : EmojiEmotions{
        override val emoji: String = "😐"
    }
}
