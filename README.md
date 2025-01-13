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
    </repository>
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
