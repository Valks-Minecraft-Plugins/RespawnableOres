# RespawnableOres

Download the appropriate release [here](https://github.com/valkyrienyanko/RespawnableOres/releases).

Fully configurable respawnable ores plugin.

### Configuration Tutorial

```yml
ores:
  regions:
    r1: # The first position of the region the blocks will be effected in.
      x: 0
      y: 0
      z: 0
    r2: # The second position of the region the blocks will be effected in.
      x: 10000
      y: 256
      z: 10000
  types: # Put the blocks here that you want effected.
  - COBWEB
  cobweb:
    respawntime: 3 # Time in seconds.
    respawnblock: DIRT # The block that you see when your waiting for the original block to respawn.
```

<details><summary>Config Preview (Click to Expand)</summary>
<p>

#### ores.yml

```yml
ores:
  regions:
    r1:
      x: 0
      y: 0
      z: 0
    r2:
      x: 10000
      y: 256
      z: 10000
  types:
  - COAL_ORE
  - IRON_ORE
  - GOLD_ORE
  - REDSTONE_ORE
  - EMERALD_ORE
  - DIAMOND_ORE
  - LAPIS_ORE
  - QUARTZ_ORE
  coal_ore:
    respawntime: 10
    respawnblock: STONE
  iron_ore:
    respawntime: 10
    respawnblock: STONE
  gold_ore:
    respawntime: 10
    respawnblock: STONE
  redstone_ore:
    respawntime: 10
    respawnblock: STONE
  emerald_ore:
    respawntime: 10
    respawnblock: STONE
  diamond_ore:
    respawntime: 10
    respawnblock: STONE
  lapis_ore:
    respawntime: 10
    respawnblock: STONE
  quartz_ore:
    respawntime: 10
    respawnblock: STONE
```
</p>
</details>
