- First of all create the interface Combatant with describing the following variables: health (double type), attack power (double type), defense (double type), speed (double type), special abilities (it could be different type depends on our desires and imagine), and the following methods: attack (returns double power), defend (returns double defense), and speed (returns double speed).

- Create also an enum class CombatantType with types like warriors, mages, archers, etc.
- Create also an enum class Scenario with types like duels, group battles, etc.
- Create also an enum class Time with types like day, night, morning, etc.
- Create also an enum class Environ with types like mounts, wood, etc.

- Then we can create as many combatants as we want, each implementing the Combatant interface and inheriting its methods. Every combatant can have their own specific values for health, attack power, defense, and speed. Additionally, each combatant can have a role variable of type CombatantType.

- The next class is BattleField. This class can include variables such as scenario, time, and environment, each derived from their corresponding enums. These conditions are selected by users. After setting the environment, users can choose their combatants and start the game.

- The game begins by calling the run() method. The user inputs commands, and run() triggers the appropriate methods such as attack(), defend(), and, if applicable, the activation of special abilities. Attacks reduce the opponent’s health until one combatant’s health reaches zero. At that point, the game ends: the combatant with remaining health is declared the winner. If both combatants reach zero health simultaneously, the result is a draw.

- This same logic can be extended to group battles. 

- When a user tries to activate a special ability, the run() method checks whether the ability is available in the current context. If it is, the method executes the ability accordingly. 

- All character stats—health, attack power, defense, and speed—are influenced by the environment and time of day, potentially increasing or decreasing based on those conditions. For example, nighttime reduces archers' attack power by 10 points.
