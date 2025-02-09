# Particles
**Particles** is a simple library for using and customizing particle effects in Minecraft.

This library is based off [ParticleSFX](https://github.com/hmzel/ParticleSFX) by [hmzel](https://github.com/hmzel)
## Setup
This library is provided through JitPack. To use it, add the following repository and dependency to your `pom.xml` file.
```html  
<repositories>  
  <repository> 
    <id>jitpack.io</id> 
    <url>https://jitpack.io</url> 
  </repository>'
</repositories>  
  
<!-- Not sure why JitPack builds 2 modules, will try to fix in the future... -->  
<dependencies>  
  <dependency> 
    <groupId>com.github.BuggyAl.Particles</groupId> 
    <artifactId>Particles</artifactId> 
    <version>Tag</version> 
  </dependency>
</dependencies>  
```  
Afterward, you should link the library to your plugin in the `onEnable()` method:
```java  
@Override  
public void onEnable() {  
  Particles.setPlugin(this);  
}  
```  
## Usage
### Simple Particles
To summon a basic particle, create an instance of your desired particle, extending `AbstractParticle`. You can find a list of particle types [here](https://github.com/BuggyAl/Particles/tree/master/src/main/java/me/buggyal/particles/particle/impl). Once created, use the `display(Location, List<Players>)` method to show the particle. The `Location` is the intended location for the particle and the `List<Players>` defines who will see the particle. The following is an example of how to display a simple particle to every player in the world.
```java
public static void dislayCritParticle(Location loc) {
  ParticleCrit particle = new ParticleCrit();
  
  // send the particle to every player in the world
  List<Player> players = loc.getWorld().getPlayers();
  
  particle.display(loc, players);
}
```
### Particle Properties
By default, the library will spawn a single particle with default values. These values can be changed by using methods provided by your particle instance. Some properties apply to all particles (count, offset, etc) while others add special functionality to a certain particle. The methods are applied directly to the particle instance and can be chained together. Using the previous particle example, here is how it can be modified to summon particles in a 3x3 area around the origin.

```java
public static void dislayCritParticle(Location loc) {
    ParticleCrit particle = new ParticleCrit().offset(3, 0, 3).count(100);
    List<Player> players = loc.getWorld().getPlayers();
    particle.display(loc, players);
}
```
#### Universal Particle Properties
|**Property**|**Description**|**Method**|**Default Value**|
|--|--|--|--|
|overrideParticleLimit|Overrides Minecraft's default particle limit of 16384.|`.overrideParticleLimit(boolean)`|`False`|
|alwaysShowParticle|Forces the particle to be displayed, even if a player's particles are on a lowered setting.|`.alwaysShowParticle(boolean)`|`True`|
|offset|The maximum distance of the random spread of the particles. Usage varies based on **offsetType**.|`.offset(float, float, float)`<br>`.modifyOffset(float, float, float)`|`(0, 0, 0)`|
|offsetType|The type of random distribution to use for **offset**.|`.offsetType(OffsetType)`<br><br>`OffsetType.UNIFORM`<br>Equal distribution between ± offset.<br><br>`OffsetType.EXPONENTIAL`<br>Distribution concentrated towards the center while decaying to 0 at the ± offsets. This is the default because it gives more precision to developers while maintaining a Minecraft-like distribution.<br><br>`OffsetType.GAUSSIAN` The default Minecraft distribution. Generates ~68% of particles within the specified offsets. Research [standard deviation](https://en.wikipedia.org/wiki/68%E2%80%9395%E2%80%9399.7_rule) for more information.|`EXPONENTIAL`|
|speed|The speed of the particle.|`.speed(float)`|`0`|
|count|The amount of particles to be summoned within the offset bounds.|`.count(int)`|0|
### Particle Shapes
Particle shapes allow you to summon a group of particles in a certain shape. You can find a list of valid shapes [here](https://github.com/BuggyAl/Particles/tree/master/src/main/java/me/buggyal/particles/shapes). Shapes are initialized with a variety of values, depending on the shape type. For example, here the following code summons a circle at the player's location when they sneak.
```java
@EventHandler
public void onSneak(PlayerToggleSneakEvent sneakEvent) {
  Location location = sneakEvent.getPlayer().getLocation();
  if (!sneakEvent.isSneaking()) return; // optional, prevents the circle from summoning twice

  ParticleCrit particle = new ParticleCrit();
  // ShapeCircle takes in 2 parameters: center location and circle radius
  ShapeCircle circle = (ShapeCircle) new ShapeCircle(location, 4).count(25).particle(particle);

  List<Player> onlinePlayers = (List<Player>) Bukkit.getOnlinePlayers().stream().toList();
  // display for 100 ticks (5 seconds)
  circle.players(onlinePlayers).display(100);
}
```
#### Universal Shape Properties
|**Property**|**Description**|**Method**|**Default Value**|
|--|--|--|--|
|particle|The particle to use in the shape display.|`.particle(AbstractParticle)`|`null`|
|async|Whether or not to display the shape asynchronously.|`.async(boolean)`|`True`|
|delayTicks|Time delay in ticks after running `display()` that the shape will appear.|`.delay(int)`|`True`|
|periodTicks|Time delay in ticks between each render of the shape.|`.period(int)`|`1`|
|distribution¹|The method of distributing points across the shape.|`.distribution(ShapeDistribution)`<br><br>`ShapeDistribution.COUNT`<br>Takes in a number of particles and evenly distributes them across the shape.<br><br>`ShapeDistribution.SPREAD`<br>Generates the shape with particles spread apart with an approximate given distance between them.|`COUNT`|
|distributionValue¹|The value for the `distribution` method to use.|`.distributionValue(double)`|`100`|

_¹Note that there exists a `.count(int)` and `.spread(double)` method that will automatically set the distribution method and value at the same time._

#### Advanced Shape Manipulation
Properties of shapes can be modified while a shape is being displayed. For example, the previous circle can be modified to follow the player's location.
```java
@EventHandler
public void onSneak(PlayerToggleSneakEvent sneakEvent) {
  Location location = sneakEvent.getPlayer().getLocation();
  if (!sneakEvent.isSneaking()) return;
  ParticleCrit particle = new ParticleCrit();
  ShapeCircle circle = (ShapeCircle) new ShapeCircle(location, 4).count(25).particle(particle);

  // Define a repeating task that updates the circle's center positon
  AtomicInteger ticks = new AtomicInteger();
  BukkitRunnable task = new BukkitRunnable() {
    @Override
    public void run() {
      // stop updating location after the circle stops displaying
      if (ticks.get() > 100) {
        this.cancel();
        return;
      }
      circle.centerPos(sneakEvent.getPlayer().getLocation());
      ticks.incrementAndGet();
    }
  };
  // run the BukkitRunnable every tick
  task.runTaskTimer(this, 0, 1);

  List<Player> onlinePlayers = (List<Player>) Bukkit.getOnlinePlayers().stream().toList()
  circle.players(onlinePlayers).display(100);
}
```
