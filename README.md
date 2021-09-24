# MiningMannies
Remote upload of my (kreatorKen) <a href="https://mcreator.net/modification/67670/mining-mannies">MiningMannies mod</a> for <a href="https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.15.2.html">Forge 1.15.2</a> made with the great help of MCreator (https://mcreator.net/). You will need one MCreator plug-in before you import the workspace: <a href="https://mcreator.net/forum/60635/miscellaneous-plugin-114115">Misclenous Plugin</a>. You can find the manual here <a href="https://www.kezmonk.com/stuff/minecrafting/miningmannies/index.html">v.1.x.x</a>.
<pre>
v1.0.x
	official beta release
v1.1.x 
    corrected phase34 slot bug
    added Steel Bar advancement (was missing): recipe release.
    corrected Steel Block advancement: recipe release.
    made steel stackable.

v.2.0.0
    seekers now actually seek through blocks below them and will dig to the object they detect. level 1: 32 blocks. level 2: 64 blocks. Will add a level 3 and 4 in the future.
    changed OreDetector to scan the block which is clicked on and not stood on.
    teleport drop now possible when destroyed dependent on the teleport probability. Found a few small bugs in the teleport calcs. Fixed those and found a way to keep it when you exit the game and come back.
	
	v.2.2
	simplified the recipie for making an oreDetector, found a small bug for gold detection
	ore detectors scan all ores to 64 blocks and then deeper for a selected block chosen by sneak-left click that way one can look for redstone and make a transporter... and then have fun letting the Mannies make a mess.

v.2.2.2
	fixed small oreDetector bug (couldn't use the left-shift click to toggle ore). Um, you have to 
	craft it to toggle the deep search function. Otherwise, just Coal is activated by defaut.

v.2.2.5
	Made the manni teleport item limit a function of the teleport chance - the higher the chance 
	the lower the minimum items in their slot needed for teleportation. 
	
v.3.0.0	

	Changed climbing axe recipe to make it more accessible at the beginning of survival, also made it work for all rock, earth and grass blocks.

	Changed mannies dig tick rate to every 1 second instead of every tick. Slows them down, allows you to dig with them.

	Changed mannies to "creatures" instead of monsters, to allow you to dig and sleep with them. Corrected a bug when you speed up their evolution which caused them to dig less.
	
	Changed battery recipe to shapeless, use lapis instead of a tripwire hook.

	Redesign of the Seekers.  

		Seekers 1.0 see 32 blocks down. Their search items are flowers - each flower is matched to a certain ore.
		coal = White Tulip
		iron = Dandelion
		redstone = Oxeye Daisy 
		gold = Azure Bluet 
		lapis = Cornflower
		nether = Lilac
		emerald = Rose Bush
		diamond = Peony

		Seekers 2.0 see 64 blocks down. Level 2.0 evolves to Level 3.0

		Seekers 3.0 can search and digs 128 blocks down to a specific ore and harvests it, teleports back to you and drops it in front of you. 

		Ore recipes will be reserved for Seekers 4.0 which will mine the entire vein before teleporting back to you.

		Added Seeker egg drop to each evolution to a new level. You get a seeker egg level 1 when a Level 1 Manni goes to Level 2, 
		seeker level 2 egg when a Manni goes from 2 to 3, and seeker level 3 egg when a Manni goes from level 3 to 4.

v.3.1.0	
	Added a command, /mannichatter, to toggle their chatter on or off.

v.3.1.1
	A single climbing axe still resulted in taking fall damage in survival mode, corrected.

v.3.1.2
	Single climbing axe angle was off, corrected.

v.3.2.0
	Added 1 xp point per manni evolution. Changed the global variables to GLOBAL_MAP.

v.3.2.1
	Sorry. I uploaded the debug version of 320. This is the working version.

v.3.2.2
	Okay. I tried the GLOBAL_MAP variable for all of my global variables but apparently they reset after a long while, no good. All are now GLOBAL_SESSION, they way they used to be.


</pre>
