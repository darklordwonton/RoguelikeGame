package main.entities.monsters.SlimeVariants;

import main.rendering.animation.Animation;

public class EntitySlimeLightBlue extends EntitySlime {
	
	
	public EntitySlimeLightBlue(int px, int py) {
		super(px, py);
		this.xpValue = 5;
		
		setSprite("enemy_slimes.png", (int)(Math.random() * 3), 3, 3);
		
	}
	
}
