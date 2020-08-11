package blackjack.view

import kotlin.system.exitProcess

object Input {
    fun name(): List<String> {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        return readLine()?.split(",") ?: exitProcess(0)
    }

    fun race(name: String): Boolean {
        println("${name}는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)")
        return if (readLine().toString() == "y") true else false ?: exitProcess(0)
    }
}
