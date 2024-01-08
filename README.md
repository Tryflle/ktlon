# KtLon - A double clicker for Weave
## How do I use KtLon?
1. Download and setup [Weave](https://github.com/tryflle/weaveinstalldocs).
2. Download the mod from the [releases](https://github.com/tryflle/ktlon/releases/latest) page.
3. Put the mod in `~/.weave/mods`.
4. Run the mod with Weave.
## KtLon's commands
- `/ktlon` - Gives help for each command.
- `/ktltoggle` - Toggles the mod on and off. (Default: Off)
- `/ktlbutton` - Sets the button to click. (Default: Left)
- `/ktlcps` - Requires you to click at least 5 CPS in order for the mod to work (Default: Off)
- `/ktlchance` - Sets the chance of the mod clicking. (Default: 50%)
## Frequently Asked Questions
### Why don't I see clicks from KtLon on my CPS counter?
Due to the way that Lunar Client's click counter checks for clicks, it would require me to hook the CPS count in order to add KtLon clicks to the CPS count.
### Will my configuration save once I close the game?
Yes! Your configuration will save once you close the game. The configuration is saved at `~/.weave/config/ktlon.json`.
### Does this have randomization?
Of course, KtLon has randomization built in. Clicks from the mod are sent at a random interval after the last click if your chance succeeds.
### Will this get me banned?
https://tryitands.ee
### How do I build KtLon?
1. Clone the repository or download the source code.
2. Execute the task 'shadowJar' with Gradle.
3. The built jar will be in `build/libs` and be called "KtLon-1.0.0-all.jar"
4. Put the jar in `~/.weave/mods`
5. Run the game with Weave.
## Notes
Thank you @SpoilerRules for helping me make the configuration system and efficient delay.
