package gameCharacter

class GameCharacter(
    val name: String,
    var state: CharacterState= CharacterState.bez
) {
    fun changeState(newstate: CharacterState) {
        state=newstate
    }

}