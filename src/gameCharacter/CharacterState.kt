package gameCharacter

sealed class CharacterState  (){
    object bez : CharacterState()
    object run : CharacterState()
    data class atack (val damage: Int) : CharacterState()
    data class death(val prich: String) : CharacterState()

}