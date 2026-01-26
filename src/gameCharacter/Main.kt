package gameCharacter

fun main(){
    val pers=GameCharacter("персонаж")
    pers.changeState(CharacterState.run)
    hState(pers.state)

    pers.changeState(CharacterState.atack(50))
    hState(pers.state)

    pers.changeState(CharacterState.death("закончились жизни"))
    hState(pers.state)
}
fun hState(state: CharacterState){
    when (state) {
        CharacterState.bez -> println("Персонаж бездействуе")
        CharacterState.run -> println("Персонаж бежит")
        is CharacterState.atack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.death -> println("Персонаж погиб: ${state.prich}")

    }
}