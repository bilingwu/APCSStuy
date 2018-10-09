<center> The Binding of Stuysaac </center>
=======
The amazing final project of Johnny, Sara, Joseph, Kevin  

Game Basics
=======
You are the yellow icon, Hero. Your enemies are the brown icons, monster. The start up screen will appear. After 5 seconds, the actual game screen will open up. This game works by a point system. The game begins when you make your first move.
Controls:
- the <b> arrows</b> keys are used to navigate.
- the <b> w,a,s,d </b> keys are used to shoot your weapons
The game ends when you are out of health or HP, which  is conveiniently placed under the canvas.

Bugs/ Things that can be improved upon
======
- The motion could be smoother
- The game is ridiclously hard. Game balancing will be a big priority. 
- More variety, in rooms, bosses, floors
- We had been working on drops (or power ups) (there is already some code for that)

Changelog 
=======
- 12/19/14 ---	Added repo
- 12/22/14 ---		Added Basechar, Baseroom
- 12/23/14 ---	Added Thing (The general object class)
- 12/23/14 ---	Updated Baseroom (with addThing)
- 01/05/15 ---	Changed Basechar to Hero, added some other misc
- 01/06/15 ---	Added Driver, fixed up a Hero constructor
- 01/07/15 ---	Created rooms and things folders to hold the different rooms and things, added Desk, added Spawnroom
- 01/07/15 ---	Added a Projectile class that will handle the attacks of a monster/boss
- 01/08/15 ---	Added Enviro, an extension of Thing, changed Desk to extend Enviro, added Trashcan to extend Enviro, added booleans movable and breakable to Enviro, finished writing Desk and Trashcan
- 01/08/15 ---	Added abstract createRoom method to Baseroom, wrote createRoom for Spawnroom
- 01/09/15 ---	Added get methods to Baseroom, added Treasureroom
- 01/12/15 ---	Projectiles fnished
- 01/13/15 ---	GUI attempted, starting with window
- 01/13/15 ---	New png images for objects added
- 01/13/15 ---	Boundary added to the window, background image added
- 01/13/15 ---  Found source of driver errors
- 01/14/15 ---	Dealt with bugs thats prevent the driver from compiling
- 01/15/15 ---  Starbucks and Halal food items added
- 01/19/15 ---	Changed the algorithm from grid layout to just coordinate based
- 01/20/15 ---  Monsters generating functions
- 01/20/15 ---  Updated hero file
- 01/13/14 ---	New png images for objects added
- 01/13/14 ---	Boundary added to the window, background image added
- 01/14/15 ---	Dealt with bugs thats prevent the driver from compiling
- 01/19/15 ---	Changed the algorithm from grid layout to just coordinate based
- 01/21/15 ---  Boundaries for the character to be limited
- 01/21/15 ---  Unity collision 
- 01/21/15 ---  Changed plans of multiple floors to single floor survival
- 01/22/15 ---  Start and end screen added
- 01/23/15 ---  Easier maneuvering and less lags
